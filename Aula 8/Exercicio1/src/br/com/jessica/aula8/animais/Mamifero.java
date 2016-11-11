package br.com.jessica.aula8.animais;

public class Mamifero extends Animal {
	private String alimento;
	
	public Mamifero(String nome, int comprimento, String cor, String alimento, String ambiente, float velocidade, int patas, String som){
		super(nome, comprimento, cor, ambiente, velocidade, patas, som);
		this.alimento = alimento;
	}
	
	public void alteraAlimento(String alimento){
		this.alimento = alimento;
	}
	
	public String alimento(){
		return alimento;
	}
	
	@Override
	public String mover(){
		return getNome() + " - Mamífero - Correr";
	}
	
	@Override
	public String dados(){
		return super.dados() + "\nAlimento: " + alimento;
	}

}
