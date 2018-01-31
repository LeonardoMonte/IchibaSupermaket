package dados;

import java.util.ArrayList;

import beans.Funcionario;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

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
	
	
	public void cadastrarFuncionario(Funcionario f) throws Objetojaexiste 
	{
		boolean result = this.funcionarioexiste(f.getCpf());
		
		if(result == true)
		{
			throw new Objetojaexiste(f.getCpf());
		}
		else
		{
			this.listafuncionarios.add(f);
		}
			
	}
	
	public void removerFuncionario(String cpf) throws Objectnotfound{

		Object f = new Object();
		f = this.buscarFuncionario(cpf);
		
		if(((Funcionario) f).getCpf() != null && f instanceof Funcionario )
		{
			this.listafuncionarios.remove(f);
			
		}
	}
	
	public int procurarIndiceF(String cpf) {

		int cont = -1;

		for (int x = 0; x < this.listafuncionarios.size(); x++) {
			if (this.listafuncionarios.get(x).getCpf().equals(cpf)) {
				cont = x;
			}
		}
		return cont;
	}
	
	public Funcionario buscarFuncionario(String cpf) throws Objectnotfound {

		Funcionario resultado = null;

		int i = this.procurarIndiceF(cpf);

		if (i >= 0) {
			resultado = this.listafuncionarios.get(i);
		}
		else
		{
			throw new Objectnotfound(cpf);
		}

		return resultado;

	}
	
	public boolean funcionarioexiste(String cpf)
	{
		boolean resultado = false;
		
		for ( int x = 0 ; x < this.listafuncionarios.size() ; x++)
		{
			if( this.listafuncionarios.get(x).getCpf().equals(cpf))
			{
				resultado = true;
			}
		}
		
		return resultado;	
	}
	
	
	
}
