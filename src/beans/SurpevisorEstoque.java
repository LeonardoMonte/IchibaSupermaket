package beans;

public class SurpevisorEstoque extends Funcionario {

	
	public SurpevisorEstoque(String cpf, String id_jornada, String seq_filial, String CNPJ_Matriz, String data_admissao, String sex,
			String estadocivil, String login, String senha,  String esp, String RG, String nome, String situacao, String endereco) {
		super(cpf, id_jornada, seq_filial, CNPJ_Matriz, data_admissao, sex, estadocivil, login, senha, RG, nome, situacao,
				endereco , esp);
	}
	
	
	public SurpevisorEstoque()
	{
		super();
	}


	


}
