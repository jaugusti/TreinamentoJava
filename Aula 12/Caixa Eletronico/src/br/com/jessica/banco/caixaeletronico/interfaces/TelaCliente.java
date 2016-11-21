package br.com.jessica.banco.caixaeletronico.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.jessica.banco.*;
import br.com.jessica.banco.caixaeletronico.*;
import br.com.jessica.banco.conta.InformacaoConta;
import br.com.jessica.banco.movimentos.*;
import br.com.jessica.cliente.*;

public class TelaCliente extends InterfaceCaixa{
	public static void iniciaTelaCliente(Banco banco, CaixaEletronico caixaEletronico){
		autenticaCliente(banco, caixaEletronico);
	}
	
	public static void autenticaCliente(Banco banco, CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		
		if(banco.getListaClientes().size() != 0){
			ler = new Scanner(System.in);
			System.out.print("Agência: ");
			String agencia = ler.nextLine();
			
			System.out.print("Número Conta: ");
			String numeroConta = ler.nextLine();
			
			System.out.print("Senha: ");
			String senha = ler.nextLine();
			
			if(banco.autenticaCliente(agencia, numeroConta, senha)){
				InformacaoConta infConta = new InformacaoConta(agencia, numeroConta);
				opcoesCliente(infConta, banco, caixaEletronico);
			}
			else
				System.out.println("Dados Incorretos!");
		}
	}
	
	public static void opcoesCliente(InformacaoConta infConta, Banco banco, CaixaEletronico caixaEletronico){
		Scanner ler = new Scanner(System.in);
		
		boolean clienteLogado = true;
		while(clienteLogado){
			try {
				System.out.println("\n-- 0 para finalizar! --\n"
								+  "1) Saque     2) Depósito\n"
								+  "3) Saldo     4) Extrato");
				int opcao = ler.nextInt();
				
				switch(opcao){
					case 0: 
						clienteLogado = false;
						break;
					case 1:
						saqueCliente(banco, caixaEletronico, infConta);
						break;
					case 2:
						informacaoContaDeposito(banco);
						break;
					case 3:
						saldoCliente(infConta, banco);
						break;
					case 4:
						extratoCliente(banco, infConta);
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
	
	/** Saque Caixa **/
	public static void saqueCliente(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta informacaoConta){
		Scanner ler = new Scanner(System.in);
		
		String notas = caixaEletronico.celulasDisponiveis();
		if(notas.equals(""))
			System.out.println("Caixa sem Cedulas!");
		else{
			int valorTotalCaixa = caixaEletronico.total();
			System.out.println("Digite o valor do saque: ");
			int valorSaque = ler.nextInt();
			if(caixaEletronico.testaSaldo(banco, informacaoConta, valorSaque))
				retiraDinheiro(banco, caixaEletronico, informacaoConta, valorSaque);
			else
				System.out.println("Não foi possível realizar o saque!");
		}
		
	}
	
	public static void retiraDinheiro(Banco banco, CaixaEletronico caixaEletronico, InformacaoConta informacaoConta, int valorSaque){
		if(caixaEletronico.sacar(banco, informacaoConta ,valorSaque)){
			System.out.println("Saque Realizado!\n");
			for(Cedulas cedula : caixaEletronico.getCedulasSaque())
				System.out.println("R$" + cedula.getValorNota() + ": " + cedula.getQntNotas() + " cedulas");
		}
		else
			System.out.println("Não foi possível realizar o saque!");
	}
	/** Fim Saque Caixa **/
	
	/** Depósito Envelope **/
	public static void informacaoContaDeposito(Banco banco){
		Scanner ler = new Scanner(System.in);
		boolean contaExiste = false;
		
		System.out.println("-- Depósito Envelope --");
		try{
			System.out.print("Agência: ");
			String agencia = ler.nextLine();
			
			System.out.print("Conta: ");
			String numeroConta = ler.nextLine();
			
			ler.reset();
			
			System.out.print("Valor:");
			double valorDeposito = ler.nextDouble();
			
			InformacaoConta informacaoConta = new InformacaoConta(agencia, numeroConta);
			
			for(Cliente cliente : banco.getListaClientes()){
				if(cliente.getConta().getAgencia().equals(agencia) &&
				cliente.getConta().getNumeroConta().equals(numeroConta)){
					imprimeInfContaDeposito(cliente, valorDeposito);
					contaExiste = true;
				}
			}
			
			if(contaExiste && confirmaDeposito())
				depositoEnvelope(informacaoConta, banco, valorDeposito);
			else
				System.out.println("Dados Incorretos!");
			
		} catch(Exception e){
			System.out.println("Erro no Sistema!");
		}
		
	}
	
	public static void imprimeInfContaDeposito(Cliente cliente, double valorDeposito){
		System.out.println("\n-- Dados Depóstio --\n"
				+ "Favorecido: " + cliente.getNome() + "\n"
				+ "Agência: " + cliente.getConta().getAgencia() + "\n"
				+ "Número Conta: " + cliente.getConta().getNumeroConta() + "\n"
				+ "Valor Depósito: " + valorDeposito + "\n");
	}
	
	public static boolean confirmaDeposito(){
		boolean erro = true;
		Scanner ler = new Scanner(System.in);
		int confirma = 0;
		
		while(erro){
			try{
				System.out.println("Deseja confirmar?\n"
									+ "1) Sim  2)Não");
				confirma = ler.nextInt();
				erro = false;
			} catch (InputMismatchException e){
				System.out.println("O valor digitado deve ser S ou N!\n");
				ler.nextLine();
			}
		}
		
		if(confirma == 1)
			return true;
		else
			return false;
	}
	
	public static void depositoEnvelope(InformacaoConta informacaoConta, Banco banco, double valorDeposito){
		if(banco.depositoEnvelope(informacaoConta, valorDeposito) != null)
			System.out.println("Depósito realizado, aguardando autorização!");
	}
	/** Fim Depósito Envelope **/
	
	/** Saldo Cliente **/
	public static void saldoCliente(InformacaoConta infConta, Banco banco){
		System.out.println("-- Saldo Total --");
		System.out.println("R$" + consultaSaldoCliente(infConta, banco) + "\n" + banco.saldoPorExtenso(infConta)); // ;
	}
	
	public static double consultaSaldoCliente(InformacaoConta infConta, Banco banco){
		RetornoCliente retornoC = banco.consultaSaldo(infConta);
		return retornoC.getSaldo();
	}
	/** Fim Saldo Cliente **/
	
	/** Extrato Cliente **/
	public static void extratoCliente(Banco banco, InformacaoConta informacaoConta){
		for(Movimento movimento : banco.getMovimentacao().gerarExtrato(informacaoConta, banco, 1)){
			imprimeMovimento(movimento);
		}
		saldoCliente(informacaoConta, banco);
	}
	
	public static void imprimeMovimento(Movimento movimento){
		System.out.println("Data: " + movimento.getData() + "\n"
						+ "Tipo Operação: " + tipoOperacao(movimento.getTipoOperacao()) + "\n"
						+ "Valor Operação: " + movimento.getValorOperacao() + "\n"
						+ "Conta: " + movimento.getConta().getNumeroConta() + "\n"
						+ "Agência: " + movimento.getConta().getAgencia() + "\n"
						+ "Situação: " + movimento.getSituacao() + "\n");
	}
	/** Fim Extrato Cliente **/
}