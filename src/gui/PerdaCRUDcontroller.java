package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.ConnectionDataBase;
import beans.Item_estoque;
import beans.Perda;
import exceptions.Objectnotfound;
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

public class PerdaCRUDcontroller implements Initializable{

	@FXML
	private Button deleteitem;
	
	@FXML
	private TextField sequencialt;
	
	@FXML
	private TextField cpfgerentet;
	
	@FXML
	private TextField diat;
	
	@FXML
	private TextField  qtdperdidat;
	
	@FXML
	private TextField motivot;
	
	@FXML
	private TableView<Perda> tableperda;
	
	@FXML
	private TableColumn<Perda, String> seq;
	
	@FXML
	private TableColumn<Perda, String> cod_lotep;
	
	@FXML
	private TableColumn<Perda, String> cod_produtop;
	
	@FXML
	private TableColumn<Perda, String> id_estoquep;
	
	@FXML
	private TableColumn<Perda, String> cpfgerente;
	
	@FXML
	private TableColumn<Perda, String> dia;
	
	@FXML
	private TableColumn<Perda, String> qtdperdida;
	
	@FXML
	private TableColumn<Perda, String> motivo;
	
	@FXML
	private TableView<Item_estoque> tableitemestoque;
	
	@FXML
	private TableColumn<Item_estoque, String> cod_lote;
	
	@FXML
	private TableColumn<Item_estoque, String> id_estoque;
	
	@FXML
	private TableColumn<Item_estoque, String> cod_produto;
	
	@FXML
	private TableColumn<Item_estoque, String> id_avaria;
	
	@FXML
	private TableColumn<Item_estoque, String> id_prateleira;
	
	@FXML
	private TableColumn<Item_estoque, String> dt_validade;
	
	@FXML
	private TableColumn<Item_estoque, String> valorcompra;
	
	@FXML
	private TableColumn<Item_estoque, String> quantidade;
	
	@FXML
	private TableColumn<Item_estoque, String>  dt_entrada;
	
	@FXML
	private TableColumn<Item_estoque, String> dt_fabricacao;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button update;
	
	@FXML
	private Button  delete ;
	
	@FXML
	private Label aviso;
	
	private Item_estoque itemestoqueescolhido;
	private Perda perdaescolhida;
	
	@FXML
	private void selecionaritem_estoque()
	{
		this.itemestoqueescolhido = this.tableitemestoque.getSelectionModel().getSelectedItem();
		
		
		ArrayList<Perda> p = (ArrayList<Perda>) Fachada.getInstancia().listarperda();
		ArrayList<Perda> p2 = new ArrayList<>();
		
		for(int x = 0 ; x < p.size() ; x++)
		{
			if(p.get(x).getCod_produto().equals(itemestoqueescolhido.getCod_produto()) 
					&& p.get(x).getId_estoque().equals(itemestoqueescolhido.getId_estoque())
					&& p.get(x).getCod_lote().equals(itemestoqueescolhido.getCod_lote()))
			{
				p2.add(p.get(x));
			}
		}
		
		
		this.seq.setCellValueFactory(new PropertyValueFactory<>("seq"));
		this.cod_lotep.setCellValueFactory(new PropertyValueFactory<>("cod_lote"));
		this.cod_produtop.setCellValueFactory(new PropertyValueFactory<>("cod_produto"));
		this.id_estoquep.setCellValueFactory(new PropertyValueFactory<>("id_estoque"));
		this.cpfgerente.setCellValueFactory(new PropertyValueFactory<>("cpf_gerente"));
		this.dia.setCellValueFactory(new PropertyValueFactory<>("dia"));
		this.qtdperdida.setCellValueFactory(new PropertyValueFactory<>("quantidade_perdida"));
		this.motivo.setCellValueFactory(new PropertyValueFactory<>("motivo"));
		
		this.tableperda.setItems(FXCollections.observableArrayList(p2));

	}
	
	@FXML
	private void selecionarperda()
	{
		this.perdaescolhida = this.tableperda.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	private void delete(ActionEvent event)
	{
		String sequencial = this.perdaescolhida.getSeq();
		
		if(!sequencial.equals(""))
		{
			
			try {
				
				Connection c;
				try {
					
					c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
					Statement s = c.createStatement();
					s.executeUpdate("delete from perda where seq = '"+ sequencial +"' ;");

					
					s.close();
					c.close();
					
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
				Fachada.getInstancia().removerperda(sequencial);
				
				
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
				
				
				
			} catch (Objectnotfound exc) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Item_estoque com o codigo " + exc.getidObjeto() + " nao existe");
				alert.showAndWait();
				
			}
			
		}
		else
		{
			this.aviso.setText("not yet");
		}
		
		
		
		
	}
	
	@FXML
	private void submit(ActionEvent event)
	{
		String sequencial, cod_lote , cod_produto, id_estoque;
		
	}
	
	@FXML
	private void update(ActionEvent event)
	{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ArrayList<Item_estoque> it = (ArrayList<Item_estoque>) Fachada.getInstancia().listaritem();
		
		
		
		this.cod_lote.setCellValueFactory(new PropertyValueFactory<>("cod_lote"));
		this.id_estoque.setCellValueFactory(new PropertyValueFactory<>("id_estoque"));
		this.cod_produto.setCellValueFactory(new PropertyValueFactory<>("cod_produto"));
		this.id_avaria.setCellValueFactory(new PropertyValueFactory<>("id_avaria"));
		this.id_prateleira.setCellValueFactory(new PropertyValueFactory<>("id_prateleira"));
		this.dt_validade.setCellValueFactory(new PropertyValueFactory<>("data_validade"));
		this.dt_fabricacao.setCellValueFactory(new PropertyValueFactory<>("data_fabricacao"));
		this.dt_entrada.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
		this.valorcompra.setCellValueFactory(new PropertyValueFactory<>("valor_compra"));
		this.quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		

		
		this.tableitemestoque.setItems(FXCollections.observableArrayList(it));

		
	}

}
