package br.com.jessica.projetointerface.menu;

import java.util.Scanner;

import br.com.jessica.projetointerface.Universidade;
import br.com.jessica.projetointerface.excecoes.FuncionarioException;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraCiaDasDiaristas;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraSulClean;
import br.com.jessica.projetointerface.interfaces.IFaxineira;

public class TelaFaxineira {
	public static void iniciaTelaFaxineira(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		String nome, telefone, observacoes;
		int idade;
		
		System.out.println("---- Gerenciar Faxineira ----");
		
		System.out.print("Nome: ");
        nome = ler.nextLine();
        
        System.out.print("Telefone: ");
        telefone = ler.nextLine();
        
        System.out.print("Observacoes: ");
        observacoes = ler.nextLine();
        
        System.out.print("Idade: ");
        idade = ler.nextInt();
        
        criaFaxineira(universidade, nome, telefone, observacoes, idade);
	}
	
	public static void criaFaxineira(Universidade universidade, String nome, String telefone, String observacoes, int idade){
		Scanner ler = new Scanner(System.in);
		IFaxineira faxineira = null;
		
        System.out.println("Empresas\n"
                	+ "1) Cia das diaristas   2) Sul Clean");
        
        int empresaFaxineira = ler.nextInt();
        
        switch (empresaFaxineira) {
            case 1:
                faxineira = new FaxineiraCiaDasDiaristas(nome, telefone, observacoes, idade);
				setFaxineira(universidade, faxineira);
				break;
            case 2:
                faxineira = new FaxineiraSulClean(nome, telefone, observacoes, idade);
                setFaxineira(universidade, faxineira);
                break;
            default: 
            	System.out.println("Opção Inválida!");
        }
	}
	
	public static void setFaxineira(Universidade universidade, IFaxineira faxineira){
		try {
			universidade.setFaxineira(faxineira);
		} catch (FuncionarioException e) {
			e.getMessage();
		}
	}
}
