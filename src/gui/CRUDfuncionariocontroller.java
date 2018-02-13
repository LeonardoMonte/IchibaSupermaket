package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.ConnectionDataBase;
import beans.Funcionario;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocios.Fachada;

public class CRUDfuncionariocontroller implements Initializable {

	@FXML
	private TextField idjornadat;
	
	@FXML
	private TextField seqfilialt;
	
	@FXML
	private TextField cnpjmatrizt;
	
	@FXML
	private TextField dtadmissaot;
	
	@FXML
	private TextField ativot;
	
	@FXML
	private TextField logint;
	
	@FXML
	private TextField senhat;
	
	@FXML
	private TextField rgt;
	
	@FXML
	private TextField nomet;
	
	@FXML
	private TextField estadocivilt;
	
	@FXML
	private TextField enderecot;
	
	@FXML
	private TextField cpft;
	
	@FXML
	private TextField sexot;
	
	@FXML
	private RadioButton DBA;
	
	@FXML
	private RadioButton gerente;
	
	@FXML
	private RadioButton supervisorestoque;
	
	@FXML
	private RadioButton estoquista;
	
	@FXML
	private RadioButton entregador;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button update;
	
	@FXML
	private TableView<Funcionario> table;
	
	@FXML
	private TableColumn<Funcionario, String> cpf;
	
	@FXML
	private TableColumn<Funcionario, String>  rg;
	
	@FXML
	private TableColumn<Funcionario, String> nome;
	
	@FXML
	private TableColumn<Funcionario, String> seqfilial;
	
	@FXML
	private TableColumn<Funcionario, String> cnpjmatriz;
	
	@FXML
	private TableColumn<Funcionario, String> dtadmissao;
	
	@FXML
	private TableColumn<Funcionario, String> login;
	
	@FXML
	private TableColumn<Funcionario, String> senha;
	
	@FXML
	private TableColumn<Funcionario, String> estadocivil;
	
	@FXML
	private TableColumn<Funcionario, String> idjornada;
	
	@FXML
	private TableColumn<Funcionario, String> sexo;
	
	@FXML
	private TableColumn<Funcionario, String> especificacao;
	
	@FXML
	private TableColumn<Funcionario, String> ativo;
	
	@FXML
	private TableColumn<Funcionario, String> endereco;	
	
	@FXML
	private Label labelaviso;
	
	@FXML
	private ToggleGroup group;
	
