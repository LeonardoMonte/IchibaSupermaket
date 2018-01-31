package dados;

import java.util.ArrayList;

import beans.Produto_ref;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioProdutoInterface;

public class RepositorioProdutos implements RepositorioProdutoInterface {
	
		private static RepositorioProdutos instancia;
		private ArrayList<Produto_ref> listaprodutos;
		
		
		private RepositorioProdutos()
		{
			this.listaprodutos = new ArrayList<>();
			
		}
		
		public static RepositorioProdutos getInstancia()
		{
			if(instancia == null)
			{
				instancia = new RepositorioProdutos();
			}
			
			return instancia;
		}
		
		
		
		public void cadastrarProduto(Produto_ref p) throws Objetojaexiste
		{
			boolean resultado = this.produtorexiste(p.getCodigo());
			
			if( resultado == true)
			{
				throw new Objetojaexiste(p.getCodigo());
			}
			else
			{
				this.listaprodutos.add(p);
			}
		}
		
		public void removerProduto(String codigo) throws Objectnotfound
		{

			Produto_ref p = new Produto_ref();
			p = this.buscarProduto(codigo);
			
			if( p.getCodigo() != null)
			{
				this.listaprodutos.remove(p);
				
			}
		}
		
		public void atualizarproduto(Produto_ref p) throws Objectnotfound, Objetojaexiste
		{
			this.removerProduto(p.getCodigo());
			this.cadastrarProduto(p);
			
		}
			
		
		public Produto_ref buscarProduto(String codigo ) throws Objectnotfound 
		{

			Produto_ref resultado = null;

			int i = this.procurarIndiceP(codigo);
			resultado = this.listaprodutos.get(i);
			return resultado;

		}
		
		
		public int procurarIndiceP(String codigo) throws Objectnotfound
		{

			int cont = -1;

			for (int x = 0; x < this.listaprodutos.size() ; x++) {
				if (this.listaprodutos.get(x).getCodigo().equals(codigo)) {
					cont = x;
				}
			}
			
			if(cont < 0)
			{
				throw new Objectnotfound(codigo);
			}
			
			
			return cont;
		}
		
		
		
		public boolean produtorexiste(String codigo)
		{
			boolean resultado = false;
			
			for ( int x = 0 ; x < this.listaprodutos.size() ; x++)
			{
				if( this.listaprodutos.get(x).getCodigo().equals(codigo))
				{
					resultado = true;
				}
			}
			
			return resultado;	
		}
		
		
		
}
