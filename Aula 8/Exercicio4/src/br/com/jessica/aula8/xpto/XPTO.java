package br.com.jessica.aula8.xpto;

import br.com.jessica.aula8.itens.*;

public class XPTO {
	public String criaItens(){
		Catalogo catalogo = new Catalogo();
		
		catalogo.addItem(new CD("362829H", "Singles", "22/12/2015", "Marron 5", "Pop Rock", "1 - This Love \n2 - Payphone (feat. Wiz Khalifa)"));
		
		catalogo.addItem(new Livro("12365B", "Game of Thrones", "23/03/2014", "George R. R. Martin", "Leya", 2015));
		
		catalogo.addItem(new Revista("198392R", "Bioinformatics", "01/10/2016", "Zhang, M.", 2016, 31, "Artigos Científicos na Área da Bioinformática"));
		
		catalogo.addItem(new DVD("183918K", "???", "09/04/2013", "Jéssica", "??", "----"));
		
		catalogo.addItem( new Livro("12365A", "A Culpa É das Estrelas", "10/11/2015", "John Green", "Intrinseca", 2014));

		return catalogo.imprimeCatalogo();
	}
}
