package br.com.jessica.aula6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.aula6.caixaeletronico.CaixaEletronico;
import br.com.jessica.aula6.caixaeletronico.Notas;

public class InterfaceCaixa {
	public static void iniciaTela(){
		Scanner ler = new Scanner(System.in);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		boolean conectado = true;
		
		while(conectado){		
			try{
				System.out.println("1) Usuário Banco\n" 
								+  "2) Cliente");
				int opcao = ler.nextInt();
				
				switch(opcao){
					case 1: 
						usuarioBanco(caixaEletronico);
						break;
					case 2:
						cliente(caixaEletronico);
						break;
					default: 
						System.out.println("Opção Inválida!");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!\n");
				ler.nextLine();
			}
		}
	}
	
	public static void usuarioBanco(CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		System.out.print("Digite a senha: ");
		
		if(ler.nextLine().equals("123mudar"))
			opcaoUsuarioBanco(caixaEletronico);
		else
			System.out.println("Senha Incorreta!\n");
	}
	
	public static void opcaoUsuarioBanco(CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		boolean usuarioBancoLogado = true;
		int opcao = -1;
		
		do{
			try{
				System.out.println("\n-- 0 Para Retornar Ao Menu Anterior --");
				System.out.println("1) Visualizar Notas\n"
								 + "2) Repor Notas");
				
				opcao = ler.nextInt();
			
				switch(opcao){
					case 0:
						usuarioBancoLogado = false;
						System.out.println("Sessão Encerrada!\n");
						break;
					case 1: 
						visualizaNotas(caixaEletronico);
						break;
					case 2:
						reporNotas(caixaEletronico);
						break;
					default: 
						System.out.println("Opção Inválida!");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!");
				ler.nextLine();
			}
		} while(usuarioBancoLogado);
	}
	
	public static void visualizaNotas(CaixaEletronico caixaEletronico){
		ArrayList<Notas> notasDisponiveis = new ArrayList<>();
		notasDisponiveis = caixaEletronico.visualizarNotas(1);
		
		if(notasDisponiveis.size() != 0)
			for(Notas nota : notasDisponiveis)
				System.out.println("Notas de " + nota.getValorNota() + ": " + nota.getQtdNotas() + " disponíveis.");
	}
	
	public static void reporNotas(CaixaEletronico caixaEletronico){
		reporNotasPorValor(caixaEletronico, 50);
		reporNotasPorValor(caixaEletronico, 20);
		reporNotasPorValor(caixaEletronico, 10);
		reporNotasPorValor(caixaEletronico, 5);
		reporNotasPorValor(caixaEletronico, 2);
	}
	
	public static void reporNotasPorValor(CaixaEletronico caixaEletronico, int valorNota){
		boolean erro = true;
		Scanner ler = new Scanner(System.in);
		
		while(erro){
			try{
				System.out.print("Quantidade de notas de R$" + valorNota + ": ");
				int qtdNotas =  ler.nextInt();
				caixaEletronico.reporNota(valorNota, qtdNotas);
				
				erro = false;
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!\n");
				ler.nextLine();
			}
		}
	}
	
	public static void cliente(CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		boolean clienteLogado = true;
		int opcao = -1;
		
		do{
			try{
				System.out.println("\n-- 0 Para Retornar Ao Menu Anterior --");
				System.out.println("1) Saque\n");
				
				opcao = ler.nextInt();
			
				switch(opcao){
					case 0:
						clienteLogado = false;
						System.out.println("Sessão Encerrada!\n");
						break;
					case 1: 
						notasDisponiveis(caixaEletronico);
						break;
					default: 
						System.out.println("Opção Inválida!");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!");
				ler.nextLine();
			}
		} while(clienteLogado);
	}
	
	public static void notasDisponiveis(CaixaEletronico caixaEletronico){
		ArrayList<Notas> notasDisponiveis = new ArrayList<>();
		
		notasDisponiveis = caixaEletronico.visualizarNotas(2);
		
		if(notasDisponiveis.size() != 0){
			System.out.println("-- Notas disponíveis --");
			for(Notas nota : notasDisponiveis)
				System.out.print("R$" + nota.getValorNota() + "  ");
			
			saque(caixaEletronico);
		}
		else
			System.out.println("Caixa Sem Notas!");
	}
	
	public static void saque(CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		
		System.out.print("\nDigite o valor do saque: ");			
		if(caixaEletronico.sacar(ler.nextInt())){
			imprimeNotasSaque(caixaEletronico);
			System.out.println("Saque realizado!");
			caixaEletronico.zerarNotasSaque();
		}
		else
			System.out.println("Não foi possível realizar a operação!");
	}
	
	public static void imprimeNotasSaque(CaixaEletronico caixaEletronico){
		ArrayList<Notas> notasSaque = new ArrayList<>();
		
		notasSaque = caixaEletronico.notasSaque();
		
		for(Notas nota : notasSaque)
			if(nota.getQtdNotas() != 0)
				System.out.println(nota.getQtdNotas() + " notas de " + nota.getValorNota());
	}
}
