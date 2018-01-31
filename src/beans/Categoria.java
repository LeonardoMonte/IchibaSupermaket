package beans;

public class Categoria {

	private String codigo;
	private String descricao;
	
	public Categoria ( String codigo, String descricao)
	{
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	public Categoria()
	{
		
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	public void setDescricao( String descricao)
	{
		this.descricao = descricao;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
