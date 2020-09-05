public class ArrayNotPossibleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ArrayNotPossibleException() {
		super("Array nulo!");
	}
	
	public ArrayNotPossibleException(String msg) {
		super(msg);
	}	
}
