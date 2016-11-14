package br.com.jessica.banco.caixaeletronico.interfaces;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.banco.*;
import br.com.jessica.banco.caixaeletronico.*;
import br.com.jessica.banco.conta.*;
import br.com.jessica.banco.movimentos.Movimento;

public class TelaUsuarioBanco extends InterfaceCaixa{
	public static void iniciaTelaUsuarioBanco(Banco banco, CaixaEletronico caixaEletronico){
		autenticaUsuarioBanco(banco, caixaEletronico);
	}
	
	public static void autenticaUsuarioBanco(Banco banco, CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		
		ler = new Scanner(System.in);
		System.out.print("Agência: ");
		String agencia = ler.nextLine();
			
		System.out.print("Número Conta: ");
		String numeroConta = ler.nextLine();
			
		System.out.print("Senha: ");
		String senha = ler.nextLine();
		
		InformacaoConta infConta = new InformacaoConta(agencia, numeroConta);
		
		if(banco.autenticaUsuario(agencia, numeroConta, senha))
			opcoesUsuarioBanco(banco, caixaEletronico, infConta);
		else
			System.out.println("\nDados Incorretos!\n");
	}
	
	public static void opcoesUsuarioBanco(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta infConta){
		Scanner ler = new Scanner(System.in);
		int opcao;
		
		boolean UsuarioBancoLogado = true;
		while(UsuarioBancoLogado){
			try{
				System.out.println("\n-- Clique 0 Para Finalizar --");
				System.out.println("1) Repor Cédulas " + "     2) Esvaziar Cédulas");
				System.out.println("3) Visualizar Cédulas " + "4) Consultar Saldo");
				System.out.println("5) Aprovar Depósitos " + " 6) Extrato Geral");
				opcao = ler.nextInt();
				
				switch(opcao){
					case 0: 
						UsuarioBancoLogado = false;
						break;
					case 1: 
						reporCedulas(banco, caixaEletronico, infConta);
						//imprimeListaMovimentos(banco);
						break;
					case 2: 
						esvaziarNotas(banco, caixaEletronico, infConta);
						break;
					case 3:
						visualizaNotas(caixaEletronico);
						break;
					case 4:
						saldoCaixa(caixaEletronico);
						break;
					case 5: 
						aprovaMovimentos(banco);
						break;
					case 6:
						extratoBanco(banco, caixaEletronico, infConta);
						break;
					default: 
						System.out.println("Opção Inválida!");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!");
				ler.nextLine();
			}
		}
	}
	
	/** Repor Cédulas **/
	public static void reporCedulas(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta infConta){
		double valorOperacao = 0;
		
		valorOperacao += reporCedulasPorValor(banco, caixaEletronico, 50);
		valorOperacao += reporCedulasPorValor(banco, caixaEletronico, 20);
		valorOperacao += reporCedulasPorValor(banco, caixaEletronico, 10);
		valorOperacao += reporCedulasPorValor(banco, caixaEletronico, 5);
		valorOperacao += reporCedulasPorValor(banco, caixaEletronico, 2);
		
		banco.addMovimento(0, valorOperacao, "2016", "c", infConta, false, "Aprovada!");
	}
	
	public static double reporCedulasPorValor(Banco banco, CaixaEletronico caixaEletronico, int valorNota){
		boolean erro = true;
		Scanner ler = new Scanner(System.in);
		
		while(erro){
			try{
				System.out.print("Quantidade de notas de R$" + valorNota + ": ");
				int qtdNotas =  ler.nextInt();
				
				caixaEletronico.adicionarCedula(valorNota, qtdNotas);
				erro = false;
				return valorNota * qtdNotas;
				
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser um número!\n");
				ler.nextLine();
			}
		}
		
		return 0;
	}
	/** Fim Repor Cédulas **/
	
	/** Evaziar Notas **/
	public static void esvaziarNotas(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta infConta){
		double valorOperacao = 0;
		boolean erro = true;
		Scanner ler = new Scanner(System.in);
		
		for(Cedulas cedula : caixaEletronico.getCedulas()){
			if(cedula.getQntNotas() != 0){
				erro = true;
				while(erro){
					try{
						System.out.print("Deseja esvaziar cédulas de " + cedula.getValorNota() + "?"
										+ "\n1) Sim  2) Não\n");
						if(ler.nextInt() == 1)
							valorOperacao += descargaCedulasPorValor(caixaEletronico, cedula);
						erro = false;
					} catch (InputMismatchException e){
						System.out.println("O valor digitado deve ser um número!\n");
						ler.nextLine();
					}
				}
			}
		}
		banco.addMovimento(0, valorOperacao, "2016", "d", infConta, false, "Aprovada!");
	}
	
	public static double descargaCedulasPorValor(CaixaEletronico caixaEletronico, Cedulas cedula){
		System.out.println("Cédulas de" + cedula.getValorNota() + " descarregadas!\n");
		
		return caixaEletronico.descargaCedulas(cedula);
	}
	/** Fim Evaziar Notas **/
	
	/** Visualiza Notas **/
	public static void visualizaNotas(CaixaEletronico caixaEletronico){
		System.out.println("\n-- Notas Disponíveis --");
		System.out.println(caixaEletronico.valorTotal());
	}
	/** Fim Visualiza Notas **/
	
	/** Saldo Total Caixa Eletrônico **/
	public static void saldoCaixa(CaixaEletronico caixaEletronico){
		System.out.println("\n-- Saldo Total Caixa --");
		System.out.println("R$" + caixaEletronico.total());
	}
	/** Fim Saldo Total Caixa Eletrônico **/
	
	/** Aprova Movimentos **/
	public static void aprovaMovimentos(Banco banco){
		ArrayList<Integer> listaMovimentosAprovados =  new ArrayList<>();
		
		ArrayList<Movimento> listaMovimentosPendentes = banco.verificaMovimentoPendente(); 
		if(listaMovimentosPendentes.size() == 0)
			System.out.println("\nNenhuma operação pendente!\n");
		else{
			boolean aprova = true;
			int opcao;
			Scanner ler = new Scanner(System.in);
			
			imprimeListaMovimentosPendentes(listaMovimentosPendentes);
			while(aprova){
				System.out.println("Digite o ID da operação a ser aprovada ou 0 para finalizar.");
				System.out.print("-- ");
				opcao = ler.nextInt();
				
				switch(opcao){
					case 0: 
						aprova = false;
						break;
					default:
						listaMovimentosAprovados.add(opcao);
						break;
				}
			}
			
			imprimeMovimentosAprovados(banco.autorizaMovimento(listaMovimentosAprovados));
			imprimeMovimentosCancelados(banco.cancelaMovimento(listaMovimentosAprovados));
		}
		
		
	}
	
	public static void imprimeMovimentosAprovados(ArrayList<Integer> listaMovimentosAprovados){
		String aprovado = "-- Movimentos Aprovados --\n";
		
		if(listaMovimentosAprovados.size() == 0)
			aprovado += "Nenhum Movimento Aprovado!\n";
		else{
			aprovado += "ID(s) Movimento(s): ";
			for(int movimentoAprovado : listaMovimentosAprovados)
				aprovado += movimentoAprovado + "  ";
		}
		System.out.println(aprovado + "\n");
	}
	
	public static void imprimeMovimentosCancelados(ArrayList<Integer> listaMovimentosCancelados){
		String cancelado = "-- Movimentos Cancelados --\n";
		
		if(listaMovimentosCancelados.size() == 0)
			cancelado += "Nenhum Movimento Cancelado!\n";
		else{
			cancelado += "ID(s) Movimento(s): ";
			for(int movimentoCancelado : listaMovimentosCancelados)
				cancelado += movimentoCancelado + ", ";
		}
		System.out.println(cancelado + "\n");
	}
	
	public static void imprimeListaMovimentosPendentes(ArrayList<Movimento> listaMovimentosPendentes){
		for(Movimento movimento : listaMovimentosPendentes){
			imprimeMovimento(movimento);
		}
	}
	/** Fim Aprova Movimentos **/
	
	/** Extrato Banco **/
	public static void extratoBanco(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta informacaoConta){
		for(Movimento movimento : banco.getMovimentacao().gerarExtrato(informacaoConta, banco, 0)){
			imprimeMovimento(movimento);
		}
		saldoCaixa(caixaEletronico);
	}
	
	/** Fim Extrato Banco **/
	
	public static void imprimeMovimento(Movimento movimento){
		System.out.println("ID Movimento: " + movimento.getIdMovimento()
						+ "\nData: " + movimento.getData() + "\n"
						+ "Tipo Usuario: " + tipoUsuario(movimento.getTipoUsuario()) + "\n"
						+ "Tipo Operação: " + tipoOperacao(movimento.getTipoOperacao()) + "\n"
						+ "Valor Operação: " + movimento.getValorOperacao() + "\n"
						+ "Conta: " + movimento.getConta().getNumeroConta() + "\n"
						+ "Agência: " + movimento.getConta().getAgencia() + "\n"
						+ "Situação: " + movimento.getSituacao() + "\n"
						+ "Operacão Pendente: " + operacaoPendente(movimento.isOperacaoPendente()) + "\n");
	}
}
