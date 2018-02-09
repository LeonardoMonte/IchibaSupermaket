package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Fornecedor;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioFornecedorInterface;


public class RepositorioFornecedor implements RepositorioFornecedorInterface {
	
	private static RepositorioFornecedor instancia;
	private ArrayList<Fornecedor> listafornecedor;
	
	
	private RepositorioFornecedor()
	{
		this.listafornecedor = this.load();
	}
	
	public static RepositorioFornecedor getInstancia()
	{
		if(instancia == null)
		{
			instancia = new RepositorioFornecedor();
		}
		
		return instancia;
	}
	
		
	public void cadastrarFornecedor (Fornecedor f) throws Objetojaexiste 
	{
		boolean result = this.fornecedorexiste(f.getCodigo());
		
		if(result == true)
		{
			throw new Objetojaexiste(f.getCodigo());
		}
		else
		{
			this.listafornecedor.add(f);
		}
			
	}
	
	public void atualiazarFornecedor(Fornecedor f) throws Objectnotfound, Objetojaexiste
	{
		this.removerFornecedor(f.getCodigo());
		this.cadastrarFornecedor(f);
	}
	
	public void removerFornecedor(String codigo) throws Objectnotfound
	{

		Fornecedor f = new Fornecedor();
		f = this.buscarFornecedor(codigo);
		
		if( f.getCodigo() != null)
		{
			this.listafornecedor.remove(f);
			
		}
	}
	
	public int procurarIndiceF(String codigo) throws Objectnotfound 
	{

		int cont = -1;

		for (int x = 0; x < this.listafornecedor.size(); x++) {
			if (this.listafornecedor.get(x).getCodigo().equals(codigo)) {
				cont = x;
			}
		}
		
		if ( cont < 0 )
		{
			throw new Objectnotfound(codigo);
		}
		
		return cont;
	}
	
	public Fornecedor buscarFornecedor(String codigo ) throws Objectnotfound 
	{

		Fornecedor resultado = null;

		int i = this.procurarIndiceF(codigo);
		resultado = this.listafornecedor.get(i);
		return resultado;

	}
	
	
	public boolean fornecedorexiste(String codigo)
	{
		boolean resultado = false;
		
		for ( int x = 0 ; x < this.listafornecedor.size() ; x++)
		{
			if( this.listafornecedor.get(x).getCodigo().equals(codigo))
			{
				resultado = true;
			}
		}
		
		return resultado;	
	}
	
	private static ArrayList<Fornecedor> load()
	{
		ArrayList<Fornecedor> rep = new ArrayList<>();
		
		try
		{
		Connection c = ConnectionDataBase.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from fornecedor");
		
		while(rs.next())
		{
			Fornecedor f = new Fornecedor(rs.getString("cod"), rs.getString("nome"), rs.getString("CNPJ"),
					rs.getString("rua"), rs.getString("bairro"), rs.getString("CEP"), rs.getString("estado"));
			
			rep.add(f);
		}
		
		s.close();
		c.close();	
		
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
		return rep;
		
		
	}
	
	
	public List<Fornecedor> listarfornecedor()
	{
		return this.listafornecedor;
	}
	
	
	
}
