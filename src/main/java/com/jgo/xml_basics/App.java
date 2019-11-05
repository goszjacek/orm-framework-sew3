package com.jgo.xml_basics;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;

import com.jgo.annotations.DismissField;
import com.jgo.converters.NameConverter;
import com.jgo.converters.TypesConverter;
import com.jgo.sqllite.Connector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
            File inputFile = new File("input.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("class");
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element cls = (Element) nNode;
                  String path = cls.getAttribute("path");
                  String clsPath = path.replace('/','.');
                  System.out.println(clsPath);

                  ClassLoader classLoader = App.class.getClassLoader();
                  
                  
                  try {
                      Class aClass = classLoader.loadClass(clsPath);
                      System.out.println("aClass.getName() = " + aClass.getSimpleName());
                      Field[] fields = aClass.getDeclaredFields();
                      System.out.println("len:"+fields.length);
                      for(Field field : fields ) {
                    	  System.out.println(field.getName());
                    	  String fieldName = field.getName();
                    	  if (fieldName.contains("PId")) {
                    		  System.out.println("Primary key is: "+ fieldName);
                    	  }
                    	  System.out.println("Type is: " + TypesConverter.convertTypeNameJavaToSQLLite(field.getType().getTypeName()));
                    	  
                      }
                      Connector.connect();
                      Connector.createTableFromFields(aClass.getSimpleName(), NameConverter.fieldsConverter(fields));
                      
                      
                      
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }
                  
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
}
