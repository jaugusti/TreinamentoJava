package exercicio3;

public class Mercadoria {
	private String nomeMercadoria;
	private float precoDeCompra, precoDeVenda; 
	
	public Mercadoria(String nomeMercadoria, float precoDeCompra, float precoDeVenda){
		this.nomeMercadoria = nomeMercadoria;
		this.precoDeCompra = precoDeCompra;
		this.precoDeVenda = precoDeVenda;
	}

	public String getNome() {
		return nomeMercadoria;
	}
	public void setNome(String nome) {
		this.nomeMercadoria = nome;
	}
	public float getPrecoDeCompra() {
		return precoDeCompra;
	}
	public void setPrecoDeCompra(float precoDeCompra) {
		this.precoDeCompra = precoDeCompra;
	}
	public float getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(float precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
}
