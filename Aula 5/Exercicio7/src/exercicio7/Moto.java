package exercicio7;

public class Moto {
	private String marca, modelo, cor;
	private int marcha;
	
	public Moto(String marca, String modelo, String cor){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = 0;
	}
	
	public String imprimir(){
		return "Marca: " + marca + "\nModelo: " + modelo + "\nCor: " + cor + "\nMarcha Atual: " + marcha;
	}
	
	public void marchaAcima(){
			marchaAcima(1);
	}
	
	public void marchaAbaixo(){
			marchaAbaixo(1);
	}
	
	public void marchaAcima(int acescentaMarcha){
			marcha += acescentaMarcha;
	}
	
	public void marchaAbaixo(int reduzMarcha){
			marcha -=  reduzMarcha;
	}
}
