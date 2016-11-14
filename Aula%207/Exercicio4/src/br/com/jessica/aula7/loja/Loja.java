package br.com.jessica.aula7.loja;

import java.util.ArrayList;

import br.com.jessica.aula7.loja.funcionario.Administrativo;
import br.com.jessica.aula7.loja.funcionario.Funcionario;
import br.com.jessica.aula7.loja.funcionario.Vendedor;

public class Loja {
	private String nomeLoja;
	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>(); 
	private ArrayList<Venda> listaVendas = new ArrayList<>();
	private ArrayList<HoraExtra> listaHorasExtras = new ArrayList<>();
	
	public Loja(String nomeLoja){
		this.nomeLoja = nomeLoja;
	}
	
	public void addfuncionario(Funcionario funcionario){
		listaFuncionarios.add(funcionario);
	}
	
	public void addVenda(Venda venda){
		listaVendas.add(venda);
	}
	
	public void addHoraExtra(HoraExtra horaExtra){
		listaHorasExtras.add(horaExtra);
	}
	
	public void totalVendasFuncionario(){
		for(Funcionario funcionario : listaFuncionarios){
			for(Venda venda : listaVendas){
				if(funcionario.getRG().equals(venda.getFuncionarioRG())
				&& funcionario instanceof Vendedor)
					((Vendedor) funcionario).setValorTotalVendas(venda.getValorVenda() + ((Vendedor) funcionario).getValorTotalVendas());
			}
		}
	}
	
	public void totalHorasExtrasFuncionario(){
		for(Funcionario funcionario : listaFuncionarios){
			for(HoraExtra horaExtra : listaHorasExtras){
				if(funcionario.getRG().equals(horaExtra.getFuncionarioRG())
				&& funcionario instanceof Administrativo)
					((Administrativo) funcionario).setQtdHorasExtras(((Administrativo) funcionario).getQtdHorasExtras() + horaExtra.getQtdHorasExtra());
			}
		}
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
}
