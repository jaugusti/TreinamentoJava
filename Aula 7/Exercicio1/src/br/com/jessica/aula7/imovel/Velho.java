package br.com.jessica.aula7.imovel;

public class Velho extends Imovel {
	private float desconto;
	
	public Velho(String enderecoImovel, float precoImovel, float desconto) {
		super(enderecoImovel, precoImovel);
		this.desconto = desconto;
		calculaPrecoDesconto();
	}

	public void calculaPrecoDesconto(){
		float precoDesconto = getPrecoImovel() - desconto;
		this.setPrecoImovel(precoDesconto);
	}
	
	@Override
	public String imprimePrecoImovel() {
		return "---- Imovel Velho ----\n" + super.imprimePrecoImovel() + "\nDesconto: R$" + desconto;
	}
	
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
}
