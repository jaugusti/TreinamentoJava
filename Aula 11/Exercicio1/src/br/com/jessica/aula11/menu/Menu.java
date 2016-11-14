package br.com.jessica.aula11.menu;

import br.com.jessica.aula11.calculadora.*;

public class Menu {
	public static void teste(){
		Calculadora calculadora = new CalculadoraCientifica();
		double valor = 0;
		
		valor = ((CalculadoraCientifica) calculadora).raizQuadrada(calculadora.divisao(calculadora.soma(9, 9), 2));
		
		System.out.println("--- " + valor);
		
		valor = ((CalculadoraCientifica) calculadora).potencia(
					((CalculadoraCientifica) calculadora).raizQuadrada(calculadora.divisao(calculadora.soma(9, 9), 2)), 3);
		
		System.out.println("--- " + valor);
	}
}

