package exercicio9;

import java.util.Scanner;

public class Main {
	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);
		
		System.out.println("Digite o Salário: ");
		float salarioPessoa = ler.nextFloat();
		
		System.out.println("Digite o Valor do Financiamento: ");
		float financiamento = ler.nextFloat();
		
		Financiamento f = new Financiamento(salarioPessoa, financiamento);
		
		System.out.println(f.imprimeSituacaoFinanciamento());
	}

}
