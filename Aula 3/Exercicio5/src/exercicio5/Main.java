package exercicio5;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);
		RelatorioPesquisa relatorio = new RelatorioPesquisa();
		
		for(int i = 0; i < 3; i++){
			System.out.print("Sexo: ");
			String sexo = ler.nextLine();
			
			System.out.print("Resposta: ");
			String resposta = ler.nextLine();
			
			Entrevistado entrevistado = new Entrevistado(sexo, resposta);
			relatorio.addEntrevistado(entrevistado);
		}
		
		System.out.println(relatorio.imprimeRelatorio());
	}
}
