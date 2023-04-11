package model.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;//declara o valor de versão da classe
	
	public DomainException(String msg) {
		super(msg);
	}
	
}
