package br.com.jessica.aula8.animais;

public class Ave extends Animal{
	private String caracteristica;
	
	public Ave(String nome, int comprimento, String cor, String ambiente, float velocidade, int patas, String caracteristica, String som){
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
		return getNome() + " - Ave - Voar";
	}
	
	@Override
	public String dados(){
		return super.dados() 
				+ "\nCaracteristica: " + caracteristica;
	}
}
