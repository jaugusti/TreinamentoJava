package br.com.jessica.cliente;

import br.com.jessica.banco.conta.InformacaoConta;

public class Cliente {
	private String senha;
	private double saldo;
	private String nome;
	private InformacaoConta conta;

	public Cliente(String agencia, String conta, String senha, double saldo, String nome) {
		this.senha = senha;
		this.saldo = saldo;
		this.conta = new InformacaoConta(agencia, conta);
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public InformacaoConta getConta() {
		return conta;
	}

	public void setConta(InformacaoConta conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
