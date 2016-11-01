package exercicio1;

public class Pessoa {
	private String nome;
	private int idadeInicial;
	
	public Pessoa(String nome, int idadeInicial){
		this.nome = nome;
		this.idadeInicial = idadeInicial;
	}
	public void fazAniversario(int aniversarios){
		idadeInicial += aniversarios;
	}
	
	public String retornaNomeIdade(){
		return "Nome: " + nome + "\nIdade: " + idadeInicial;
	}
}
