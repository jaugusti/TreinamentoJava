package br.com.jessica.aula11.calculadora;

public class CalculadoraCientifica extends Calculadora{
	
	public double raizQuadrada(double valor){
		return Math.sqrt(valor);
	}
	
	public double potencia(double valor, double expoente){
		return Math.pow(valor, expoente);
	}
}
