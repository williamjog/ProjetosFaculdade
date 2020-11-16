public class StaticQueue<E> implements Queue<E> {

	protected int first;
	protected int last;
	protected E elements[];

	@SuppressWarnings("unchecked")
	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}

	public boolean isEmpty() {
		return first == -1;
	}

	public boolean isFull() {
		return first == ((last + 1) % elements.length);
	}

	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length; // p/ legibilidade da expressao abaixo
			return ((n + last - first) % n) + 1;
		}
	}

	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}

	}

	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}

	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[" + elements[first];
			int n = numElements();
			for (int i = 1; i < n; i++) {
				int k = (first + i) % elements.length;
				s += ", " + elements[k];
			}
			s += "]";
			return s;
		}
	}
		
	//Exercicio 2
	public StaticQueue<E> prependQueue(StaticQueue<E> q1, StaticQueue<E> q2) {
			int q2length = q2.numElements();
			int q1length = q1.numElements();
			StaticQueue<E> aux = new StaticQueue<E>(q1.numElements() + q2.numElements());
			for (int i = 0; i < q2length; i++) {
				aux.enqueue(q2.dequeue());
			}
			for (int i = 0; i < q1length; i++) {
				aux.enqueue(q1.dequeue());
			}
			return aux;
			
	}
	
	//Exercicio 3
	public StaticQueue<E> exterminateFromQueue(StaticQueue<E> q, E element) {
		int length = q.numElements();
		StaticQueue<E> aux = new StaticQueue<E>(length);
		StaticQueue<E> aux2 = new StaticQueue<E>(length - 1);
		for (int i = 0; i < length; i++) {
			aux.enqueue(q.dequeue());	
		}
		for (int i = 0; i < length; i++) {
			if (aux.elements[i].toString().equals(element.toString())) {
				aux2.enqueue(aux.dequeue());
			} else {
				q.enqueue(aux.dequeue());
			}
		}
		return q;
	}
	
	//Exercicio 4
	public boolean contains(E element) {
		for (int i = 0; i < this.numElements(); i++) {
			if (this.elements[i].toString().equals(element.toString())) {
				return true;
			}
		}
		return false;
	}
	
	//Exercicio 5
	@SuppressWarnings("unchecked")
	public void flip() {
		int length = this.numElements();
		E[] arrayThatWillFlip = (E[]) new Object[this.numElements()];
		for (int i = 0; i < length; i++) {
			arrayThatWillFlip[i] = this.dequeue();
		}
		for (int i = length - 1; i >= 0; i--) {
			this.enqueue(arrayThatWillFlip[i]);
		}
	}
		
	//Exercicio 6
		public void enqueue(StaticQueue<E> queue) {
			int length = queue.numElements();
			for (int i = 0; i < length; i++) {
				this.enqueue(queue.dequeue());	
			}
		}
		
	//Exercicio 7
		@SuppressWarnings("unchecked")
		public void enqueueWithPriority(E element) {
			E[] auxArray = (E[]) new Object[this.numElements()];
			for (int i = 0; i < auxArray.length; i++) {
				auxArray[i] = this.dequeue();
			}
			this.enqueue(element);
			for (int i = 0; i < auxArray.length; i++) {
				this.enqueue(auxArray[i]);
			}
		}
		
	//Exercicio 8
		public boolean equals(StaticQueue<E> queue) {
			if (this.numElements() != queue.numElements()) return false;
			if (this.front() != queue.front()) return false;
			if (this.back() != queue.back()) return false;
			int length = this.numElements();
			for (int i = 0; i < length; i++) {
				if (!this.elements[i].toString().equals(queue.elements[i].toString())) {
					return false;
				}
			}
			return true;		
		}
		
	//Exercicio 9
		public StaticQueue<E> clone() {
			StaticQueue<E> clonedQueue = new StaticQueue<E>(this.numElements());
			clonedQueue = this;
			return clonedQueue;
		}
		
	//Exercicio 11
		@SuppressWarnings("unchecked")
		public StaticQueue<E> split(E element) {
			int position = 0;
			int length = this.numElements();
			for (int i = 0; i < length; i++) {
				if (this.elements[i].toString().equals(element.toString())) {
					position = i;
					break;
				}
			}
			StaticQueue<E> newQueue = new StaticQueue<E>(length - (position + 1));
			E[] auxArray = (E[]) new Object[position + 1];
			for (int i = 0; i < length; i++) {
				if (i <= position) {
					auxArray[i] = this.dequeue();
				} else {
					break;
				}
			}
			for (int j = 0; j < newQueue.elements.length; j++) {
				newQueue.enqueue(this.dequeue());
			}
			for (int i = 0; i < auxArray.length; i++) {
				this.enqueue(auxArray[i]);
				auxArray[i] = null;
			}
			return newQueue;
	   }
		
	//Exercicio 12
		@SuppressWarnings("unchecked")
		public void moveToBackAllOccurrencesOf(E element) {
			int elementCounter = 0;
			int length = this.numElements();
			E[] auxArray = (E[]) new Object[length];
			for (int i = 0; i < length; i++) {
				auxArray[i] = this.dequeue();
				elementCounter++;
			}
			for (int i = 0; i < length; i++) {
				if (!auxArray[i].toString().equals(element.toString())) {
					this.enqueue(auxArray[i]);
					auxArray[i] = null;
				}
			}
			for (int i = 0; i < elementCounter; i++) {
				if (auxArray[i] != null) {
					this.enqueue(auxArray[i]);
				}
			}
		}
		
	//Exercicio 13
		@SuppressWarnings("unchecked")
		public void ensureCapacity(int capacity) {
			if (capacity <= this.elements.length) return;
			E[] auxArray = (E[]) new Object[this.numElements()];
			for (int i = 0; i < auxArray.length; i++) {
				auxArray[i] = this.dequeue();
			}
			this.elements = (E[]) new Object[capacity];
			for (int i = 0; i < auxArray.length; i++) {
				this.enqueue(auxArray[i]);
				auxArray[i] = null;
			}
		}
		
		public int size() {
			return this.elements.length;
		}
  }