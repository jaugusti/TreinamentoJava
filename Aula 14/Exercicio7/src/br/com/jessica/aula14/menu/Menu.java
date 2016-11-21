package br.com.jessica.aula14.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula14.argumentos.Argumento;
import br.com.jessica.aula14.argumentos.ManipulaArgumentos;
import br.com.jessica.aula14.stringsexception.ArgumentsException;

public class Menu {
	public static void leDados(){
		boolean erro = false, sair = false;
		Scanner ler = new Scanner(System.in);
		ArrayList<Argumento> listaArgumentos = new ArrayList<>();
		String tipo, nome;
		int opcao = -1;
		
		try {
			while(!sair){
				System.out.println("0) Sair\n"
								+ "1) Adicionar Argumento");
				opcao = ler.nextInt();
				switch(opcao){
					
					case 0:
						sair = true;
						break;
					case 1:
						ler = new Scanner(System.in);
						System.out.println("Digite o tipo: ");
						tipo = ler.nextLine();
						
						System.out.println("Digite o nome: ");
						nome = ler.nextLine();
							
						listaArgumentos.add(new Argumento(tipo, nome));
						erro = false;
				}
			}
							
			System.out.println(ManipulaArgumentos.imprimeArgumentos(listaArgumentos));
					
		} catch (ArgumentsException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
}
