package exercicio6;

import java.util.ArrayList;

public class Vestibular {
	private ArrayList<Curso> listaCursos = new ArrayList<>();
	private float maiorCandidatoVaga = 0f;
	int indiceMaiorCandidatoVaga = 0;
	
	public void adicionaCurso(Curso curso){
		curso.setTotalCandidatos(curso.getnCandidatosHomens() + curso.getnCandidatosMulheres());
		listaCursos.add(curso);
	}

	public float candidatoPorVaga(int indice){
		float candidatoVaga = listaCursos.get(indice).getTotalCandidatos() / listaCursos.get(indice).getNumeroDeVagas();
		if(maiorCandidatoVaga < candidatoVaga){
			maiorCandidatoVaga = candidatoVaga;
			indiceMaiorCandidatoVaga = indice;
		}
		return candidatoVaga;
	}
	
	public float pctgCandidatoSexo(int indice, float nCandidatosSexo){
		float tCandidatos = listaCursos.get(indice).getTotalCandidatos();
		return (tCandidatos == 0f) ? 0 : (nCandidatosSexo * 100) / tCandidatos;
	}
	
	public String imprimeVestibular(){
		String resultadoPorCurso = ""; 
		for(int i = 0; i < listaCursos.size(); i++){
			resultadoPorCurso += "--- " + listaCursos.get(i).getCodigoDoCurso() + " - " + listaCursos.get(i).getNomeCurso() + " ---\n"
							+ "Número de Candidatos por Vaga: " + candidatoPorVaga(i) 
							+ "\nPorcentagem Candidatas Mulheres: " + pctgCandidatoSexo(i , listaCursos.get(i).getnCandidatosMulheres()) + "%\n\n";
		}
		return resultadoPorCurso;
	}
	
	public String imprimeMaiorCandidatoVaga(){
		return "--- Maior Número de Candidatos por Vaga ---\n" 
				+ listaCursos.get(indiceMaiorCandidatoVaga).getCodigoDoCurso() + " - "
				+ listaCursos.get(indiceMaiorCandidatoVaga).getNomeCurso() + ": "
				+ maiorCandidatoVaga + " candidatos por vaga";
	}
}
