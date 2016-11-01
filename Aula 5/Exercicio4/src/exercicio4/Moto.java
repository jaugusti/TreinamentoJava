package exercicio4;

public class Moto {
	private String marca, modelo, cor;
	private int marcha;
	
	public Moto(String marca, String modelo, String cor, int marcha){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = marcha;
	}
	
	public String imprimir(){
		return "Marca: " + marca + "\nModelo: " + modelo + "\nCor: " + cor + "\nMarcha Atual: " + marcha;
	}
	
}
