package br.com.jessica.aula7.loja.folhapagamento;

import br.com.jessica.aula7.loja.*;
import br.com.jessica.aula7.loja.funcionario.*;

public class FolhaPagamento {
	
	public static void teste(){
		Loja loja1 = new Loja("Loja 1");
		Funcionario funcionario;
		
		funcionario = new Vendedor("Carlos", "2322985452", 1000f, 0.5f);
		loja1.addfuncionario(funcionario);
		
		funcionario = new Administrativo("Maria", "2819236778", 1500f, 100f);
		loja1.addfuncionario(funcionario);
		
		funcionario = new Vendedor("Joao", "2321986452", 1000f, 0.5f);
		loja1.addfuncionario(funcionario);
		
		funcionario = new Administrativo("Paulo", "2890923077", 1500f, 100f);
		loja1.addfuncionario(funcionario);
		
		addVenda(loja1);
		addHoraExtra(loja1);
		
		loja1.totalVendasFuncionario();
		loja1.totalHorasExtrasFuncionario();
		
		imprimeFolhaPagamento(loja1);
	}
	
	public static void addVenda(Loja loja){
		Venda venda1 = new Venda(15f, "2322985452");
		loja.addVenda(venda1);
		
		Venda venda2 = new Venda(10f, "2321986452");
		loja.addVenda(venda2);
		
		Venda venda3 = new Venda(30f, "2322985452");
		loja.addVenda(venda3);
	}
	
	public static void addHoraExtra(Loja loja){
		HoraExtra horaExtra1 = new HoraExtra(2, "2819236778");
		loja.addHoraExtra(horaExtra1);
		
		HoraExtra horaExtra2 = new HoraExtra(3, "2890923077");
		loja.addHoraExtra(horaExtra2);
		
		HoraExtra horaExtra3 = new HoraExtra(5, "2819236778");
		loja.addHoraExtra(horaExtra3);
	}
	
	public static void imprimeFolhaPagamento(Loja loja){
		for(Funcionario funcionario : loja.getListaFuncionarios()){
			if(funcionario instanceof Vendedor)
				System.out.println("Nome Funcionário: " + funcionario.getNome()
						+ "\nRG Funcionário: " + funcionario.getRG() 
						+ "\nSalário: " + ((Vendedor) funcionario).imprimeSalario() + "\n\n");
			else if(funcionario instanceof Administrativo)
				System.out.println("Nome Funcionário: " + funcionario.getNome()
						+ "\nRG Funcionário: " + funcionario.getRG() 
						+ "\nSalário: " + ((Administrativo) funcionario).imprimeSalario() + "\n\n");
		}
	}
}
