package br.com.jessica.aula8.itens;

public class Livro extends Item{
	private String nomeEditora;
	private int anoPublicacao;
	
	public Livro(String identificacao, String nome, String dataAquisicao, String listaAutores, String nomeEditora, int anoPublicacao) {
		super(identificacao, nome, dataAquisicao, listaAutores);
		this.nomeEditora = nomeEditora;
		this.anoPublicacao = anoPublicacao;
	}
	
	@Override
	public String imprimeItem(){
		return "Identifica��o: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisi��o: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nEditora: " + nomeEditora
				+ "\nAno Publica��o: " + anoPublicacao;
	}
}
