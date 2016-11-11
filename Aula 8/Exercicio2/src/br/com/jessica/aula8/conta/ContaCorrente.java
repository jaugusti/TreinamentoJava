package br.com.jessica.aula8.conta;

public class ContaCorrente extends Conta{

	public ContaCorrente(double saldo) {
		super(saldo);
	}
	
	@Override
	public void atualizaSaldo(double taxa){
		super.atualizaSaldo(2*taxa);
	}
	
	@Override
	public String imprimeSaldo(){
		return "Saldo Conta Corrente: " + super.imprimeSaldo();
	}
}
