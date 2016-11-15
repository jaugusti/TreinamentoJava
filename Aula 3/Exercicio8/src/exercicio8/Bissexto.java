package exercicio8;

public class Bissexto {
	private int ano;

	public Bissexto(int ano){
		this.ano = ano;
	}
	
	public boolean isBissexto(){
		return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)) ? true : false;
	}
	
	public String imprimeResultado(){
		return (isBissexto()) ? "É bissexto!" : "Não é bissexto!";
	}
}
