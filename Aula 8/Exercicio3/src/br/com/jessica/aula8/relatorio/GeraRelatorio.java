package br.com.jessica.aula8.relatorio;

import java.util.ArrayList;

import br.com.jessica.aula8.conta.*;

public class GeraRelatorio {
	private ArrayList<Conta> listaContas = new ArrayList<>();
	double totalSaldoAnterior, totalSaldo;
	
	public void addConta(Conta conta){
		listaContas.add(conta);
	}
	
	public void atualizaContas(double taxa){
		for(Conta conta : listaContas){
			conta.setSaldoAnterior(conta.getSaldo());
			conta.atualizaSaldo(0.3);
		}
	}
	
	public double calculaTotalDinheiroAtualizado(){
		for(Conta conta : listaContas){
			totalSaldoAnterior += conta.getSaldoAnterior();
			totalSaldo += conta.getSaldo();
		}
		
		return totalSaldo - totalSaldoAnterior;
		
	}
	
	public String geraRelatorio(){
		String relatorio = "";
		for(Conta conta : listaContas){
			relatorio += "Saldo Anterior: " + conta.getSaldoAnterior()
						+ "\nSaldo Atual: " + conta.getSaldo()
						+ "\n----------------------\n";
		}
		relatorio += "\nTotal dinheiro atualizado: " + calculaTotalDinheiroAtualizado();
		
		return relatorio;
	}
}
