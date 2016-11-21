package br.com.jessica.banco.movimentos;

import java.util.ArrayList;

import br.com.jessica.banco.Banco;
import br.com.jessica.banco.conta.InformacaoConta;
import br.com.jessica.cliente.RetornoCliente;

public class Movimentacao {
	private ArrayList<Movimento> listaMovimentos = new ArrayList<>();
	
	public void addMovimento(Movimento movimento){
		listaMovimentos.add(movimento);
	}
	
	public ArrayList<Movimento> gerarExtrato(InformacaoConta infConta, Banco banco, int tipoSolicitacao){
		ArrayList<Movimento> movimentosExtrato = new ArrayList<>();
		
		for(Movimento movimento : listaMovimentos){
			if(tipoSolicitacao == 1){ // se usuario solicitou
				if(movimento.getTipoUsuario() == 1
					&& movimento.getConta().getAgencia().equals(infConta.getAgencia()) 
					&& movimento.getConta().getNumeroConta().equals(infConta.getNumeroConta())){
					
					movimentosExtrato.add(movimento);
				}
			}
			else
				movimentosExtrato.add(movimento);
		}
		return movimentosExtrato;
	}

	public ArrayList<Movimento> getListaMovimentos() {
		return listaMovimentos;
	}

	public void setListaMovimentos(ArrayList<Movimento> listaMovimentos) {
		this.listaMovimentos = listaMovimentos;
	}
}
