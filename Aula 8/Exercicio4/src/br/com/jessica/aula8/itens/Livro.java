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
		return "Identificação: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisição: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nEditora: " + nomeEditora
				+ "\nAno Publicação: " + anoPublicacao;
	}
}
