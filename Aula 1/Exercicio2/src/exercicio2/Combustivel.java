package exercicio2;


public class Combustivel {
	float preco, precoDesconto;
	
	public Combustivel(float preco, float precoDesconto){
		this.preco = preco;
		this.precoDesconto = precoDesconto;
	}
	
	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public float getPreco_Desconto() {
		return precoDesconto;
	}


	public void setPrecoDesconto(float preco_desconto) {
		this.precoDesconto = preco_desconto;
	}
}
