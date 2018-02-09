package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.ConnectionDataBase;
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

public class CRUDprodutocontroller implements Initializable{

	@FXML
	private TextField codigot;
	
	@FXML
	private TextField idfornecedort;
	
	@FXML
	private TextField icmst;
	
	@FXML
	private TextField idncmt;
	
	@FXML
	private TextField idunidadet;
	
	@FXML
	private TextField idmarcat;
	
	@FXML
	private TextField cstt;
	
	@FXML
	private TextField idcodbarrast;
	
	@FXML
	private TextField idcategoriat;
	
	@FXML
	private TextField precoportabelat;
	
	@FXML
	private TextField freqpedidot;
	
	@FXML
	private TextField idsubcategoriat;
	
	@FXML
	private TextField descricaot;
	
	@FXML
	private TextField qtdestoquet;
	
	@FXML
	private TextField qtdtotalestoquet;
	
	@FXML
	private TextField qtdminimat;
	
	@FXML
	private TextField precoultimacomprat;
	
	@FXML
	private Label codigol;
	
	@FXML
	private Label idfornecedorl;
	
	@FXML
	private Label icmsl;
	
	@FXML
	private Label idncml;
	
	@FXML
	private Label qtdestoquel;
	
	@FXML
	private Label idunidadel;
	
	@FXML
	private Label idmarcal;
	
	@FXML
	private Label cstl;
	
	@FXML
	private Label idcodbarrasl;
	
	@FXML
	private Label idcategorial;
	
	@FXML
	private Label precoportabelal;
	
	
	@FXML
	private Label freqpedidol;
	
	@FXML
	private Label idsubcategorial;
	
	@FXML
	private Label descricaol;
	
	@FXML
	private Label qtdtotalestoquel;
	
	@FXML
	private Label qtdminimal;
	
	@FXML
	private Label precoultimacompral;
	
	@FXML
	private Button update;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button delete;
	
	@FXML
	private Label labelaviso;
	
	
	@FXML
	private TableView<Produto_ref> table;
	
	@FXML
	private TableColumn<Produto_ref, String> codigo;
	
	@FXML
	private TableColumn<Produto_ref, String> idfornecedor;
	
	@FXML
	private TableColumn<Produto_ref, String> idmarca;
	
	@FXML
	private TableColumn<Produto_ref, String> idncm;
	
	@FXML
	private TableColumn<Produto_ref, String> qtdestoque;
	
	@FXML
	private TableColumn<Produto_ref, String> idcategoria;
	
	@FXML
	private TableColumn<Produto_ref, String> idsubcategoria;
	
	@FXML
	private TableColumn<Produto_ref, String> cst;
	
	@FXML
	private TableColumn<Produto_ref, String> icms;
	
	@FXML
	private TableColumn<Produto_ref, String> codbarras;
	
	@FXML
	private TableColumn<Produto_ref, String> precoportabela;
	
	@FXML
	private TableColumn<Produto_ref, String> freqpedido;
	
	@FXML
	private TableColumn<Produto_ref, String> qtdtotal;
	
	@FXML
	private TableColumn<Produto_ref, String> qtdmin;
	
	@FXML
	private TableColumn<Produto_ref, String> preultcompra;
	
	@FXML
	private TableColumn<Produto_ref, String> idunidade;
	
