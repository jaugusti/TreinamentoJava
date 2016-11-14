package br.com.jessica.banco.caixaeletronico;

import java.util.ArrayList;

import br.com.jessica.banco.Banco;
import br.com.jessica.banco.conta.InformacaoConta;
import br.com.jessica.cliente.RetornoCliente;

public class CaixaEletronico 
{
	private String senhaV = "adm"; //Senha inicial
	private ArrayList<Cedulas> cedulas;
	private ArrayList<Cedulas> cedulasSaque;
//	private String cedulasSaque;
	
	//-------------------------------------------------------------//

	public CaixaEletronico()
	{
		cedulas = new ArrayList<>();
//		cedulasSaque = "";
		cedulasSaque = new ArrayList<>();
	}
	
	//-------------------------------------------------------------//

	public void criarLista()
	{
		cedulas.add(new Cedulas(50, 0));
		cedulas.add(new Cedulas(20, 0));
		cedulas.add(new Cedulas(10, 0));
		cedulas.add(new Cedulas(5, 0));
		cedulas.add(new Cedulas(2, 0));
	}
	
	//-------------------------------------------------------------//

	public boolean validacaoSenha(String senha)
	{
		if(senha == senhaV)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//-------------------------------------------------------------//
	
	public String valorTotal()
	{
		String text = "";
		int total = 0;
		
		for(Cedulas cedulas: cedulas)
		{
			text = (text+cedulas.getValorNota()+" -> "+cedulas.getQntNotas()+" cedulas\n");
			total = total + (cedulas.getQntNotas() * cedulas.getValorNota());
		}
		text = (text+"\nValor total: R$ "+total+",00");
		
		return text;
	}
	
	//-------------------------------------------------------------//
	
	public int total()
	{
		int valorTotal = 0;
		for(Cedulas cedulas: cedulas)
		{
			valorTotal = valorTotal + (cedulas.getQntNotas() * cedulas.getValorNota());
		}
		return valorTotal;
	}
	
	//-------------------------------------------------------------//
	
	public void adicionarCedula(int valor, int quantidade)
	{
		for(Cedulas nota: cedulas)
		{
			if(nota.getValorNota() == valor)
				nota.setQntNotas(nota.getQntNotas()+quantidade);
		}
	}
	
	//-------------------------------------------------------------//
	
	public String celulasDisponiveis()
	{
		String text = "";
		for(Cedulas nota: cedulas)
		{
			if(nota.getQntNotas() > 0)
				text = (text + "R$ " + nota.getValorNota()+"\t");
		}
		return text;
	}
	
	//-------------------------------------------------------------//
	public void inicializarCedulasSaque(){
		for(Cedulas cedula : cedulas){
			cedulasSaque.add(new Cedulas(cedula.getValorNota(), 0));
		}
	}
	
	public boolean testaSaldo(Banco banco, InformacaoConta infConta, int valorSaque){
		RetornoCliente retornoC = banco.consultaSaldo(infConta);
		if(retornoC.getSaldo() >= valorSaque && total() >= valorSaque)
			return true;
		return false;
	}
	
	public boolean sacar(Banco banco, InformacaoConta infConta, int valorSaque)
	{
		int valor = valorSaque;
		Cedulas cedula = null;
		if ((valorSaque % 2) != 0) {
			cedula = procuraMaiorCedulaImpar();
			
			if(cedula == null){
				return false;
			}
			
			else {
				valorSaque = valorSaque - cedula.getValorNota();
				cedula.setQntNotas(cedula.getQntNotas() - 1);
			}
		}
		if(retiraDinheiro(valorSaque)){
			banco.addMovimento(1, valor, "2016", "d", infConta, false, "Aprovado!");
			banco.movimentoDebitoCliente(infConta, valor);
			if(cedula != null)
			for(Cedulas cedulaSaque : cedulasSaque)
				if(cedulaSaque.getValorNota() == cedula.getValorNota())
					cedulaSaque.setQntNotas(cedulaSaque.getQntNotas()+1);
			return true;
		}
		return false;
	}
	
	public Cedulas procuraMaiorCedulaImpar(){
		for (Cedulas cedula : cedulas)
			if ((cedula.getValorNota() % 2) != 0 && cedula.getQntNotas() !=0)
				return cedula;
		return null;
	}
	
	public boolean retiraDinheiro(int valorSaque){
		int indice = 0;
		int qtdNotas = 0;
		
		for(Cedulas cedula : cedulas){
			if(valorSaque == 0){
				break;
			}
			qtdNotas = (int) Math.floor(valorSaque / cedula.getValorNota());
				
			if(qtdNotas > cedula.getQntNotas()){
				qtdNotas = cedula.getQntNotas();
			}
				
			valorSaque = valorSaque - (qtdNotas * cedula.getValorNota());
			cedula.setQntNotas(cedula.getQntNotas() - qtdNotas);
			cedulasSaque.get(indice).setQntNotas(qtdNotas);
			indice++;
		}
		
		if(valorSaque == 0){
			return true;
		}
		else
			return false;
	}

	public ArrayList<Cedulas> getCedulas() {
		return cedulas;
	}

	public void setCedulas(ArrayList<Cedulas> cedulas) {
		this.cedulas = cedulas;
	}

	public ArrayList<Cedulas> getCedulasSaque() {
		return cedulasSaque;
	}

	public void setCedulasSaque(ArrayList<Cedulas> cedulasSaque) {
		this.cedulasSaque = cedulasSaque;
	}
	
	//-------------------------------------------------------------//
	public static double descargaCedulas(Cedulas cedula){
		double valorOperacao = cedula.getValorNota()*cedula.getQntNotas();
		
		cedula.setQntNotas(0);
		
		return valorOperacao;
	}

}
