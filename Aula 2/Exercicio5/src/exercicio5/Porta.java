package exercicio5;

public class Porta {
	private boolean aberta;
	private String cor;
	private double dimensaoX, dimensaoY, dimensaoZ;
	
	public Porta(boolean aberta, double dimensaoX, double dimensaoY, double dimensaoZ){
		this.aberta = aberta;
		this.dimensaoX = dimensaoX;
		this.dimensaoY = dimensaoY;
		this.dimensaoZ = dimensaoZ;
	}
	
	public void abre(){
		aberta = true;
	}
	public void fecha(){
		aberta = false;
	}
	
	public void pinta(String cor){
		this.cor = cor;
	}
	public boolean estaAberta(){
		return aberta;
	}
	
	public String imprimePorta(int indice){
		return "\nPorta " + indice + "\n" 
				+ "Cor da Porta: " + cor + "\n" 
				+ "Status Porta: " + aberta + "\n"
				+ "Dimensão X: " + dimensaoX + "\n"
				+ "Dimensão Y: " + dimensaoY + "\n"
				+ "Dimensão Z: " + dimensaoZ + "\n";
	}
}
