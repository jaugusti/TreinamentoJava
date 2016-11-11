package br.com.jessica.aula8.conta;

public class Conta {
	private double saldo;
	
	public Conta(double saldo){
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valorDeposito){
		saldo += valorDeposito;
	}
	
	public String saque(double valorSaque){
		if(saldo >= valorSaque){
			saldo -= valorSaque;
			return "Saque Realizado Com Sucesso!";
		}
		return "Saldo Insuficiente!";	
	}
	
	public void atualizaSaldo(double taxa){
		saldo += (saldo * taxa) / 100;
	}
	
	public String imprimeSaldo(){
		return "" + saldo;
	}
}
