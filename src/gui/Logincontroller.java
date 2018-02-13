package gui;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import beans.ConnectionDataBase;
import exceptions.Wrongsenha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import negocios.Fachada;

public class Logincontroller implements Initializable {

	@FXML
	private PasswordField password;	
	
	@FXML
	private TextField login;
	
	@FXML
	private Label aviso;
	
	@FXML
	private Button enter;
	
	private static String username;
	private static String password2;
	
	public static String getUsername()
	{
		return username;
	}
	
	public static String getPassword()
	{
		return password2;
	}
	
	
	
	@FXML
	public void enter(ActionEvent event)
	{
		
		username = this.login.getText();
		password2 = this.password.getText();
		
		if(!login.equals("") && !password2.equals(""))
		{
				
					try {
						
						
						Connection c = ConnectionDataBase.getConnection(username, password2);
						System.out.println(c.getCatalog());
						
						try
						{
							((Node) (event.getSource())).getScene().getWindow().hide();
							
							Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
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
						
						
					} catch (Exception e1) {
					
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("Impossivel realizar a acao");
						alert.setContentText("Senha ou login errados");	
						alert.showAndWait();
					}
								
				

		}
		else
		{
			this.aviso.setText("Digite o login e senha");
		}
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
