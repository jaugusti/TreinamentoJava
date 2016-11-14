package br.com.jessica.aula7;

import br.com.jessica.aula7.animais.*;

public class TesteAnimais {
	public String testeAnimais(){
		String imprimeAnimais = "Zoo\n";
		Animal animal = new Animal("Camelo", 150, "Amarelo", "Terra", 2.0f, 4);
		imprimeAnimais += "------------------------------\n" + animal.dados() + "\n";
		
		animal = new Peixe("Tubarão", 300, "Cinzento", "Mar", 1.5f, "Barbatanas e Cauda", 0);
		imprimeAnimais += "------------------------------\n" + animal.dados() + "\n";
		
		animal = new Mamifero("Urso-do-canadá", 180, "Vermelho", "Mel", "Terra", 0.5f, 4);
		imprimeAnimais += "------------------------------\n" + animal.dados() + "\n";
		
		return imprimeAnimais;
	}
}
