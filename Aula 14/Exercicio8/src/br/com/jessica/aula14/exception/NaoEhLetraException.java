package br.com.jessica.aula14.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NaoEhLetraException extends Exception{
	
	public NaoEhLetraException(String mensagem) {
        super(mensagem);        
    }
}
