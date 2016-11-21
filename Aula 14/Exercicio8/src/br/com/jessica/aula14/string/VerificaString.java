package br.com.jessica.aula14.string;

import br.com.jessica.aula14.exception.CaracterMinusculoException;

public class VerificaString {
	
	public static boolean verificaLetrasMaiusculas(String palavra) throws CaracterMinusculoException{

		for(int i = 0; i < palavra.length(); i++){
			if(!Character.isLetter(palavra.charAt(i)))
				throw new CaracterMinusculoException("Palavra possui caracter que não é letra!");
			else if(!Character.isUpperCase(palavra.charAt(i)))
				throw new CaracterMinusculoException("Palavra possui caracter minúsculo!");
		}
		
		return true;
	}
}
