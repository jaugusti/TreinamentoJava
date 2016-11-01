package exercicio5;

import java.util.ArrayList;

public class Casa {
	private String cor;
	ArrayList<Porta> portas = new ArrayList<>();
	
	public void adicionaPorta(Porta p){
		portas.add(p);
	}
	
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
	public int totalDePortasFechadas(){
		int nPortasfechadas = 0;
		for(Porta porta : portas)
			if(!porta.estaAberta())
				nPortasfechadas++;
		return nPortasfechadas;
	}

	public String imprimeCasa(int indice){
		return "\nCasa " + indice + "\n" 
				+ "Cor da Casa: " + cor + "\n" 
				+ "Portas abertas: " + quantasPortasEstaoAbertas() + "\n"
				+ "Portas fechadas: " + totalDePortasFechadas() + "\n"; 
	}
}
