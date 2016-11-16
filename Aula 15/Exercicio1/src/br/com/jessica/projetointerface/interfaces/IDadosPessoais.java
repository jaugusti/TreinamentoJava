package br.com.jessica.projetointerface.interfaces;

public interface IDadosPessoais {
	public String getNome();
	public void setNome(String nome);
	
	public String getTelefone();
	public void setTelefone(String telefone);

	public int getIdade();
	public void setIdade(int idade);
	
	public String getObservacoes();
	public void setObservacoes(String observacoes);
}
