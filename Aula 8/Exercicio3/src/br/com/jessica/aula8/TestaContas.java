package br.com.jessica.aula8;

import br.com.jessica.aula8.conta.*;
import br.com.jessica.aula8.relatorio.*;

public class TestaContas {

	public static void main(String[] args) {
		GeraRelatorio relatorio = new GeraRelatorio();
		Conta conta = new ContaPoupanca(150);
		relatorio.addConta(conta);
		
		conta = new ContaCorrente(150);
		relatorio.addConta(conta);
		conta.saque(10);
		relatorio.atualizaContas(0.3);
		System.out.println(relatorio.geraRelatorio());
	}

}
