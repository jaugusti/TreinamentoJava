package br.com.jessica.aula8.conta;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(double saldo) {
		super(saldo);
	}
	
	@Override
	public void depositar(double valorDeposito) {
		super.depositar(valorDeposito - 0.10);
	}
	
	@Override
	public void atualizaSaldo(double taxa){
		super.atualizaSaldo(3*taxa);
	}
	
	@Override
	public String imprimeSaldo(){
		return "Saldo Conta Poupança: " + super.imprimeSaldo();
	}
}
