package br.com.jessica.aula8.zoologico;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.jessica.aula8.animais.*;
import br.com.jessica.aula8.jaula.Jaula;

public class Zoologico {
	private ArrayList<Jaula> listaJaulas = new ArrayList<>();
	private int numeroJaula = 0;
	
	public void addJaula(Jaula jaula){
		listaJaulas.add(jaula);
	}
	
	public String imprimeZoo(){
		String retorno = "";
		for(Jaula jaula : listaJaulas){
			retorno += jaula.getAnimal().getSom() + "\n";
			if(jaula.getAnimal() instanceof Mamifero)
				retorno += jaula.getAnimal().mover() + "\n";
			else if(jaula.getAnimal() instanceof Peixe)
				retorno += jaula.getAnimal().mover() + "\n";
			else if(jaula.getAnimal() instanceof Ave)
				retorno += jaula.getAnimal().mover() + "\n";
			retorno += "------------\n";
		}
		return retorno;
	}
	
	public String imprimeJaulas(){
		String retorno = "";
		for(Jaula jaula : listaJaulas){
			if(jaula.getAnimal() != null)
				retorno += "Jaula " + jaula.getNumeroJaula() + "\n" + jaula.getAnimal().dados() + "\n\n";
			else
				retorno += "Jaula " + jaula.getNumeroJaula() + "\n\n";
		}
		
		return retorno;
	}
	
	public String verificaJaulasVazias(){
		String jaulasVazias = "";
		for(Jaula jaula : listaJaulas)
			if(jaula.getAnimal() == null)
				jaulasVazias += "Jaula " + jaula.getNumeroJaula() + " Vazia\n";
		return jaulasVazias;
	}
	
	public boolean addAnimalJaulaVazia(Animal animal, int numeroJaula){
		for(Jaula jaula : listaJaulas)
			if(jaula.getNumeroJaula() == numeroJaula && jaula.getAnimal() == null){
				jaula.setAnimal(animal);
				return true;
			}
		return false;
	}
	
	public boolean criaNovaJaula(Animal animal){
		numeroJaula += 1;
		addJaula(new Jaula(animal, numeroJaula));
		
		return true;
	}
	
	public boolean removeAnimal(Zoologico zoo, int numeroJaula ){
		for(Jaula jaula : zoo.listaJaulas){
			if (jaula.getNumeroJaula() == numeroJaula && jaula.getAnimal() != null){
				jaula.setAnimal(null);	
				return true;
			}
		}
		
		return false;
	}

	public ArrayList<Jaula> getListaJaulas() {
		return listaJaulas;
	}

	public void setListaJaulas(ArrayList<Jaula> listaJaulas) {
		this.listaJaulas = listaJaulas;
	}
}
