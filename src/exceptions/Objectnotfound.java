package exceptions;

public class Objectnotfound extends Exception{

	private String idObjeto;
	
	public Objectnotfound(String idObjeto)
	{
		super("Objeto nao encontrado");
		this.idObjeto = idObjeto;
	}
	
	public String getidObjeto()
	{
		return this.idObjeto;
	}
	
	public void setidObjeto(String idObjeto)
	{
		this.idObjeto = idObjeto;
	}
	
}
