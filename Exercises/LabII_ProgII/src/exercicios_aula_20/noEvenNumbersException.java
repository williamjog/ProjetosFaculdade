package exercicios_aula_20;

public class noEvenNumbersException extends Exception {

	private static final long serialVersionUID = 1L;

	public noEvenNumbersException() {
		super("There are no even numbers in this list!");
	}

}
