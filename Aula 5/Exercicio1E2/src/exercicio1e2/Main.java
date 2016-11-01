package exercicio1e2;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		
		ler = new Scanner(System.in);
		System.out.print("Número de Contatos: ");
		int qtdPessoas = ler.nextInt();
		
		for(int i = 0; i < qtdPessoas; i++){
			ler = new Scanner(System.in);
			
			System.out.print("Nome Pessoa: ");
			String nomePessoa = ler.nextLine();
			
			System.out.print("Endereço: ");
			String endereçoPessoa = ler.nextLine();
			
			System.out.print("Telefone: ");
			String telefonePessoa = ler.nextLine();
			
			Pessoa pessoa = new Pessoa(nomePessoa, endereçoPessoa, telefonePessoa);
			p.addPessoa(pessoa);
		}
		
		System.out.println(p.imprimir());
	}

}