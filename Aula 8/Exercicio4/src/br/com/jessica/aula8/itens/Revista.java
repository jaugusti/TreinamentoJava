package br.com.jessica.aula8.itens;

public class Revista extends Item{
	private int anoPublicacao, volume;
	private String principaisAssuntos;
	
	public Revista(String identificacao, String nome, String dataAquisicao, String listaAutores, int anoPublicacao, int volume, String principaisAssuntos) {
		super(identificacao, nome, dataAquisicao, listaAutores);
		this.anoPublicacao = anoPublicacao;
		this.volume = volume;
		this.principaisAssuntos = principaisAssuntos;
	}
	
	@Override
	public String imprimeItem(){
		return "Identifica��o: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisi��o: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nAno Publica��o: " + anoPublicacao
				+ "\nAno Volume: " + volume
				+ "\nPrincipais Assuntos: " + principaisAssuntos;
	}
}
