package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Fornecedor;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocios.Fachada;

public class CRUDfornecedorcontroller implements Initializable {

	@FXML
	private TextField codigo;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField CNPJ;
	
	@FXML
	private TextField rua;
	
	@FXML
	private TextField bairro;
	
	@FXML
	private TextField CEP;
	
	@FXML
	private TextField estado;
	
	@FXML
	private TextField ativo;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button update;
	
	@FXML
	private Button delete;
	
	@FXML
	private Label codigol;
	
	@FXML
	private Label nomel;
	
	@FXML
	private Label CNPJl;
	
	@FXML
	private Label rual;
	
	@FXML
	private Label bairrol;
	
	@FXML
	private Label CEPl;
	
	@FXML
	private Label estadol;
	
	@FXML
	private Label ativol;
	
	@FXML
	private TableView<Fornecedor> table;
	
	@FXML
	private TableColumn<Fornecedor, String> codcolumn;
	
	@FXML
	private TableColumn<Fornecedor, String> nomec;
	
	@FXML
	private TableColumn<Fornecedor, String> CNPJc;
	
	@FXML
	private TableColumn<Fornecedor, String> ruac;
	
	@FXML
	private TableColumn<Fornecedor, String> bairroc;
	
	@FXML
	private TableColumn<Fornecedor, String> CEPc;
	
	@FXML
	private TableColumn<Fornecedor, String> estadoc;
	
	@FXML
	private TableColumn<Fornecedor, Boolean> statusc;
	
	@FXML
	private Label labelaviso;
	
	@FXML
	private void update(ActionEvent event)
	{
		String rua , bairro, cep , estado , status , codigo;
		
		codigo = this.codigo.getText();
		rua = this.rua.getText();
		bairro = this.bairro.getText();
		cep = this.CEP.getText();
		estado = this.estado.getText();
		status = this.ativo.getText();
		
		if(!codigo.equals(""))
		{
		
		if( !rua.equals("") && !bairro.equals("") && !cep.equals("") && !estado.equals("") && !status.equals("")
				&& this.CNPJ.getText().equals("") && this.nome.getText().equals(""))
		{
			
			boolean status2 = Boolean.parseBoolean(status);
			
			Fornecedor f;
			try {
				f = Fachada.getInstancia().buscarFornecedor(codigo);
				f.setAtivo(status2);
				f.setRua(rua);
				f.setBairro(bairro);
				f.setCep(cep);
				f.setEstado(estado);
				
				try {
					
					Fachada.getInstancia().atualizarFornecedor(f);
					
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
					
					
					
				} catch (Objectnotfound e) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Fornecedor com o codigo " + e.getidObjeto() + " nao existe");	
					alert.showAndWait();
					
				} catch (Objetojaexiste e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				
			} catch (Objectnotfound e1) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Fornecedor com o codigo " + e1.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
			
			
			
			
			
		}
		else
		{
			this.labelaviso.setText("Mude apenas endereço e status");
		}
		
		}
		else
		{
			this.labelaviso.setText("digite o codigo do fornecedor");
		}
	}
	
	
	@FXML
	private void delete(ActionEvent evente)
	{
		String codigo = this.codigo.getText();
		
		if(!codigo.equals("") && this.nome.getText().equals("") && this.CNPJ.getText().equals("") &&
				this.rua.getText().equals("") && this.bairro.getText().equals("") && 
				this.CEP.getText().equals("") && this.estado.getText().equals("") && this.ativo.getText().equals(""))
			
		{
			try {
				Fachada.getInstancia().removerFornecedor(codigo);
				
				try
				{
					((Node) (evente.getSource())).getScene().getWindow().hide();
					
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
				
				
				
			} catch (Objectnotfound e) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Fornecedor com o codigo " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
			
			
		}
		else
		{
			this.labelaviso.setText("Preencha apenas codigo para remover");
		}
	}
	
	@FXML
	private void submit(ActionEvent event)
	{
		
		String codigo , nome, CNPJ , rua , bairro , CEP , estado;
		
		codigo = this.codigo.getText();
		nome = this.nome.getText();
		CNPJ = this.CNPJ.getText();
		rua = this.rua.getText();
		bairro = this.bairro.getText();
		CEP = this.CEP.getText();
		estado = this.estado.getText();
		
		if(!codigo.equals("") && !nome.equals("") && !CNPJ.equals("") && !rua.equals("") && !bairro.equals("") &&
				!CEP.equals("") && !estado.equals("") )
		{
			
			Fornecedor f = new Fornecedor(codigo, nome, CNPJ, rua, bairro, CEP, estado);
		
			try {
				Fachada.getInstancia().cadastrarFornecedor(f);
				
				
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
				
				
				
			} catch (Objetojaexiste exc) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Fornecedor com o codigo " + exc.getId() + " Ja existe");
				alert.showAndWait();
				
			}
				
			
		}
		else
		{
			this.labelaviso.setText("Preencha todos o campos");
		}
			
	}

	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<Fornecedor> f = (ArrayList<Fornecedor>) Fachada.getInstancia().listarFornecedores();
		
		
		this.codcolumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.nomec.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.CNPJc.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		this.ruac.setCellValueFactory(new PropertyValueFactory<>("rua"));
		this.bairroc.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		this.CEPc.setCellValueFactory(new PropertyValueFactory<>("cep"));
		this.estadoc.setCellValueFactory(new PropertyValueFactory<>("estado"));
		this.statusc.setCellValueFactory(new PropertyValueFactory<>("ativo"));
		
		this.table.setItems(FXCollections.observableArrayList(f));
		
		
		
		
		
		
	}

}
