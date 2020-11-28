public interface Queue {

		public boolean isEmpty();
		
		public boolean isFull();
		
		public int numElements();
		
		public void enqueue(Ingresso element) throws OverflowException;
		
		public Ingresso dequeue() throws UnderflowException;
		
		public Ingresso front() throws UnderflowException;
		
		public Ingresso back() throws UnderflowException;

}