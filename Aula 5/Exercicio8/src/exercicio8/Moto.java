package exercicio8;

public class Moto {
	private String marca, modelo, cor;
	private int marcha, maiorMarcha, menorMarcha;
	
	public Moto(String marca, String modelo, String cor, int menorMarcha, int maiorMarcha){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = 0;
		this.menorMarcha = menorMarcha;
		this.maiorMarcha = maiorMarcha;
	}
	
	public String imprimir(){
		return "Marca: " + marca + "\nModelo: " + modelo + "\nCor: " + cor + "\nMenor Marcha: " + menorMarcha 
				+ "\nMaior Marcha: " + maiorMarcha + "\nMarcha Atual: " + marcha;
	}
	
	public void marchaAcima(){
		marchaAcima(1);
	}
	
	public void marchaAbaixo(){
			marchaAbaixo(1);
	}

	public void marchaAcima(int acrescentaMarcha){
		if((marcha + acrescentaMarcha) <= maiorMarcha)
			marcha += acrescentaMarcha;
	}

	public void marchaAbaixo(int reduzMarcha){
		if((marcha - reduzMarcha) >= menorMarcha)
			marcha -= reduzMarcha;
	}
}
