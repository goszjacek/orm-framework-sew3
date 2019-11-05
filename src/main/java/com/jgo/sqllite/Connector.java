package com.jgo.sqllite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jgo.converters.Column;
import com.jgo.xml_basics.App;

public class Connector {
	//db parameters
	private static final String url = "jdbc:sqlite:D:\\E\\objektorientierte_softwareentwicklung\\workspace\\sqlite-test1.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	public static void connect() {
		try {
            Class.forName(Connector.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
		Connection conn = null;
	    try {
	        // create a connection to the database
	        conn = DriverManager.getConnection(url);
	        
	        System.out.println("Connection to SQLite has been established.");
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
	}
	
	public static void createTableFromFields(String tableName, List<Column>columns) {
		String sql = "CREATE TABLE IF NOT EXISTS " 
				+ tableName 
				+ " (\n";
		
//                + "    id integer PRIMARY KEY,\n"
//                + "    name text NOT NULL,\n"
//                + "    capacity real\n"
//        
		for(int i=0; i<columns.size(); i++) {
			Column c = columns.get(i);
			String toAdd = "";
			toAdd += c.getName();
			toAdd += " " +  c.getType();
			toAdd += " " + c.getSpecial();
			if(i!=columns.size()-1) {
				toAdd += ",\n";
			}else {
				toAdd += "\n";
			}
			sql += toAdd;
		}
        sql+= ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
}
