package exercicio2;

public class Calculos {
	private int maior = 0, menor, qtdValores = 0;
	private int soma = 0;
	
	public void calculaMaior(int valor){
		if(valor > maior)
			this.maior = valor;
	}
	
	public void calculaMenor(int valor){
		if(valor < menor)
			menor = valor;
	}
	
	public void setQtdValores(int qtdValores) {
		this.qtdValores = qtdValores;
	}

	public float calculaMedia(){
		return ((float) soma) / qtdValores;
	}
	
	public void somaValor(int valor){
		soma += valor;
	}
	public void setMenor(int menor) {
		this.menor = menor;
	}

	public String imprimeMaiorMenorMedia(){
		return  "\n-------- Resultado --------\n"
				+ "O maior valor é: " + maior
				+ "\nO menor valor é: " + menor
				+ "\nA media dos valores é: " + calculaMedia();
	}
}
