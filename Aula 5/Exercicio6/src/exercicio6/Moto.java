package exercicio6;

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
			marcha++;
	}
	
	public void marchaAbaixo(){
			marcha--;
	}
}
