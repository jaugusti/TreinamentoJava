package br.com.jessica.aula6;

import java.util.Scanner;

import br.com.jessica.aula6.caixaeletronico.CaixaEletronico;
import br.com.jessica.aula6.caixaeletronico.Notas;

public class InterfaceCaixa {
	private static Scanner ler = new Scanner(System.in);
	private static CaixaEletronico caixaEletronico = new CaixaEletronico();
	
	public static void iniciaTela(){
		boolean conectado = true;
		
		while(conectado){
			System.out.print(visualizaNotas(2));
			
			System.out.println("\n1) Usuário Banco -" + "- 2) Cliente");
			int opcao = ler.nextInt();
			
			switch(opcao){
				case 1: 
					usuarioBanco();
					break;
				case 2:
					cliente();
					break;
				default: 
					System.out.println("Opção Inválida!");
					break;
			}
		}
	}
	
	public static void usuarioBanco(){
		ler = new Scanner(System.in);
		System.out.print("Digite a senha: ");
		
		if(ler.nextLine().equals("123mudar"))
			opcaoUsuarioBanco();
		else
			System.out.println("Senha Incorreta!\n");
	}
	
	public static void opcaoUsuarioBanco(){
		int opcao = 0;
		while(opcao != 3){
			System.out.println("\n-- Saldo Caixa Eletrônico: " + caixaEletronico.calculaSaldoCaixa() + " --");
			System.out.println("1) Visualizar Notas -" + "- 2) Inserir Notas -" + "- 3) Sair");
			opcao = ler.nextInt();
			switch(opcao){
				case 1: 
					System.out.println(visualizaNotas(1));
					break;
				case 2: 
					insereNotas();
					break;
				case 3:
					break;
				default: 
					System.out.println("Opção Inválida!");
					break;
			}
		}
	}
	
	public static String visualizaNotas(int identificaUsuario){
		String retorna = "";
		if(identificaUsuario == 1)
			for(Notas nota : caixaEletronico.getListaNotas())
				retorna += "Notas de " + nota.getValor() + ": " + nota.getQuantidade() + " célula(s) disponível(is)\n";
		else{
			retorna += "Notas Disponiveis - ";
			for(Notas nota : caixaEletronico.getListaNotas()){
				if(nota.getQuantidade() > 0)
					retorna += "R$" + nota.getValor() + " ";
			}}
		return retorna;
	}
	
	public static void insereNotas(){
		ler = new Scanner(System.in);
		
		System.out.print("Notas de R$50,00: ");
		caixaEletronico.insereNotas(50, ler.nextInt());
		
		System.out.print("Notas de R$20,00: ");
		caixaEletronico.insereNotas(20, ler.nextInt());
		
		System.out.print("Notas de R$10,00: ");
		caixaEletronico.insereNotas(10, ler.nextInt());
		
		System.out.print("Notas de R$5,00: ");
		caixaEletronico.insereNotas(5, ler.nextInt());
		
		System.out.print("Notas de R$2,00: ");
		caixaEletronico.insereNotas(2, ler.nextInt());
	}
	
	public static void cliente(){
		System.out.print("Valor: ");
		System.out.println(caixaEletronico.retiraDinheiro(ler.nextInt()));
	}
}
