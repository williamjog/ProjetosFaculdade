
public class DoublyLinkedList<E> implements List<E> {
	DNode<E> head;
	DNode<E> tail;
	int numElements;

	/**
	 * Constroi uma lista inicialmente vazia.
	 */
	public DoublyLinkedList() {
		head = tail = null;
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		// uma lista com aloca��o din�mica nunca estar� cheia!
		return false;
	}
	
	/**
	 * Insere um novo elemento na posicao inicial da lista.
	 * @param element O elemento a ser inserido
	 */
	public void insertFirst(E element) {
		// cria um novo n� e o torna o novo "head"
		DNode<E> newNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}

		// ajusta o total de elementos
		numElements++;
	}
		
	/**
	 * Insere um novo elemento no final da lista.
	 * @param element O elemento a ser inserido
	 */
	public void insertLast(E element) {
		// cria um novo n� e o torna o novo "tail"
		DNode<E> newNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		// ajusta o total de elementos
		numElements++;
	}

	public E removeFirst() {
		// verifica se ha pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma refer�ncia tempor�ria ao elemento sendo removido
		E element = head.getElement();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// ...senao, o segundo elemento passa a ser o "head"
			head = head.getNext();
			head.setPrevious(null);
		}

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}
	
	/**
	 * Remove o �ltimo elemento da lista.
	 * @return O elemento removido
	 */
	public E removeLast() {
		// verifica se ha pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma refer�ncia tempor�ria ao elemento sendo removido
		E element = tail.getElement();
		
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// ...sen�o, o pen�ltimo elemento passa a ser o "tail"
			tail = tail.getPrevious();
			tail.setNext(null);
		}

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}
	
	public void insert(E element, int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		
		// casos especiais: inser��o no in�cio...
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements) // ... ou inser��o no final
			insertLast(element);
		else { // caso geral: inser��o no meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// onde o novo ser� inserido
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newNode = new DNode<E>(element);
			newNode.setPrevious(prev);
			newNode.setNext(prev.getNext());
			prev.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			numElements++;
		}
	}
	
	public E remove(int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		// casos especiais: remo��o do in�cio...
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) // ... ou remo��o do final
			return removeLast();
		else { // caso geral: remo��o do meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// de onde o elemento ser� removido
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			
			// guarda uma ref. tempor�ria ao elemento sendo removido
			E element = prev.getNext().getElement();

			// ajusta o encadeamento "pulando" o n� sendo removido
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);

			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	}

	public E get(int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		// percorre o encadeamento at� chegar ao elemento
		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		
		return current.getElement();
	}
	
	public int search(E element) {
		// percorre o encadeamento at� encontrar o elemento
		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
					return i;
			i++;
			current = current.getNext();
		}
		
		// se chegar ate aqui, e porque nao encontrou
		return -1;
	}
		
	/**
	 * Retorna uma representacao String da lista.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";

		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " ";
			current = current.getNext();
		}
		return s;
	}
	
	// Exercicio 3 Implementar um método que busca um elemento na lista e retorna
	// sua posição e valor
	@SuppressWarnings("unchecked")
	public E[] searchElement(E element) throws ElementNotFoundException {
		E positionAndValue[] = (E[]) new Object[2];
		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (current.getElement().toString().equals(element.toString())) {
				positionAndValue[0] = (E) (Object) i;
				positionAndValue[1] = current.getElement();
				return positionAndValue;
			}
			current = current.getNext();
			i++;
		}
		throw new ElementNotFoundException();
	}
	
	
	// Exercicio 4 Implementar um método que insere um novo elemento em uma
	// posição passada por parâmetro
	public void insertOptimized(E element, int pos) {
		if (pos < 0  ||  pos > numElements) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == numElements - 1) {
			this.insertLast(element);
			return;
		}
		if (pos < 1) {
			this.insertFirst(element);
			return;
		}
		int middle = numElements / 2;
		if (pos < middle) {
			DNode<E> prev = head;
			for (int i = 0; i < pos - 1; i++) {
				prev = prev.getNext();
			}
			DNode<E> newValue = new DNode<E>(element);
			newValue.setPrevious(prev);
			newValue.setNext(prev.getNext());
			newValue.getPrevious().setNext(newValue);
			newValue.getNext().setPrevious(newValue);
			numElements++;
		} else {
			DNode<E> prev = tail;
			for (int i = numElements; i > pos + 1; i--) {
				prev = prev.getPrevious();
			}
			DNode<E> newValue = new DNode<E>(element);
			newValue.setNext(prev);
			newValue.setPrevious(prev.getPrevious());
			newValue.getPrevious().setNext(newValue);
			newValue.getNext().setPrevious(newValue);
			numElements++;
		}
	}
	
	
	// Exercicio 5 Implementar um métodos que remove o elemento contido na
	// posição passada por parâmetro
	public void removeOptimized(int pos) {
		if (pos < 0 || pos >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == numElements - 1) {
			this.removeLast();
			return;
		}
		if (pos < 1) {
			this.removeFirst();
			return;
		}
		int middle = numElements / 2;
		if (pos < middle) {
			DNode<E> prev = head;
			for (int i = 0; i < pos - 1; i++) {
				prev = prev.getNext();
			}
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);
		} else {
			DNode<E> prev = tail;
			for (int i = numElements; i > pos - 1; i--) {
				prev = prev.getNext();
			}
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);
		}
	}
}