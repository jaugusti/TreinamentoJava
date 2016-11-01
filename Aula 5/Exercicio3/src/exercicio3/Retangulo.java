package exercicio3;

public class Retangulo {
	private float comprimento, largura, area, perimetro;
	
	public Retangulo(float comprimento, float largura){
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public float calculaArea(){
		area = comprimento*largura; 
		return area;
	}
	
	public float calculaPerimetro(){
		perimetro = (comprimento + largura)*2;
		return perimetro;
	}
	
	public void calcularTudo(){
		calculaArea();
		calculaPerimetro();
	}
	
	public String imprimir(){
		return "Comprimento: " + comprimento + "\nLargura: " + largura + "\nArea: " + area + "\nPerimetro: " + perimetro;
	}

	public void setDados(float comprimento) {
		setDados(comprimento, 0f);
	}

	public void setDados(float comprimento, float largura) {
		setDados(largura, comprimento, 0f);
	}

	public void setDados(float largura, float comprimento, float area) {
		setDados(largura, comprimento, area, 0F);
	}

	public void setDados(float largura, float comprimento, float area, float perimetro) {
		this.largura = largura;
		this.comprimento = comprimento;
		this.area = area;
		this.perimetro = perimetro;
	}
	
}
