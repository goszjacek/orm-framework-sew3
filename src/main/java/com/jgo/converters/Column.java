package com.jgo.converters;

public class Column{
	String name, type, special;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public Column(String name, String type, String special) {
		super();
		this.name = name;
		this.type = type;
		this.special = special;
	}
	
	
}
