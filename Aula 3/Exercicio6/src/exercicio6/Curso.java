package exercicio6;

public class Curso {
	private String nomeCurso;
	private float numeroDeVagas, nCandidatosHomens, nCandidatosMulheres, totalCandidatos;
	private int codigoDoCurso;
	
	public Curso(String nomeCurso, int codigoDoCurso, float numeroDeVagas, float nCandidatosHomens, float nCandidatosMulheres){
		this.nomeCurso = nomeCurso;
		this.codigoDoCurso = codigoDoCurso;
		this.numeroDeVagas = numeroDeVagas;
		this.nCandidatosHomens = nCandidatosHomens;
		this.nCandidatosMulheres = nCandidatosMulheres;
	}
	
	public void setTotalCandidatos(float totalCandidatos) {
		this.totalCandidatos = totalCandidatos;
	}
	
	
	public float getTotalCandidatos() {
		return totalCandidatos;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public int getCodigoDoCurso() {
		return codigoDoCurso;
	}

	public float getNumeroDeVagas() {
		return numeroDeVagas;
	}
	
	public float getnCandidatosHomens() {
		return nCandidatosHomens;
	}
	
	public float getnCandidatosMulheres() {
		return nCandidatosMulheres;
	}
		
}
