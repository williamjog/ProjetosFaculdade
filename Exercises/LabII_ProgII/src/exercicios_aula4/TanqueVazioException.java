package exercicios_aula4;

public class TanqueVazioException extends Exception {
	
	private static final long serialVersionUID = 7727323784896687825L; // O que � isso? 

	public TanqueVazioException() {
		super("Tanque atual n�o tem combust�vel para andar!");
	}
	
	public TanqueVazioException(String msg) {
		super(msg);
	}

}
