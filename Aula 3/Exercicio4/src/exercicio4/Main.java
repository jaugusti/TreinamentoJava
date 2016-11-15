package exercicio4;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		
		
		ler = new Scanner(System.in);
		System.out.print("Digite a Massa do Material: ");
		Material material = new Material(ler.nextFloat());
		
		System.out.println(material.imprimeResultado());
	}

}
