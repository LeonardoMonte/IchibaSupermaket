package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CRUDfornecedor extends Application{


	public void start(Stage stage) throws Exception {
		
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("FornecedorCRUD2.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("CRUD fornecedor");
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
