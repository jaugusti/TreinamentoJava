package br.com.jessica.projetointerface.menu;

import java.util.Scanner;

import br.com.jessica.projetointerface.Universidade;
import br.com.jessica.projetointerface.excecoes.FuncionarioException;
import br.com.jessica.projetointerface.funcionario.administrativo.Jardineiro;

public class TelaJardineiro {
	public static void iniciaTelaJardineiro(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		String nome, telefone, observacoes;
		int idade;
		
		System.out.println("---- Gerenciar Jardineiro ----");
		
		System.out.print("Nome: ");
        nome = ler.nextLine();
        
        System.out.print("Telefone: ");
        telefone = ler.nextLine();
        
        System.out.print("Observacoes: ");
        observacoes = ler.nextLine();
        
        System.out.print("Idade: ");
        idade = ler.nextInt();
        
        Jardineiro jardineiro = new Jardineiro(nome, telefone, observacoes, idade);
        
        try {
			universidade.setJardineiro(jardineiro);
		} catch (FuncionarioException e) {
			e.getMessage();
		}
	}
}
