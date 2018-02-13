package interfaces;

import java.util.List;

import beans.Estoque;
import exceptions.Objectnotfound;

public interface RepositorioEstoqueInterface {

	public List<Estoque> listarestoque();
	
	public Estoque buscarestoque(String id) throws Objectnotfound;
	
}
