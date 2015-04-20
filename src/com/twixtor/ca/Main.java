package com.twixtor.ca;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Scene scene;
	static Pane layout;
	static ArrayList<Command> commands;
	static ArrayList<Room> rooms;
	static Player player;
	static String output;
	static ScrollPane sp;
	static Text t;
	private static ImageView imgView;
	private TextField tf;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Java Console Application");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		
		commands = new ArrayList<Command>();
		rooms = new ArrayList<Room>();
		player = new Player(0, 0);
		
		initCommands();
		initRooms();
		
		layout = new Pane();
		scene = new Scene(layout, 800, 600);
		stage.setScene(scene);
		stage.show();
		
		t = new Text();
		output = "Please enter a command.";
		t.setText(output);
		
		sp = new ScrollPane();
		sp.setContent(t);
		sp.setPrefWidth(scene.getWidth());
		sp.setPrefHeight(scene.getHeight() - 31);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		tf = new TextField();
		tf.setPrefWidth(scene.getWidth());
		tf.setPrefHeight(30);
		tf.setLayoutY(scene.getHeight() - 31);
		tf.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				proccesCommand(tf.getText());
				tf.clear();
			}
		});
		
		layout.getChildren().add(sp);
		layout.getChildren().add(tf);
		
		imgView = new ImageView(new Image(player.getCurrentRoom().imgPath, true));
		imgView.setLayoutX(scene.getWidth() - 165);
		
		layout.getChildren().add(imgView);
		
		resizeHandler(scene);
	}
	
	public void initCommands()  {
		try {
			commands.add(new Command("Help", "?", Actions.class.getDeclaredMethod("help")));
			commands.add(new Command("Murder", Actions.class.getDeclaredMethod("kill")));
			commands.add(new Command("Inventory", "Inv", Actions.class.getDeclaredMethod("inventory")));
			commands.add(new Command("look", Actions.class.getMethod("look")));
			commands.add(new Command("search", Actions.class.getMethod("search")));
			commands.add(new Command(true, "take", Actions.class.getMethod("take", String.class)));
			commands.add(new Command(true, "go", Actions.class.getMethod("goTo", String.class)));
			commands.add(new Command(true, "use", Actions.class.getMethod("use", String.class)));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void proccesCommand(final String command) {
		for(int i = 0; i < commands.size(); i++) {
			if(	commands.get(i).multiCommand && command.toLowerCase().startsWith(commands.get(i).name.toLowerCase())) {
					commands.get(i).performAction(command);
					return;
			}
			
			else if(commands.get(i).name.equalsIgnoreCase(command) && !commands.get(i).multiCommand) {
				commands.get(i).performAction();
				return;
			} else if(commands.get(i).altName.equalsIgnoreCase(command) && !commands.get(i).multiCommand) {
				commands.get(i).performAction();
				return;
			}
		}
		cout("Unknown Command. Type '?' for a list of commands.");
	}
	
	public static void cout(String text) {
		output = output + "\n" + text;
		t.setText(output);
		sp.setContent(t);
	}
	
	public static void updateImage() {
		layout.getChildren().remove(imgView);
		
		if(!player.getCurrentRoom().imgPath.equalsIgnoreCase("")) {
			imgView = new ImageView(new Image(player.getCurrentRoom().imgPath, true));
			imgView.setLayoutX(scene.getWidth() - 165);
			layout.getChildren().add(imgView);
		} else
			System.out.println("No image.");
	}
	
	public void resizeHandler(final Scene scene) {
		scene.widthProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
		    	sp.setPrefWidth(scene.getWidth());
		    	tf.setPrefWidth(scene.getWidth());
		    	updateImage();
		    }
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
		    	sp.setPrefHeight(scene.getHeight() - 31);
		    	tf.setLayoutY(scene.getHeight() - 31);
		    }
		});
	}
	
	public void initRooms() {
		try {
			Room garden = new Room("Garden", "A buetefull place with flowers.", 0, 0, "http://c2.tuid.nl/i/150x150/smart/filters:no_upscale()/http://tuintuin.nl/uploads/142383/8943-garden-tours-great-dixter-kent-sussex-17-1024x768.jpg");
			garden.addItem(new Item("Spoon", "That is slightly bend.", ItemActions.class.getDeclaredMethod("spoon")));
			rooms.add(garden);
			
			Room crematorium = new Room("Crematorium", "It smells like death in here...", 0, 1, "http://www.vrijheidrondomsterven.nl/wp-content/uploads/2010/09/zoomstede_crematorium_025_31d4f2-150x150.jpg");
			rooms.add(crematorium);
			
			Room hotelRoom = new Room("Hotel Room", "A very nice room.", 0, -1);
			rooms.add(hotelRoom);
			
			Room bathroom = new Room("Bathroom", "A smoking hot place.", 1, 0, "http://abencaodopai.com/wp-content/uploads/2015/03/model-design-unique-hotel-room-design-on-room-design-with-painting-ideas-2015--150x150.jpg");
			rooms.add(bathroom);
			
			Room garbageDump = new Room("Garbage Dumb", "It stinks in here... Allot", -1, 0);
			rooms.add(garbageDump);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}