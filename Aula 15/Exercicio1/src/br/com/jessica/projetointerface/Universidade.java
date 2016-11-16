package br.com.jessica.projetointerface;

import java.util.ArrayList;

import br.com.jessica.projetointerface.aluno.Aluno;
import br.com.jessica.projetointerface.aluno.ControleAluno;
import br.com.jessica.projetointerface.excecoes.AlunoException;
import br.com.jessica.projetointerface.excecoes.FuncionarioException;
import br.com.jessica.projetointerface.funcionario.administrativo.Jardineiro;
import br.com.jessica.projetointerface.interfaces.IControleAluno;
import br.com.jessica.projetointerface.interfaces.IFaxineira;
import br.com.jessica.projetointerface.interfaces.IFuncionario;
import br.com.jessica.projetointerface.interfaces.IJardineiro;
import br.com.jessica.projetointerface.interfaces.IProfessor;

public class Universidade{
	private IControleAluno controleAluno;
    private IFaxineira faxineira;    
    private IJardineiro jardineiro;
    private ArrayList<IProfessor> professores;
    
    public Universidade()
    {
        professores = new ArrayList<>();
        controleAluno = new ControleAluno();
    }

	public void setControleAluno(IControleAluno controleAluno) {
		this.controleAluno = controleAluno;
	}

	public void setFaxineira(IFaxineira paramFaxineira) throws FuncionarioException
    {
        if(paramFaxineira.temAutorizacao()) {
            this.faxineira = paramFaxineira;
        } else  {
            throw new FuncionarioException("Faxineira sem autorizacao");
        }        
    }
    
    public void setJardineiro(IFuncionario paramJardineiro) throws FuncionarioException
    {
        if(paramJardineiro.temAutorizacao()) {
            this.jardineiro = (Jardineiro)paramJardineiro;
        } else  {
            throw new FuncionarioException("Jardineiro sem autorizacao");
        }        
    }
    
    public void diaDaLimpeza()
    {
        faxineira.lavar();
        faxineira.varrer();
        faxineira.tirarLixo();        
        jardineiro.cortarGrama();        
    }    
    
    public void adicionarProfessor(IProfessor professor) throws FuncionarioException
    {
        if(professor.temAutorizacao()){
            professores.add(professor);
        } else {
            throw new FuncionarioException("Professor sem autorizacao");
        }
    }
    
    public void listarProfessores()
    {
        for(IProfessor prof : professores)
        {
            System.out.println(prof.dadosPessoais());
            System.out.println("----------");
        }
    }
    
	public void adicionarAluno(Aluno aluno) {
		controleAluno.adicionar(aluno);
	}

	public Aluno getAluno(int indice) throws AlunoException{
		return this.controleAluno.get(indice);
	}

	public void excluirAluno(int indice) throws AlunoException{
		controleAluno.excluir(indice);
	}
	
	public ArrayList<Aluno> listagem(){
		return controleAluno.listagem();
	}
	
	public void editarAluno(Aluno aluno, String nome, String email, String endereco, String bairro, String cidade, String cep, String estado,
			String pais, String telefone){
		controleAluno.editarAluno(aluno, nome, email, endereco, bairro, cidade, cep, estado, pais, telefone);
	}
}
