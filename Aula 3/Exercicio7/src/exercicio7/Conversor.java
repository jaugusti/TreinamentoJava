package exercicio7;

public class Conversor {
	private int temperaturaFahrenheit = 0;
	
	public Conversor(int temperaturaFahrenheit){
		this.temperaturaFahrenheit = temperaturaFahrenheit;
	}
	
	public float converteFahrenheitParaCentigrados(){
		float temperaturaCentigrados = ((temperaturaFahrenheit - 32f)*5f)/9f;
		return temperaturaCentigrados;
	}
	
	public String imprimeFahrenheitCentigrados(){
		String tabela = " F  " + "|" + "   C";
		while(temperaturaFahrenheit <= 150){
			if(temperaturaFahrenheit > 98)
				tabela += "\n---------------\n" + temperaturaFahrenheit + " | " + converteFahrenheitParaCentigrados();
			else
				tabela += "\n---------------\n" + temperaturaFahrenheit + "  | " + converteFahrenheitParaCentigrados();
			temperaturaFahrenheit += 2;
		}
		return tabela;
	}
}
