package br.com.jessica.aula14.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula14.vetor.Vetor;
import vetorexception.VetorException;

public class Menu {
	public static void iniciaTela(){
		Scanner ler = new Scanner(System.in);

		try{
			System.out.print("Digite o tamanho do vetor: ");
			Vetor.retornaVetor(ler.nextInt());
			
			System.out.println("Vetor Criado!");
		} catch(VetorException e){
			System.out.println(e.getMessage());
		}
	}
}
