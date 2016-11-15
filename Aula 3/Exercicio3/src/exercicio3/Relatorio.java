package exercicio3;

import java.util.ArrayList;

public class Relatorio {
	ArrayList<Mercadoria> listaMercadorias = new ArrayList<>();
	
	public void addMercadoria(Mercadoria mercadoria){
		listaMercadorias.add(mercadoria);
	}
	
	public int qtdMercadoriaLucroMenor10(){
		int numeroMercadoriasLucroDez = 0;
		for(int i = 0; i < listaMercadorias.size(); i++)
			if(calculaLucroMercadoria(i) < 10)
				numeroMercadoriasLucroDez ++;
		return numeroMercadoriasLucroDez;
	}
	
	public int qtdMercadoriaLucroEntre10E20(){
		int numeroMercadoriasDezEVinte = 0;
		for(int i = 0; i < listaMercadorias.size(); i++)
			if(calculaLucroMercadoria(i) >= 10 && calculaLucroMercadoria(i) <= 20)
				numeroMercadoriasDezEVinte ++;
		return numeroMercadoriasDezEVinte;
	}
	
	public int qtdMercadoriaLucroMaior20Porcento(){
		int numeroMercadoriasVinte = 0;
		for(int i = 0; i < listaMercadorias.size(); i++)
			if(calculaLucroMercadoria(i) > 20)
				numeroMercadoriasVinte ++;
		return numeroMercadoriasVinte;
	}
	
	public float calculaLucroMercadoria(int indice){
		float diferenca = listaMercadorias.get(indice).getPrecoDeVenda() - listaMercadorias.get(indice).getPrecoDeCompra();
		return (diferenca * 100) / listaMercadorias.get(indice).getPrecoDeCompra();
	}
	
	public float valorTotalCompra(){
		float valorTotalCompra = 0f;
		for(Mercadoria mercadoria : listaMercadorias)
			valorTotalCompra += mercadoria.getPrecoDeCompra();
		return valorTotalCompra;
	}
	
	public float valorTotalVenda(){
		float valorTotalVenda = 0f;
		for(Mercadoria mercadoria : listaMercadorias)
			valorTotalVenda += mercadoria.getPrecoDeVenda();
		return valorTotalVenda;
	}
	
	public float totalLucro(){
		return ((valorTotalVenda() - valorTotalCompra())*100) / valorTotalCompra();
	}
	
	public String imprimeRelatorio(){
		return "Número de Mercadorias com Lucro Menor que 10%: " + qtdMercadoriaLucroMenor10()
			   + "\nNúmero de Mercadorias com Lucro Entre 10% e 20%: " + qtdMercadoriaLucroEntre10E20() 
			   + "\nNúmero de Mercadorias com Lucro Maior que 20%: " + qtdMercadoriaLucroMaior20Porcento()
			   + "\nValor Total de Compra: " + valorTotalCompra() + "\nValor Total de Venda: " + valorTotalVenda()
			   + "\nLucro Total: " + totalLucro();
	}
}
