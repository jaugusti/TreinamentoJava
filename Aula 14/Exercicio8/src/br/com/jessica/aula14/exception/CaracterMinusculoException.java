package br.com.jessica.aula14.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaracterMinusculoException extends Exception{
	
	public CaracterMinusculoException(String mensagem) {
        super(mensagem);        
    }
}
