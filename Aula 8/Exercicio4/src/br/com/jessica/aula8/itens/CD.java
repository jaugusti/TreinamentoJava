package br.com.jessica.aula8.itens;

public class CD extends Item{
	private String generoMusical, idFaixas;
	
	public CD(String identificacao, String nome, String dataAquisicao, String listaAutores, String generoMusical, String idFaixas) {
		super(identificacao, nome, dataAquisicao, listaAutores);
		this.generoMusical = generoMusical;
		this.idFaixas = idFaixas;
	}
	
	@Override
	public String imprimeItem(){
		return "Identificação: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisição: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nGênero: " + generoMusical
				+ "\nFaixas:\n" + idFaixas;
	}
}
