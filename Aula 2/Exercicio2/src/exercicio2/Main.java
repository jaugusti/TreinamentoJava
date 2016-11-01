package exercicio2;

public class Main {

	public static void main(String[] args) {
		Lampada lampada = new Lampada();
		
		lampada.liga();
		lampada.desliga();
		
		System.out.println(lampada.observa());
	}

}
