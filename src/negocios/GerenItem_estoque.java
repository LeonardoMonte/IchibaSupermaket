package negocios;

import java.util.List;

import beans.Item_estoque;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioItem_estoqueInterface;

public class GerenItem_estoque {
	
	private RepositorioItem_estoqueInterface rep;
	
	public GerenItem_estoque (RepositorioItem_estoqueInterface rep)
	{
		this.rep = rep;
	}
	
	public void cadastrar(Item_estoque i )  throws Objetojaexiste
	{
		this.rep.cadastrarItem_estoque(i);
	}
	
	public void atualizar(Item_estoque i) throws Objectnotfound, Objetojaexiste
	{
		this.rep.atualizarItem_estoque(i);
	}
	
	public void remover(String codlote , String codproduto , String idestoque) throws Objectnotfound
	{
		this.rep.removerItem_Estoque(codlote, codproduto, idestoque);
	}
	
	public int procurarindice(String codlote, String codproduto , String idestoque) throws Objectnotfound
	{
		return this.rep.procurarIndice(codlote, idestoque, codproduto);
	}
	
	public Item_estoque buscar(String codlote, String codproduto , String idestoque) throws Objectnotfound
	{
		return this.rep.buscaritem(codlote, codproduto, idestoque);
	}
	
	public List<Item_estoque> listar()
	{
		return this.rep.listaritem_estoque();
	}
	

}
