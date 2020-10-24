package exercicios_aula_20;

public class objectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public objectNotFoundException() {
		super("Object not found in the list!");
	}

}
