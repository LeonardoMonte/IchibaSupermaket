package exceptions;

public class Wrongsenha extends Exception{

	private String senhaerrada;
	
	public Wrongsenha(String senhaerrada)
	{
		super("Senha incorreta");
		this.senhaerrada = senhaerrada;
	}
	
	public String getSenhaErrada()
	{
		return this.senhaerrada;
				
	}
	
	public void setSenhaErrada(String senhaerrada)
	{
		this.senhaerrada = senhaerrada;
	}
}
