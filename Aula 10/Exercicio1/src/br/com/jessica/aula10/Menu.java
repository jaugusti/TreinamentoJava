package br.com.jessica.aula10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.com.jessica.aula10.agenda.*;
import br.com.jessica.utilitarios.ValidaCpfCnpj;

public class Menu {

	public static void inicializaMenu() throws IOException{
		boolean tela = true;
		Scanner ler = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		while(tela){
			System.out.println("-- Clique 0 Para Sair --\n"
							+ "1) Adicionar Contato   2) Excluir Contato\n"
							+ "3) Editar Contatos     4) Pesquisar Contato\n"
							+ "5) Listar Contatos     6) Exportar Contatos");
			int opcao = ler.nextInt();
		
			switch(opcao){
				case 0:
					tela = false;
					break;
				case 1: 
					addContato(agenda);
					break;
				case 2:
					excluiContato(agenda);
					break;
				case 3:
					editarContato(agenda);
					break;
				case 4:
					pesquisaContato(agenda);
					break;
				case 5:
					visualizaContatos(agenda);
					break;
				case 6:
					gravarArquivo(agenda);
					break;
				default: 
					System.out.println("Opção Inválida!");
					break;
			}
		}
	}
	
	public static void addContato(Agenda agenda){
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n-- Add Contato --");
		ler = new Scanner(System.in);
		System.out.print("CPF/CNPJ: ");
		String cpfCnpj = ler.nextLine();
		String validaCpfCnpj = cpfCnpj.replaceAll("[.]|[-]|[/]", "");
		
		if((validaCpfCnpj.length() == 11 && ValidaCpfCnpj.isValidCPF(validaCpfCnpj)) | 
			(validaCpfCnpj.length() == 14 && ValidaCpfCnpj.isValidCPF(validaCpfCnpj))){
			System.out.print("Nome: ");
			String nome = ler.nextLine();
			
			System.out.print("Telefone: ");
			String telefone = ler.nextLine();
			agenda.addContato(new Contato(nome, telefone, cpfCnpj));
			System.out.print("\n");
		}
		else
			System.out.println("CPF ou CNPJ Inválido!");
	}
	
	public static void excluiContato(Agenda agenda){
		Scanner ler = new Scanner(System.in);
		System.out.println("\n-- Exclui Contato --");
		System.out.print("Nome ou Telefone: ");
		System.out.println(agenda.excluiContato(ler.nextLine()));
	}
	
	public static void visualizaContatos(Agenda agenda){
		System.out.println("\n-- Lista Contatos --");
		System.out.println(agenda.imprimeAgenda());
	}
	
	public static void pesquisaContato(Agenda agenda){
		Scanner ler = new Scanner(System.in);
		System.out.println("\n-- Pesquisa Contato --");
		System.out.print("Nome ou Telefone: ");
		System.out.println(agenda.pesquisaContato(ler.nextLine()));
	}
	
	public static void gravarArquivo(Agenda agenda) throws IOException{
		agenda.exportaContatos();
	}
	
	public static void editarContato(Agenda agenda){
		String informacao, nome = "", telefone = "", cpfCnpj = "";
		
		Scanner ler = new Scanner(System.in);
		System.out.println("\n-- Edita Contato --");
		System.out.print("Nome ou Telefone do contato que deseja editar: ");
		informacao = ler.nextLine();
		Contato contato = agenda.procuraContato(informacao);
		
		if(contato != null){
			System.out.println("Nome: " + contato.getNome());
			System.out.print("-");
			nome = ler.nextLine();
			if(verificaEdicao(nome))
				nome = contato.getNome();
			
			System.out.println("Telefone: " + contato.getTelefone());
			System.out.print("-");
			telefone = ler.nextLine();
			if(verificaEdicao(telefone))
				telefone = contato.getTelefone();
			
			System.out.println("CPF/CNPJ: " + contato.getCpfCnpj() + "\n");
			System.out.print("-");
			cpfCnpj = ler.nextLine();
			if(verificaEdicao(cpfCnpj))
				cpfCnpj = contato.getCpfCnpj();
			
			agenda.editarContato(contato, nome, telefone, cpfCnpj);
		}
		else
			System.out.println("Contato não encontrado!");
	}
	
	public static boolean verificaEdicao(String informacao){
		Scanner ler = new Scanner(System.in);
		
		if(informacao.equals("")){
			System.out.println("Deseja Excluir Informação (S/N): ");
			if(ler.nextLine().equalsIgnoreCase("n"))
					return true;
		}
		return false;
	}
}
