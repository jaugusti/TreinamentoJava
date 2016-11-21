package br.com.jessica.aula14.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula14.numeros.Calculos;
import numeroexception.NumeroException;

public class Menu {
	public static void iniciaTela(){
		try{
			System.out.println(Calculos.divide(9, 3));
		} catch(NumeroException e){
			System.out.println(e.getMessage());
		}
	}
}
