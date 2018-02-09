package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.DBA;
import beans.Entregador;
import beans.Estoquista;
import beans.Funcionario;
import beans.Gerente;
import beans.SurpevisorEstoque;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import exceptions.Wrongsenha;
import interfaces.RepositorioFuncionarioInterface;


public class RepositorioFuncionarios implements RepositorioFuncionarioInterface {
	
	private static RepositorioFuncionarios instancia;
	private ArrayList<Funcionario> listafuncionarios;
	
	
	private RepositorioFuncionarios()
	{
		this.listafuncionarios = this.load();
	}
	
	public static RepositorioFuncionarios getInstancia()
	{
		if(instancia == null)
		{
			instancia = new RepositorioFuncionarios();
		}
		
		return instancia;
	}
	
	
	public void cadastrarFuncionario(Funcionario f) throws Objetojaexiste 
	{
		boolean result = this.funcionarioexiste(f.getCpf());
		
		if(result == true)
		{
			throw new Objetojaexiste(f.getCpf());
		}
		else
		{
			this.listafuncionarios.add(f);
		}
			
	}
	
	public void atualizarFuncionario(Funcionario f) throws Objectnotfound, Objetojaexiste
	{
		this.removerFuncionario(f.getCpf());
		this.cadastrarFuncionario(f);
		
		
	}
	
	public void removerFuncionario(String cpf) throws Objectnotfound
	{

		Object f = new Object();
		f = this.buscarFuncionario(cpf);
		
		if(((Funcionario) f).getCpf() != null && f instanceof Funcionario )
		{
			this.listafuncionarios.remove(f);
			
		}
	}
	
	public int procurarIndiceF(String cpf) throws Objectnotfound
	{

		int cont = -1;

		for (int x = 0; x < this.listafuncionarios.size(); x++) {
			if (this.listafuncionarios.get(x).getCpf().equals(cpf)) {
				cont = x;
			}
		}
		
		if( cont < 0 )
		{
			throw new Objectnotfound(cpf);
		}
		
		return cont;
	}
	
	public Funcionario buscarFuncionario(String cpf) throws Objectnotfound 
	{

		Funcionario resultado = null;

		int i = this.procurarIndiceF(cpf);
		resultado = this.listafuncionarios.get(i);
		return resultado;

	}
	
	public void login(String login, String senha) throws Wrongsenha
	{
		int contacerto = 0;
		
		for(int x = 0 ; x < this.listafuncionarios.size() ; x++)
		{
			if(this.listafuncionarios.get(x).getSenha().equals(senha) && this.listafuncionarios.get(x).getLogin().equals(login))
			{
				contacerto++;
			}
		}
		
		if(contacerto == 0)
		{
			throw new Wrongsenha(login);
		}
	}
	
	public boolean funcionarioexiste(String cpf)
	{
		boolean resultado = false;
		
		for ( int x = 0 ; x < this.listafuncionarios.size() ; x++)
		{
			if( this.listafuncionarios.get(x).getCpf().equals(cpf))
			{
				resultado = true;
			}
		}
		
		return resultado;	
	}
	
	public List<Funcionario> listarfuncionarios()
	{
		return this.listafuncionarios;
	}
	
	
	private static ArrayList<Funcionario> load()
	{
		ArrayList<Funcionario> f = new ArrayList<>();
		
		
		try
		{
			Connection c = ConnectionDataBase.getConnection();
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery("select * from funcionario inner join DBA where funcionario.CPF = DBA.cpf;");		
			
			while(rs.next())
			{		
				System.out.println(rs.getString("endereco"));
				
				DBA dba = new DBA(rs.getString("CPF"), rs.getString("id_jornada") , rs.getString("seq_filial"), rs.getString("cnpj_matriz")
						, rs.getString("data_admissao"),rs.getString("sex"), rs.getString("estado_civil")
						,rs.getString("login"), rs.getString("senha"), "DBA",rs.getString("RG") ,
						rs.getString("nome") , rs.getString("situacao"), rs.getString("endereco") );
				
					
				System.out.println(dba);
				
				f.add(dba);
			}
			
			ResultSet entregador = s.executeQuery("select * from funcionario inner join entregador where funcionario.CPF = entregador.cpf;");		
			
			while(entregador.next())
			{		
				
				Entregador entre = new Entregador(entregador.getString("CPF"), entregador.getString("id_jornada"), 
						 entregador.getString("seq_filial"), entregador.getString("cnpj_matriz")
						 , entregador.getString("data_admissao"), entregador.getString("sex"), 
						 entregador.getString("estado_civil"), entregador.getString("login") ,
						 entregador.getString("senha"), "entregador",entregador.getString("RG") ,
						 entregador.getString("nome"),entregador.getString("situacao"), entregador.getString("endereco"));
				
				f.add(entre);
			}
			
			ResultSet estoquista = s.executeQuery("select * from funcionario inner join estoquista where funcionario.CPF = estoquista.cpf;");		
			
			while(estoquista.next())
			{		
				Estoquista estoq = new Estoquista(estoquista.getString("CPF"), estoquista.getString("id_jornada"),
						estoquista.getString("seq_filial"), estoquista.getString("cnpj_matriz"), estoquista.getString("data_admissao")
						, estoquista.getString("sex"), estoquista.getString("estado_civil"), estoquista.getString("login")
						, estoquista.getString("senha"), "estoquista", estoquista.getString("RG") , estoquista.getString("nome")
						, estoquista.getString("situacao"), estoquista.getString("endereco"));
				
				f.add(estoq);
			}
			
			ResultSet gerente = s.executeQuery("select * from funcionario inner join gerente where funcionario.CPF = gerente.cpf;");		
			
			while(gerente.next())
			{		
				Gerente geren = new Gerente(gerente.getString("CPF"), gerente.getString("id_jornada"),
						gerente.getString("seq_filial"), gerente.getString("cnpj_matriz"), gerente.getString("data_admissao")
						, gerente.getString("sex"), gerente.getString("estado_civil"), gerente.getString("login"), 
						gerente.getString("senha"), "gerente", gerente.getString("RG") , gerente.getString("nome")
						, gerente.getString("situacao") , gerente.getString("endereco"));
				
				f.add(geren);
			}
			
			ResultSet spv = s.executeQuery("select * from funcionario inner join supervisorestoque where funcionario.CPF = supervisorestoque.cpf;");		
			
			while(spv.next())
			{		
				SurpevisorEstoque supervisor = new SurpevisorEstoque(spv.getString("CPF"), spv.getString("id_jornada"), spv.getString("seq_filial")
						, spv.getString("cnpj_matriz"),spv.getString("data_admissao") , spv.getString("sex")
						, spv.getString("estado_civil"), spv.getString("login"), spv.getString("senha")
						, "supervisor estoque", spv.getString("RG"), spv.getString("nome"), spv.getString("situacao"), spv.getString("endereco"));
			
				f.add(supervisor);
			}
			
		c.close();
		s.close();
			
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return f;
		
		
		
		
		
	}
	
	
}
