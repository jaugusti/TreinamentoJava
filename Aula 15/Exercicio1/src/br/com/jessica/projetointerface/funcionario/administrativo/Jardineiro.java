package br.com.jessica.projetointerface.funcionario.administrativo;

import br.com.jessica.projetointerface.interfaces.IJardineiro;

public class Jardineiro implements IJardineiro {
	private String nome, telefone, observacoes;
	private int idade;
	
    public Jardineiro(String nome, String telefone, String observacoes, int idade) {
		this.nome = nome;
		this.telefone = telefone;
		this.observacoes = observacoes;
		this.idade = idade;
	}

	@Override
    public Boolean temAutorizacao() {
        return true;
    }

    @Override
    public Boolean possuiEquipamento() {
        return true;
    }
    
    public void cortarGrama() {
        System.out.println("Jardineiro - cortarGrama");
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