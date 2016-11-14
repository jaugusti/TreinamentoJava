package br.com.jessica.aula11.pessoa;

import br.com.jessica.aula11.pessoa.IMC.PessoaIMC;

public class Homem extends PessoaIMC{

	public Homem(String nome, String dataNascimento, double peso, double altura) {
		super(nome, dataNascimento, peso, altura);
	}

	@Override
	public String resultadoIMC(){
		double IMC = calcularIMC();
		String retorno = "IMC: " + IMC + "\n";
		
		if(IMC < 20.7)
			retorno += "Abaixo do peso ideal!";
		else if (IMC > 20.7 && IMC < 26.4)
			retorno += "Peso ideal!";
		else
			retorno += "Acima do peso ideal!";
		
		return retorno;
	}
}
