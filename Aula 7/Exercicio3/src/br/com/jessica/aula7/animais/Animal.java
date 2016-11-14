package br.com.jessica.aula7.animais;

public class Animal {
	private String nome;
	private int comprimento, patas;
	private String cor, ambiente;
	private float velocidade;
	
	public Animal(String nome, int comprimento, String cor, String ambiente, float velocidade, int patas){
		this.nome = nome;
		this.comprimento = comprimento;
		this.cor = cor;
		this.ambiente = ambiente;
		this.velocidade = velocidade;
		this.patas = patas;
	}
	
	public void alteraNome(String nome){
		this.nome = nome;
	}
	
	public void alteraComprimento(int comprimento){
		this.comprimento = comprimento;
	}
	
	public void alteraCor(String cor){
		this.cor = cor;
	}
	
	public void alteraAmbiente(String ambiente){
		this.ambiente = ambiente;
	}
	
	public void alteraVelocidade(float velocidade){
		this.velocidade = velocidade;
	}
	
	public String dados(){
		return "Nome: " + nome
				+ "\nComprimento: " + comprimento + " cm"
				+ "\nPatas: " + patas
				+ "\nCor: " + cor
				+ "\nAmbiente: " + ambiente
				+ "\nVelocidade: " + velocidade + " m/s";
	}

	public String getNome() {
		return nome;
	}

	public int getComprimento() {
		return comprimento;
	}

	public String getCor() {
		return cor;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public float getVelocidade() {
		return velocidade;
	}
}
