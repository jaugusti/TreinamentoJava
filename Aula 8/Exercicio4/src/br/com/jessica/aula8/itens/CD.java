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
		return "Identifica��o: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisi��o: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nG�nero: " + generoMusical
				+ "\nFaixas:\n" + idFaixas;
	}
}
