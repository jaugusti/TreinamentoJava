package exercicio1;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Jessica", 22);
		
		ler = new Scanner(System.in);
		System.out.print("Aniversários: ");
		pessoa.fazAniversario(ler.nextInt());
		
		System.out.println(pessoa.retornaNomeIdade());
	}

}