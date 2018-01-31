package beans;

public class NCM {

	private String id; // tam max 4
	private String descricao;
	private String codMercosul;
	
	public NCM()
	{
		
	}
	
	
	public NCM(String id, String descricao, String codMercosul) {
	
		this.id = id;
		this.descricao = descricao;
		this.codMercosul = codMercosul;
		
	}

	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCodMercosul() {
		return codMercosul;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCodMercosul(String codMercosul) {
		this.codMercosul = codMercosul;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NCM other = (NCM) obj;
		if (codMercosul == null) {
			if (other.codMercosul != null)
				return false;
		} else if (!codMercosul.equals(other.codMercosul))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
