package br.com.jessica.aula14.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula14.strings.ComparacaoStrings;
import br.com.jessica.aula14.stringsexception.ComparacaoStringException;

public class Menu {
	public static void leDados(){
		boolean erro = false;
		Scanner ler = new Scanner(System.in);
		
		do{
			try {
				System.out.print("Digite a primeira string: ");
				String string1 = ler.nextLine();
				
				System.out.print("Digite a segunda string: ");
				String string2 = ler.nextLine();
				
				int resultadoComparacao = ComparacaoStrings.comparaStrings(string1, string2);
				exibeComparacao(resultadoComparacao);
				
			} catch (ComparacaoStringException e) {
				System.out.println(e.getMessage() + "\n");
				erro = true;
			}
		} while(erro);
	}
	
	public static void exibeComparacao(int resultadoComparacao){
		if(resultadoComparacao < 0)
			System.out.println("A primeira string é menor que a segunda!");
		else if(resultadoComparacao > 0)
			System.out.println("A primeira string é maior que a segunda!");
		else
			System.out.println("As strings são iguais!");
	}
}
