package interfaces;

import java.util.List;

import beans.Item_estoque;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public interface  RepositorioItem_estoqueInterface {

	public void cadastrarItem_estoque(Item_estoque i) throws Objetojaexiste;
	
	public void atualizarItem_estoque(Item_estoque i) throws Objectnotfound, Objetojaexiste;
	
	public void removerItem_Estoque(String codlote , String codproduto , String idestoque) throws Objectnotfound;
	
	public int procurarIndice(String codigolote, String idestoque, String codproduto) throws Objectnotfound;
	
	public Item_estoque buscaritem(String codigolote , String codproduto , String idestoque) throws Objectnotfound;
	
	public boolean itemexiste(String codigolote, String codproduto , String idestoque);
	
	public List<Item_estoque> listaritem_estoque();
	
	
}
