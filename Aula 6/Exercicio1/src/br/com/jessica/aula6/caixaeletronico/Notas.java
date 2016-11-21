package br.com.jessica.aula6.caixaeletronico;

public class Notas {
	private int valorNota, qtdNotas;

	public Notas(int valorNota, int qtdNotas) {
		this.valorNota = valorNota;
		this.qtdNotas = qtdNotas;
	}

	public int getValorNota() {
		return valorNota;
	}

	public void setValorNota(int valorNota) {
		this.valorNota = valorNota;
	}

	public int getQtdNotas() {
		return qtdNotas;
	}

	public void setQtdNotas(int qtdNotas) {
		this.qtdNotas = qtdNotas;
	}
}
