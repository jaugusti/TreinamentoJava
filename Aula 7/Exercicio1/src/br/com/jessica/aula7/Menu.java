package br.com.jessica.aula7;

import java.util.Scanner;

import br.com.jessica.aula7.imovel.*;

public class Menu {
	private static Scanner ler;

	public static void menu() {
		Imovel imovel;
		
		ler = new Scanner(System.in);
		System.out.println("1 - Novo\n2 - Velho");
		
		int opcao = ler.nextInt();
		
		switch (opcao) {
			case 1: imovel = new Novo("Daltro Filho, 159", 1000.50f, 450f);
					System.out.println(imovel.imprimePrecoImovel());
					break;
			case 2: imovel = new Velho("Daltro Filho, 159", 1000.50f, 100f);
					System.out.println(imovel.imprimePrecoImovel());
					break;
			default: System.out.println("Opção Inválida!!");
		}
	}
}
