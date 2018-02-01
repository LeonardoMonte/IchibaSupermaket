package interfaces;

import java.util.List;

import beans.Funcionario;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public interface RepositorioFuncionarioInterface {

	public void cadastrarFuncionario(Funcionario f) throws Objetojaexiste;
	
	public void atualizarFuncionario(Funcionario f) throws Objectnotfound, Objetojaexiste;
	
	public void removerFuncionario(String cpf) throws Objectnotfound;
	
	public int procurarIndiceF(String cpf) throws Objectnotfound;
	
	public Funcionario buscarFuncionario(String cpf) throws Objectnotfound;
	
	public boolean funcionarioexiste(String cpf);
	
	public List<Funcionario> listarfuncionarios();
	
	
	
	
	
}
