package com.twixtor.ca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Item {
	
	public String name;
	public String description;
	private Method action;
	
	Item(String name, String description, Method action) {
		this.name = name;
		this.description = description;
		this.action = action;
	}
	
	public void use() {
		try {
			action.invoke(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
