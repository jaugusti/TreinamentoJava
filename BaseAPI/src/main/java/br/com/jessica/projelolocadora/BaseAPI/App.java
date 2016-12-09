package br.com.jessica.projelolocadora.BaseAPI;

import java.util.Calendar;

import br.com.jessica.projetolocadora.dao.CategoriaDAO;
import br.com.jessica.projetolocadora.dao.FilmeDAO;
import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.modelo.Filme;

public class App 
{
    public static void main( String[] args )
    {
    	App aplicacao = new App();
//        Categoria categoria = new Categoria();
//        CategoriaDAO dao = new CategoriaDAO();
        //categoria.setDescricao("T");
        
        try {
			
			aplicacao.criarFilme(aplicacao.criarCategoria());
			
			System.out.println("Filme Criado com sucesso.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    public Categoria criarCategoria() throws Exception{
    	Categoria categoria = new Categoria();
    	categoria.setDescricao("Terror");
    	
    	new CategoriaDAO().criar(categoria);
    	
    	return categoria;		
    }
    
    public void criarFilme(Categoria categoria) throws Exception {
    	
    	Filme filme = new Filme();
    	FilmeDAO dao = new FilmeDAO();
    	
    	filme.setDescricao("Smurfs");
    	filme.setAno(Calendar.getInstance());
    	filme.setResumo("Todos alegres");
    	filme.setClassificacao(8);
    	
    	Calendar duracao = Calendar.getInstance();
    	
    	duracao.set(Calendar.HOUR, 2);
    	duracao.set(Calendar.MINUTE, 0);
    	filme.setDuracao(duracao);
    	
    	dao.criar(filme);

    	
    }
}
