package exercicio4;

public class Material {
	private float tempoSegundos = 0.f, massaInicial = 0f; 
	
	public Material(float massaInicial){
		this.massaInicial = massaInicial;
	}
	
	public void calculaTempoSegundos(){
		tempoSegundos += 50f;
	}
	
	public float calculaTempoMinutos(){
		return (tempoSegundos/60);
	}
	
	public float calculaTempoHoras(){
		return (tempoSegundos/3600);
	}
	
	public float calculaMassa(){
		float massaFinal = massaInicial;
		
		while(massaFinal >= 0.5f){
			calculaTempoSegundos();
			massaFinal = massaFinal/2;
		}
		return massaFinal;
	}
	
	public String imprimeResultado(){
		return "Massa inicial: " + massaInicial + "\nMassa Final: " + calculaMassa() + "\nTempo Horas: " + calculaTempoHoras() +" horas"
				+ "\nTempo Minutos: " + calculaTempoMinutos() + " minutos" + "\nTempo Segundos: " + tempoSegundos + " segundos";
	}
}
