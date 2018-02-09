package dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionDataBase;
import beans.Produto_ref;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioProdutoInterface;

public class RepositorioProdutos implements RepositorioProdutoInterface {
	
		private static RepositorioProdutos instancia;
		private ArrayList<Produto_ref> listaprodutos;
		
		
		private RepositorioProdutos()
		{
			this.listaprodutos = this.load();
			
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
		
		public List<Produto_ref> listarprodutos()
		{
			return this.listaprodutos;
		}
		
		public static ArrayList<Produto_ref> load()
		{
			ArrayList<Produto_ref> array = new ArrayList<>();
				
				try
				{
				Connection c = ConnectionDataBase.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("select * from produto_ref");
				
				while(rs.next())
				{
					
					
				Produto_ref p = new Produto_ref(rs.getString("cod"), rs.getString("id_unidade"), 
						rs.getString("id_marca"), rs.getString("id_ncm"), rs.getString("id_categoria")
						, rs.getString("id_subcategoria"), rs.getString("id_fornecedor"), 
						rs.getInt("qtd_estoque"), rs.getFloat("ICMS"), rs.getString("CST")
						, rs.getFloat("preco_por_tabela"), rs.getString("cod_barra"), rs.getFloat("freq_pedido"), 
						rs.getString("descricao"),rs.getInt("qtd_min"), rs.getInt("qtd_total_estoque"),
						rs.getFloat("preco_ult_compra"));
					
					array.add(p);
					
					
				}
				
				s.close();
				c.close();
				
				}
				
				catch(Exception e)
				{
					e.getMessage();
				}
			
			return array;
		}
		
		
}
