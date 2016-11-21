package br.com.jessica.aula6.caixaeletronico;

import java.util.ArrayList;

public class CaixaEletronico {
	private ArrayList<Notas> listaNotas;
	private ArrayList<Notas> notasSaque;
	
	public CaixaEletronico(){
		listaNotas = new ArrayList<>();
		notasSaque = new ArrayList<>();
		
		criaNotas();
	}
	
	public void criaNotas(){
		listaNotas.add(new Notas(50, 0));
		listaNotas.add(new Notas(20, 0));
		listaNotas.add(new Notas(10, 0));
		listaNotas.add(new Notas(5, 0));
		listaNotas.add(new Notas(2, 0));
		
		inicializarCedulasSaque();
	}
	
	public void inicializarCedulasSaque(){
		for(Notas nota : listaNotas)
			notasSaque.add(new Notas(nota.getValorNota(), 0));
	}
	
	
	/** Saldo Caixa Eletronico **/
	public int saldoCaixaEletronico(){
		int saldoCaixa = 0;
		
		for(Notas nota : listaNotas)
			saldoCaixa += nota.getQtdNotas()*nota.getValorNota();
		
		return saldoCaixa;
	}
	/** Fim Saldo Caixa Eletronico **/
	
	/** Repor Notas **/
	public void reporNota(int valorNota, int quantidade){
		for(Notas nota: listaNotas)
			if(nota.getValorNota() == valorNota)
				nota.setQtdNotas(nota.getQtdNotas() + quantidade);
	}
	/** Fim Repor Notas **/
	
	/** Visualiza Notas **/
	public ArrayList<Notas> visualizarNotas(int tipoSolicitacao){
		ArrayList<Notas> notasDisponiveis = new ArrayList<>();
		
		if(tipoSolicitacao == 1)
			for(Notas nota : listaNotas)
				notasDisponiveis.add(nota);
		
		else if(tipoSolicitacao == 2)
			for(Notas nota : listaNotas)
				if(nota.getQtdNotas() != 0)
					notasDisponiveis.add(nota);
		
		return notasDisponiveis;
	}
	/** Fim Visualiza Notas **/
	
	/** Fim Saque **/
	public boolean sacar(int valorSaque){
		int valor = valorSaque;
		Notas nota = null;
		if ((valorSaque % 2) != 0) {
			nota = procuraMaiorCedulaImpar();
			
			if(nota == null){
				return false;
			}
			
			else {
				valorSaque = valorSaque - nota.getValorNota();
				nota.setQtdNotas(nota.getQtdNotas() - 1);
			}
		}
		if(retiraDinheiro(valorSaque)){
			if(nota != null)
				for(Notas notaSaque : notasSaque)
					if(notaSaque.getValorNota() == nota.getValorNota())
						notaSaque.setQtdNotas(notaSaque.getQtdNotas()+1);
			return true;
		}
		return false;
	}
	
	public Notas procuraMaiorCedulaImpar(){
		for (Notas cedula : listaNotas)
			if ((cedula.getValorNota() % 2) != 0 && cedula.getQtdNotas() !=0)
				return cedula;
		return null;
	}
	
	public boolean retiraDinheiro(int valorSaque){
		int indice = 0;
		int qtdNotas = 0;
		
		for(Notas nota : listaNotas){
			if(valorSaque == 0){
				break;
			}
			
			qtdNotas = (int) Math.floor(valorSaque / nota.getValorNota());
			
			
			if(qtdNotas > nota.getQtdNotas()){
				qtdNotas = nota.getQtdNotas();
			}
			
			valorSaque = valorSaque - (qtdNotas * nota.getValorNota());
				
			nota.setQtdNotas(nota.getQtdNotas() - qtdNotas);
			notasSaque.get(indice).setQtdNotas(qtdNotas);
			
			indice++;
		}
		
		if(valorSaque == 0){
			return true;
		}
		else
			return false;
	}
	
	public void zerarNotasSaque(){
		for(Notas nota : notasSaque)
			nota.setQtdNotas(0);
	}
	
	
	public ArrayList<Notas> notasSaque(){
		return notasSaque;
	}
	/** Fim Saque **/
}
