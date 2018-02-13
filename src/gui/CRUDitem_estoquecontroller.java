package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.ConnectionDataBase;
import beans.Estoque;
import beans.Item_estoque;
import beans.Prateleira;
import beans.Produto_ref;
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

public class CRUDitem_estoquecontroller implements Initializable{

	
	@FXML
	private TextField codlotet;
	
	@FXML
	private TextField idavariat;
	
	@FXML
	private TextField dt_validadet;
	
	@FXML
	private TextField dt_fabricacaot;
	
	@FXML
	private TextField dtentradat;
	
	@FXML
	private TextField  valorcomprat;
	
	@FXML
	private TextField quantidadet;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button update;
	
	@FXML
	private Button  delete ;
	
	@FXML
	private Button retornar;
	
	@FXML
	private Label aviso;
	
	@FXML
	private TableView<Produto_ref> tableproduto;
	
	@FXML
	private TableColumn<Produto_ref, String> codigoproduto ;	
	
	@FXML
	private TableColumn<Produto_ref, String> descricaoproduto;
	
	@FXML
	private TableView<Estoque> tableestoque;
	
	@FXML
	private TableColumn<Estoque, String> idestoque;
	
	@FXML
	private TableColumn<Estoque, String> descricaoestoque;
	
	@FXML
	private TableView<Prateleira> tableprateleira;
	
	@FXML
	private TableColumn<Prateleira, String> codigoprateleira;
	
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
	
	private Produto_ref produtoescolhido;
	private Estoque estoqueescolhido;
	private Prateleira prateleiraescolhida;
	private Item_estoque itemestoqueescolhido;
	
