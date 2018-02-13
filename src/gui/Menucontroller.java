package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menucontroller implements Initializable {

	@FXML
	private Button funcionariob;
	
	@FXML
	private Button produtob;
	
	@FXML
	private Button fornecedorb;
	
	@FXML
	private Button sairb;
	
	@FXML
	private Button item_estoque;
	
	@FXML
	private Button perda;
	
	@FXML
	private void sair(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
		
	}
	
	@FXML
	private void funcionario(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("FuncionarioCRUD.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void perda(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("PerdaCRUD.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void fornecedor(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("FornecedorCRUD2.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void produto(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("ProdutoCRUD2.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("produto");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void item_estoque(ActionEvent event)
	{
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("Item_estoqueCRUD.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Item_estoque");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
