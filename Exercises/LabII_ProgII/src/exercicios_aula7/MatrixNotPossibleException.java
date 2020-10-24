package exercicios_aula7;

public class MatrixNotPossibleException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MatrixNotPossibleException() {
		super("Esta matriz não possui diagonal!!");
	}
	
	public MatrixNotPossibleException(String msg) {
		super(msg);
	}

}
