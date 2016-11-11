package br.com.jessica.aula10.agenda;

public class Contato {
	private String nome, telefone, cpfCnpj;
	
	public Contato(String nome, String telefone, String cpfCnpj){
		this.nome = nome;
		this.telefone = telefone;
		this.cpfCnpj = cpfCnpj;
	}
	
	protected String imprimeContato(){
		return "Nome: " + nome
				+ "\nTelefone: " + telefone
				+ "\nCPF/CNPJ: " + cpfCnpj
				+ "\n-----------------";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
}
