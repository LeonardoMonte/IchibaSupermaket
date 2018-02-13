package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Estoque;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioEstoqueInterface;

public class RepositorioEstoque implements RepositorioEstoqueInterface {

	private ArrayList<Estoque> listaestoque;
	
	
	public RepositorioEstoque()
	{
		this.listaestoque = this.load();
	}
	
	public void cadastrarestoque(Estoque e) throws Objetojaexiste
	{
		boolean result = this.estoqueexiste(e.getId());
		
		if(result == true)
		{
			throw new Objetojaexiste(e.getId());
		}
		else
		{
			this.listaestoque.add(e);
		}
	}
	
	public void removerestoque(String id) throws Objectnotfound
	{
		Estoque e = new Estoque();
		e = this.buscarestoque(id);
		
		if(e.getId() != null)
		{
			this.listaestoque.remove(e);
		}
	}
	
	public int procurarindice(String codigo) throws Objectnotfound
	{
		int cont = -1;
		
		for(int x = 0 ; x < this.listaestoque.size() ; x++)
		{
			if(this.listaestoque.get(x).getId().equals(codigo))
			{
				cont = x;
			}
		}
		
		if(cont < 0)
		{
			throw new Objectnotfound(codigo);
		}
		
		return cont;
	}
	
	
	public Estoque buscarestoque(String id) throws Objectnotfound
	{
		Estoque resultado = null;
		
		int i = this.procurarindice(id);
		resultado = this.listaestoque.get(i);
		return resultado;
		
		
	}
	
	
	public boolean estoqueexiste(String id)
	{
		boolean resultado = false;
		
		for(int x = 0 ; x < this.listaestoque.size() ; x++)
		{
			if(this.listaestoque.get(x).getId().equals(id))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	private ArrayList<Estoque> load()
	{
		ArrayList<Estoque> rep = new ArrayList<>();
		
		try
		{
		Connection c = ConnectionDataBase.getConnection2();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from estoque");
		
		while(rs.next())
		{
			
			Estoque f = new Estoque(rs.getString("id"), rs.getString("seq_filial"), rs.getString("cnpj_matriz"), rs.getString("descricao"), rs.getString("dt_ultima_entrada"));		
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
	
	public List<Estoque> listarestoque()
	{
		return this.listaestoque;
	}
	
}
