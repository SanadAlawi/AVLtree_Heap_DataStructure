package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	private AVLtree<City> avl = new AVLtree<>();
	private HashTable<Resident> hash = new HashTable<>();
	
	// Button objects
	Button LoadButton = new Button("Load File"); // load city file
	Button sortbutton = new Button("Sort"); // sort the cities
	Button searchbutton = new Button("Search"); // sort the cities
	Button insertbutton = new Button("Insert"); // insert new city
	Button deletebutton = new Button("Delete"); // delete city
	Button enterbutton = new Button("Enter"); // enter a city
	Button exitbutton = new Button("Exit");
	
	// Label object
	Label heightlabel = new Label("Tree Height= 0");
	Label searchlabel = new Label("Search Specific City: ");
	Label insertlabel = new Label("Insert New City: ");
	Label deletelabel = new Label("Delete City: ");
	
	// TextField objects
	TextField searchfield = new TextField();
	TextField insertfield = new TextField();
	TextField deletefield = new TextField();
	TextField cityfield = new TextField();
	
	//Combo Box object
	ComboBox cb = new ComboBox();
	
	// TextArea object
	TextArea ta = new TextArea();
	
	// Button object 2
	Button printbutton = new Button("Print Table");
	Button hashbutton = new Button("Hash");
	Button insert2button = new Button("insert");
	Button search2button = new Button("Search");
	Button delete2button = new Button("Delete");
	Button savebutton = new Button("Save To file");
	Button returnbutton = new Button("Retrun");
		
	// TextField object 2
	TextField IDtf = new TextField();
	TextField nametf = new TextField();
	TextField gendertf = new TextField();
	TextField agetf = new TextField();
	TextField searchtf = new TextField();
	TextField deletetf = new TextField();
		
	// Label object 2
	Label sizelabel = new Label("Hash Table Size= 0 \n"
			+ "Current Size= 0");
	Label insert2label = new Label("insert new resident:(ID)(Name)(Age)(gender):");
	Label search2label = new Label("Search By ID: ");
	Label delete2label = new Label("Delete By ID: ");
		
	// TextArea object 2
	TextArea ta2 = new TextArea();
	
	Scene scene1 , scene2;
	
	
	@Override
	public void start(Stage stage) throws Exception{
		Arrays.sort(new int[] {});
		searchfield.setMaxWidth(100);
		insertfield.setMaxWidth(100);
		deletefield.setMaxWidth(100);
		
		sortbutton.setTranslateX(20);
		LoadButton.setTranslateX(200);
		
		ta.setPrefHeight(100);
		ta.setMaxWidth(400);
		
		// Button size
		LoadButton.setPrefWidth(100);
		sortbutton.setPrefWidth(60);
		searchbutton.setPrefWidth(60);
		insertbutton.setPrefWidth(60);
		deletebutton.setPrefWidth(60);
		enterbutton.setPrefWidth(60);
		exitbutton.setPrefWidth(60);
		
		// Button size
		printbutton.setPrefWidth(100);
		hashbutton.setPrefWidth(60);
		search2button.setPrefWidth(70);
		insert2button.setPrefWidth(70);
		delete2button.setPrefWidth(70);
		savebutton.setPrefWidth(90);
		returnbutton.setPrefWidth(60);
				
		// Button size
		IDtf.setPrefWidth(70);
		nametf.setPrefWidth(70);
		agetf.setPrefWidth(70);
		gendertf.setPrefWidth(70);
		deletetf.setMaxWidth(70);
		searchtf.setMaxWidth(70);
		returnbutton.setPrefWidth(60);
				
		ta2.setPrefHeight(100);
		ta2.setMaxWidth(400);
		
		// Form Begin
		VBox vb1 = new VBox(20);
		vb1.getChildren().addAll(searchlabel, insertlabel, deletelabel, cb);
		vb1.setTranslateY(70);
		
		VBox vb2 = new VBox(10);
		vb2.getChildren().addAll(LoadButton, sortbutton, searchfield, insertfield, deletefield, enterbutton);
		
		VBox vb3 = new VBox(10);
		vb3.getChildren().addAll(searchbutton, insertbutton, deletebutton);
		vb3.setTranslateY(70);
		
		HBox hb = new HBox(15);
		hb.getChildren().addAll(vb1, vb2, vb3);
		hb.setTranslateX(50);
		
		VBox vb = new VBox(15);
		vb.getChildren().addAll(hb, ta, heightlabel, exitbutton);
		exitbutton.setTranslateX(400);
		
		Group group = new Group();
		group.getChildren().add(vb);
		group.setLayoutX(160);
		
		scene1 = new Scene(group, 800, 400);
		
		stage.setTitle("Project #3");
		stage.setScene(scene1);
		stage.show();
		
		VBox vbox1 = new VBox(15);
		Label CityLabel = new Label();
		vbox1.getChildren().addAll(CityLabel,insert2label, search2label, delete2label);
		vbox1.setTranslateY(10);
		
		HBox hb1 = new HBox(10);
		hb1.getChildren().addAll(IDtf, nametf, agetf,  gendertf, insert2button);
		
		HBox hb2 = new HBox(50);
		hb2.getChildren().addAll(hashbutton, printbutton);
		
		VBox vbox3 = new VBox(15);
		vbox3.getChildren().addAll(search2button, delete2button, savebutton);
		vbox3.setTranslateY(68);
		vbox3.setTranslateX(-325);
		
		VBox vbox2 = new VBox(10);
		vbox2.getChildren().addAll(hb2, hb1, searchtf, deletetf);
		
		HBox hb3 = new HBox(15);
		hb3.getChildren().addAll(vbox1, vbox2, vbox3);
		
		VBox vbox = new VBox(50);
		vbox.getChildren().addAll(hb3, ta2, sizelabel, returnbutton);
		returnbutton.setTranslateY(-40);
		returnbutton.setTranslateX(600);
		ta2.setTranslateX(200);
		
		Group group2 = new Group();
		group2.getChildren().addAll(vbox);
		group2.setLayoutX(80);
		
		scene2 = new Scene(group2, 800, 400);
		
		// Form end
		
		/////////////////////////// Button Actions ///////////////////////////
		LoadButton.setOnAction(e -> { // ReadFile Button action
			try {
				ReadCityFile();
				heightlabel.setText("Tree Height= "+avl.height());
				cb.getSelectionModel().selectFirst();
			}
			catch(Exception ex){
				
			}
		});
		
		sortbutton.setOnAction(e -> { // Sort City File Button action
			if(!avl.isEmpty()) {
				String s = avl.inOrder();
				ta.setText(s);
			}
			else
				new Alert(AlertType.WARNING, "File not Load!!!").show();
		});
		
		searchbutton.setOnAction(e -> { // search button action
			if(!searchfield.getText().isEmpty() && !avl.isEmpty()) {
				if (avl.Search(new City(searchfield.getText(), null)) != null)
					cb.getSelectionModel().select(SearchIndex(searchfield.getText()));
				else
					new Alert(AlertType.WARNING, "City Not Found!!!").show();
			}
			else
				new Alert(AlertType.WARNING, "File not Load OR Empty Field!!!").show();
			searchfield.setText("");
		});
		
		insertbutton.setOnAction(e -> { // Insert Button action
			if(!insertfield.getText().isEmpty()) {
				avl.insert(new City(insertfield.getText()+"" , "city"+cb.getItems().size()+".txt"));
				cb.getItems().add(insertfield.getText());
				cb.getSelectionModel().selectLast();
			}
			else
				new Alert(AlertType.WARNING, "File not Load OR Empty Field!!!").show();
			insertfield.setText("");
			heightlabel.setText("Tree Height= "+avl.height());
		});
		
		deletebutton.setOnAction(e -> { // Delete button action
			if(!deletefield.getText().isEmpty() && !avl.isEmpty()) {
				if( avl.delete(new City(deletefield.getText(), null)) != null)
					cb.getItems().remove(SearchIndex(deletefield.getText()));
				else
					new Alert(AlertType.WARNING, "City Not Found!!!").show();
			}
			else
				new Alert(AlertType.WARNING, "File not Load OR Empty Field!!!").show();
			deletefield.setText("");
			heightlabel.setText("Tree Height= "+avl.height());
		});
		
		enterbutton.setOnAction(e -> { // Enter Button action
			if(cb.getItems().size() > 0 && !cb.getSelectionModel().getSelectedItem().toString().isEmpty()) {
				stage.setScene(scene2);
				try {
					ReadResidentFile(cb.getSelectionModel().getSelectedItem().toString());
					sizelabel.setText("Hash Table Size= "+hash.Size()+"\n"+
					"Current Size= "+hash.CurrentSize());
					CityLabel.setText("City Name: "+cb.getSelectionModel().getSelectedItem().toString());
				}
				catch(Exception ex) {
					
				}
			}
			else
				new Alert(AlertType.WARNING, "Combo Box is Empty Or Not Chice City Yet!!!").show();
		});
		
		returnbutton.setOnAction(e -> { // Enter Button action
			stage.setScene(scene1);
			hash.clear();
			ta2.setText("");
			sizelabel.setText("Hash Table Size= "+hash.Size()+"\n"+
					"Current Size= "+hash.CurrentSize());
		});
		
		exitbutton.setOnAction(e -> { // Exit Button action
			stage.close();
		});
		
		hashbutton.setOnAction(e -> { // Print Hash Function Button action
			if(!hash.isEmpty()) {
				String string = hash.HashFunction();
				ta2.setText(string);
			}
			else
				new Alert(AlertType.WARNING, "Empty City!!!").show();
		});
		
		printbutton.setOnAction(e -> { // Print HashTable Button action
			if(!hash.isEmpty()) {
				String string = hash.print();
				ta2.setText(string);
			}
			else
				new Alert(AlertType.WARNING, "Empty City!!!").show();
		});
		
		insert2button.setOnAction(e -> { // insert new resident
			if(!IDtf.getText().isEmpty() && !nametf.getText().isEmpty()) {
				long id = Integer.parseInt(IDtf.getText().trim());
				String name = nametf.getText().trim();
				int age = Integer.parseInt(agetf.getText().trim());
				char gender = gendertf.getText().trim().charAt(0);
				hash.insert(new Resident(id, name, age, gender));
			}
			else
				new Alert(AlertType.WARNING, "ID And Name Field are Important!!!").show();
			sizelabel.setText("Hash Table Size= "+hash.Size()+"\n"+
					"Current Size= "+hash.CurrentSize());
			IDtf.setText("");
			nametf.setText("");
			agetf.setText("");
			gendertf.setText("");
		});
		
		search2button.setOnAction(e -> { // Search for Resident Button action
			if(!hash.isEmpty()) {
				if(!searchtf.getText().isEmpty()) {
					long id = Integer.parseInt(searchtf.getText().trim());
					int index = hash.Search(new Resident(id, null, 0, ' '));
					ta2.setText(index > -1 ? "index "+index+"->"+hash.get(index)+"" : "Not Found");
				}
				else
					new Alert(AlertType.WARNING, "Search Field is Empty!!!").show();
			}
			else
				new Alert(AlertType.WARNING, "Hash Table is Empty!!!").show();
			searchtf.setText("");
		});
		
		delete2button.setOnAction(e -> { // Delete Resident Button action
			if(!hash.isEmpty()) {
				if(!deletetf.getText().isEmpty()) {
					long id = Integer.parseInt(deletetf.getText().trim());
					int index = hash.Delete(new Resident(id, null, 0, ' '));
					ta2.setText(index > -1 ? "index "+index+"-> Deleted" : "Not Found" );
				}
				else
					new Alert(AlertType.WARNING, "Delete Field is Empty!!!").show();
			}
			else
				new Alert(AlertType.WARNING, "Hash Table is Empty!!!").show();
			deletetf.setText("");
			sizelabel.setText("Hash Table Size= "+hash.Size()+"\n"+
					"Current Size= "+hash.CurrentSize());
		});
		
		savebutton.setOnAction(e -> { // Save To file Button action
			if(!hash.isEmpty()) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(cb.getSelectionModel().getSelectedItem().toString()+".txt"));
					bw.write(hash.print());
					bw.close();
					Alert alert = new Alert(AlertType.INFORMATION, "Please Refresh your Project Explorer to see your  File");
					alert.setHeaderText("Equations Transfer Succefully");
					alert.show();
				}
				catch(Exception ex) {
					
				}
			}
			else
				new Alert(AlertType.WARNING, "Hash Table is Empty!!!").show();
		});
		
		/////////////////////////// Button Actions Ends ///////////////////////////
	}
	
	private void ReadResidentFile(String file) throws Exception { // Read City Resident File method
		file = file+".txt";
		File f = new File(file);
//		BufferedReader bf = new BufferedReader(new FileReader(file));
		if(f.exists()) {
			Scanner in = new Scanner(f);
			while(in.hasNext()) {
				String line = in.nextLine();
				if( line.contains("/")) {
					String[]  r = line.split(">");
					hash.insert(new Resident(r[1].trim()));
				}
			}
		}
	} // end method
	
	private int SearchIndex(String string) { // show specific city in the combo box
		for(int i = 0 ; i < cb.getItems().size() ; i++) {
			if(string.equalsIgnoreCase(cb.getItems().get(i).toString()))
				return i;
		}
		return -1;
	}
	
	private void ReadCityFile() throws Exception { // Read City File contents
		File CityFile = new File("City.txt");
//		BufferedReader bf = new BufferedReader(new FileReader("City.txt"));
		if(CityFile.exists()) {
			Scanner in = new Scanner(CityFile);
			while(in.hasNext()) {
				String [] city = in.nextLine().split("/");
				avl.insert(new City(city[0].trim(), city[1].trim()));
				cb.getItems().add(city[0].trim());
			}
		}
	} // end method
	
	public static void main(String[] args) {
		launch(args);
	}
}
