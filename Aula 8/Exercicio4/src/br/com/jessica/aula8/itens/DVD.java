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
		return "Identificação: " + getIdentificacao()
				+ "\nNome: " + getNome()
				+ "\nData Aquisição: " + getDataAquisicao()
				+ "\nAutores: " + getListaAutores()
				+ "\nTipo: " + tipoDVD
				+ "\nDescrição Geral: " + descricaoGeral;
	}
}
