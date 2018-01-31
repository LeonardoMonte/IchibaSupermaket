package interfaces;

import beans.Produto_ref;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public interface RepositorioProdutoInterface {

	public void cadastrarProduto(Produto_ref p) throws Objetojaexiste;
	
	public void removerProduto(String codigo) throws Objectnotfound;
	
	public void atualizarproduto(Produto_ref p) throws Objectnotfound, Objetojaexiste;
	
	public Produto_ref buscarProduto(String codigo ) throws Objectnotfound;
	
	public int procurarIndiceP(String codigo) throws Objectnotfound;
	
	public boolean produtorexiste(String codigo);
	
	
}

