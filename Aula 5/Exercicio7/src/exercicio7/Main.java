package exercicio7;

public class Main {

	public static void main(String[] args) {
		Moto moto = new Moto("Honda", "CG", "azul");
		
		moto.marchaAcima(1);
		moto.marchaAcima(2);
		moto.marchaAbaixo(1);
//		moto.marchaAcima(3);
//		moto.marchaAcima(2);
		
		System.out.println(moto.imprimir());
	}

}
