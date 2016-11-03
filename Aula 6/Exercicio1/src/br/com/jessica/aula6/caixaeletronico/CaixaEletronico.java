package br.com.jessica.aula6.caixaeletronico;

import java.util.ArrayList;

public class CaixaEletronico {
	private ArrayList<Notas> listaNotas = new ArrayList<>();
	private int saldoCaixa;
	private String statusSaque;
	
	public CaixaEletronico(){
		saldoCaixa = 0;
		statusSaque = "";
		Notas nota50 = new Notas(50, 0);
		addNota(nota50);
		Notas nota20 = new Notas(20, 0);
		addNota(nota20);
		Notas nota10 = new Notas(10, 0);
		addNota(nota10);
		Notas nota5 = new Notas(5, 0);
		addNota(nota5);
		Notas nota2 = new Notas(2, 0);
		addNota(nota2);
	}
	
	public void insereNotas(int valorNota, int qtdNota){
		for(Notas nota : listaNotas)
			if(nota.getValor() == valorNota)
				nota.setQuantidade(nota.getQuantidade()+qtdNota);
	}
	
	public void addNota(Notas nota){
		listaNotas.add(nota);
	}
	
	public int calculaSaldoCaixa(){
		for(Notas nota : listaNotas)
			saldoCaixa += nota.getValor() * nota.getQuantidade();
		
		return saldoCaixa;
	}
	

	public String retiraDinheiro(int valorSaque){
		int qtdSaque = 0;
		String retorno = ""; 
		if(calculaSaldoCaixa() >= valorSaque){
			for(Notas nota : listaNotas){
				if (nota.getQuantidade() > 0){
					
					nota.setQuantidade(nota.getQuantidade() - (valorSaque / nota.getValor()));
					qtdSaque = valorSaque / nota.getValor();
					valorSaque = (valorSaque % nota.getValor());
					
					if(nota.getValor()% 2 != 0 && (valorSaque + nota.getValor()) % 2 == 0){
						if(qtdSaque>0)
						 { 
							 qtdSaque -= 1;
							 nota.setQuantidade(nota.getQuantidade() + 1);
						 }
						valorSaque += nota.getValor();
					}
					if(nota.getValor() >= 10 && valorSaque == 1){
						if(qtdSaque>0)
						 { 
							 qtdSaque -= 1;
							 nota.setQuantidade(nota.getQuantidade() + 1);
						 }
						valorSaque += nota.getValor();
					}
					if(nota.getQuantidade() < qtdSaque){
						if(qtdSaque>0)
						 { 
							 qtdSaque -= 1;
							 nota.setQuantidade(nota.getQuantidade() + 1);
						 }
						valorSaque += nota.getValor();
					}
				}
				retorno += ("Notas de " + nota.getValor() + ": " + qtdSaque + "\n");
			}
			if(valorSaque == 0)
				return "-- Saque Realizado! --\n" + retorno;
			else
				return "-- Saque Realizado! --\n";
		}
		else
			retorno = "-- Saldo Indisponível! --\n";
		return retorno;
	}
	
	public String imprimeSaque(){
		return statusSaque;
	}

	public ArrayList<Notas> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(ArrayList<Notas> listaNotas) {
		this.listaNotas = listaNotas;
	}	
}
