package interfaces;

import beans.Fornecedor;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public interface RepositorioFornecedorInterface {

	public void cadastrarFornecedor (Fornecedor f) throws Objetojaexiste ;
	
	public void atualiazarFornecedor(Fornecedor f) throws Objectnotfound, Objetojaexiste;
	
	public void removerFornecedor(String codigo) throws Objectnotfound;
	
	public int procurarIndiceF(String codigo) throws Objectnotfound;
	
	public Fornecedor buscarFornecedor(String codigo ) throws Objectnotfound;
	
	public boolean fornecedorexiste(String codigo);
	
	
	
}
