package br.com.jessica.projetointerface.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.projetointerface.Universidade;
import br.com.jessica.projetointerface.excecoes.AlunoException;

public class Menu {
	public static void iniciaMenu() {
		Scanner ler = new Scanner(System.in);
		Universidade ufsm = new Universidade();
		
		while(true){
			try {
				System.out.print("------------ MENU ------------\n"
                        + "1) Jardineiro     2) Faxineira\n"
                        + "3) Professor      4) Aluno\n"
                        + "5) Limpeza\n");
				
                int opcao = ler.nextInt();
       
                switch (opcao) {
                    case 1: 
                    	TelaJardineiro.iniciaTelaJardineiro(ufsm);
                    	break;
                    case 2:
                        TelaFaxineira.iniciaTelaFaxineira(ufsm);
                    	break;
                    case 3:
                        TelaProfessor.iniciaTelaProfessor(ufsm);
                        break;
                    case 4:
                    	TelaAluno.iniciaTelaAluno(ufsm);
                    	break;
                    case 5:
                    	ufsm.diaDaLimpeza();
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            
			} catch (InputMismatchException e) {
        		System.out.println("O valor digitado deve ser um número!\n");
        		ler.nextLine();
			} catch (NullPointerException e) {
        		System.out.println("Falta de funcionários!\n");
        		ler.nextLine();
			}
		}
	}
}