package br.com.jessica.aula7.loja;

public class HoraExtra {
	private float qtdHorasExtra;
	private String funcionarioRG;
	
	public HoraExtra(float qtdHorasExtra, String funcionarioRG) {
		super();
		this.qtdHorasExtra = qtdHorasExtra;
		this.funcionarioRG = funcionarioRG;
	}

	public float getQtdHorasExtra() {
		return qtdHorasExtra;
	}

	public void setQtdHorasExtra(float qtdHorasExtra) {
		this.qtdHorasExtra = qtdHorasExtra;
	}

	public String getFuncionarioRG() {
		return funcionarioRG;
	}

	public void setFuncionarioRG(String funcionarioRG) {
		this.funcionarioRG = funcionarioRG;
	}
}
