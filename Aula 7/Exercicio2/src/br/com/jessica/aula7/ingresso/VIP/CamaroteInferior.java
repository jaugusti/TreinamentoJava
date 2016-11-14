package br.com.jessica.aula7.ingresso.VIP;

public class CamaroteInferior extends VIP{
	private String localizacaoIngresso;
	
	public CamaroteInferior(float precoIngresso, float valorAdicional, String localizacaoIgresso) {
		super(precoIngresso, valorAdicional);
		this.localizacaoIngresso = localizacaoIgresso;
	}
	
	
	@Override
	public String imprimeValorIngresso(){
		return  super.imprimeValorIngresso();
	}
	
	@Override
	public String imprimeLocalizacaoIngresso() {
		return super.imprimeLocalizacaoIngresso() + " Camarote Inferior - " + localizacaoIngresso + "\n";
	}

	public void setLocalizacaoIngresso(String localizacaoIngresso) {
		this.localizacaoIngresso = localizacaoIngresso;
	}
}