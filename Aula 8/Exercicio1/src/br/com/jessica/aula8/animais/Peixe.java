package br.com.jessica.aula8.animais;

public class Peixe extends Animal{
	private String caracteristica;
	
	public Peixe(String nome, int comprimento, String cor, String ambiente, float velocidade, String caracteristica, int patas, String som){
		super(nome, comprimento, cor, ambiente, velocidade, patas, som);
		this.caracteristica = caracteristica;
	}
	
	public void alteraCaracteristica(String caracteristica){
		this.caracteristica = caracteristica;
	}
	
	public String caracteristica(){
		return caracteristica;
	}
	
	@Override
	public String mover(){
		return getNome() + " - Peixe - Nadar";
	}
	
	@Override
	public String dados(){
		return super.dados() + "\nCaracteristica: " + caracteristica;
	}
}
