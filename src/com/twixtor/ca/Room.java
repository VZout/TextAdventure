package com.twixtor.ca;

import java.util.ArrayList;

public class Room {
	
	public String name;
	public String description;
	public int x;
	public int y;
	public ArrayList<Item>items;
	public ArrayList<Enemy>enemies;
	public String imgPath;
	
	Room(String name, String description, int x, int y) {
		this.name = name;
		this.description = description;
		this.x = x;
		this.y = y;
		items = new ArrayList<Item>();
		enemies = new ArrayList<Enemy>();
		this.imgPath = "";
	}
	
	Room(String name, String description, int x, int y, String imgPath) {
		this.name = name;
		this.description = description;
		this.x = x;
		this.y = y;
		items = new ArrayList<Item>();
		enemies = new ArrayList<Enemy>();
		this.imgPath = imgPath;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	public void removeEnemy(Enemy e) {
		enemies.remove(e);
	}
}
