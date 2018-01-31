package beans;

public class Matriz {

	private String CNPJ;
	private String NomeFantasia;
	
	public Matriz()
	{
		
	}
	
	public Matriz( String CNPJ, String NomeFantasia)
	{
		this.CNPJ = CNPJ;
		this.NomeFantasia = NomeFantasia;
	}
	
	public String getCNPJ()
	{
		return this.CNPJ;
	}
	
	public String getNomeFantasia()
	{
		return this.NomeFantasia;
	}
	
	public void setNomeFantasia(String neww)
	{
		this.NomeFantasia = neww;
	}
	
	
}
