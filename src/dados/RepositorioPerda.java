package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Perda;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioPerdaInterface;

public class RepositorioPerda implements RepositorioPerdaInterface {

	
	private ArrayList<Perda> listaperda;
	
	public RepositorioPerda()
	{
		this.listaperda = this.load();
	}
	
	public void cadastrarperda(Perda p) throws Objetojaexiste
	{
		boolean result = this.perdaexiste(p.getSeq());
		
		if(result == true)
		{
			throw new Objetojaexiste(p.getSeq());
		}
		else
		{
			this.listaperda.add(p);
		}
	}
	
	public void atualizarperda(Perda p) throws Objectnotfound, Objetojaexiste
	{
		this.removerperda(p.getSeq());
		this.cadastrarperda(p);
	}
	
	public void removerperda(String seq) throws Objectnotfound
	{
		
		Perda p = new Perda();
		p = this.buscarperda(seq);
		
		if(p.getSeq() != null)
		{
			this.listaperda.remove(p);
		}
	}
	
	public int procurarindice(String seq) throws Objectnotfound
	{
		int cont = -1;
		
		for(int x = 0 ; x < this.listaperda.size() ; x++)
		{
			if(this.listaperda.get(x).getSeq().equals(seq))
			{
				cont = x;
			}
		}
		
		if(cont < 0 )
		{
			throw new Objectnotfound(seq);
		}
		
		return cont;
	}
	
	public Perda buscarperda(String seq) throws Objectnotfound
	{
		Perda resultado = null;
		
		int i = this.procurarindice(seq);
		resultado = this.listaperda.get(i);
		return resultado;
	}
	
	
	public boolean perdaexiste(String seq)
	{
		boolean resultado = false;
		
		for(int x = 0 ; x < this.listaperda.size() ; x++)
		{
			if(this.listaperda.get(x).getSeq().equals(seq))
			{
				resultado = true;
			}
		}
		
		return resultado;
		
	}
	
	private ArrayList<Perda> load()
	{
		ArrayList<Perda> rep = new ArrayList<>();
		
		try
		{
		Connection c = ConnectionDataBase.getConnection2();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from perda");
		
		while(rs.next())
		{
			
			Perda p = new Perda(rs.getString("seq"), rs.getString("cod_lote"), rs.getString("cod_produto"), rs.getString("id_estoque"), 
					rs.getString("cpf_gerente"), rs.getString("dia"), rs.getInt("quantidade_perdida"), rs.getString("motivo"));
			
			rep.add(p);
		}
		
		
		s.close();
		c.close();	
		
		}catch(Exception e)
		{
			e.getMessage();
		}		
		
		return rep;
			
	}	
	
	
	public List<Perda> listarperda()
	{
		return this.listaperda;
	}
	
			
			
		
}
