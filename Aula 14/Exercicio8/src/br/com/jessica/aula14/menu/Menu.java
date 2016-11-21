package br.com.jessica.aula14.menu;

import java.util.Scanner;

import br.com.jessica.aula14.exception.CaracterMinusculoException;
import br.com.jessica.aula14.string.VerificaString;

public class Menu {
	public static void leDados(){
		boolean erro = false;
		Scanner ler = new Scanner(System.in);
		String palavra = "";
		
		do{
			try {
				System.out.print("Digite a palavra: ");
				palavra = ler.nextLine();
				
				if(VerificaString.verificaLetrasMaiusculas(palavra));
					System.out.println("\n-- Palavra composta apenas por caracteres maiúsculos --\n" + palavra);
				
				erro = false;
				
			} catch (CaracterMinusculoException e) {
				System.out.println(e.getMessage() + "\n");
				erro = true;
			}
		} while(erro);
	}
}
