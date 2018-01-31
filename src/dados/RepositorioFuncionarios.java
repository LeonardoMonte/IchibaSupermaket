package dados;

import java.util.ArrayList;

import beans.Funcionario;

public class RepositorioFuncionarios {
	private static RepositorioFuncionarios instancia;
	private ArrayList<Funcionario> listafuncionarios;
	
	
	private RepositorioFuncionarios()
	{
		this.listafuncionarios = new ArrayList<>();
	}
	
	public static RepositorioFuncionarios getInstancia()
	{
		if(instancia == null)
		{
			instancia = new RepositorioFuncionarios();
		}
		
		return instancia;
	}
	
	
	
	
	
}
