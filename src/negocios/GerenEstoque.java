package negocios;

import java.util.List;

import beans.Estoque;
import exceptions.Objectnotfound;
import interfaces.RepositorioEstoqueInterface;

public class GerenEstoque {

	private RepositorioEstoqueInterface rep;
	
	public GerenEstoque( RepositorioEstoqueInterface rep)
	{
		this.rep = rep;
		
	}
	
	public List<Estoque> listar()
	{
		return this.rep.listarestoque();
	}
	
	public Estoque buscarestoque(String codigo) throws Objectnotfound
	{
		return this.rep.buscarestoque(codigo);
	}
	
}
