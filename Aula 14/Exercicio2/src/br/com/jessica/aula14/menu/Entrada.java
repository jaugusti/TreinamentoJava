package br.com.jessica.aula14.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	public static int leEntrada(String nomeValor){
		boolean erro = false;
		int valor = 1; 
		Scanner ler = new Scanner(System.in);
		
		
		do{
			try{
				int forcaErro = 0;
				
				System.out.print("Digite o " + nomeValor + ": ");
				valor = ler.nextInt();
				
				if(nomeValor.equalsIgnoreCase("divisor"))
					forcaErro = 1 / valor;
				
				erro = false;
			} catch (InputMismatchException e) {
				System.out.println("-- O valor digitado deve ser um número! --");
				ler.next();
				
				erro = true;
				
			} catch (ArithmeticException e) {
				System.out.println("-- O valor digitado deve ser diferente de zero! --");
				
				erro = true;
			}
			
		} while(erro);
		
		return valor;
	}
}
