package br.com.jessica.aula10.agenda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> listaContatos = new ArrayList<>();
	private boolean pesquisaNome = false;
	
	public void addContato(Contato contato){
		listaContatos.add(contato);
	}
	
	public String excluiContato(String infContato){
		Contato contato = procuraContato(infContato);
		pesquisaNome = false;
		
		if(contato != null){
			listaContatos.remove(contato);
			return "Contato Excluído!\n";
		}
		else
			return "Contato não Encontrado!\n";
	}
	
	public Contato procuraContato(String infContato){
		int i;
		if(infContato.matches("[[\\d]|[-]|[(]|[)]]+")){ // se infContato é um telefone
			for(i = 0; i < listaContatos.size(); i++)
				if(listaContatos.get(i).getTelefone().equals(infContato))
					return listaContatos.get(i);
		}
		else{
			for(i = 0; i < listaContatos.size(); i++) // se infContato é um nome
				if(listaContatos.get(i).getNome().equalsIgnoreCase(infContato)){
					pesquisaNome = true;
					return listaContatos.get(i);
				}
		}
		return null;
	}
	
	public String pesquisaContato(String infContato){
		Contato contato = procuraContato(infContato);
		
		if(pesquisaNome == true && contato != null){ // se a informação for um nome
			pesquisaNome = false;
			return "Telefone: " + contato.getTelefone() + "\n";
		}
		else if(contato != null)
			return "Nome: " + contato.getNome() + "\n";
		
		return "Contato não Encontrado!\n";
	}
	
	public void editarContato(Contato contato, String nome, String telefone, String cpfCnpj){
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setCpfCnpj(cpfCnpj);
	}
	
	public void exportaContatos() throws IOException{
		FileWriter arq = new FileWriter(".\\src\\arquivotxt\\agenda.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf(imprimeAgenda());
	    arq.close();
	}
	
	public String imprimeAgenda(){
		String retorna = "";
		if(listaContatos.size() == 0)
			return "Agenda Vazia!\n";
		else
			for(Contato contato : listaContatos)
				retorna += contato.imprimeContato() + "\n";
		return retorna;
	}
}