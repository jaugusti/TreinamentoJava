package exercicio1e2;

import java.util.ArrayList;

public class Pessoa {
	private String nomeP, enderecoP, telefoneP;
	private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
	
	public Pessoa(String nomeP, String enderecoP, String telefoneP){
		this.nomeP = nomeP;
		this.enderecoP = enderecoP;
		this.telefoneP = telefoneP;
	}
	
	public Pessoa(){}
	
	public void addPessoa(Pessoa pessoa){
		listaPessoas.add(pessoa);
	}
	
	public String imprimir(){
		String contatos = "";
		for(Pessoa p : listaPessoas)
			contatos += "\n--- " + p.nomeP + " ---" + "\nEndereço: " + p.enderecoP + "\nTelefone: " + p.telefoneP + "\n";
		return contatos;
	}
	public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
}
