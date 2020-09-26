package unisinos;

public class stockIsFullException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public stockIsFullException() {
		super("Estoque Cheio!!");
	}

}
