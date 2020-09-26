package unisinos;

public class idDoesntExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public idDoesntExistException() {
		super("ID não localizado");
	}

}
