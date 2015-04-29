package com.twixtor.ca;

import java.util.ArrayList;

public class Player {
	
	public int health;
	public int attackPower;
	public boolean isBatteling;
	public Enemy currentEnemy;
	int x;
	int y;
	public ArrayList<Item>inventory;
	
	Player(int x, int y) {
		this.health = 100;
		this.attackPower = 25;
		this.isBatteling = false;
		currentEnemy = null;
		this.x = x;
		this.y = y;
		inventory = new ArrayList<Item>();
	}
	
	public void move(int x, int y) {
		
		this.x += x;
		this.y += y;
		
		String newPosition = "UNKNOWN";
		
		for(int i = 0; i < Main.rooms.size(); i++) {
			if(Main.rooms.get(i).x == Main.player.x && Main.rooms.get(i).y == Main.player.y) {
				newPosition = Main.rooms.get(i).name;
			}
		}
		
		if(!newPosition.equalsIgnoreCase("unknown")) {
			Main.updateImage();
			Main.cout("You moved to the " + newPosition);
		} else {
			Main.cout("You cant move in that direction!");
			this.x -= x;
			this.y -=y;
		}
	}
	
	public void hurtPlayer(int amount) {
		health -= amount;
		Main.cout("You took " + amount + " damage.");
		Main.cout("Player health: " + health);
	}
	
	public Room getCurrentRoom() {
		Room room = new Room("ERROR CANNOT FIND CURRENT ROOM", "ERROR CANNOT FIND CURRENT ROOM", x, y);
		for(int i = 0; i < Main.rooms.size(); i++) {
			if(Main.rooms.get(i).x == Main.player.x && Main.rooms.get(i).y == Main.player.y) {
				room = Main.rooms.get(i);
			}
		}
		return room;
	}
}
