package br.com.jessica.aula8.itens;

public class Item {
	private String identificacao, nome, dataAquisicao, listaAutores;
	
	public Item(String identificacao, String nome, String dataAquisicao, String listaAutores){
		this.identificacao = identificacao;
		this.nome = nome;
		this.dataAquisicao = dataAquisicao;
		this.listaAutores = listaAutores;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(String listaAutores) {
		this.listaAutores = listaAutores;
	}
	
	public String imprimeItem(){
		return "Identificação: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisição: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores();
	}
	
}
