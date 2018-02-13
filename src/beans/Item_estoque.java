package beans;

public class Item_estoque {

	private String cod_lote;
	private String id_estoque;
	private String cod_produto;
	private String id_avaria;
	private String id_prateleira;
	private String data_validade;
	private String data_fabricacao;
	private String data_entrada;
	private float valor_compra;
	private int quantidade;
	
	
	public Item_estoque()
	{
		
	}
	
	public Item_estoque(String cod_lote, String id_estoque, String cod_produto, String id_avaria, String id_prateleira,
			String data_validade, String data_fabricacao, String data_entrada, float valor_compra, int quantidade) {
		super();
		this.cod_lote = cod_lote;
		this.id_estoque = id_estoque;
		this.cod_produto = cod_produto;
		this.id_avaria = id_avaria;
		this.id_prateleira = id_prateleira;
		this.data_validade = data_validade;
		this.data_fabricacao = data_fabricacao;
		this.data_entrada = data_entrada;
		this.valor_compra = valor_compra;
		this.quantidade = quantidade;
	}


	public String getCod_lote() {
		return cod_lote;
	}


	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}


	public String getId_estoque() {
		return id_estoque;
	}


	public void setId_estoque(String id_estoque) {
		this.id_estoque = id_estoque;
	}


	public String getCod_produto() {
		return cod_produto;
	}


	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}


	public String getId_avaria() {
		return id_avaria;
	}


	public void setId_avaria(String id_avaria) {
		this.id_avaria = id_avaria;
	}


	public String getId_prateleira() {
		return id_prateleira;
	}


	public void setId_prateleira(String id_prateleira) {
		this.id_prateleira = id_prateleira;
	}


	public String getData_validade() {
		return data_validade;
	}


	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}


	public String getData_fabricacao() {
		return data_fabricacao;
	}


	public void setData_fabricacao(String data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}


	public String getData_entrada() {
		return data_entrada;
	}


	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}


	public float getValor_compra() {
		return valor_compra;
	}


	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public String toString() {
		return "Item_estoque [cod_lote=" + cod_lote + ", id_estoque=" + id_estoque + ", cod_produto=" + cod_produto
				+ ", id_avaria=" + id_avaria + ", id_prateleira=" + id_prateleira + ", data_validade=" + data_validade
				+ ", data_fabricacao=" + data_fabricacao + ", data_entrada=" + data_entrada + ", valor_compra="
				+ valor_compra + ", quantidade=" + quantidade + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item_estoque other = (Item_estoque) obj;
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
		if (id_estoque == null) {
			if (other.id_estoque != null)
				return false;
		} else if (!id_estoque.equals(other.id_estoque))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
