package negocios;

import java.util.List;

import beans.Produto_ref;
import dados.RepositorioProdutos;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioProdutoInterface;

public class GerenProduto {
	
	private RepositorioProdutoInterface rep;
	
	public GerenProduto(RepositorioProdutoInterface rep)
	{
		this.rep = rep;
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
	
	public List<Produto_ref> listar()
	{
		return this.rep.listarprodutos();
	}
	
}
