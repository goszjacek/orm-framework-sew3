package com.jgo.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.jgo.annotations.DismissField;

public class NameConverter {
	public static String nameJavaToSql(String javaName) {
		String newName = javaName.toLowerCase();
		return newName;
	}
	
	public static List<Column> fieldsConverter(Field[] fields) {
		List<Column> columns = new ArrayList<Column>();
		for(Field f : fields) {
			Annotation a = f.getAnnotation(DismissField.class);
		  	if(a==null) {
		  		String fieldType = TypesConverter.convertTypeNameJavaToSQLLite(f.getType().getTypeName());
				String fieldName = f.getName();
				String special = "";
				if(fieldName.toLowerCase().contains("pid")) {
					special+=" primary key";
				}
				columns.add(new Column(fieldName, fieldType, special));
		  	}
			
		}
		return columns;
	}
	
//	public static boolean isFirstSmallCamelCase(String title) {
//		if(title.length()<1) {
//			return false;
//		}else {
//			int i = title.length() - 1, lastCut = title.length();
//			List<String> words = new ArrayList<String>();
//			for(; i>=0; i--) {
//				Character tmpChar = (Character) title.charAt(i); 
//				if(Character.isUpperCase(title.charAt(i))) {
//					if(i==title.length()-1 || Character.isLowerCase(title.charAt(i+1))) {
//						//do cut
//						words.add(title.substring(i,lastCut));
//						lastCut=i;
//					}else {
//						if(i==0 || Character.isLowerCase(title.charAt(i-1))) {
//							
//						}
//					}
//				}
//			}
//		}
//	}
//	public static boolean isFirstSmallCamelCase(String title) {
//		int i=0, lastFirst = 0;
//		List<String> words = new ArrayList<String>();
//		while(i<title.length()) {
//			if(Character.isUpperCase(title.charAt(0))) {
//				return false;				
//			}
//			if(Character.isLowerCase(title.charAt(i))&&(i==title.length()-1 || Character.isUpperCase(title.charAt(i+1)))) {
//				words.add(title.substring(lastFirst, i+1));
//				lastFirst = i+1;
//				
//			}else {
//				
//			}
//			
//			
//			i++;
//		}
//	}
}
