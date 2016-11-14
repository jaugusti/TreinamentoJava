
package br.com.jessica.aula7.ingresso.VIP;

public class CamaroteSuperior extends VIP{
	private String localizacaoIngresso;
	private float valorAdicionalCamarote;
	
	public CamaroteSuperior(float precoIngresso, float valorAdicional, float valorAdicionalCamarote, String localizacaoIngresso) {
		super(precoIngresso, valorAdicional);
		this.valorAdicionalCamarote = valorAdicionalCamarote;
		this.localizacaoIngresso = localizacaoIngresso;
		calculaValorVIPCamarote();
	}
	
	public void calculaValorVIPCamarote(){
		float valorVipCamarote = this.getPrecoIngresso() + valorAdicionalCamarote;
		setPrecoIngresso(valorVipCamarote);
	}
	
	@Override
	public String imprimeValorIngresso(){
		return super.imprimeValorIngresso();
	}
	
	@Override
	public String imprimeLocalizacaoIngresso() {
		return super.imprimeLocalizacaoIngresso() + " Camarote Superior - " + localizacaoIngresso + "\n";
	}

	public void setLocalizacaoIngresso(String localizacaoIngresso) {
		this.localizacaoIngresso = localizacaoIngresso;
	}
}

