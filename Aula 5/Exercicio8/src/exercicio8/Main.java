package exercicio8;

public class Main {

	public static void main(String[] args) {
		Moto moto = new Moto("Honda", "CG", "azul", 0, 6);
		
		moto.marchaAcima(2);
		moto.marchaAcima(4);
		moto.marchaAbaixo(2);
//		moto.marchaAcima(3);
//		moto.marchaAcima(2);
		
		System.out.println(moto.imprimir());
	}

}
