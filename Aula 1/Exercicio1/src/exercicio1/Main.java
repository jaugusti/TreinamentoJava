package exercicio1;

import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		Candidato c = new Candidato();
		ler = new Scanner(System.in);
		
		System.out.print("C�digo Candidato: ");
		c.setCodigo(ler.nextInt());
		
		System.out.print("Ano de Nascimento: ");
		c.setAnoNascimento(ler.nextInt());
		
		System.out.print("Nota Etapa 1: ");
		c.setNotaEtapa1(ler.nextFloat());
		
		System.out.print("Qualifica��o (horas): ");
		c.setHrsQualificacao(ler.nextFloat());
		
		System.out.print("Experi�ncia (anos): ");
		c.setAnosExperiencia(ler.nextFloat());
		
		System.out.println("\n--------- Resultado ---------\n" + c.verificaAprovacao());
	}

}
