package br.com.jessica.aula11.utilitarios;

public class Util {
	private String dia = "";
	private String mes = "";
	private String ano = "";
	
	public String quebraData(String dataNascimento){
		String[] data = dataNascimento.split("[/]");
		dia = data[0];
		mes = data[1];
		ano = data[2];
		
		return getDataNascimento(dia, mes, ano);
	}
	
	public String getDataNascimento(String dia, String mes, String ano){
		return dia + " de " + mesPorExtenso() + " de " + ano;
	}
	
	public String getAno() {
		return ano;
	}

	public String mesPorExtenso(){
		String mesPorExtenso = "";
		switch(mes){
			case "01": 
				mesPorExtenso = "Janeiro";
				break;
			case "02": 
				mesPorExtenso = "Fevereiro";
				break;
			case "03": 
				mesPorExtenso = "Março";
				break;
			case "04": 
				mesPorExtenso = "Abril";
				break;
			case "05": 
				mesPorExtenso = "Maio";
				break;
			case "06": 
				mesPorExtenso = "Junho";
				break;
			case "07": 
				mesPorExtenso = "Julho";
				break;
			case "08": 
				mesPorExtenso = "Agosto";
				break;
			case "09": 
				mesPorExtenso = "Setembro";
				break;
			case "10": 
				mesPorExtenso = "Outubro";
				break;
			case "11": 
				mesPorExtenso = "Novembro";
				break;
			case "12": 
				mesPorExtenso = "Dezembro";
				break;
		}
		return mesPorExtenso;
	}
}
