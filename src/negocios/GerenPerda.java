package negocios;

import java.util.List;

import beans.Perda;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import interfaces.RepositorioPerdaInterface;

public class GerenPerda {

	private RepositorioPerdaInterface rep;
	
	public GerenPerda(RepositorioPerdaInterface rep)
	{
		this.rep = rep;
	}
	
	public void cadastrar(Perda p) throws Objetojaexiste
	{
		this.rep.cadastrarperda(p);
	}
	
	public void atualizar(Perda p) throws Objectnotfound, Objetojaexiste
	{
		this.rep.atualizarperda(p);
	}
	
	public void remover(String seq ) throws Objectnotfound
	{
		this.rep.removerperda(seq);
	}
	
	public Perda buscar(String seq) throws Objectnotfound
	{
		return this.rep.buscarperda(seq);
	}
	
	public List<Perda> listar()
	{
		return this.rep.listarperda();
	}
	
}
