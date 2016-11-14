package br.com.jessica.aula7.loja;

public class Venda {
	private float valorVenda;
	private String funcionarioRG;
	
	public Venda(float valorVenda, String funcionarioRG){
		this.valorVenda = valorVenda;
		this.funcionarioRG = funcionarioRG;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getFuncionarioRG() {
		return funcionarioRG;
	}

	public void setFuncionarioRG(String funcionarioRG) {
		this.funcionarioRG = funcionarioRG;
	}
}
