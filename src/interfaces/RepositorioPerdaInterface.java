package interfaces;

import java.util.List;

import beans.Perda;
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;

public interface RepositorioPerdaInterface {

	public void cadastrarperda(Perda p) throws Objetojaexiste;
	
	public void atualizarperda(Perda p) throws Objectnotfound, Objetojaexiste;
	
	public void removerperda(String seq) throws Objectnotfound;
	
	public Perda buscarperda(String seq) throws Objectnotfound;
	
	public List<Perda> listarperda();
}
