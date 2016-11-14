package br.com.jessica.aula7.ingresso;

public class Normal extends Ingresso{
	public Normal(float precoIngresso) {
		super(precoIngresso);
	}
	
	@Override
	public String imprimeTipoIngresso() {
		return super.imprimeTipoIngresso() + "Normal ----\n";
	}
	@Override
	public String imprimeValorIngresso(){
		return super.imprimeValorIngresso();
	}
}
