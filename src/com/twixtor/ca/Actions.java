package com.twixtor.ca;

public class Actions {
	
	public static void help() {
		Main.cout("---Commands---");
		for(int i = 0; i < Main.commands.size(); i++) {
			if(!Main.commands.get(i).altName.equalsIgnoreCase(""))
				Main.cout("	" + (i + 1) + ". " + Main.commands.get(i).name + " / " + Main.commands.get(i).altName);
			else
				Main.cout("	" + (i + 1) + ". " + Main.commands.get(i).name);
		}
	}
	
	public static void fight() {
		if(!Main.player.getCurrentRoom().enemies.isEmpty()) {
			Main.cout("You started fighting the closest enemy. All commands disabled exept 'Attack'");
			Main.player.isBatteling = true;
			Main.player.currentEnemy = Main.player.getCurrentRoom().enemies.get(0);
		} else {
			Main.cout("Could not find a enemy in this room.");
		}
	}
	
	public static void stats() {
		Main.cout("---Player Stats---");
		Main.cout("Health: " + Main.player.health);
	}
	
	public static void inventory() {
		if(Main.player.inventory.size() > 0) {
			Main.cout("You have the following items in your backpack: ");
			for(int i = 0; i < Main.player.inventory.size(); i++) {
				Main.cout("	" + (i + 1) + ". " +Main.player.inventory.get(i).name);
			}
		} else
			Main.cout("You don't have any items in your backpack.");
	}
	
	public static void look() {
		for(int i = 0; i < Main.rooms.size(); i++) {
			if(Main.rooms.get(i).x == Main.player.x && Main.rooms.get(i).y == Main.player.y) {
				Main.cout("You are currently at the " + Main.rooms.get(i).name + ". " + Main.rooms.get(i).description);
				Main.cout("From here you can move: ");
				for(int j = 0; j < Main.rooms.size(); j++) {
					if(Main.rooms.get(j).x == Main.player.x && Main.rooms.get(j).y == Main.player.y + 1) { //Check north
						Main.cout("	North, To the " + Main.rooms.get(j).name);
					}
					else if(Main.rooms.get(j).x == Main.player.x && Main.rooms.get(j).y == Main.player.y - 1) { //Check south
						Main.cout("	South, To the " + Main.rooms.get(j).name);
					}
					else if(Main.rooms.get(j).x == Main.player.x + 1 && Main.rooms.get(j).y == Main.player.y) { //Check east
						Main.cout("	East, To the " + Main.rooms.get(j).name);
					}
					else if(Main.rooms.get(j).x == Main.player.x - 1 && Main.rooms.get(j).y == Main.player.y) { //Check west
						Main.cout("	West, To the " + Main.rooms.get(j).name);
					}
				}
				return;
			}
		}
	}
	
	public static void search() {
		if(!Main.player.getCurrentRoom().items.isEmpty()) {
			Main.cout("You found the following items: ");
			for(int i = 0; i < Main.player.getCurrentRoom().items.size(); i++) {
				Main.cout("	" + (i + 1) + ". " + Main.player.getCurrentRoom().items.get(i).name);
			}
			
		} else
			Main.cout("No items found.");
		
		if(!Main.player.getCurrentRoom().enemies.isEmpty()) {
			Main.cout("You found the following enemies: ");
			for(int i = 0; i < Main.player.getCurrentRoom().enemies.size(); i++) {
				Main.cout("	" + (i + 1) + ". " + Main.player.getCurrentRoom().enemies.get(i).name);
			}
		} else
			Main.cout("No enemies found.");
	}
	
	public static void goTo(String direction) {
		if (direction.equalsIgnoreCase("north"))
			Main.player.move(0, 1);
		else if (direction.equalsIgnoreCase("east"))
			Main.player.move(1, 0);
		else if (direction.equalsIgnoreCase("south"))
			Main.player.move(0, -1);
		else if (direction.equalsIgnoreCase("west"))
			Main.player.move(-1, 0);
		else {
			Main.cout("That is not a proper direction...");
		}
	}
	
	public static void take(String item) {
		for(int i = 0; i < Main.player.getCurrentRoom().items.size(); i++) {
			if(item.equalsIgnoreCase(Main.player.getCurrentRoom().items.get(i).name)) {
				Main.cout("You picked up the " + Main.player.getCurrentRoom().items.get(i).name);
				Main.player.inventory.add(Main.player.getCurrentRoom().items.get(i));
				Main.player.getCurrentRoom().items.remove(Main.player.getCurrentRoom().items.get(i));
				return;
			}
		}
		Main.cout("There is no item with that name.");
	}
	
	public static void use(String item) {
		for(int i = 0; i < Main.player.inventory.size(); i++) {
			if(item.equalsIgnoreCase(Main.player.inventory.get(i).name)) {
				Main.player.inventory.get(i).use();
				Main.player.inventory.remove(Main.player.inventory.get(i));
				return;
			}
		}
		Main.cout("There is no item with that name");
	}
}
