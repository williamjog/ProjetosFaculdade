package exercicios_aula4;

public class TanqueVazioException extends Exception {
	
	private static final long serialVersionUID = 7727323784896687825L; // O que é isso? 

	public TanqueVazioException() {
		super("Tanque atual não tem combustível para andar!");
	}
	
	public TanqueVazioException(String msg) {
		super(msg);
	}

}
