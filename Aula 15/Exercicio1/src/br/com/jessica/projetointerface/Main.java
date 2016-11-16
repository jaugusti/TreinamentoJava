package br.com.jessica.projetointerface;

import java.util.Scanner;

import br.com.jessica.projetointerface.excecoes.AlunoException;
import br.com.jessica.projetointerface.excecoes.FuncionarioException;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraCiaDasDiaristas;
import br.com.jessica.projetointerface.funcionario.administrativo.FaxineiraSulClean;
import br.com.jessica.projetointerface.funcionario.administrativo.Jardineiro;
import br.com.jessica.projetointerface.funcionario.professor.Advogado;
import br.com.jessica.projetointerface.funcionario.professor.Dentista;
import br.com.jessica.projetointerface.interfaces.IFaxineira;
import br.com.jessica.projetointerface.interfaces.IProfessor;
import br.com.jessica.projetointerface.menu.Menu;

public class Main {

	public static void main(String[] args){
		Menu.iniciaMenu();
	}

}