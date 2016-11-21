package br.com.jessica.cliente;

import br.com.jessica.banco.conta.InformacaoConta;

public class RetornoCliente {
	private InformacaoConta conta;
	private double saldo;

	public RetornoCliente(InformacaoConta conta, double saldo) {
		this.conta = conta;
		this.saldo = saldo;
	}

	public InformacaoConta getConta() {
		return conta;
	}

	public void setConta(InformacaoConta conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
