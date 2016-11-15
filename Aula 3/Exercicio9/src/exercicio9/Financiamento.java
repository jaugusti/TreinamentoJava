package exercicio9;

public class Financiamento {
	private float salarioPessoa, financiamento;
	
	public Financiamento(float salarioPessoa, float financiamento){
		this.salarioPessoa = salarioPessoa;
		this.financiamento = financiamento;
	}
	
	public String aprovaFinanciamento(){
		return (financiamento <= salarioPessoa*5) ? "Financiamento Concedido!" : "Financiamento Negado";
	}
	
	public String imprimeSituacaoFinanciamento(){
		return aprovaFinanciamento() + "\nObrigado por nos consultar!"; 
	}
}
