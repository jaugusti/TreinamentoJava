package br.com.jessica.aula11.menu;

import java.util.Scanner;

import br.com.jessica.aula11.pessoa.*;
import br.com.jessica.aula11.pessoa.IMC.PessoaIMC;
import br.com.jessica.aula11.utilitarios.Util;

public class Menu {
	public static void iniciaTela(){
		Scanner ler = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nome = ler.nextLine();
		
		System.out.print("Data Nascimento: ");
		String dataNascimento = ler.nextLine();
		
		ler = new Scanner(System.in);
		System.out.print("Peso: ");
		double peso = ler.nextDouble();
		
		System.out.print("Altura: ");
		double altura = ler.nextDouble();
		
		PessoaIMC pessoa = null;
		
		System.out.println("1 - Mulher\n2 - Homem");
		int opcao = ler.nextInt();
		
		ler = new Scanner(System.in);
		
		switch(opcao){
			case 1:
				pessoa = new Mulher(nome, dataNascimento, peso, altura);
				break;
			case 2: 
				pessoa = new Homem(nome, dataNascimento, peso, altura);
				break;
			default:
				System.out.println("Opção Inválida!");
		}
		
		System.out.println(pessoa.imprimir() + "\n");
		System.out.println(pessoa.resultadoIMC());
	}
}
