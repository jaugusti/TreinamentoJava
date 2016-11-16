package br.com.jessica.projetointerface.funcionario.administrativo;

import br.com.jessica.projetointerface.interfaces.IFaxineira;

public class FaxineiraCiaDasDiaristas implements IFaxineira {
	private String nome, telefone, observacoes;
	private int idade;
	
    public FaxineiraCiaDasDiaristas(String nome, String telefone, String observacoes, int idade) {
		this.nome = nome;
		this.telefone = telefone;
		this.observacoes = observacoes;
		this.idade = idade;
	}

	@Override
    public void varrer() {
        System.out.println("FaxineiraCiaDasDiaristas - Varrer");
    }

    @Override
    public void lavar() {
        System.out.println("FaxineiraCiaDasDiaristas - lavar");
    }

    @Override
    public void tirarLixo() {
        System.out.println("FaxineiraCiaDasDiaristas - tirarLixo");
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