package exercicio5;

import java.util.ArrayList;

public class Edificio {
	private String cor;
	private int totalDeAndares;
	private ArrayList<Porta> portas = new ArrayList<>();
		
	public void pinta(String cor){
		this.cor = cor;
	}
	
	public int quantasPortasEstaoAbertas(){
		int nPortasabertas = 0;
		for(Porta porta : portas)
			if(porta.estaAberta())
				nPortasabertas++;
		return nPortasabertas;
	}
	
	public void adicionaPorta(Porta p){
		portas.add(p);
	}
		
	public int totalDePortas(){
		int totalDePortas = portas.size();
		return totalDePortas;
	}
	public void adicionaAndar(int nAdares){
		totalDeAndares += nAdares;
	}
	public int totalDeAndares(){
		return totalDeAndares;
	}
	
	public String imprimeEdificio(int indice){
		return "\nEdificio " + indice + "\n" 
				+ "Cor do Edificio: " + cor + "\n" 
				+ "Portas abertas: " + quantasPortasEstaoAbertas() + "\n"
				+ "Total de Portas: " + totalDePortas() + "\n"
				+ "Total Andares: " + totalDeAndares() + "\n";
	}
	
}
