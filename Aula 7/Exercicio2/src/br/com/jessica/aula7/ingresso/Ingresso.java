package br.com.jessica.aula7.ingresso;

public class Ingresso {
	private float precoIngresso;
	
	public Ingresso(float precoIngresso){
		this.precoIngresso = precoIngresso;
	}
	
	public String imprimeValorIngresso(){
		return "Preço: R$" + precoIngresso;
	}
	
	public String imprimeTipoIngresso(){
		return "---- Ingresso ";
	}
	public float getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(float precoIngresso) {
		this.precoIngresso = precoIngresso;
	}
}