	@FXML
	private void retornar(ActionEvent event)
	{
		
		try
		{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Perda");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void update(ActionEvent event)
	{
		String codigolote, codproduto, idestoque , valorcompra, quantidade;
		codigolote = this.itemestoqueescolhido.getCod_lote();
		codproduto = this.itemestoqueescolhido.getCod_produto();
		idestoque = this.itemestoqueescolhido.getId_estoque();
		valorcompra = this.valorcomprat.getText();
		quantidade = this.quantidadet.getText();
		
		if(!codigolote.equals("") && !codproduto.equals("") && !idestoque.equals("")
				&& !valorcompra.equals("") && !quantidade.equals(""))
		{
			
			float valorcompra2 = Float.parseFloat(valorcompra);
			int quantidade2 = Integer.parseInt(quantidade);
			
			
			try {
				
				Connection c;
				try {
					
					c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
					Statement s = c.createStatement();
					s.executeUpdate("update item_estoque set quantidade = "+ quantidade2 +" , valor_compra = "+valorcompra2+" where cod_lote = '"+ codigolote +"' and id_estoque = '"+idestoque+"' and cod_produto = '"+codproduto+"'");

					
					s.close();
					c.close();
					
					Item_estoque it = Fachada.getInstancia().buscaritem(codigolote, codproduto, idestoque);
					it.setQuantidade(quantidade2);
					it.setValor_compra(valorcompra2);
					
				} catch (Objectnotfound exc) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Item_estoque com o codigo " + exc.getidObjeto() + " nao existe");
					alert.showAndWait();
					
				}
					
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
								
				try
				{
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					Parent root = FXMLLoader.load(getClass().getResource("Item_estoqueCRUD.fxml"));
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
		else
		{
			this.aviso.setText("do ritgh");
		}
		
	}
	
	@FXML
	private void delete(ActionEvent event)
	{
		String codigolote , codproduto , idestoque;
		codigolote = this.itemestoqueescolhido.getCod_lote();
		codproduto = this.itemestoqueescolhido.getCod_produto();
		idestoque = this.itemestoqueescolhido.getId_estoque();
		
		
		
		if(!codigolote.equals("") && !codproduto.equals("") && !idestoque.equals(""))
		{
			try {
				
				Connection c;
				try {
					
					c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
					Statement s = c.createStatement();
					s.executeUpdate("delete from item_estoque where cod_lote = '"+ codigolote +"' and id_estoque = '"+idestoque+"' and cod_produto = '"+codproduto+"'");

					
					s.close();
					c.close();
					
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
				Fachada.getInstancia().removeritem(codigolote, codproduto, idestoque);
				
				
				try
				{
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					Parent root = FXMLLoader.load(getClass().getResource("Item_estoqueCRUD.fxml"));
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
			this.aviso.setText("selecione alguma coisa");
		}
	}
	
	@FXML
	private void submit(ActionEvent event)
	{
		String cod_lote ,id_estoque, cod_produto, id_prateleira, id_avaria, data_validade, 
		data_fabricacao, data_entrada, valor_compra, quantidade;
		
		cod_lote = this.codlotet.getText();
		id_estoque = this.estoqueescolhido.getId();
		cod_produto = this.produtoescolhido.getCodigo();
		id_prateleira = this.prateleiraescolhida.getCodigo();
		id_avaria = this.idavariat.getText();
		data_validade = this.dt_validadet.getText();
		data_fabricacao = this.dt_fabricacaot.getText();
		data_entrada = this.dtentradat.getText();
		valor_compra = this.valorcomprat.getText();
		quantidade = this.quantidadet.getText();
		
		if(!cod_lote.equals("") && !id_estoque.equals("") && !cod_produto.equals("") && !id_prateleira.equals("") &&
			!id_avaria.equals("") && !data_validade.equals("") && !data_fabricacao.equals("") && !data_entrada.equals("") &&
			!valor_compra.equals("") && !quantidade.equals(""))
		{
			
			float valor_compra2 = Float.parseFloat(valor_compra);
			int quantidade2 = Integer.parseInt(quantidade);
			
			Item_estoque it = new Item_estoque(cod_lote, id_estoque, cod_produto, id_avaria, id_prateleira, data_validade, data_fabricacao, data_entrada, valor_compra2, quantidade2);
			
			try {
				
				Connection c;
				try {
					
					c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
					Statement s = c.createStatement();
					s.executeUpdate("INSERT INTO item_estoque ( cod_lote, id_estoque , cod_produto , id_avaria , id_prateleira , data_validade , data_fabricacao , data_entrada , valor_compra, quantidade ) VALUES"
							+ " ('"+cod_lote+"' , '"+id_estoque+"' , '"+cod_produto+"' , '"+id_avaria+"' , '"+id_prateleira+"' "
							+ ", '"+data_validade+"' , '"+data_fabricacao+"' , '"+data_entrada +"' , "+valor_compra2 + " , "+ quantidade2 + ");");

					
					s.close();
					c.close();
					
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
				Fachada.getInstancia().cadastraritem(it);
				
				
				try
				{
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					Parent root = FXMLLoader.load(getClass().getResource("Item_estoqueCRUD.fxml"));
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
				alert.setContentText("Item_estoque com o codigo " + exc.getId() + " Ja existe");
				alert.showAndWait();
				
			}
			
			
		}
		else
		{
			this.aviso.setText("preencha tudo");
		}
		
		
	}
	
	@FXML
	private void selecionaritem_estoque()
	{
		this.itemestoqueescolhido = this.tableitemestoque.getSelectionModel().getSelectedItem();

	}
	
	@FXML
	private void selecionarproduto()
	{
		this.produtoescolhido = this.tableproduto.getSelectionModel().getSelectedItem();
		this.produtoescolhido.setFreq_pedido(0);
		this.produtoescolhido.setICMS(0);
		this.produtoescolhido.setPreco_por_tabela(0);
		this.produtoescolhido.setPreco_ult_compra(0);
		this.produtoescolhido.setQtd_estoque(0);
		this.produtoescolhido.setQtd_min(0);
		this.produtoescolhido.setQtd_total_estoque(0);
	}
	
	@FXML
	private void selecionarestoque()
	{
		this.estoqueescolhido = this.tableestoque.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	private void selecionarprateleira()
	{
		this.prateleiraescolhida = this.tableprateleira.getSelectionModel().getSelectedItem();
		this.prateleiraescolhida.setAltura(0);
		this.prateleiraescolhida.setComprimento(0);
	
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<Produto_ref> p = (ArrayList<Produto_ref>) Fachada.getInstancia().listarProdutos();
		ArrayList<Item_estoque> it = (ArrayList<Item_estoque>) Fachada.getInstancia().listaritem();
		ArrayList<Estoque> e = (ArrayList<Estoque>) Fachada.getInstancia().listarestoque();
		ArrayList<Prateleira> prate = (ArrayList<Prateleira>) Fachada.getInstancia().listarprateleira();
		
		
		
		this.codigoproduto.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.descricaoproduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
		this.idestoque.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.descricaoestoque.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
		this.codigoprateleira.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		
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
		
		this.tableestoque.setItems(FXCollections.observableArrayList(e));
		this.tableitemestoque.setItems(FXCollections.observableArrayList(it));
		this.tableprateleira.setItems(FXCollections.observableArrayList(prate));
		this.tableproduto.setItems(FXCollections.observableArrayList(p));
		
		
	}

}
