package br.com.jessica.aula11.calculadora;

public abstract class Calculadora {
	
	public double soma(double valor1, double valor2){
		return valor1 + valor2;
	}
	
	public double subtracao(double valor1, double valor2){
		return valor1 - valor2;
	}
	
	public double divisao(double valor1, double valor2){
		return valor1/valor2;
	}
	
	public double multiplicacao(double valor1, double valor2){
		return valor1 * valor2;
	}
}
