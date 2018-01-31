package beans;

import java.util.ArrayList;

public class Filial {

	private String sequencial;
	private String CNPJ_Matriz;
	private String CPF_gerente;
	private String endereco;
	private int quantidadefunc;
	private ArrayList<String> telefone;
	
	public Filial ( String seq , String cnpj , String cpf, String end, int quant , String telefone )
	{
		this.sequencial = seq;
		this.CNPJ_Matriz = cnpj;
		this.CPF_gerente = cpf;
		this.endereco = end;
		this.quantidadefunc = quant;
		this.telefone.add(telefone);
	}
	
	public String getTelefone()
	{
		return this.telefone.toString();
	}

	public String getSequencial() {
		return sequencial;
	}

	public String getCNPJ_Matriz() {
		return CNPJ_Matriz;
	}

	public String getCPF_gerente() {
		return CPF_gerente;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getQuantidadefunc() {
		return quantidadefunc;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	public void setCNPJ_Matriz(String cNPJ_Matriz) {
		CNPJ_Matriz = cNPJ_Matriz;
	}

	public void setCPF_gerente(String cPF_gerente) {
		CPF_gerente = cPF_gerente;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public void addfuncionario()
	{
		this.quantidadefunc++;
	}
	
	public void removerfuncinario()
	{
		this.quantidadefunc--;
	}
	
	
	
	
	
}
