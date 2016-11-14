package br.com.jessica.aula7.ingresso.VIP;

import br.com.jessica.aula7.ingresso.Ingresso;

public class VIP extends Ingresso {
	private float valorAdicional;
	
	public VIP(float precoIngresso, float valorAdicional) {
		super(precoIngresso);
		this.valorAdicional = valorAdicional;
		calculaValorVIP();
	}
	
	public void calculaValorVIP(){
		setPrecoIngresso(this.getPrecoIngresso() + valorAdicional);
	}
	
	@Override
	public String imprimeTipoIngresso() {
		return super.imprimeTipoIngresso() + "VIP ----";
	}
	
	@Override
	public String imprimeValorIngresso(){
		return super.imprimeValorIngresso();
	}
	
	public float getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(float valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public String imprimeLocalizacaoIngresso() {
		return "------- VIP --------\nLocalização: ";
	}
}
