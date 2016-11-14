package br.com.jessica.aula7.loja.funcionario;

public class Administrativo extends Funcionario{
	private float valorHoraExtra, qtdHorasExtras;

	public Administrativo(String nome, String RG, float salarioFixo, float valorHoraExtra) {
		super(nome, RG, salarioFixo);
		this.valorHoraExtra = salarioFixo / valorHoraExtra;
		qtdHorasExtras = 0;
	}

	public float calculaAdiconal(){
		return valorHoraExtra*qtdHorasExtras;
	}

	@Override
	public float imprimeSalario(){
		float salarioFinal = calculaAdiconal() + getSalario();
		qtdHorasExtras = 0;
		return salarioFinal;
	}

	public float getValorHoraExtra() {
		return valorHoraExtra;
	}

	public void setValorHoraExtra(float valorHoraExtra) {
		this.valorHoraExtra = valorHoraExtra;
	}

	public float getQtdHorasExtras() {
		return qtdHorasExtras;
	}

	public void setQtdHorasExtras(float qtdHorasExtras) {
		this.qtdHorasExtras = qtdHorasExtras;
	}
	
	
}
