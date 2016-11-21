package br.com.jessica.aula14.numeros;

import numeroexception.NumeroException;

public class Calculos {
	
	public static int divide(int dividendo, int divisor) throws NumeroException{
		try{
			return dividendo/divisor;
		
		} catch(ArithmeticException e) {
			throw new NumeroException("Não é permitido divisor igual a zero!");
		}
	}
}