	@FXML
	private void delete(ActionEvent event)
	{
		String cpf = this.cpft.getText();
		
		if( !cpf.equals("") && this.idjornadat.getText().equals("") && this.seqfilialt.getText().equals("") && this.cnpjmatrizt.getText().equals("") &&
				this.dtadmissaot.getText().equals("") && this.sexot.getText().equals("") && this.estadocivilt.getText().equals("") 
				&& this.logint.getText().equals("") && this.senhat.getText().equals("") && this.rgt.getText().equals("") &&
				this.nomet.getText().equals("") && this.ativot.getText().equals("") && this.enderecot.getText().equals(""))
		{
			
			try {
				
				
				Fachada.getInstancia().buscarFuncionario(cpf);
				
			Connection c;
				try {
					c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
					Statement s = c.createStatement();
					s.executeUpdate("delete from funcionario where CPF = '" + cpf + "';");

					
					s.close();
					c.close();
					
					Fachada.getInstancia().removerFuncionario(cpf);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
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
				
				
			} catch (Objectnotfound e) 
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Funcionario com o codigo " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
			
			
		}
		else
		{
			this.labelaviso.setText("Preencha apenas o cpf");
		}
		
		
		
		
	}
	
	@FXML
	private void update(ActionEvent event)
	{
		String estadocivil, login, senha , endereco , ativo , cpf;
		
		estadocivil = this.estadocivilt.getText();
		login = this.logint.getText();
		senha = this.senhat.getText();
		endereco = this.enderecot.getText();
		ativo = this.ativot.getText();
		cpf = this.cpft.getText();
		
		if( !cpf.equals("") && this.idjornadat.getText().equals("") && this.seqfilialt.getText().equals("") && this.cnpjmatrizt.getText().equals("") &&
				this.dtadmissaot.getText().equals("") && this.sexot.getText().equals("") && !estadocivil.equals("") 
				&& !login.equals("") && !senha.equals("") && this.rgt.getText().equals("") &&
				this.nomet.getText().equals("") && !ativo.equals("") && !endereco.equals(""))
		{
			
			Connection c;
			try {
				
				
				if(this.DBA.isSelected())
				{
					beans.DBA dba = (beans.DBA) Fachada.getInstancia().buscarFuncionario(cpf);

					try {
						
						
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("update funcionario set estado_civil = '"+estadocivil+"' , login = '"+login+"' , senha = '"+ senha+"', endereco = '"+ endereco+"' , situacao = '"+ ativo+ "' where CPF = '"+ cpf +"' ;" );
						dba.setEstadocivil(estadocivil);
						dba.setLogin(login);
						dba.setSenha(senha);
						dba.setEndereco(endereco);
						dba.setSituacao(ativo);
						
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
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				if(this.gerente.isSelected())
				{
					beans.Gerente gerente = (beans.Gerente) Fachada.getInstancia().buscarFuncionario(cpf);

					try {
						
						
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("update funcionario set estado_civil = '"+estadocivil+"' , login = '"+login+"' , senha = '"+ senha+"', endereco = '"+ endereco+"' , situacao = '"+ ativo+ "' where CPF = '"+ cpf +"' ;" );
						
						gerente.setEstadocivil(estadocivil);
						gerente.setLogin(login);
						gerente.setSenha(senha);
						gerente.setEndereco(endereco);
						gerente.setSituacao(ativo);
						
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
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(this.supervisorestoque.isSelected())
				{
					
					beans.SurpevisorEstoque sup = (beans.SurpevisorEstoque) Fachada.getInstancia().buscarFuncionario(cpf);
					
					try {
						
						
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("update funcionario set estado_civil = '"+estadocivil+"' , login = '"+login+"' , senha = '"+ senha+"', endereco = '"+ endereco+"' , situacao = '"+ ativo+ "' where CPF = '"+ cpf +"' ;" );
						
						sup.setEstadocivil(estadocivil);
						sup.setLogin(login);
						sup.setSenha(senha);
						sup.setEndereco(endereco);
						sup.setSituacao(ativo);
						
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
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				if(this.estoquista.isSelected())
				{
					
					beans.Estoquista est = (beans.Estoquista) Fachada.getInstancia().buscarFuncionario(cpf);
					
					try {
						
						
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("update funcionario set estado_civil = '"+estadocivil+"' , login = '"+login+"' , senha = '"+ senha+"', endereco = '"+ endereco+"' , situacao = '"+ ativo+ "' where CPF = '"+ cpf +"' ;" );
						
						est.setEndereco(endereco);
						est.setSenha(senha);
						est.setLogin(login);
						est.setEstadocivil(estadocivil);
						est.setSituacao(ativo);
						
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

						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(this.entregador.isSelected())
				{
					
					beans.Entregador entre = (beans.Entregador) Fachada.getInstancia().buscarFuncionario(cpf);
					
					try {
						
						
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("update funcionario set estado_civil = '"+estadocivil+"' , login = '"+login+"' , senha = '"+ senha+"', endereco = '"+ endereco+"' , situacao = '"+ ativo+ "' where CPF = '"+ cpf +"' ;" );
						
						entre.setEstadocivil(estadocivil);
						entre.setLogin(login);
						entre.setSenha(senha);
						entre.setEndereco(endereco);
						entre.setSituacao(ativo);

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
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
								
				
				
			} catch (Objectnotfound e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Funcionario com o codigo " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
			
			
			
		}
		else
		{
			this.labelaviso.setText("Digite apenas os campos necessarios");
		}
		
		
		
	}
	
	@FXML
	private void submit(ActionEvent event)
	{
		String cpf, idjornada, seqfilial , cnpjmatriz, dataadmissao , sex, estadocivil, login , senha , rg , nome , situacao, endereco;
		
		cpf = this.cpft.getText();
		idjornada = this.idjornadat.getText();
		seqfilial = this.seqfilialt.getText();
		cnpjmatriz = this.cnpjmatrizt.getText();
		dataadmissao = this.dtadmissaot.getText();
		sex = this.sexot.getText();
		estadocivil = this.estadocivilt.getText();
		login = this.logint.getText();
		senha = this.senhat.getText();
		rg = this.rgt.getText();
		nome = this.nomet.getText();
		situacao = this.ativot.getText();
		endereco = this.enderecot.getText();
		
		if( !cpf.equals("") && !idjornada.equals("") && !seqfilial.equals("") && !cnpjmatriz.equals("") && !dataadmissao.equals("") && 
			!sex.equals("") && !estadocivil.equals("") && !login.equals("") && !senha.equals("") && !rg.equals("") &&
			!nome.equals("") && !situacao.equals("") && !endereco.equals(""))
		{
			
			if(this.DBA.isSelected())
			{
				
				beans.DBA dba = new beans.DBA(cpf, idjornada, seqfilial, cnpjmatriz, dataadmissao, sex, estadocivil, login, senha, "DBA", rg, nome, situacao, endereco);
				
				
				try {
					
					Connection c;
					try {
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("INSERT INTO funcionario (CPF, id_jornada, seq_filial, cnpj_matriz, data_admissao"
								+ ", sex, estado_civil, login, senha, RG, nome, situacao, endereco) VALUES"
								+ "('"+ cpf +"' , '"+ idjornada +"' , '"+ seqfilial+ "' , '"+cnpjmatriz+"' "
										+ ", '"+dataadmissao+"', '"+sex+"' , '"+estadocivil+"', '"+login+"', '"+senha+"',"
												+ "'"+rg+"', '"+nome+"' , '"+situacao+"', '"+endereco+"');");
						
						s.executeUpdate("INSERT INTO DBA (CPF) VALUES ('"+cpf+"');");
						
						s.close();
						c.close();
						
					} catch (Exception e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					
					Fachada.getInstancia().cadastrarFuncionario(dba);
					
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
					
					
				} catch (Objetojaexiste exc) 
				{

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Funcionario com o codigo " + exc.getId() + " Ja existe");
					alert.showAndWait();
					
				}
				
				
			}
			
			// FIM DBA
			
			if(this.gerente.isSelected())
			{
				
				beans.Gerente gerente = new beans.Gerente(cpf, idjornada, seqfilial, cnpjmatriz, dataadmissao, sex, estadocivil, login, senha, "gerente", rg, nome, situacao, endereco);
				
				try {
					
					
						
					Connection c;
						try {
							
							c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
							Statement s = c.createStatement();
							s.executeUpdate("INSERT INTO funcionario (CPF, id_jornada, seq_filial, cnpj_matriz, data_admissao"
									+ ", sex, estado_civil, login, senha, RG, nome, situacao, endereco) VALUES"
									+ "('"+ cpf +"' , '"+ idjornada +"' , '"+ seqfilial+ "' , '"+cnpjmatriz+"' "
											+ ", '"+dataadmissao+"', '"+sex+"' , '"+estadocivil+"', '"+login+"', '"+senha+"',"
													+ "'"+rg+"', '"+nome+"' , '"+situacao+"', '"+endereco+"');");
							
							s.executeUpdate("INSERT INTO gerente (CPF) VALUES ('"+cpf+"');");
							
							s.close();
							c.close();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					
					
					
					Fachada.getInstancia().cadastrarFuncionario(gerente);
					
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
					
					
				} catch (Objetojaexiste exc) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Funcionario com o codigo " + exc.getId() + " Ja existe");
					alert.showAndWait();
					
				}
				
				
			}
			// FIM DE GERENTE
			
			if(this.supervisorestoque.isSelected())
			{
				
				beans.SurpevisorEstoque sup = new beans.SurpevisorEstoque(cpf, idjornada, seqfilial, cnpjmatriz, dataadmissao, sex, estadocivil, login, senha,"supervisor estoque", rg, nome, situacao, endereco);
				
				try {
					
					
					Connection c;
					try {
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("INSERT INTO funcionario (CPF, id_jornada, seq_filial, cnpj_matriz, data_admissao"
								+ ", sex, estado_civil, login, senha, RG, nome, situacao, endereco) VALUES"
								+ "('"+ cpf +"' , '"+ idjornada +"' , '"+ seqfilial+ "' , '"+cnpjmatriz+"' "
										+ ", '"+dataadmissao+"', '"+sex+"' , '"+estadocivil+"', '"+login+"', '"+senha+"',"
												+ "'"+rg+"', '"+nome+"' , '"+situacao+"', '"+endereco+"');");
						
						s.executeUpdate("INSERT INTO supervisorestoque (CPF) VALUES ('"+cpf+"');");
						
						s.close();
						c.close();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					
					Fachada.getInstancia().cadastrarFuncionario(sup);
					
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
					
					
				} catch (Objetojaexiste exc) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Funcionario com o codigo " + exc.getId() + " Ja existe");
					alert.showAndWait();
					
				}
				
				
			}
			
			// FIM DE SUPERVISOR ESTOQUE
			
			if(this.estoquista.isSelected())
			{
				
				beans.Estoquista estoq = new beans.Estoquista(cpf, idjornada, seqfilial, cnpjmatriz, dataadmissao, sex, estadocivil, login, senha, "estoquista", rg, nome, situacao, endereco);
				
				try {
					
					
					Connection c;
					try {
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("INSERT INTO funcionario (CPF, id_jornada, seq_filial, cnpj_matriz, data_admissao"
								+ ", sex, estado_civil, login, senha, RG, nome, situacao, endereco) VALUES"
								+ "('"+ cpf +"' , '"+ idjornada +"' , '"+ seqfilial+ "' , '"+cnpjmatriz+"' "
										+ ", '"+dataadmissao+"', '"+sex+"' , '"+estadocivil+"', '"+login+"', '"+senha+"',"
												+ "'"+rg+"', '"+nome+"' , '"+situacao+"', '"+endereco+"');");
						
						s.executeUpdate("INSERT INTO estoquista (CPF) VALUES ('"+cpf+"');");
						
						s.close();
						c.close();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					
					Fachada.getInstancia().cadastrarFuncionario(estoq);
					
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
					
					
				} catch (Objetojaexiste exc) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Funcionario com o codigo " + exc.getId() + " Ja existe");
					alert.showAndWait();
					
				}
				
				
			}
			
			if(this.entregador.isSelected())
			{
				
				beans.Entregador entregador = new beans.Entregador(cpf, idjornada, seqfilial, cnpjmatriz, dataadmissao, sex, estadocivil, login, senha, "entregador", rg, nome, situacao, endereco);
				
				try {
					
					Connection c;
					try {
						
						c = ConnectionDataBase.getConnection(Logincontroller.getUsername() , Logincontroller.getPassword());
						Statement s = c.createStatement();
						s.executeUpdate("INSERT INTO funcionario (CPF, id_jornada, seq_filial, cnpj_matriz, data_admissao"
								+ ", sex, estado_civil, login, senha, RG, nome, situacao, endereco) VALUES"
								+ "('"+ cpf +"' , '"+ idjornada +"' , '"+ seqfilial+ "' , '"+cnpjmatriz+"' "
										+ ", '"+dataadmissao+"', '"+sex+"' , '"+estadocivil+"', '"+login+"', '"+senha+"',"
												+ "'"+rg+"', '"+nome+"' , '"+situacao+"', '"+endereco+"');");
						
						s.executeUpdate("INSERT INTO entregador (CPF) VALUES ('"+cpf+"');");
						
						s.close();
						c.close();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					
					Fachada.getInstancia().cadastrarFuncionario(entregador);
					
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
					
					
				} catch (Objetojaexiste exc) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Funcionario com o codigo " + exc.getId() + " Ja existe");
					alert.showAndWait();
					
				}
				
				
			}
			
			
			
			
		}
		else
		{
			this.labelaviso.setText("Preencha todos os campos");
		}
		
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		 
		ArrayList<Funcionario> f = (ArrayList<Funcionario>) Fachada.getInstancia().listarFuncionarios();
		
		this.cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		this.idjornada.setCellValueFactory(new PropertyValueFactory<>("id_jornada"));
		this.seqfilial.setCellValueFactory(new PropertyValueFactory<>("seq_filial"));
		this.cnpjmatriz.setCellValueFactory(new PropertyValueFactory<>("CNPJ_Matriz"));
		this.dtadmissao.setCellValueFactory(new PropertyValueFactory<>("data_admissao"));
		this.sexo.setCellValueFactory(new PropertyValueFactory<>("sex"));
		this.estadocivil.setCellValueFactory(new PropertyValueFactory<>("estadocivil"));
		this.login.setCellValueFactory(new PropertyValueFactory<>("login"));
		this.senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		this.rg.setCellValueFactory(new PropertyValueFactory<>("RG"));
		this.ativo.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		this.endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		this.nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.especificacao.setCellValueFactory(new PropertyValueFactory<>("especificao"));
		
		this.table.setItems(FXCollections.observableArrayList(f));
		
		
		
		
	}

}
