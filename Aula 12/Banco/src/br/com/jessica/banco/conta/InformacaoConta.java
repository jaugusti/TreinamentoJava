package br.com.jessica.banco.conta;

public class InformacaoConta {
	private String agencia, numeroConta;

	public InformacaoConta(String agencia, String conta) {
		this.agencia = agencia;
		this.numeroConta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
}
