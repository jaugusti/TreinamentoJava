package exercicio2;

import java.util.ArrayList;

public class Caixa {
	private ArrayList<Bomba> bombas = new ArrayList<>();
	
	public void adicionaBomba(Bomba bomba){
		bombas.add(bomba);
	}
	
	public float calculaDesconto(float valorPagamento){
		float desconto = valorPagamento * 0.10f;
		
		return desconto;
	}
	
	public float calculaTotalDeLitros(){
		float totalLitros = 0f;
		for(int i = 0; i < bombas.size(); i++)
			totalLitros += bombas.get(i).getLitros();
		return totalLitros;		
	}
		
	public String calculaPagamento(){
		float valorPagamento = 0f;
		
		for(Bomba bomba : bombas){
			valorPagamento += bomba.calculaValorCombustivel();
		}
		
		return (calculaTotalDeLitros() >= 20 || valorPagamento > 70.00) ? 
				"Valor Total: " + (valorPagamento - calculaDesconto(valorPagamento)) + "\nDesconto: R$" + calculaDesconto(valorPagamento)
				: "Valor Total: " + valorPagamento;
	}
}
