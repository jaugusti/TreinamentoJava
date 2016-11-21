package br.com.jessica.aula14.vetor;

import vetorexception.VetorException;

public class Vetor {
	
	public static int[] retornaVetor(int tamanho) throws VetorException{
		try{
			int[] vetor = null;
			vetor = new int[tamanho];
			return vetor;
		} catch (NegativeArraySizeException e){
			throw new VetorException("Tamanho Negativo!");
		}
	}
}
