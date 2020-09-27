package unisinos;

public class outOfStockException extends Exception {

	private static final long serialVersionUID = 1L;

	public outOfStockException() {
		super("Quantidade superior a quantidade em Estoque! Verifique a quantidade a ser vendida!\n");
	}
}
