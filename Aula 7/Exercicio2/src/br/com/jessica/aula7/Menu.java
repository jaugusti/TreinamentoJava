package br.com.jessica.aula7;

import java.util.Scanner;

import br.com.jessica.aula7.ingresso.*;
import br.com.jessica.aula7.ingresso.VIP.CamaroteInferior;
import br.com.jessica.aula7.ingresso.VIP.CamaroteSuperior;
import br.com.jessica.aula7.ingresso.VIP.VIP;

public class Menu {
	private static Scanner ler;
	
	public static void tela(){
		Ingresso ingresso = null;
		
		ler = new Scanner(System.in);
		System.out.println("1 - Normal\n2 - VIP");
		int opcao = ler.nextInt();
		
		switch (opcao) {
			case 1: ingressoNormal(ingresso);
					break;
			case 2: ingressoVIP(ingresso);
					break;
			default: System.out.println("Opção Inválida!!");
		}

	}
	
	public static void ingressoNormal(Ingresso ingresso){
		ingresso = new Normal(10f);
		System.out.println(ingresso.imprimeTipoIngresso() + ingresso.imprimeValorIngresso());
	}
	
	public static void ingressoVIP(Ingresso ingresso){
		ingresso = new VIP(10f, 2.5f);
		System.out.println(ingresso.imprimeTipoIngresso());
		
		ler = new Scanner(System.in);
		System.out.println("1 - Camarote Inferior\n2 - Camarote Superior");
		int opcao = ler.nextInt();
		
		switch (opcao) {
			case 1: vipCamaroteInferior(ingresso);
					break;
			case 2: vipCamaroteSuperior(ingresso);
					break;
			default: System.out.println("Opção Inválida!!");
		}
	}
	
	public static void vipCamaroteInferior(Ingresso ingresso){
		ingresso = new CamaroteInferior(10f, 2.5f, "Cadeira 2");
		System.out.println(((VIP) ingresso).imprimeLocalizacaoIngresso() + ingresso.imprimeValorIngresso());
	}
	
	public static void vipCamaroteSuperior(Ingresso ingresso){
		ingresso = new CamaroteSuperior(10f, 2.5f, 5.5f, "Cadeira 6");
		System.out.println(((VIP) ingresso).imprimeLocalizacaoIngresso() + ingresso.imprimeValorIngresso());
	}
}
