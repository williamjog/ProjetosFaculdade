package unisinos;

public class idAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public idAlreadyExistsException() {
		super("ID já cadastrado!!");
	}
}
