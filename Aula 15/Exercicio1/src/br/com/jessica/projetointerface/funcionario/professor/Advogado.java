package br.com.jessica.projetointerface.funcionario.professor;

import br.com.jessica.projetointerface.interfaces.IProfessor;

public class Advogado implements IProfessor {
	private String nome, telefone, observacoes;
	private int idade;
	
    public Advogado(String nome, String telefone, int idade, String observacoes){
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.observacoes = observacoes;
	}

	@Override
    public void darAula() {
        System.out.println("Advogado - darAula");
    }

    @Override
    public void lancarNotas() {
        System.out.println("Advogado - lancarNotas");
    }

    @Override
    public String dadosPessoais() {
        return "Nome: " + nome
        		+ "\nTelefone: " + telefone
        		+ "\nIdade: " + idade
        		+ "\nObservações: " + observacoes;
    }

    @Override
    public Boolean temAutorizacao() {
        return true;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}