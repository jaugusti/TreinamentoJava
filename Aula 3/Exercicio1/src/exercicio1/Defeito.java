package exercicio1;

public class Defeito {
	Modelo modelo;
	
	public Defeito(Modelo modelo){
		this.modelo = modelo;
	}
	
	public float numeroCarrosComDefeito(){
		return (modelo.getTotalCarros() * modelo.getPercentualDefeito()) / 100;
	}
	
	public float pecentagemDefeitoXTotal(){
		return (numeroCarrosComDefeito() * 100) / modelo.getTotalCarros();
	}
	
	public String imprimeNumeroCarrosComDefeito(){
		return "Quantidade de carros do " + modelo.getNomeModelo() 
				+ "com defeito: " + numeroCarrosComDefeito() 
				+ "\nPercentagem de carros do modelo" + modelo.getNomeModelo()
				+ "em relação ao total: " + pecentagemDefeitoXTotal(); 
	}	
}
