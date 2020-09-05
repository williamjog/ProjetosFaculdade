package exercicios_aula04;

public class TanqueCheioException extends Exception {

	private static final long serialVersionUID = 7727323784896687825L; // O que é isso? 

	public TanqueCheioException() {
		super("Tanque Cheio!");
	}
	
	public TanqueCheioException(String msg) {
		super(msg);
	}
	
}
