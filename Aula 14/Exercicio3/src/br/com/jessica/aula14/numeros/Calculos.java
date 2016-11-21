package br.com.jessica.aula14.numeros;

import numeroexception.NumeroException;

public class Calculos {
	
	public static int divide(int dividendo, int divisor) throws NumeroException{
		try{
			return dividendo/divisor;
		
		} catch(ArithmeticException e) {
			throw new NumeroException("N�o � permitido divisor igual a zero!");
		}
	}
}
