package br.com.jessica.aula14.argumentos;

import java.util.ArrayList;

import br.com.jessica.aula14.stringsexception.ArgumentsException;

public class ManipulaArgumentos {
	
	public static String imprimeArgumentos(ArrayList<Argumento> listaArgumentos) throws ArgumentsException{
		String retorno = "";
		
		if(listaArgumentos.size() != 4)
			throw new ArgumentsException("Argumentos Passados: " + listaArgumentos.size() + "\n"
										+ "Valor Correto: 4");
		else{
			for(Argumento argumento : listaArgumentos)
				retorno += argumento.getTipo() + " " + argumento.getNome() + "\n";
			
			return retorno;
		}
	}
}
