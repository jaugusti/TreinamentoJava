package br.com.jessica.aula8.itens;

public class DVD extends Item{
	private String tipoDVD, descricaoGeral;
	
	public DVD(String identificacao, String nome, String dataAquisicao, String listaAutores, String tipoDVD, String descricaoGeral) {
		super(identificacao, nome, dataAquisicao, listaAutores);
		this.tipoDVD = tipoDVD;
		this.descricaoGeral = descricaoGeral;
	}
	
	@Override
	public String imprimeItem(){
		return "Identifica��o: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisi��o: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nTipo: " + tipoDVD
				+ "\nDescri��o Geral: " + descricaoGeral;
	}
}
