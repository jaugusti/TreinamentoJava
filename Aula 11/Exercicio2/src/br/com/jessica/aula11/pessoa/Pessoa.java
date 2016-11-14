package br.com.jessica.aula11.pessoa;

import java.util.Calendar;
import java.util.Scanner;

import br.com.jessica.aula11.utilitarios.Util;

public class Pessoa {
	protected String nome, dataNascimento;
	Scanner ler = new Scanner(System.in);
	Util util = new Util();

	public Pessoa(String nome, String dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public String imprimir(){
		return "Nome: " + nome 
				+ "\nData de Nascimento: " + util.quebraData(dataNascimento) 
				+ "\nIdade: " + calculaIdade() + " anos";
	}
	
	public int calculaIdade(){
		Calendar cal = Calendar.getInstance();
		int anoAtual = cal.get(Calendar.YEAR);
		
		return (anoAtual - Integer.parseInt(util.getAno()));
	}
}
