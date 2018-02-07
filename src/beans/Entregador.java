package beans;

public class Entregador extends Funcionario {

	public Entregador(String cpf, String id_jornada, String seq_filial, String CNPJ_Matriz, String data_admissao,
			String sex, String estadocivil, String login, String senha, String RG, String nome, String situacao,
			String endereco, String telefone) {
		super(cpf, id_jornada, seq_filial, CNPJ_Matriz, data_admissao, sex, estadocivil, login, senha, RG, nome, situacao,
				endereco, telefone);
	}

	public Entregador(String cpf, String id_jornada, String seq_filial, String CNPJ_Matriz, String data_admissao,
			String sex, String estadocivil, String login, String senha, String RG, String nome, String situacao,
			String endereco) {
		super(cpf, id_jornada, seq_filial, CNPJ_Matriz, data_admissao, sex, estadocivil, login, senha, RG, nome, situacao,
				endereco);
	}
	
	public Entregador()
	{
		super();
	}

}
