package com.jgo.converters;

public class TypesConverter {
	public static String convertTypeJavaToSQLLite(Object o) {
		if(o instanceof Integer) {
			return "integer";
		}
		if(o instanceof String) {
			return "text";
		}
		if(o instanceof Float || o instanceof Double) {
			return "real";
		}
		return "byte";
	}
	
	public static String convertTypeNameJavaToSQLLite(String type){
		if(type.equals("java.lang.Integer")) {
			return "integer";
		}
		if(type.equals("java.lang.String")) {
			return "text";
		}
		if(type.equals("java.lang.Float") || type.contentEquals("java.lang.Double")) {
			return "real";
		}
		return "byte";
	}
}
