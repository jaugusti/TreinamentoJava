package exercicio4;

public class Estoque {
	private String nomeProduto;
	int qtdAtual, qtdMinima;
	
	public Estoque(String nome, int qtdAtual, int qtdMinima){
		this.nomeProduto = nome;
		this.qtdAtual = qtdAtual;
		this.qtdMinima = qtdMinima;
	}
	
	public void mudarNome(String nome){
		this.nomeProduto = nome;
	}
	
	public void mudarQtdMinima(int qtdMinima){
		this.qtdMinima = qtdMinima;
	}
	
	public String repor(int qtdRepor){
		qtdAtual += qtdRepor;
		return qtdRepor + " item(ns) adicionados!";
	}
	
	public String darBaixa(int qtdBaixa){
		if (testaQuantidade(qtdBaixa) && qtdAtual >= qtdBaixa){
			qtdAtual -= qtdBaixa;
			return "Baixa " + nomeProduto + " Efetuada: " + qtdBaixa + " item(ns)";
		}
		return "Baixa Não Efetua!";
	}
	
	public boolean testaQuantidade(int qtd){
		return (qtdAtual > 0); 		
	}
	
	public String mostra(){
		return "Nome Produto: " + nomeProduto 
				+ "\nQuantidade Minima: " + qtdMinima 
				+ "\nQuantidade Atual: " + qtdAtual;
	}

	public boolean precisaRepor(){
		return (qtdAtual <= qtdMinima) ? true : false;
	}
}
