package exercicio8;

import java.util.Scanner;

public class Main {
	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);
		System.out.println("Digite o Ano: ");
		Bissexto  ano = new Bissexto(ler.nextInt());
		
		System.out.println(ano.imprimeResultado());
	}
}
