package negocios;

import java.util.List;

import beans.Fornecedor;
import dados.RepositorioFornecedor;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioFornecedorInterface;

public class GerenFornecedor {

	private RepositorioFornecedorInterface rep;
	
	public GerenFornecedor(RepositorioFornecedorInterface rep)
	{
		this.rep = rep;
	}
	
	
	public void cadastrar( Fornecedor f) throws Objetojaexiste
	{
		this.rep.cadastrarFornecedor(f);
	}
	
	public void atualizar(Fornecedor f) throws Objectnotfound, Objetojaexiste
	{
		this.rep.atualiazarFornecedor(f);
	}
	
	public void remover(String codigo) throws Objectnotfound
	{
		this.rep.removerFornecedor(codigo);
	}
	
	public int procurarindice(String codigo) throws Objectnotfound
	{
		return this.rep.procurarIndiceF(codigo);
	}
	
	public Fornecedor buscar(String codigo) throws Objectnotfound
	{
		return this.rep.buscarFornecedor(codigo);
	}
	
	public boolean existe(String codigo)
	{
		return this.rep.fornecedorexiste(codigo);
	}
	
	public List<Fornecedor> listar()
	{
		return this.rep.listarfornecedor();
	}
	
	
}
