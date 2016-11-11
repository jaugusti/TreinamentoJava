package br.com.jessica.aula8;

import br.com.jessica.aula8.conta.*;

public class TestaContas {

	public static void main(String[] args) {
		Conta conta = new ContaPoupanca(150);
		conta.atualizaSaldo(0.3);
		System.out.println("-- Atualiza Saldo 0.3% --\n " + conta.imprimeSaldo());
		//conta.depositar(10);
		System.out.println("-- Depósito R$10 --\n" + conta.imprimeSaldo());
		
		conta = new ContaCorrente(150);
		conta.atualizaSaldo(0.3);
		System.out.println("\n-- Atualiza Saldo 0.3% --\n " + conta.imprimeSaldo());
	}

}
