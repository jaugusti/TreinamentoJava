package exercicio6;

public class Main {
	public static void main(String[] args) {
		Vestibular vestibular = new Vestibular();
		
		Curso cienciaDaComputacao = new Curso("Ciência da Computação", 77, 10, 10, 0);
		vestibular.adicionaCurso(cienciaDaComputacao);
		
		Curso medicina = new Curso("Medicina", 54, 20, 50, 53);
		vestibular.adicionaCurso(medicina);
		
		Curso historia = new Curso("Historia", 90, 15, 6, 9);
		vestibular.adicionaCurso(historia);
	
		System.out.print(vestibular.imprimeVestibular());
		System.out.print(vestibular.imprimeMaiorCandidatoVaga());
	}
}
