package br.com.jessica.aula8;

import java.awt.List;
import java.util.Scanner;

import br.com.jessica.aula8.animais.Animal;
import br.com.jessica.aula8.animais.Ave;
import br.com.jessica.aula8.animais.Mamifero;
import br.com.jessica.aula8.animais.Peixe;
import br.com.jessica.aula8.jaula.Jaula;
import br.com.jessica.aula8.zoologico.Zoologico;

public class Menu {
	
	public static void iniciaTela(){
		Scanner ler = new Scanner(System.in);;
		Animal animal = null;
		Zoologico zoo = new Zoologico();
		
		boolean conectado = true;
		int opcao = -1;
		
		while(conectado){
			System.out.println("-- 0 Para Sair --");
			System.out.println("1) Colocar Animal na Jaula\n"
							+ "2) Remover Animal da Jaula");
			opcao = ler.nextInt();
			switch(opcao){
			case 0: 
				conectado = false;
				break;
			case 1: 
				addAnimal(zoo, animal);
				break;
			case 2: 
				removeAnimal(zoo);
				break;
			}
		}
		System.out.println(zoo.imprimeZoo());
	}
	
	/** Adiciona Animal **/
	public static void addAnimal(Zoologico zoo, Animal animal){
		Scanner ler = new Scanner(System.in);
		System.out.println("1) Adicionar um Mamífero\n"
				+ "2) Adicionar um Peixe\n"
				+ "3) Adicionar uma Ave");
		int opcao = ler.nextInt();
		switch(opcao){
			case 1: 
				animal = addMamifero();
				colocaAnimalJaula(zoo, animal);
				break;
			case 2: 
				animal = addPeixe();
				colocaAnimalJaula(zoo, animal);
				break;
			case 3:
				animal = addAve();
				colocaAnimalJaula(zoo, animal);
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
		}
	}
	
	public static void colocaAnimalJaula(Zoologico zoo, Animal animal){
		Scanner ler = new Scanner(System.in);
		if(verificaJaulasVazias(zoo)){
			System.out.println("Deseja Adicionar na Jaula Vazia (S/N): ");
			String resposta = ler.nextLine();
			
			if(resposta.equalsIgnoreCase("s"))
				addAnimalJaulaVazia(zoo, animal);
			else{
				zoo.criaNovaJaula(animal);
				System.out.println("Animal Adicionado!");
			}
		}
		else{
			zoo.criaNovaJaula(animal);
			System.out.println("Animal Adicionado9!");
		}
	}
	
	public static Animal addMamifero(){
//		return new Mamifero("Urso-do-canadá", 180, "Vermelho", "Mel", "Terra", 0.5f, 4, "grww");
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Nome Animal: ");
		String nomeAnimal = ler.nextLine();
		
		System.out.println("Cor: ");
		String cor = ler.nextLine();
		
		System.out.println("Alimento: ");
		String alimento = ler.nextLine();
		
		System.out.println("Ambiente: ");
		String ambiente = ler.nextLine();
		
		System.out.println("Som: ");
		String som = ler.nextLine();
		
		ler = new Scanner(System.in);
		
		System.out.println("Comprimento: ");
		int comprimento = ler.nextInt();
		
		System.out.println("Qtd Patas: ");
		int qtdPatas = ler.nextInt();
		
		
		System.out.println("Velocidade: ");
		float velocidade = ler.nextFloat();
		
		return new Mamifero(nomeAnimal, comprimento, cor, alimento, ambiente, velocidade, qtdPatas, som);
	}
	
	public static Animal addPeixe(){
//		return new Peixe("Tubarão", 300, "Cinzento", "Mar", 1.5f, "Barbatanas e Cauda", 0, "glub glub");
		Scanner ler = new Scanner(System.in);
		System.out.println("Nome Animal: ");
		String nomeAnimal = ler.nextLine();
		
		System.out.println("Cor: ");
		String cor = ler.nextLine();
		
		System.out.println("Ambiente: ");
		String ambiente = ler.nextLine();
		
		System.out.println("Caracteristica: ");
		String caracteristica = ler.nextLine();
		
		System.out.println("Som: ");
		String som = ler.nextLine();
		
		ler = new Scanner(System.in);
		
		System.out.println("Comprimento: ");
		int comprimento = ler.nextInt();
		
		System.out.println("Qtd Patas: ");
		int qtdPatas = ler.nextInt();
		
		
		System.out.println("Velocidade: ");
		float velocidade = ler.nextFloat();
		
		return new Peixe(nomeAnimal, comprimento, cor, ambiente, velocidade, caracteristica, qtdPatas, som);
	}
	
	public static Animal addAve(){
//		return new Ave("Arara", 100, "Azul", "Terra", 0.5f, 2, "Amazonia", "kkkkk");
		Scanner ler = new Scanner(System.in);
		System.out.println("Nome Animal: ");
		String nomeAnimal = ler.nextLine();
		
		System.out.println("Cor: ");
		String cor = ler.nextLine();
		
		System.out.println("Ambiente: ");
		String ambiente = ler.nextLine();
		
		System.out.println("Caracteristica: ");
		String caracteristica = ler.nextLine();
		
		System.out.println("Som: ");
		String som = ler.nextLine();
		
		ler = new Scanner(System.in);
		
		System.out.println("Comprimento: ");
		int comprimento = ler.nextInt();
		
		System.out.println("Qtd Patas: ");
		int qtdPatas = ler.nextInt();
		
		System.out.println("Velocidade: ");
		float velocidade = ler.nextFloat();
		
		return new Ave(nomeAnimal, comprimento, cor, ambiente, velocidade, qtdPatas, caracteristica, som);
	}
	
	public static boolean verificaJaulasVazias(Zoologico zoo){
		String jaulasVazias = zoo.verificaJaulasVazias();
		
		if(!jaulasVazias.equals("")){
			System.out.println(jaulasVazias);
			return true;
		}
		return false;	
	}
	
	public static void addAnimalJaulaVazia(Zoologico zoo, Animal animal){
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o Número da Jaula Vazia: ");
		int numeroJaula = ler.nextInt();
		
		if(zoo.addAnimalJaulaVazia(animal, numeroJaula))
			System.out.println("Animal adicionado!");
		else
			System.out.println("Não vou possível adicionar o animal!");
	}
	/** Fim Add Animal **/
	
	/** Remove animal **/
	public static void removeAnimal(Zoologico zoo){
		Scanner ler = new Scanner(System.in);

		System.out.println(zoo.imprimeJaulas());
		System.out.println("Numero da Jaula: ");
		
		if(zoo.removeAnimal(zoo, ler.nextInt()))
			System.out.println("Animal Excluído!\n");
		else
			System.out.println("Jaula Não Existe ou Está Vazia!\n");
	}
	/** Fim Remove Animal**/
}
