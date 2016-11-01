package exercicio4;

public class Main {

	public static void main(String[] args) {
		Estoque estoque1 = new Estoque("Impressora Jato de Tinta", 13, 6);
		Estoque estoque2 = new Estoque("Monito LCD 17 polegadas", 11, 13);
		Estoque estoque3 = new Estoque("Mouse", 6, 2);
		
		System.out.println("A: " + estoque1.darBaixa(5));
		System.out.println("\nB: " + estoque2.repor(7));
		System.out.println("\nC: " + estoque3.darBaixa(4));
		System.out.println("\nD: -----------------------------");
		System.out.println("Precisa Repor Estoque 1: " + estoque1.precisaRepor());
		System.out.println("Precisa Repor Estoque 2: " + estoque2.precisaRepor());
		System.out.println("Precisa Repor Estoque 3: " + estoque3.precisaRepor());
		System.out.println("\nE: ------- Estoque 1 ------- ");
		System.out.println(estoque1.mostra());
		System.out.println("\nE: ------- Estoque 2------- ");
		System.out.println(estoque2.mostra());
		System.out.println("\nE: ------- Estoque 3 ------- ");
		System.out.println(estoque3.mostra());
	}

}
