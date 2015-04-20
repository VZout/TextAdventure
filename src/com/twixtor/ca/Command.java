package com.twixtor.ca;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Command {
	
	private Method action;
	public String name;
	public String altName;
	public boolean multiCommand;
	
	Command(String name, Method action) {
		this.action = action;
		this.name = name;
		this.altName = "";
		multiCommand = false;
	}
	
	Command(String name, String altName, Method action) {
		this.action = action;
		this.name = name;
		this.altName = altName;
		multiCommand = false;
	}
	
	Command(boolean multiCommand, String name, Method action) {
		this.action = action;
		this.name = name;
		this.altName = "";
		this.multiCommand = multiCommand;
	}
	
	public void performAction() {
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
	
	public void performAction(String cmd) {
		String[] splited = cmd.split("\\s+");
		if(splited.length == 2) {
			System.out.println("Splitted Command: " + splited[1]);
		} else if(splited.length < 2) {
			Main.cout("You don't have a sub command!");
			return;
		} else if(splited.length > 2) {
			Main.cout("You have to much sub commands");
			return;
		}
		
		try {
			action.invoke(this, splited[1]);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
