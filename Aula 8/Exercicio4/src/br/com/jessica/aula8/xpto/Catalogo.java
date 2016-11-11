package br.com.jessica.aula8.xpto;

import java.util.ArrayList;

import br.com.jessica.aula8.itens.CD;
import br.com.jessica.aula8.itens.DVD;
import br.com.jessica.aula8.itens.Item;
import br.com.jessica.aula8.itens.Livro;
import br.com.jessica.aula8.itens.Revista;

public class Catalogo {
	private ArrayList<Item> listaLivros = new ArrayList<>();
	private ArrayList<Item> listaCDs = new ArrayList<>();
	private ArrayList<Item> listaDVDs = new ArrayList<>();
	private ArrayList<Item> listaRevistas = new ArrayList<>();
	
	public void addItem(Item item){
		if(item instanceof Livro)
			listaLivros.add(item);
		else if(item instanceof CD)
			listaCDs.add(item);
		else if(item instanceof DVD)
			listaDVDs.add(item);
		else if(item instanceof Revista)
			listaRevistas.add(item);
	}
	
	public String imprimeCatalogo(){
		String catalogo;
		catalogo = "---- Livros ----\n";
		for(Item item : listaLivros)
			catalogo +=  item.imprimeItem() + "\n-------------\n";
		catalogo += "\n---- CDs ----\n";
		for(Item item : listaCDs)
			catalogo +=  item.imprimeItem() + "\n--------------\n";
		catalogo += "\n---- DVDs ----\n";
		for(Item item : listaDVDs)
			catalogo +=  item.imprimeItem() + "\n------------------\n";
		catalogo += "\n---- Revistas ----\n";
		for(Item item : listaRevistas)
			catalogo +=  item.imprimeItem() + "\n-------------\n";
		return catalogo;
	}
}
