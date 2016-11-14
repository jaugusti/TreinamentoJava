package br.com.jessica.aula7.imovel;

public class Imovel {
	private String enderecoImovel;
	private float precoImovel;
	
	public Imovel(String enderecoImovel, float precoImovel){
		this.enderecoImovel = enderecoImovel;
		this.precoImovel = precoImovel;
	}
	
	public String imprimePrecoImovel(){
		return "Preço Imovel: R$" + precoImovel;
	}
	
	public String getEnderecoImovel() {
		return enderecoImovel;
	}
	public void setEnderecoImovel(String enderecoImovel) {
		this.enderecoImovel = enderecoImovel;
	}
	public float getPrecoImovel() {
		return precoImovel;
	}
	public void setPrecoImovel(float precoImovel) {
		this.precoImovel = precoImovel;
	}
	
	
}
