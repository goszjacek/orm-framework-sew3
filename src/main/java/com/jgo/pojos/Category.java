package com.jgo.pojos;

public class Category {
	private String name;
	private Integer categoryPid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCategoryPid() {
		return categoryPid;
	}
	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}
	public Category(String name, Integer categoryPid) {
		super();
		this.name = name;
		this.categoryPid = categoryPid;
	} 
	
	
}
