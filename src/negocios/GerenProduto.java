package negocios;

import beans.Produto_ref;
import dados.RepositorioProdutos;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioProdutoInterface;

public class GerenProduto {
	
	private static GerenProduto instancia;
	private RepositorioProdutoInterface rep;
	
	private GerenProduto()
	{
		this.rep = RepositorioProdutos.getInstancia();
	}
	
	public static GerenProduto getInstancia()
	{
		if(instancia == null)
		{
			instancia = new GerenProduto();
		}
		
		return instancia;
	}
	
	public void cadastrar(Produto_ref p) throws Objetojaexiste
	{
		this.rep.cadastrarProduto(p);
	}
	
	public void remover(String codigo) throws Objectnotfound
	{
		this.rep.removerProduto(codigo);
	}
	
	public void atualizar(Produto_ref p) throws Objectnotfound, Objetojaexiste
	{
		this.rep.atualizarproduto(p);
	}
	
	public Produto_ref buscar(String codigo) throws Objectnotfound
	{
		return this.rep.buscarProduto(codigo);
	}
	
	public int procurarindice(String codigo) throws Objectnotfound
	{
		return this.rep.procurarIndiceP(codigo);
	}
	
	public boolean existe(String codigo)
	{
		return this.rep.produtorexiste(codigo);
	}
	
	
}
