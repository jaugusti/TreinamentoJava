package exercicio3;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);
		System.out.print("Lado do Quadrado: ");
		Quadrado quadrado = new Quadrado(ler.nextDouble());
		
		System.out.println(quadrado.imprimeAreaPerimetro());
	}
}
