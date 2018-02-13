package negocios;

import java.util.List;

import beans.Estoque;
import beans.Fornecedor;
import beans.Funcionario;
import beans.Item_estoque;
import beans.Perda;
import beans.Prateleira;
import beans.Produto_ref;
import dados.RepositorioEstoque;
import dados.RepositorioFornecedor;
import dados.RepositorioFuncionarios;
import dados.RepositorioItem_estoque;
import dados.RepositorioPerda;
import dados.RepositorioPrateleira;
import dados.RepositorioProdutos;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import exceptions.Wrongsenha;
import interfaces.RepositorioEstoqueInterface;
import interfaces.RepositorioFornecedorInterface;
import interfaces.RepositorioFuncionarioInterface;
import interfaces.RepositorioItem_estoqueInterface;
import interfaces.RepositorioPerdaInterface;
import interfaces.RepositorioPrateleiraInterface;
import interfaces.RepositorioProdutoInterface;

public class Fachada {

	private static Fachada instancia;
	private GerenFuncionario gerenfuncionario;
	private GerenFornecedor gerenfornecedor;
	private GerenProduto gerenproduto;
	private GerenItem_estoque gerenitemestoque;
	private GerenEstoque gerenestoque;
	private GerenPrateleira gerenprate;
	private GerenPerda gerenperda;
	
	
	private Fachada()
	{
		RepositorioFuncionarioInterface repfuncionario = new RepositorioFuncionarios();
		this.gerenfuncionario = new GerenFuncionario(repfuncionario);
		
		RepositorioProdutoInterface repproduto =  new RepositorioProdutos();
		this.gerenproduto = new GerenProduto(repproduto);
		
		RepositorioFornecedorInterface repfornecedor = new RepositorioFornecedor();
		this.gerenfornecedor = new GerenFornecedor(repfornecedor);	
		
		RepositorioItem_estoqueInterface repitemestoque = new RepositorioItem_estoque();
		this.gerenitemestoque = new GerenItem_estoque(repitemestoque);
		
		RepositorioEstoqueInterface repestoque = new RepositorioEstoque();
		this.gerenestoque = new GerenEstoque(repestoque);
		
		RepositorioPrateleiraInterface repprate = new RepositorioPrateleira();
		this.gerenprate = new GerenPrateleira(repprate);
		
		RepositorioPerdaInterface repperda = new RepositorioPerda();
		this.gerenperda = new GerenPerda(repperda);
		
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
	
	public void login(String login , String senha) throws Wrongsenha
	{
		this.gerenfuncionario.Login(login, senha);
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
	
	// INICIO ITEMESTOQUE
	
	
	public void cadastraritem(Item_estoque i) throws Objetojaexiste
	{
		this.gerenitemestoque.cadastrar(i);
	}
	
	public void atualizaritem(Item_estoque i) throws Objectnotfound, Objetojaexiste
	{
		this.gerenitemestoque.atualizar(i);
	}
	
	public void removeritem(String codlote , String codproduto , String idestoque) throws Objectnotfound
	{
		this.gerenitemestoque.remover(codlote, codproduto, idestoque);
	}
	
	public Item_estoque buscaritem(String codlote, String codproduto , String idestoque) throws Objectnotfound
	{
		return this.gerenitemestoque.buscar(codlote, codproduto, idestoque);
	}
	
	public List<Item_estoque> listaritem()
	{
		return this.gerenitemestoque.listar();
	}
	
	// FIM ITEM ESTOQUE
	
	// INICIO DE ESTOQUE
	
	
	public List<Estoque> listarestoque()
	{
		return this.gerenestoque.listar();
	}
	
	public Estoque buscarestoque(String codigo) throws Objectnotfound
	{
		return this.gerenestoque.buscarestoque(codigo);
	}
	
	// FIM DE ESTOQUE
	
	// INICIO PRATELEIRA
	
	public List<Prateleira> listarprateleira()
	{
		return this.gerenprate.listar();
	}
	// FIM PRATELEIRA
	
	// INICIO DE PERDA
	
	public void cadastrarperda(Perda p ) throws Objetojaexiste
	{
		this.gerenperda.cadastrar(p);
	}
	
	public void atualizarperda(Perda p) throws Objectnotfound, Objetojaexiste
	{
		this.gerenperda.atualizar(p);
	}
	
	public void removerperda(String seq) throws Objectnotfound
	{
		this.gerenperda.remover(seq);
	}
	
	public Perda buscarperda(String seq) throws Objectnotfound
	{
		return this.gerenperda.buscar(seq);
	}
	
	public List<Perda> listarperda()
	{
		return this.gerenperda.listar();
	}
	
	// FIM DE PERDA
	
	
	
}
