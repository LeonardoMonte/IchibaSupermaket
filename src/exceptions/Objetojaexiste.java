package exceptions;

public class Objetojaexiste extends Exception {

	private String idObjtjaexistente;
	
	public Objetojaexiste(String idObjtjaexistente)
	{
		super("Objeto ja existe");
		this.idObjtjaexistente = idObjtjaexistente;
		
	}
	
	public String getId()
	{
		return this.idObjtjaexistente;
	}
	
	public void setId(String id)
	{
		this.idObjtjaexistente = id;
	}
}
