package exercicio3;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);
		
		System.out.print("Número de Mercadorias: ");
		int numeroMercadorias = Math.abs(ler.nextInt());
		ler.nextLine();
		
		Relatorio relatorio = new Relatorio();
		for(int i = 0; i < numeroMercadorias; i++){
			System.out.print("Mercadoria: ");
			String nomeMercadoria = ler.nextLine();
			ler.reset();
			
			System.out.print("Preço de Compra: ");
			float precoDeCompra = ler.nextFloat();
			
			System.out.print("Preço de Venda: ");
			float precoDeVenda = ler.nextFloat();
			
			Mercadoria mercadoria = new Mercadoria(nomeMercadoria, precoDeCompra, precoDeVenda);
			relatorio.addMercadoria(mercadoria);
			
			ler.nextLine();
		}

		System.out.print(relatorio.imprimeRelatorio());
	}
}
