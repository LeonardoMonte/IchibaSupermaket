package beans;

import java.util.ArrayList;

public class Fornecedor {

	private String codigo;
	private String nome;
	private String CNPJ;
	private String rua;
	private String bairro;
	private String cep;
	private String estado;
	private boolean ativo = true;
	private ArrayList<String> telefone = new ArrayList<>();
	
	public Fornecedor(String codigo, String nome, String cNPJ, String rua, String bairro, String cep, String estado, String telefone) 
	{
		
		this.codigo = codigo;
		this.nome = nome;
		this.CNPJ = cNPJ;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.telefone.add(telefone);
		
	}
	
	public Fornecedor(String codigo, String nome, String cNPJ, String rua, String bairro, String cep, String estado) 
	{
		
		this.codigo = codigo;
		this.nome = nome;
		this.CNPJ = cNPJ;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		
	}
	
	public Fornecedor( String rua, String bairro, String cep, String estado , boolean ativo) 
	{
		

		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.ativo = ativo;
		
	}
	
	public Fornecedor() {
		
	}

	public ArrayList getTelefone()
	{
		return this.telefone;
	}
	
	public void addnumero(String telefone)
	{
		this.telefone.add(telefone);
	}

	public void removenumero(String numero)
	{
		
	this.telefone.remove(numero);
		
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean getAtivo()
	{
		return this.ativo;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getEstado() {
		return estado;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + "\n nome=" + nome + "\n CNPJ=" + CNPJ + "\n rua=" + rua + "\n bairro="
				+ bairro + "\n cep=" + cep + "\n estado=" + estado + "\n ativo=" + ativo + "\n telefone=" + telefone + "]\n\n\n";
	}

	

	
	
	
	
	
	
	
}
