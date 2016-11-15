package exercicio1;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		ler = new Scanner(System.in);

		System.out.print("Percentual de Carros Com Defeito Modelo X: ");
		Modelo modeloX = new Modelo("modelo X", 120, ler.nextFloat());
		
		Defeito defeitoX = new Defeito(modeloX);
		System.out.println(defeitoX.imprimeNumeroCarrosComDefeito());
		
		System.out.print("\nPercentual de Carros Com Defeito Modelo Y: ");
		Modelo modeloY = new Modelo("modelo Y", 40, ler.nextFloat());
		
		Defeito defeitoY = new Defeito(modeloY);
		System.out.println(defeitoY.imprimeNumeroCarrosComDefeito());
	}

}