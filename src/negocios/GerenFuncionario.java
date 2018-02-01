package negocios;

import java.util.List;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioFuncionarioInterface;

public class GerenFuncionario {

	private static GerenFuncionario instancia;
	private RepositorioFuncionarioInterface rep;
	
	private GerenFuncionario()
	{
		this.rep = RepositorioFuncionarios.getInstancia();
	}
	
	public static GerenFuncionario getInstancia()
	{
		if(instancia == null)
		{
			instancia = new GerenFuncionario();
		}
		
		return instancia;
	}
	
	public void cadastrar(Funcionario f) throws Objetojaexiste
	{
		this.rep.cadastrarFuncionario(f);
	}
	
	public void remover(String cpf) throws Objectnotfound
	{
		this.rep.removerFuncionario(cpf);
	}
	
	public void atualizar(Funcionario f) throws Objectnotfound, Objetojaexiste
	{
		this.rep.atualizarFuncionario(f);
	}
	
	public int procurarindice(String cpf) throws Objectnotfound
	{
		return this.rep.procurarIndiceF(cpf);
	}
	
	public Funcionario buscar(String cpf) throws Objectnotfound
	{
		return this.rep.buscarFuncionario(cpf);
	}
	
	public boolean existe(String cpf)
	{
		return this.rep.funcionarioexiste(cpf);
	}
	
	public List<Funcionario> listar()
	{
		return this.rep.listarfuncionarios();
	}
	
}
