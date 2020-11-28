public interface List {
	public int numElements();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void insert(Ingresso element, int pos);
	
	public Ingresso remove(int pos);
	
	public Ingresso get(int pos);
	
	public int search(Ingresso element);
}
