package br.com.jessica.projetointerface.aluno;

import java.util.ArrayList;

import br.com.jessica.projetointerface.excecoes.AlunoException;
import br.com.jessica.projetointerface.interfaces.*;

public class ControleAluno implements IControleAluno{
	private ArrayList<Aluno> listaAlunos;
	
	public ControleAluno(){
        listaAlunos = new ArrayList<>();
    }
	
	@Override
	public void adicionar(Aluno aluno){
		listaAlunos.add(aluno);
	}

	@Override
	public Aluno get(int indice) throws AlunoException{
		if(indice < 0 || indice >= listaAlunos.size())
			throw new AlunoException("Aluno não existe!");
		return listaAlunos.get(indice);
	}

	@Override
	public void excluir(int indice) throws AlunoException{
		if(indice < 0 || indice >= listaAlunos.size())
			throw new AlunoException("Aluno não existe!");
		listaAlunos.remove(indice);
	}

	@Override
	public ArrayList<Aluno> listagem(){
		return listaAlunos;
	}
	
	@Override
	public void editarAluno(Aluno aluno, String nome, String email, String endereco, String bairro, String cidade, String cep, String estado,
			String pais, String telefone){
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setEndereco(endereco);
		aluno.setBairro(bairro);
		aluno.setCidade(cidade);
		aluno.setCep(cep);
		aluno.setEstado(estado);
		aluno.setPais(pais);
		aluno.setTelefone(telefone);
	}

	public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
}
