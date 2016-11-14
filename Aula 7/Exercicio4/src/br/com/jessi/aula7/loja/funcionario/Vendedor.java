package br.com.jessi.aula7.loja.funcionario;

import java.util.ArrayList;

import br.com.jessica.aula7.loja.Venda;

public class Vendedor extends Funcionario{
	private float comissaoVenda, valorTotalVendas;

	public Vendedor(String nome, String RG, float salarioBase, float comissaoVenda) {
		super(nome, RG, salarioBase);
		this.comissaoVenda = comissaoVenda;
		this.valorTotalVendas = 0;
	}
	
	public float calculaAdiconal(){
		return comissaoVenda*valorTotalVendas;
	}

	@Override
	public float imprimeSalario(){
		return calculaAdiconal() + getSalario();
	}

	public float getComissaoVenda() {
		return comissaoVenda;
	}

	public void setComissaoVenda(float comissaoVenda) {
		this.comissaoVenda = comissaoVenda;
	}

	public float getValorTotalVendas() {
		return valorTotalVendas;
	}

	public void setValorTotalVendas(float valorTotalVendas) {
		this.valorTotalVendas = valorTotalVendas;
	}
	
	
}
