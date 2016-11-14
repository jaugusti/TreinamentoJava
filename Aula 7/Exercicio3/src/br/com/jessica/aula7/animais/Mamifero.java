package br.com.jessica.aula7.animais;

public class Mamifero extends Animal {
	private String alimento;
	
	public Mamifero(String nome, int comprimento, String cor, String alimento, String ambiente, float velocidade, int patas){
		super(nome, comprimento, cor, ambiente, velocidade, patas);
		this.alimento = alimento;
	}
	
	public void alteraAlimento(String alimento){
		this.alimento = alimento;
	}
	
	public String alimento(){
		return alimento;
	}
	
	@Override
	public String dados(){
		return super.dados() + "\nAlimento: " + alimento;
	}

}
