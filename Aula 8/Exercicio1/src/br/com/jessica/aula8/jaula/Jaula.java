package br.com.jessica.aula8.jaula;

import br.com.jessica.aula8.animais.*;

public class Jaula {
	private Animal animal;
	private int numeroJaula;
	
	public Jaula(Animal animal, int numeroJaula){
		this.animal = animal;
		this.numeroJaula = numeroJaula;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getNumeroJaula() {
		return numeroJaula;
	}

	public void setNumeroJaula(int numeroJaula) {
		this.numeroJaula = numeroJaula;
	}
}
