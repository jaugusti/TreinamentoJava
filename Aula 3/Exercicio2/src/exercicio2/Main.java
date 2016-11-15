package exercicio2;
import java.util.Scanner;

public class Main {

	private static Scanner ler;

	public static void main(String[] args) {
		Calculos v = new Calculos();
		
		ler = new Scanner(System.in);
		System.out.print("Quantidade de valores que deseja ler: ");
		int qtdValores = Math.abs(ler.nextInt());
		v.setQtdValores(qtdValores); 
		
		for(int i = 0; i < qtdValores; i++){
			System.out.print("Digite o valor: ");
			int valor = Math.abs(ler.nextInt());
			
			v.calculaMaior(valor);  
			if(i == 0)
				v.setMenor(valor);
			else
				v.calculaMenor(valor);
			
			v.somaValor(valor);
		}
		
		System.out.println(v.imprimeMaiorMenorMedia());
	}
}