	@FXML
	private TableColumn<Produto_ref, String> descricao;
	
	

	
	@FXML
	private void delete(ActionEvent event)
	{
		String codigo = this.codigot.getText();
		
		if(!codigo.equals("") && this.idfornecedort.getText().equals("") && this.icmst.getText().equals("") && this.idncmt.getText().equals("") &&
				this.freqpedidot.getText().equals("") && this.idunidadet.getText().equals("") && this.idmarcat.getText().equals("") &&
				this.cstt.getText().equals("") && this.idcodbarrast.getText().equals("") && this.qtdtotalestoquet.getText().equals("") &&
				this.idcategoriat.getText().equals("") && this.precoportabelat.getText().equals("") && this.descricaot.getText().equals("") &&
				this.idsubcategoriat.getText().equals("") && this.qtdminimat.getText().equals("") && this.precoultimacomprat.getText().equals("") &&
				this.qtdestoquet.getText().equals(""))
		{
			
			try {
				
				Connection c;
				try {
					c = ConnectionDataBase.getConnection();
					Statement s = c.createStatement();
					s.executeUpdate("delete from produto_ref where cod = '" + codigo + "';");

					
					s.close();
					c.close();
					
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Fachada.getInstancia().removerProduto(codigo);
				
				try
				{
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					Parent root = FXMLLoader.load(getClass().getResource("ProdutoCRUD2.fxml"));
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
			this.labelaviso.setText("Preencha somente o campo codigo");
		}
		
		
	}
	
	@FXML
	private void update(ActionEvent event)
	{
		String freqpedido , quantidadetotal, descricao , qtdestoque , precoultimacompra ,precoportabela, qtdmin , codigo;
		
		freqpedido = this.freqpedidot.getText();
		quantidadetotal = this.qtdtotalestoquet.getText();
		descricao = this.descricaot.getText();
		qtdestoque = this.qtdestoquet.getText();
		precoultimacompra = this.precoultimacomprat.getText();
		precoportabela = this.precoportabelat.getText();
		qtdmin = this.qtdminimat.getText();
		codigo = this.codigot.getText();
		
		if(!codigo.equals("") && this.idfornecedort.getText().equals("") && this.icmst.getText().equals("") && this.idncmt.getText().equals("") &&
				!freqpedido.equals("") && this.idunidadet.getText().equals("") && this.idmarcat.getText().equals("") &&
				this.cstt.getText().equals("") && this.idcodbarrast.getText().equals("") && !quantidadetotal.equals("") &&
				this.idcategoriat.getText().equals("") && !precoportabela.equals("") && !descricao.equals("") &&
				this.idsubcategoriat.getText().equals("") && !qtdmin.equals("") && !precoultimacompra.equals("") &&
				!qtdestoque.equals(""))
		{
			
			int qtdestoque2 = Integer.parseInt(qtdestoque);
			float precoportable = Float.parseFloat(precoportabela);
			float freqpedido2 = Float.parseFloat(freqpedido);
			int qtdmin2 = Integer.parseInt(qtdmin);
			int qtdtotalestoque2 = Integer.parseInt(quantidadetotal);
			float precoultimacompra2 = Float.parseFloat(precoultimacompra);
			
			try {
				
				
				Produto_ref p = Fachada.getInstancia().buscarProduto(codigo);
				p.setQtd_estoque(qtdestoque2);
				p.setPreco_por_tabela(precoportable);
				p.setFreq_pedido(freqpedido2);
				p.setQtd_min(qtdmin2);
				p.setQtd_total_estoque(qtdtotalestoque2);
				p.setPreco_ult_compra(precoultimacompra2);
				p.setDescricao(descricao);
				
				
				try {
					
					Connection c;
					try {
						c = ConnectionDataBase.getConnection();
						Statement s = c.createStatement();
						s.executeUpdate("update produto_ref set qtd_estoque = "+ qtdestoque2+" "
								+ " , preco_por_tabela = "+precoportable+" , freq_pedido = "+ freqpedido2+" , "
										+ " descricao = '"+descricao+"' , qtd_min = "+ qtdmin2	+ " , qtd_total_estoque = "+qtdtotalestoque2+" "
												+ " , preco_ult_compra = "+precoultimacompra2+"  where cod = '"+ codigo +"' ;" );

						
						s.close();
						c.close();
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					Fachada.getInstancia().atualizarProduto(p);
					
					try
					{
						((Node) (event.getSource())).getScene().getWindow().hide();
						
						Parent root = FXMLLoader.load(getClass().getResource("ProdutoCRUD2.fxml"));
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
					
					
					
				} catch (Objetojaexiste e) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Produto com o codigo " + e.getId() + " Ja existe");
					alert.showAndWait();
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
			this.labelaviso.setText("preencha apenas os campos que devem ser preenchidos");
		}
		
		
		
		
	}
	
	
	@FXML 
	private void submit(ActionEvent event)
	{
		String codigo, idfornecedor, icms, idncm, freqpedido, idunidade, idmarca, cst, codigodebarras,
		qtdtotalestoque, idcategoria, precoportabela, descricao, idsubcategoria , quantidademinima, precoultcompra, qtdestoque;
		
		codigo = this.codigot.getText();
		idfornecedor = this.idfornecedort.getText();
		icms = this.icmst.getText();
		idncm = this.idncmt.getText();
		freqpedido = this.freqpedidot.getText();
		idunidade = this.idunidadet.getText();
		idmarca = this.idmarcat.getText();
		cst = this.cstt.getText();
		codigodebarras = this.idcodbarrast.getText();
		qtdtotalestoque = this.qtdtotalestoquet.getText();
		idcategoria = this.idcategoriat.getText();
		precoportabela = this.precoportabelat.getText();
		descricao = this.descricaot.getText();
		idsubcategoria = this.idsubcategoriat.getText();
		quantidademinima = this.qtdminimat.getText();
		precoultcompra = this.precoultimacomprat.getText();
		qtdestoque = this.qtdestoquet.getText();
		
		if(!codigo.equals("") && !idfornecedor.equals("") && !icms.equals("") && !idncm.equals("") &&
				!freqpedido.equals("") && !idunidade.equals("") && !idmarca.equals("") &&
				!cst.equals("") && !codigodebarras.equals("") && !qtdtotalestoque.equals("") &&
				!idcategoria.equals("") && !precoportabela.equals("") && !descricao.equals("") &&
				!idsubcategoria.equals("") && !quantidademinima.equals("") && !precoultcompra.equals("") &&
				!qtdestoque.equals(""))
		{
			
			int qtdestoque2 = Integer.parseInt(qtdestoque);
			float icms2 = Float.parseFloat(icms);
			float precoportable = Float.parseFloat(precoportabela);
			float freqpedido2 = Float.parseFloat(freqpedido);
			int qtdmin2 = Integer.parseInt(quantidademinima);
			int qtdtotalestoque2 = Integer.parseInt(qtdtotalestoque);
			float precoultimacompra2 = Float.parseFloat(precoultcompra);
			
			Produto_ref p = new Produto_ref(codigo, idunidade, idmarca, idncm, idcategoria, 
					idsubcategoria, idfornecedor, qtdestoque2, icms2, cst, precoportable, 
					codigodebarras, freqpedido2, descricao, qtdmin2, qtdtotalestoque2, precoultimacompra2);
			
			try {
				
				Connection c;
				try {
					
					c = ConnectionDataBase.getConnection();
					Statement s = c.createStatement();
					s.executeUpdate("INSERT INTO produto_ref (cod, id_unidade , id_marca , id_ncm , "
							+ "id_categoria, id_subcategoria, id_fornecedor , qtd_estoque ,\r\n" + 
							" ICMS , CST , preco_por_tabela , cod_barra , "
							+ "freq_pedido , descricao , qtd_min, qtd_total_estoque , preco_ult_compra) VALUES"
							+ " ('"+codigo+"' , '"+idunidade+"' , '"+idmarca+"', '"+idncm+"' "
							+ ", '"+idcategoria+"' , '"+idsubcategoria+"' , '"+idfornecedor+"' , "+qtdestoque2+" , "
							+ " "+icms2+" , '"+cst+"' , "+ precoportable+", "
							+ "'"+codigodebarras+"' ,  "+freqpedido2+" , '"+descricao+"' , "+qtdmin2+" , "+qtdtotalestoque2+" , "+precoultimacompra2+" );");

					
					s.close();
					c.close();
					
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
				Fachada.getInstancia().cadastrarProduto(p);
				
				try
				{
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					Parent root = FXMLLoader.load(getClass().getResource("ProdutoCRUD2.fxml"));
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
				alert.setContentText("Produto com o codigo " + exc.getId() + " Ja existe");
				alert.showAndWait();
			}
			
		}
		else
		{
			this.labelaviso.setText("preencha todos os campos");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Produto_ref> p = (ArrayList<Produto_ref>) Fachada.getInstancia().listarProdutos();
		
		this.codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.idunidade.setCellValueFactory(new PropertyValueFactory<>("id_unidade"));
		this.idmarca.setCellValueFactory(new PropertyValueFactory<>("id_marca"));
		this.idncm.setCellValueFactory(new PropertyValueFactory<>("id_ncm"));
		this.idcategoria.setCellValueFactory(new PropertyValueFactory<>("id_categoria"));
		this.idsubcategoria.setCellValueFactory(new PropertyValueFactory<>("id_subcategoria"));
		this.idfornecedor.setCellValueFactory(new PropertyValueFactory<>("id_fornecedor"));
		this.qtdestoque.setCellValueFactory(new PropertyValueFactory<>("qtd_estoque"));
		this.icms.setCellValueFactory(new PropertyValueFactory<>("ICMS"));
		this.cst.setCellValueFactory(new PropertyValueFactory<>("CST"));
		this.precoportabela.setCellValueFactory(new PropertyValueFactory<>("preco_por_tabela"));
		this.codbarras.setCellValueFactory(new PropertyValueFactory<>("cod_barra"));
		this.freqpedido.setCellValueFactory(new PropertyValueFactory<>("freq_pedido"));
		this.descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		this.qtdmin.setCellValueFactory(new PropertyValueFactory<>("qtd_min"));
		this.qtdtotal.setCellValueFactory(new PropertyValueFactory<>("qtd_total_estoque"));
		this.preultcompra.setCellValueFactory(new PropertyValueFactory<>("preco_ult_compra"));
		
		
		this.table.setItems(FXCollections.observableArrayList(p));
		
		
		
		
		
		
		
		
		
	}

}
