package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Item_estoque;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioItem_estoqueInterface;

public class RepositorioItem_estoque implements RepositorioItem_estoqueInterface {

	private ArrayList<Item_estoque> lista;
	
	public RepositorioItem_estoque()
	{
		this.lista = this.load();
	}
	
	public void cadastrarItem_estoque(Item_estoque i) throws Objetojaexiste
	{
		boolean result = this.itemexiste(i.getCod_lote(), i.getCod_produto(), i.getId_estoque());
		
		if(result == true)
		{
			throw new Objetojaexiste(i.getCod_produto());
		}
		
		else
		{
			this.lista.add(i);
		}
		
	}
	
	public void atualizarItem_estoque(Item_estoque i) throws Objectnotfound, Objetojaexiste
	{
		this.removerItem_Estoque(i.getCod_lote(), i.getCod_produto(), i.getId_estoque());
		this.cadastrarItem_estoque(i);
	}
	
	public void removerItem_Estoque(String codlote , String codproduto , String idestoque) throws Objectnotfound
	{
		Item_estoque i = new Item_estoque();
		i = this.buscaritem(codlote, codproduto, idestoque);
		
		if(i.getCod_lote() != null && i.getId_estoque() != null && i.getCod_produto() != null)
		{
			this.lista.remove(i);
		}
		
	}
	
	
	public int procurarIndice(String codigolote, String idestoque, String codproduto) throws Objectnotfound
	{
		int cont = -1;
		
		for(int x = 0 ; x < this.lista.size() ; x++)
		{
			if(this.lista.get(x).getCod_lote().equals(codigolote) &&
					this.lista.get(x).getCod_produto().equals(codproduto) &&
					this.lista.get(x).getId_estoque().equals(idestoque))
			{
				cont = x;
			}
		}
		
		if(cont < 0)
		{
			throw new Objectnotfound(idestoque);
		}
		
		return cont;
	}
	
	
	public Item_estoque buscaritem(String codigolote , String codproduto , String idestoque) throws Objectnotfound
	{
		Item_estoque resultado = null;
		
		int i = this.procurarIndice(codigolote, idestoque, codproduto);
		resultado = this.lista.get(i);
		return resultado;
	}
	
	public boolean itemexiste(String codigolote, String codproduto , String idestoque)
	{
		boolean resultado = false;
		
		for(int x = 0 ; x < this.lista.size() ; x++)
		{
			if(this.lista.get(x).getCod_lote().equals(codigolote) &&
					this.lista.get(x).getCod_produto().equals(codproduto) &&
					this.lista.get(x).getId_estoque().equals(idestoque))
			{
				resultado = true;
			}
		}
		
		return resultado;
		
	}
	
	
	public List<Item_estoque> listaritem_estoque()
	{
		return this.lista;
	}
	
	private ArrayList<Item_estoque> load()
	{
		ArrayList<Item_estoque> rep = new ArrayList<>();
		
		try
		{
			Connection c = ConnectionDataBase.getConnection2();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from item_estoque");
			
			while(rs.next())
			{
				Item_estoque i = new Item_estoque(rs.getString("cod_lote"), rs.getString("id_estoque"), 
						rs.getString("cod_produto"), rs.getString("id_avaria"), rs.getString("id_prateleira"), rs.getString("data_validade"), 
						rs.getString("data_fabricacao"), rs.getString("data_entrada"), rs.getFloat("valor_compra"), rs.getInt("quantidade"));
				
				rep.add(i);
			}
			
			s.close();
			c.close();
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return rep;
		
	}
	
	
	
	
	
	
}
