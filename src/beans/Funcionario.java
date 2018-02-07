package beans;

import java.util.ArrayList;

public abstract class Funcionario {

	private String cpf;
	private String id_jornada;
	private String seq_filial;
	private String CNPJ_Matriz;
	private String data_admissao;
	private String sex;
	private String estadocivil;
	private String login;
	private String senha;
	private String RG;
	private String nome;
	private String situacao;
	private String endereco;
	private ArrayList<String> telefone = new ArrayList<String>();;
	
	
	public Funcionario(String cpf , String id_jornada , String seq_filial , String CNPJ_Matriz , 
			String data_admissao , String sex , String estadocivil , String login , String senha, String RG,
			String nome, String situacao , String endereco , String telefone)
	{
		
		this.cpf = cpf;
		this.id_jornada = id_jornada;
		this.seq_filial = seq_filial;
		this.CNPJ_Matriz = CNPJ_Matriz;
		this.data_admissao = data_admissao;
		this.sex = sex;
		this.estadocivil = estadocivil;
		this.login = login;
		this.senha = senha;
		this.RG = RG;
		this.situacao = situacao;
		this.endereco = endereco;
		this.telefone.add(telefone);
		
		
	}
	
	public Funcionario(String cpf , String id_jornada , String seq_filial , String CNPJ_Matriz , 
			String data_admissao , String sex , String estadocivil , String login , String senha, String RG,
			String nome, String situacao , String endereco )
	{
		
		this.cpf = cpf;
		this.id_jornada = id_jornada;
		this.seq_filial = seq_filial;
		this.CNPJ_Matriz = CNPJ_Matriz;
		this.data_admissao = data_admissao;
		this.sex = sex;
		this.estadocivil = estadocivil;
		this.login = login;
		this.senha = senha;
		this.RG = RG;
		this.situacao = situacao;
		this.endereco = endereco;
		
		
	}
	
	public Funcionario() {
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
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public String getCpf() {
		return cpf;
	}


	public String getId_jornada() {
		return id_jornada;
	}


	public String getSeq_filial() {
		return seq_filial;
	}


	public String getCNPJ_Matriz() {
		return CNPJ_Matriz;
	}


	public String getData_admissao() {
		return data_admissao;
	}


	public String getSex() {
		return sex;
	}


	public String getEstadocivil() {
		return estadocivil;
	}


	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}


	public String getRG() {
		return RG;
	}


	public String getNome() {
		return nome;
	}


	public String getSituacao() {
		return situacao;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setId_jornada(String id_jornada) {
		this.id_jornada = id_jornada;
	}


	public void setSeq_filial(String seq_filial) {
		this.seq_filial = seq_filial;
	}


	public void setCNPJ_Matriz(String cNPJ_Matriz) {
		CNPJ_Matriz = cNPJ_Matriz;
	}


	public void setData_admissao(String data_admissao) {
		this.data_admissao = data_admissao;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + "\n id_jornada=" + id_jornada + "\n seq_filial=" + seq_filial
				+ "\n CNPJ_Matriz=" + CNPJ_Matriz + "\n data_admissao=" + data_admissao + "\n sex=" + sex
				+ "\n estadocivil=" + estadocivil + "\n login=" + login + "\n senha=" + senha + "\n RG=" + RG + "\n nome="
				+ nome + "\n situacao=" + situacao + "\n endereco=" + endereco + "\n telefone=" + telefone + "]\n\n";
	}
	
	
		
	
	
}
