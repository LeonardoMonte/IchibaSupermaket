package beans;

public class Unidade {

	private String codigo;
	private String descricao;
	private String sigla;
	
	public Unidade(String codigo, String descricao, String sigla) 
	{		
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;	
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
