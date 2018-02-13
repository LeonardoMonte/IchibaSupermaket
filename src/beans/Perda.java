package beans;

public class Perda {

	private String seq;
	private String cod_lote;
	private String cod_produto;
	private String id_estoque;
	private String cpf_gerente;
	private String dia;
	private int quantidade_perdida;
	private String motivo;
	
	public Perda()
	{
		
	}
	
	
	public Perda(String seq, String cod_lote, String cod_produto, String id_estoque, String cpf_gerente, String dia,
			int quantidade_perdida, String motivo) {
		super();
		this.seq = seq;
		this.cod_lote = cod_lote;
		this.cod_produto = cod_produto;
		this.id_estoque = id_estoque;
		this.cpf_gerente = cpf_gerente;
		this.dia = dia;
		this.quantidade_perdida = quantidade_perdida;
		this.motivo = motivo;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getCod_lote() {
		return cod_lote;
	}


	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}


	public String getCod_produto() {
		return cod_produto;
	}


	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}


	public String getId_estoque() {
		return id_estoque;
	}


	public void setId_estoque(String id_estoque) {
		this.id_estoque = id_estoque;
	}


	public String getCpf_gerente() {
		return cpf_gerente;
	}


	public void setCpf_gerente(String cpf_gerente) {
		this.cpf_gerente = cpf_gerente;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public int getQuantidade_perdida() {
		return quantidade_perdida;
	}


	public void setQuantidade_perdida(int quantidade_perdida) {
		this.quantidade_perdida = quantidade_perdida;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	@Override
	public String toString() {
		return "Perda [seq=" + seq + ", cod_lote=" + cod_lote + ", cod_produto=" + cod_produto + ", id_estoque="
				+ id_estoque + ", cpf_gerente=" + cpf_gerente + ", dia=" + dia + ", quantidade_perdida="
				+ quantidade_perdida + ", motivo=" + motivo + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perda other = (Perda) obj;
		if (cod_lote == null) {
			if (other.cod_lote != null)
				return false;
		} else if (!cod_lote.equals(other.cod_lote))
			return false;
		if (cod_produto == null) {
			if (other.cod_produto != null)
				return false;
		} else if (!cod_produto.equals(other.cod_produto))
			return false;
		if (cpf_gerente == null) {
			if (other.cpf_gerente != null)
				return false;
		} else if (!cpf_gerente.equals(other.cpf_gerente))
			return false;
		if (id_estoque == null) {
			if (other.id_estoque != null)
				return false;
		} else if (!id_estoque.equals(other.id_estoque))
			return false;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
