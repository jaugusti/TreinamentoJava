package exercicio1;

public class Modelo {
	private String nomeModelo;
	private int totalCarros;
	private float percentualDefeito;
	
	public Modelo (String modelo, int totalCarros, float percentualDefeito){
		this.nomeModelo = modelo;
		this.totalCarros = totalCarros;
		this.percentualDefeito = percentualDefeito;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}

	public int getTotalCarros() {
		return totalCarros;
	}

	public float getPercentualDefeito() {
		return percentualDefeito;
	}

}
