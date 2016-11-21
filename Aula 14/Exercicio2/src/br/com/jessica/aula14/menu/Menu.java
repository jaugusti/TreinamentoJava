package br.com.jessica.aula14.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula14.numeros.Calculos;

public class Menu {
	public static void iniciaTela(){
		boolean erro = false;
		int dividendo = 0, divisor = 1; 
		Scanner ler = new Scanner(System.in);

		dividendo = Entrada.leEntrada("Dividendo");
		divisor = Entrada.leEntrada("Divisor");
		
		System.out.println(Calculos.divide(dividendo, divisor));
	}
}
