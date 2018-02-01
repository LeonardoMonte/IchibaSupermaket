package negocios;

import java.util.List;

import beans.Fornecedor;
import beans.Funcionario;
import beans.Produto_ref;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public class Fachada {

	private static Fachada instancia;
	private GerenFuncionario gerenfuncionario;
	private GerenFornecedor gerenfornecedor;
	private GerenProduto gerenproduto;
	
	
	private Fachada()
	{
		this.gerenfornecedor = GerenFornecedor.getInstancia();
		this.gerenfuncionario = GerenFuncionario.getInstancia();
		this.gerenproduto = GerenProduto.getInstancia();
		
	}
	
	public static Fachada getInstancia()
	{
		if(instancia == null)
		{
			instancia = new Fachada();
		}
		
		return instancia;
	}
	
	
	// INICIO FUNCIONARIO
	
	public void cadastrarFuncionario(Funcionario f) throws Objetojaexiste
	{
		this.gerenfuncionario.cadastrar(f);
	}
	
	public void removerFuncionario(String cpf) throws Objectnotfound
	{
		this.gerenfuncionario.remover(cpf);
	}
	
	public void atualizarFuncionario(Funcionario f) throws Objectnotfound, Objetojaexiste
	{
		this.gerenfuncionario.atualizar(f);
	}
	
	public int procurarindiceFuncionario(String cpf) throws Objectnotfound
	{
		return this.gerenfuncionario.procurarindice(cpf);
	}
	
	public Funcionario buscarFuncionario(String cpf) throws Objectnotfound
	{
		return this.gerenfuncionario.buscar(cpf);
	}
	
	public boolean existeFuncionario(String cpf)
	{
		return this.gerenfuncionario.existe(cpf);
	}
	
	public List<Funcionario> listarFuncionarios()
	{
		return this.gerenfuncionario.listar();
	}
	
	// FIM FUNCIONARIO
	
	
	// INICIO FORNECEDOR
	
	public void cadastrarFornecedor( Fornecedor f) throws Objetojaexiste
	{
		this.gerenfornecedor.cadastrar(f);
	}
	
	public void atualizarFornecedor(Fornecedor f) throws Objectnotfound, Objetojaexiste
	{
		this.gerenfornecedor.atualizar(f);
	}
	
	public void removerFornecedor(String codigo) throws Objectnotfound
	{
		this.gerenfornecedor.remover(codigo);
	}
	
	public int procurarindiceFornecedor(String codigo) throws Objectnotfound
	{
		return this.gerenfornecedor.procurarindice(codigo);
	}
	
	public Fornecedor buscarFornecedor(String codigo) throws Objectnotfound
	{
		return this.gerenfornecedor.buscar(codigo);
	}
	
	public boolean existeFornecedor(String codigo)
	{
		return this.gerenfornecedor.existe(codigo);
	}
	
	public List<Fornecedor> listarFornecedores()
	{
		return this.gerenfornecedor.listar();
	}
	
	
	// FIM FORNECEDOR
	
	
	// INICIO PRODUTO
	
	public void cadastrarProduto(Produto_ref p) throws Objetojaexiste
	{
		this.gerenproduto.cadastrar(p);
	}
	
	public void removerProduto(String codigo) throws Objectnotfound
	{
		this.gerenproduto.remover(codigo);
	}
	
	public void atualizarProduto(Produto_ref p) throws Objectnotfound, Objetojaexiste
	{
		this.gerenproduto.atualizar(p);
	}
	
	public Produto_ref buscarProduto(String codigo) throws Objectnotfound
	{
		return this.gerenproduto.buscar(codigo);
	}
	
	public int procurarindiceProduto(String codigo) throws Objectnotfound
	{
		return this.gerenproduto.procurarindice(codigo);
	}
	
	public boolean existeProduto(String codigo)
	{
		return this.gerenproduto.existe(codigo);
	}
	
	public List<Produto_ref> listarProdutos()
	{
		return this.gerenproduto.listar();
	}
	
	
	// FIM PRODUTO
	
	
}
