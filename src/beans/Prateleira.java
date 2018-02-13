package beans;

public class Prateleira {

	private String codigo;
	private float altura;
	private float comprimento;
	private String posicao_nivel;
	
	public Prateleira()
	{
		
	}
	
	public Prateleira(String codigo, float altura, float comprimento, String posicao_nivel) {
		super();
		this.codigo = codigo;
		this.altura = altura;
		this.comprimento = comprimento;
		this.posicao_nivel = posicao_nivel;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public float getComprimento() {
		return comprimento;
	}


	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}


	public String getPosicao_nivel() {
		return posicao_nivel;
	}


	public void setPosicao_nivel(String posicao_nivel) {
		this.posicao_nivel = posicao_nivel;
	}


	@Override
	public String toString() {
		return "Prateleira [codigo=" + codigo + ", altura=" + altura + ", comprimento=" + comprimento
				+ ", posicao_nivel=" + posicao_nivel + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prateleira other = (Prateleira) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
}
