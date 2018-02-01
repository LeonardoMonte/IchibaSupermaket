package beans;

public class Produto_ref {

	private String codigo;
	private String id_unidade;
	private String id_marca;
	private String id_ncm;
	private String id_categoria;
	private String id_subcategoria;
	private String id_fornecedor;
	private int qtd_estoque;
	private float ICMS;
	private String CST;
	private float preco_por_tabela;
	private String cod_barra;
	private float freq_pedido;
	private String descricao;
	private int qtd_min;
	private int qtd_total_estoque;
	private float preco_ult_compra;
	
	
	public Produto_ref()
	{
		
	}
	
	public Produto_ref(String codigo, String id_unidade, String id_marca, String id_ncm, String id_categoria,
			String id_subcategoria, String id_fornecedor, int qtd_estoque, float iCMS, String cST,
			float preco_por_tabela, String cod_barra, float freq_pedido, String descricao, int qtd_min,
			int qtd_total_estoque, float preco_ult_compra) 
	{
		
		this.codigo = codigo;
		this.id_unidade = id_unidade;
		this.id_marca = id_marca;
		this.id_ncm = id_ncm;
		this.id_categoria = id_categoria;
		this.id_subcategoria = id_subcategoria;
		this.id_fornecedor = id_fornecedor;
		this.qtd_estoque = qtd_estoque;
		ICMS = iCMS;
		CST = cST;
		this.preco_por_tabela = preco_por_tabela;
		this.cod_barra = cod_barra;
		this.freq_pedido = freq_pedido;
		this.descricao = descricao;
		this.qtd_min = qtd_min;
		this.qtd_total_estoque = qtd_total_estoque;
		this.preco_ult_compra = preco_ult_compra;
	}


	public String getCodigo() {
		return codigo;
	}


	public String getId_unidade() {
		return id_unidade;
	}


	public String getId_marca() {
		return id_marca;
	}


	public String getId_ncm() {
		return id_ncm;
	}


	public String getId_categoria() {
		return id_categoria;
	}


	public String getId_subcategoria() {
		return id_subcategoria;
	}


	public String getId_fornecedor() {
		return id_fornecedor;
	}


	public int getQtd_estoque() {
		return qtd_estoque;
	}


	public float getICMS() {
		return ICMS;
	}


	public String getCST() {
		return CST;
	}


	public float getPreco_por_tabela() {
		return preco_por_tabela;
	}


	public String getCod_barra() {
		return cod_barra;
	}


	public float getFreq_pedido() {
		return freq_pedido;
	}


	public String getDescricao() {
		return descricao;
	}


	public int getQtd_min() {
		return qtd_min;
	}


	public int getQtd_total_estoque() {
		return qtd_total_estoque;
	}


	public float getPreco_ult_compra() {
		return preco_ult_compra;
	}


	public void setId_unidade(String id_unidade) {
		this.id_unidade = id_unidade;
	}


	public void setId_marca(String id_marca) {
		this.id_marca = id_marca;
	}


	public void setId_ncm(String id_ncm) {
		this.id_ncm = id_ncm;
	}


	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}


	public void setId_subcategoria(String id_subcategoria) {
		this.id_subcategoria = id_subcategoria;
	}


	public void setId_fornecedor(String id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}


	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}


	public void setICMS(float iCMS) {
		ICMS = iCMS;
	}


	public void setCST(String cST) {
		CST = cST;
	}


	public void setPreco_por_tabela(float preco_por_tabela) {
		this.preco_por_tabela = preco_por_tabela;
	}


	public void setCod_barra(String cod_barra) {
		this.cod_barra = cod_barra;
	}


	public void setFreq_pedido(float freq_pedido) {
		this.freq_pedido = freq_pedido;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setQtd_min(int qtd_min) {
		this.qtd_min = qtd_min;
	}


	public void setQtd_total_estoque(int qtd_total_estoque) {
		this.qtd_total_estoque = qtd_total_estoque;
	}


	public void setPreco_ult_compra(float preco_ult_compra) {
		this.preco_ult_compra = preco_ult_compra;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto_ref other = (Produto_ref) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String toString() {
		return "Produto_ref [codigo=" + codigo + ", id_unidade=" + id_unidade + ", id_marca=" + id_marca + ", id_ncm="
				+ id_ncm + ", id_categoria=" + id_categoria + ", id_subcategoria=" + id_subcategoria
				+ ", id_fornecedor=" + id_fornecedor + ", qtd_estoque=" + qtd_estoque + ", ICMS=" + ICMS + ", CST="
				+ CST + ", preco_por_tabela=" + preco_por_tabela + ", cod_barra=" + cod_barra + ", freq_pedido="
				+ freq_pedido + ", descricao=" + descricao + ", qtd_min=" + qtd_min + ", qtd_total_estoque="
				+ qtd_total_estoque + ", preco_ult_compra=" + preco_ult_compra + "]";
	}
	
	
	
	
	
	
}
