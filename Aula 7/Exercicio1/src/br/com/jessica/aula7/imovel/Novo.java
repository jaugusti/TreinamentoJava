package br.com.jessica.aula7.imovel;

public class Novo extends Imovel {
	private float adicional;
	
	public Novo(String enderecoImovel, float precoImovel, float adicional) {
		super(enderecoImovel, precoImovel);
		this.adicional = adicional;
		calculaPrecoAdicional();
	}
	
	public void calculaPrecoAdicional(){
		float precoAdicional = getPrecoImovel() + adicional;
		this.setPrecoImovel(precoAdicional);
	}
	
	@Override
	public String imprimePrecoImovel() {
		return "---- Imovel Novo ----\n" + super.imprimePrecoImovel() + "\nAdicional: R$" + adicional;
	}
	
	public float getAdicional() {
		return adicional;
	}

	public void setAdicional(float adicional) {
		this.adicional = adicional;
	}
}
