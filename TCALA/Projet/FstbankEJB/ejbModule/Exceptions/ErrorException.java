package Exceptions;

public class ErrorException extends Exception {

	public ErrorException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		System.out.print(message);
	}

}
