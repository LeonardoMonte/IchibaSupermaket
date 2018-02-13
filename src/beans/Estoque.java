package beans;

public class Estoque {

	private String id;
	private String seq_filial;
	private String cnpj_matriz;
	private String descricao;
	private String dt_ultima_entrada;
	
	public Estoque()
	{
		
	}
	
	public Estoque(String id, String seq_filial, String cnpj_matriz, String descricao, String dt_ultima_entrada) {
		super();
		this.id = id;
		this.seq_filial = seq_filial;
		this.cnpj_matriz = cnpj_matriz;
		this.descricao = descricao;
		this.dt_ultima_entrada = dt_ultima_entrada;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSeq_filial() {
		return seq_filial;
	}


	public void setSeq_filial(String seq_filial) {
		this.seq_filial = seq_filial;
	}


	public String getCnpj_matriz() {
		return cnpj_matriz;
	}


	public void setCnpj_matriz(String cnpj_matriz) {
		this.cnpj_matriz = cnpj_matriz;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDt_ultima_entrada() {
		return dt_ultima_entrada;
	}


	public void setDt_ultima_entrada(String dt_ultima_entrada) {
		this.dt_ultima_entrada = dt_ultima_entrada;
	}


	@Override
	public String toString() {
		return "Estoque [id=" + id + ", seq_filial=" + seq_filial + ", cnpj_matriz=" + cnpj_matriz + ", descricao="
				+ descricao + ", dt_ultima_entrada=" + dt_ultima_entrada + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (cnpj_matriz == null) {
			if (other.cnpj_matriz != null)
				return false;
		} else if (!cnpj_matriz.equals(other.cnpj_matriz))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (seq_filial == null) {
			if (other.seq_filial != null)
				return false;
		} else if (!seq_filial.equals(other.seq_filial))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
