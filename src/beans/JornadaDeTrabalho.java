package beans;

public class JornadaDeTrabalho {

	private String id;
	private String descricao;
	private boolean trabalhasabado = true;
	
	public JornadaDeTrabalho()
	{
		
	}
	
	public JornadaDeTrabalho ( String id , String descricao )
	{
		
		this.id = id;
		this.descricao = descricao;
		
	}
	
	
	public String getId()
	{
		return this.id;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	public boolean getTrabalhaSabado()
	{
		return this.trabalhasabado;
	}
	
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	public void seTrabalhasabado(boolean altera)
	{
		this.trabalhasabado = altera;
	}

	@Override
	public String toString() {
		return "JornadaDeTrabalho [id=" + id + ", descricao=" + descricao + ", trabalhasabado=" + trabalhasabado + "]";
	}
	
	
}
