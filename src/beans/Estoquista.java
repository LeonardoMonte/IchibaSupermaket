package beans;

public class Estoquista extends Funcionario {

	public Estoquista(String cpf, String id_jornada, String seq_filial, String CNPJ_Matriz, String data_admissao,
			char sex, String estadocivil, String login, String senha, String RG, String nome, String situacao,
			String endereco, String telefone) {
		super(cpf, id_jornada, seq_filial, CNPJ_Matriz, data_admissao, sex, estadocivil, login, senha, RG, nome, situacao,
				endereco, telefone);
		
	}
	
	public Estoquista()
	{
		super();
	}


}
