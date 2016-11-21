package br.com.jessica.aula14.stringsexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComparacaoStringException extends Exception{
	
	public ComparacaoStringException(String mensagem) {
        super(mensagem);        
    }
}
