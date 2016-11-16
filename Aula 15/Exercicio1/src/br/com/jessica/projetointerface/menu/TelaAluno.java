package br.com.jessica.projetointerface.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.projetointerface.Universidade;
import br.com.jessica.projetointerface.aluno.Aluno;
import br.com.jessica.projetointerface.excecoes.AlunoException;

public class TelaAluno {
	public static void iniciaTelaAluno(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		boolean gerenciarAluno = true;
		
		while(gerenciarAluno){
			try {
				System.out.println("---- Gerenciar Aluno ----");
				System.out.println("1) Adicionar   2) Excluir\n"
							     + "3) Editar      4) Listar");
				System.out.println("0 para finalizar...");
				
				int opcaoAluno = ler.nextInt();
				
				switch(opcaoAluno){
					case 0: 
						gerenciarAluno = false;
						break;
					case 1: 
						lerDados(universidade);
						break;
					case 2:
						excluirAluno(universidade);
						break;
					case 3:
						editarAluno(universidade);
						break;
					case 4:
						listarAluno(universidade);
						break;
					default:
						System.out.println("Opção Inválida!");
						break;
				}
			}  catch (AlunoException e) {
				System.out.println(e.getMessage() + "\n");
        		ler.nextLine();
        		
			} catch (InputMismatchException e) {
	    		System.out.println("O valor digitado deve ser um número!\n");
	    		ler.nextLine();
			}
		}
	}
	
	public static void lerDados(Universidade universidade){
		Scanner ler = new Scanner(System.in);
		String nome, email, endereco, bairro, cidade, cep, estado, pais, telefone;
		
		System.out.print("Nome: ");
        nome = ler.nextLine();
        
        System.out.print("Email: ");
        email = ler.nextLine();
        
        System.out.print("Endereço: ");
        endereco = ler.nextLine();
        
        System.out.print("Bairro: ");
        bairro = ler.nextLine();
        
        System.out.print("Cidade: ");
        cidade = ler.nextLine();
        
        System.out.print("CEP: ");
        cep = ler.nextLine();
        
        System.out.print("Estado: ");
        estado = ler.nextLine();
        
        System.out.print("País: ");
        pais = ler.nextLine();
        
        System.out.print("Telefone: ");
        telefone = ler.nextLine();
        Aluno aluno = new Aluno(nome, email, endereco, bairro, cidade, cep, estado, pais, telefone);
        universidade.adicionarAluno(aluno);
	}
	
	public static void excluirAluno(Universidade universidade) throws AlunoException{
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o índide do aluno: ");
		universidade.excluirAluno(ler.nextInt());
	}
	
	public static void editarAluno(Universidade universidade) throws AlunoException{
		Scanner ler = new Scanner(System.in);
		String nome = "", email = "", endereco = "", bairro = "", cidade = "", cep = "", estado = "", pais = "", telefone = "";
		System.out.println("Digite o indice do aluno que deseja editar: ");
		Aluno aluno = universidade.getAluno(ler.nextInt());
		
		if(aluno != null){
			ler = new Scanner(System.in);
			System.out.print("Nome: " + aluno.getNome());
			System.out.print("\n-- ");
	        nome = ler.nextLine();
	        if(verificaEdicao(nome))
	        	nome = aluno.getNome();
	        
	        System.out.print("Email: " + aluno.getEmail());
	        System.out.print("\n-- ");
	        email = ler.nextLine();
	        if(verificaEdicao(email))
	        	email = aluno.getEmail();
	       
	        System.out.print("Endereço: " + aluno.getEndereco());
	        System.out.print("\n-- ");
	        endereco = ler.nextLine();
	        if(verificaEdicao(endereco))
	        	endereco = aluno.getEndereco();
	        
	        System.out.print("Bairro: " + aluno.getBairro());
	        System.out.print("\n-- ");
	        bairro = ler.nextLine();
	        if(verificaEdicao(bairro))
	        	bairro = aluno.getBairro();
	        
	        System.out.print("Cidade: " + aluno.getCidade());
	        System.out.print("\n-- ");
	        cidade = ler.nextLine();
	        if(verificaEdicao(cidade))
	        	cidade = aluno.getCidade();
	        
	        System.out.print("CEP: " + aluno.getCep());
	        System.out.print("\n-- ");
	        cep = ler.nextLine();
	        if(verificaEdicao(cep))
	        	cep = aluno.getCep();
	        
	        System.out.print("Estado: " + aluno.getEstado());
	        System.out.print("\n-- ");
	        estado = ler.nextLine();
	        if(verificaEdicao(estado))
	        	estado = aluno.getEstado();
	        
	        System.out.print("País: " + aluno.getPais());
	        System.out.print("\n-- ");
	        pais = ler.nextLine();
	        if(verificaEdicao(pais))
	        	pais = aluno.getPais();
	        
	        System.out.print("Telefone: " + aluno.getTelefone());
	        System.out.print("\n-- ");
	        telefone = ler.nextLine();
	        if(verificaEdicao(telefone))
	        	telefone = aluno.getTelefone();
	        
	        universidade.editarAluno(aluno, nome, email, endereco, bairro, cidade, cep, estado, pais, telefone);
        }
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
	
	public static void listarAluno(Universidade universidade){
		ArrayList<Aluno> listaAlunos = universidade.listagem();
		int indiceAluno = 0;
		
        if (listaAlunos != null) {
            for (Aluno aluno : listaAlunos) {
                System.out.println("----- Indice Aluno: " + indiceAluno
                        + "\nNome: " + aluno.getNome()
                        + "\nEmail: " + aluno.getEmail()
                        + "\nEndereco: " + aluno.getEndereco()
                        + "\nBairro: " + aluno.getBairro()
                        + "\nCidade: " + aluno.getCidade()
                        + "\nCEP: " + aluno.getCep()
                        + "\nEstado: " + aluno.getEstado()
                        + "\nPais: " + aluno.getPais()
                        + "\nTelefone: " + aluno.getTelefone() + "\n");
                indiceAluno +=1;
            }
        } else {
            System.out.println("Nao ha alunos cadastrados no sistema!");
        }
	}
}
