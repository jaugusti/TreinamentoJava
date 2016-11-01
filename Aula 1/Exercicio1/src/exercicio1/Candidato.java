package exercicio1;
import java.util.Calendar;

public class Candidato {
	private int codigo, anoNascimento;
	private float notaEtapa1, hrsQualificacao, anosExperiencia;

	public String verificaAprovacao(){
		return (notaEtapa1 >= 8.0 || hrsQualificacao >= 1000.0 || (calculaIdade() <= 30 && anosExperiencia >= 2.0)) ? 
				"Código Candidato: " + codigo + "\nIdade: " + calculaIdade() + "\nAprovado para a terceira etapa!"
				: "Código Candidato: " + codigo + "\nIdade: " + calculaIdade() + "\nReprovado!";
	}
	
	public int calculaIdade(){
		Calendar cal = Calendar.getInstance();
		int anoAtual = cal.get(Calendar.YEAR);
		
		return anoAtual - anoNascimento;
		
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public void setNotaEtapa1(float notaEtapa1) {
		this.notaEtapa1 = notaEtapa1;
	}

	public void setHrsQualificacao(float hrsQualificacao) {
		this.hrsQualificacao = hrsQualificacao;
	}

	public void setAnosExperiencia(float anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}
}
