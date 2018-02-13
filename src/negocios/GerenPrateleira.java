package negocios;

import java.util.List;

import beans.Prateleira;
import interfaces.RepositorioPrateleiraInterface;

public class GerenPrateleira {

	
	private RepositorioPrateleiraInterface rep;
	
	public GerenPrateleira(RepositorioPrateleiraInterface rep)
	{
		this.rep = rep;
	}
	
	public List<Prateleira> listar()
	{
		return this.rep.listarprate();
	}
}
