package br.com.jessica.projetointerface.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.projetointerface.Universidade;
import br.com.jessica.projetointerface.excecoes.FuncionarioException;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraCiaDasDiaristas;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraSulClean;
import br.com.jessica.projetointerface.funcionario.professor.Advogado;
import br.com.jessica.projetointerface.funcionario.professor.Dentista;
import br.com.jessica.projetointerface.interfaces.IFaxineira;
import br.com.jessica.projetointerface.interfaces.IProfessor;

public class TelaProfessor {
	public static void iniciaTelaProfessor(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		boolean gerenciarProfessor = true;
		
		while(gerenciarProfessor){
			try{
				System.out.println("--------- Gerenciar Professor ---------");
				System.out.print("1) Add Professor  2) Listar Professores\n");
				System.out.println("0 para finalizar...");
				
				int opcaoProfessor = ler.nextInt();
		        
		        switch (opcaoProfessor) {
		        	case 0: 
		        		gerenciarProfessor = false;
		        		break;
		            case 1: 
		            	lerDados(universidade);
		            	break;
		            case 2:
		            	universidade.listarProfessores();
		            	break;
		            default: 
		            	System.out.println("Opção Inválida!");
		            	break;
		        }
			} catch (InputMismatchException e) {
	    		System.out.println("O valor digitado deve ser um número!\n");
	    		ler.nextLine();
			}
		}
	}
	public static void lerDados(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		String nome, telefone, observacoes;
		int idade;
		
		System.out.print("Nome: ");
        nome = ler.nextLine();
        
        System.out.print("Telefone: ");
        telefone = ler.nextLine();
        
        System.out.print("Observacoes: ");
        observacoes = ler.nextLine();
        
        System.out.print("Idade: ");
        idade = ler.nextInt();
        
        criaProfessor(universidade, nome, telefone, observacoes, idade);
	}
	
	public static void criaProfessor(Universidade universidade, String nome, String telefone, String observacoes, int idade){
		Scanner ler = new Scanner(System.in);
		IProfessor professor = null;
        
        System.out.print("\n1) Advogado   2) Dentista\n");
        
        int opcao = ler.nextInt();
        
        switch (opcao) {
            case 1:
            	professor = new Advogado(nome, telefone, idade, observacoes);
				setProfessor(universidade, professor);
				break;
            case 2:
            	professor = new Dentista(nome, telefone, idade, observacoes);
				setProfessor(universidade, professor);
				break;
            default: 
            	System.out.println("Opção Inválida!");
            	break;
        }
	}
	
	public static void setProfessor(Universidade universidade, IProfessor professor){
		try {
			universidade.adicionarProfessor(professor);
		} catch (FuncionarioException e) {
			e.getMessage();
		}
	}
}
