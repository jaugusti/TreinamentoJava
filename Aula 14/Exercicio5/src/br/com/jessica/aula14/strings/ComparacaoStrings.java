package br.com.jessica.aula14.strings;

import java.util.ArrayList;

import br.com.jessica.aula14.stringsexception.ComparacaoStringException;

public class ComparacaoStrings {
	
	public static int comparaStrings(String string1, String string2) throws ComparacaoStringException{
		try{
			return string1.compareToIgnoreCase(string2);
		} catch(NullPointerException e) {
			throw new ComparacaoStringException("Não é permitido valores nulos!");
		}
	}
}
