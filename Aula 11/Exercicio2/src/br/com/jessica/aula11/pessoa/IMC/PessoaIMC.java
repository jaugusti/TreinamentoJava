package br.com.jessica.aula11.pessoa.IMC;

import br.com.jessica.aula11.pessoa.Pessoa;

public abstract class PessoaIMC extends Pessoa{
	protected double peso, altura;

	public PessoaIMC(String nome, String dataNascimento, double peso, double altura) {
		super(nome, dataNascimento);
		this.peso = peso;
		this.altura = altura;
	}

	public double calcularIMC(){
		return peso/(altura*altura);
	}
	
	public abstract String resultadoIMC();
	
	@Override
	public String imprimir(){
		return super.imprimir()
				+ "\nPeso: " + peso + "Kg"
				+ "\nAltura: " + altura + "cm";
	}
	
	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}
}
