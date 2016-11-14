package br.com.jessi.aula7.loja.funcionario;

public abstract class Funcionario {
	private String nome;
	private String RG;
	private float salario;
	
	public Funcionario(String nome, String RG, float salario) {
		this.nome = nome;
		this.RG = RG;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public abstract float imprimeSalario();
}
