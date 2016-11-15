package exercicio5;

import java.util.ArrayList;

public class RelatorioPesquisa {
	private ArrayList<Entrevistado> listaEntrevistado = new ArrayList<>();
	
	public void addEntrevistado(Entrevistado entrevistado){
		listaEntrevistado.add(entrevistado);
	}
	
	public float calculaTotalDeEntrevistadosPorSexo(String sexo){
		float totalCandidatosSexo = 0;
		for(Entrevistado e : listaEntrevistado)
			if(e.getSexo().equals(sexo))
				totalCandidatosSexo ++;
		return totalCandidatosSexo;
	}
	
	public float calculaTotalDeRespostasSimOuNao(String resposta){
		float totalRepostasSimOuNao = 0;
		for(Entrevistado e : listaEntrevistado)
			if(e.getResposta().equals(resposta))
				totalRepostasSimOuNao ++;
		return totalRepostasSimOuNao;
	}
	
	public float calculaRespostaSimOuNãoPorSexo(String sexoCandidato, String resposta){
		float numeroSimPorSexoCandidato = 0;
		for(Entrevistado e : listaEntrevistado)
			if(e.getSexo().equals(sexoCandidato) && e.getResposta().equals(resposta))
				numeroSimPorSexoCandidato ++;
		return numeroSimPorSexoCandidato;
	}
	
	public float pctgRespostaSimOuNaoPorSexo(String sexo, String resposta){
		return (calculaTotalDeEntrevistadosPorSexo(sexo) == 0f) ? 0f : (calculaRespostaSimOuNãoPorSexo(sexo, resposta) * 100) / calculaTotalDeEntrevistadosPorSexo(sexo);
	}
	
	public String imprimeRelatorio(){
		return "Total de Respostas Sim: " + calculaTotalDeRespostasSimOuNao("sim")
				+ "\nTotal de Resposta Não: " + calculaTotalDeRespostasSimOuNao("não")
				+ "\nPorcentagem Mulheres SIM: " + pctgRespostaSimOuNaoPorSexo("feminino", "sim") + "%"
				+ "\nPorcentagem Homens NÃO: " + pctgRespostaSimOuNaoPorSexo("masculino", "não") + "%";
	}
}
