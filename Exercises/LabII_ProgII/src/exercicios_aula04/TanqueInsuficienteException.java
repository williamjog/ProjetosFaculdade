package exercicios_aula04;

public class TanqueInsuficienteException extends Exception {
	
	private static final long serialVersionUID = 7727323784896687825L; // O que � isso? 

	public TanqueInsuficienteException() {
		super("O capcidade do tanque cheio � insuficiente para o trajeto solicitado!");
	}
	
	public TanqueInsuficienteException(String msg) {
		super(msg);
	}

}
