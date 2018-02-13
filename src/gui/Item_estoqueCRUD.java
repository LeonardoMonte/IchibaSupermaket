package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Item_estoqueCRUD extends Application {

	
	public void start(Stage stage) throws Exception {
		
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Item_estoqueCRUD.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("CRUD produto");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main (String[] args){
		launch(args);
	}
	
}

