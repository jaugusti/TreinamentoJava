package br.com.jessica.banco.caixaeletronico.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.banco.*;
import br.com.jessica.banco.caixaeletronico.*;


public class InterfaceCaixa {
	
	public static void iniciaTela(){
		Scanner ler = new Scanner(System.in);
		Banco banco = new Banco();
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		caixaEletronico.criarLista();
		caixaEletronico.inicializarCedulasSaque();
		
		boolean conectado = true;
		
		while(conectado){
			try {
				System.out.println("1) Usu�rio Banco\n"
								+  "2) Cliente");
				int opcao = ler.nextInt();
				
				switch(opcao){
					case 1: 
						TelaUsuarioBanco.iniciaTelaUsuarioBanco(banco, caixaEletronico);
						break;
					case 2:
						TelaCliente.iniciaTelaCliente(banco, caixaEletronico);
						break;
					default: 
						System.out.println("Op��o Inv�lida!");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um n�mero!\n");
				ler.nextLine();
			}
		}
	}
	
	public static String tipoOperacao(String tipoOperacao){
		if(tipoOperacao.equals("c"))
			return "Cr�dito";
		else if(tipoOperacao.equals("d"))
			return "D�bito";
		return "Op��o de Opera��o Inv�lida!";
	}
	
	public static String operacaoPendente(boolean operacaoPendente){
		if(operacaoPendente == true)
			return "Sim";
		else
			return "N�o";
	}
	
	public static String tipoUsuario(int tipoUsuario){
		if(tipoUsuario == 0)
			return "Usu�rio Banco";
		else if(tipoUsuario == 1)
			return "Cliente";
		return "Opc��o de Usu�rio Inv�lida!";
	}
}
