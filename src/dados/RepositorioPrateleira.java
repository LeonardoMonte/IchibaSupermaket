package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Prateleira;
import exceptions.Objectnotfound;
import interfaces.RepositorioPrateleiraInterface;

public class RepositorioPrateleira implements RepositorioPrateleiraInterface {

	private ArrayList<Prateleira> listaprate;
	
	public RepositorioPrateleira()
	{
		this.listaprate = this.load();
	}
	
	
	public int procurarindice(String codigo) throws Objectnotfound
	{
		int cont = -1;
		
		for(int x = 0 ; x < this.listaprate.size() ; x++)
		{
			if(this.listaprate.get(x).getCodigo().equals(codigo))
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
	
	public Prateleira buscarprate(String codigo) throws Objectnotfound
	{
		Prateleira resultado = null;
		
		int i = this.procurarindice(codigo);
		resultado = this.listaprate.get(i);
		
		return resultado;
	}
	
	public boolean prateleiraexiste(String codigo)
	{
		boolean resultado = false;
		
		for(int x = 0 ; x < this.listaprate.size() ; x++)
		{
			if(this.listaprate.get(x).getCodigo().equals(codigo))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	private ArrayList<Prateleira> load()
	{
		ArrayList<Prateleira> rep = new ArrayList<>();
		
		try
		{
		Connection c = ConnectionDataBase.getConnection2();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from prateleira");
		
		while(rs.next())
		{
			Prateleira f = new Prateleira(rs.getString("codigo"), rs.getFloat("altura"), rs.getFloat("comprimento"), rs.getString("posicao_nivel"));
			
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
	
	public List<Prateleira> listarprate()
	{
		return this.listaprate;
	}
	
}
