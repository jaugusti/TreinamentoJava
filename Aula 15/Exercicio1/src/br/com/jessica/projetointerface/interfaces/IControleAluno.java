package br.com.jessica.projetointerface.interfaces;

import java.util.ArrayList;

import br.com.jessica.projetointerface.aluno.Aluno;
import br.com.jessica.projetointerface.excecoes.AlunoException;

public interface IControleAluno {
	void adicionar(Aluno aluno);
	Aluno get(int indice) throws AlunoException;
	void excluir(int indice) throws AlunoException;
	ArrayList<Aluno> listagem();
	void editarAluno(Aluno aluno, String nome, String email, String endereco, String bairro, String cidade, String cep, String estado, String pais, String telefone);
}
