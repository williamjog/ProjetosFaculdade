public interface Queue<E> {
		/**
		 * Informa se a fila esta vazia.
		 * @return Verdadeiro se a fila estiver vazia, falso caso contrario.
		 */
		public boolean isEmpty();
		
		/**
		 * Informa se a fila esta cheia.
		 * @return Verdadeiro se a fila estiver cheia, falso caso contrario.
		 */
		public boolean isFull();
		
		/**
		 * Informa a quantidade de elementos armazenados na fila.
		 * @return A quantidade de elementos armazenados na fila.
		 */
		public int numElements();

		/**
		 * Insere um novo elemento na fila.
		 * @param element O elemento a ser inserido
		 */
		public void enqueue(E element) throws OverflowException;
		
		/**
		 * Retira um elemento da fila.
		 * @return O elemento retirado
		 */
		public E dequeue() throws UnderflowException;
		
		/**
		 * Informa qual o primeiro elemento da fila.
		 * @return O primeiro elemento da fila
		 */
		public E front() throws UnderflowException;
		
		/**
		 * Informa qual o ultimo elemento da fila.
		 * @return O ultimo elemento da fila
		 */
		public E back() throws UnderflowException;

}
