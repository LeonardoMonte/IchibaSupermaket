package beans;

public class SubCategoria {

	private String codigo;
	private String cod_categoria;
	private String descricao;
	
	public SubCategoria(String codigo, String cod_categoria, String descricao) 
	{
		this.codigo = codigo;
		this.cod_categoria = cod_categoria;
		this.descricao = descricao;
	}
	
	public SubCategoria()
	{
		
	}

	public String getCodigo() {
		return codigo;
	}

	public String getCod_categoria() {
		return cod_categoria;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao)
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
		SubCategoria other = (SubCategoria) obj;
		if (cod_categoria == null) {
			if (other.cod_categoria != null)
				return false;
		} else if (!cod_categoria.equals(other.cod_categoria))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String toString() {
		return "SubCategoria [codigo=" + codigo + ", cod_categoria=" + cod_categoria + ", descricao=" + descricao + "]";
	}
	
	
	
	
	
	
}
