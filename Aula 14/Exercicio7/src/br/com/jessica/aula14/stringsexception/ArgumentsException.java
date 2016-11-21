package br.com.jessica.aula14.stringsexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArgumentsException extends Exception{
	
	public ArgumentsException(String mensagem) {
        super(mensagem);        
    }
}
