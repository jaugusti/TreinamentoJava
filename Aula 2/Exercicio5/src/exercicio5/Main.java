package exercicio5;

import java.util.Scanner;

public class Main {

	private Scanner ler;

	public static void main(String[] args) {
		Main constroiPorta = new Main(); 
		
//		Porta porta = new Porta(true, 1, 1, 1);
//		System.out.println(porta.imprimePorta(1));
		
//		Casa casa1 = new Casa();
//		casa1.pinta("azul");
//		casa1.adicionaPorta(constroiPorta.constroiPorta());
//		System.out.println(casa1.imprimeCasa(1));
		
		Edificio edificio1 = new Edificio();
		edificio1.pinta("verde");
		edificio1.adicionaPorta(constroiPorta.constroiPorta());
		System.out.println(edificio1.imprimeEdificio(1));
	}
	
	public Porta constroiPorta(){
		ler = new Scanner(System.in);
		boolean aberta = false;
		
		System.out.print("Status Porta: ");
		String status = ler.nextLine();
		
		if(status.equals("aberta"))
			aberta = true;
		
		System.out.print("Cor: ");
		String cor = ler.nextLine();
		
		System.out.print("DimensãoX: ");
		double dimensaoX = ler.nextInt();
				
		System.out.print("DimensãoY: ");
		double dimensaoY = ler.nextInt();
				
		System.out.print("DimensãoZ: ");
		double dimensaoZ = ler.nextInt();
		
		Porta p = new Porta(aberta, dimensaoX, dimensaoY, dimensaoZ);
		
		p.pinta(cor);
		
		return p;
	}	
}
