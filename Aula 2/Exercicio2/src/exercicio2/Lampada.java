package exercicio2;

public class Lampada {
	private Boolean ligada;
	
	public void liga(){
		ligada = true;
	}
	
	public void desliga(){
		ligada = false;
	}
	
	public String observa(){
		return (this.estaLigada()) ? "ligada" : "desligada";
	}

	public Boolean estaLigada() {
		return ligada;
	}
}
