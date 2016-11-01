package exercicio2;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		Combustivel alcool = new Combustivel(2.57f, 2.10f);
		Combustivel gasolina = new Combustivel(3.39f, 3.39f);		
					
		ler = new Scanner(System.in);
		System.out.print("Alcool (litros): ");
		Bomba bombaalcool = new Bomba(alcool, ler.nextFloat());
		
		System.out.print("Gasolina (litros): ");
		Bomba bombagasolina = new Bomba(gasolina, ler.nextFloat());
		
		Caixa nota = new Caixa();
		nota.adicionaBomba(bombaalcool);
		nota.adicionaBomba(bombagasolina);	
		System.out.println("\n----- Valor Pagamento -----\n" + nota.calculaPagamento());	    
	}

}
