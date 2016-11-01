package exercicio6;

public class Main {

	public static void main(String[] args) {
		Moto moto = new Moto("Honda", "CG", "azul");
		
		moto.marchaAbaixo();
		moto.marchaAcima();
		moto.marchaAbaixo();
		moto.marchaAcima();
		moto.marchaAcima();
		
		System.out.println(moto.imprimir());
	}

}
