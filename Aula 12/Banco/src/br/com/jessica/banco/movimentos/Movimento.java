package br.com.jessica.banco.movimentos;

import br.com.jessica.banco.conta.InformacaoConta;

public class Movimento {
	private int idMovimento;
	private int tipoUsuario;// 1- cliente, 0 - banco 
	private double valorOperacao;
	private String data, tipoOperacao;
	private InformacaoConta conta;
	private boolean operacaoPendente;
	private String situacao;
	
	public Movimento(int idMovimento, int tipoUsuario, double valorOperacao, String data, String tipoOperacao, 
			InformacaoConta conta, boolean operacaoPendente, String situacao) {
		
		this.idMovimento = idMovimento;
		this.tipoUsuario = tipoUsuario;
		this.valorOperacao = valorOperacao;
		this.data = data;
		this.tipoOperacao = tipoOperacao;
		this.conta = conta;
		this.operacaoPendente = operacaoPendente;
		this.situacao = situacao;
	}

	public int getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public InformacaoConta getConta() {
		return conta;
	}

	public void setConta(InformacaoConta conta) {
		this.conta = conta;
	}

	public boolean isOperacaoPendente() {
		return operacaoPendente;
	}

	public void setOperacaoPendente(boolean operacaoPendente) {
		this.operacaoPendente = operacaoPendente;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
