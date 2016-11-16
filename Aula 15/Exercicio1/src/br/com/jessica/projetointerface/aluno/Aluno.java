package br.com.jessica.projetointerface.aluno;

import br.com.jessica.projetointerface.excecoes.AlunoException;

public class Aluno {
	private String nome, email, endereco, bairro;
	private String cidade, cep, estado, pais, telefone;
	
	public Aluno(String nome, String email, String endereco, String bairro, String cidade, String cep, String estado,
			String pais, String telefone) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
		this.telefone = telefone;
		
		try {
			validaDados();
		} catch (AlunoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void validaDados() throws AlunoException{
		if(nome == null || email == null || endereco == null || bairro == null || cidade == null || cep == null || estado == null
				|| pais == null || telefone == null)
			throw new AlunoException("Campo(s) nulo(s)!");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
