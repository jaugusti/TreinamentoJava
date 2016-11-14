package br.com.jessica.aula7.animais;

public class Peixe extends Animal{
	private String caracteristica;
	
	public Peixe(String nome, int comprimento, String cor, String ambiente, float velocidade, String caracteristica, int patas){
		super(nome, comprimento, cor, ambiente, velocidade, patas);
		this.caracteristica = caracteristica;
	}
	
	public void alteraCaracteristica(String caracteristica){
		this.caracteristica = caracteristica;
	}
	
	public String caracteristica(){
		return caracteristica;
	}
	
	@Override
	public String dados(){
		return super.dados() + "\nCaracteristica: " + caracteristica;
	}
}
