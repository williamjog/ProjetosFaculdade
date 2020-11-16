
public class SinglyLinkedList<E> implements List<E> {
	
	protected Node<E> head;
	protected Node<E> tail;
	protected int numElements;

	/**
	 * Constroi uma lista inicialmente vazia.
	 */
	public SinglyLinkedList() {
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
		// uma lista com alocacao dinamica nunca estara cheia!
		return false;
	}

	/**
	 * Insere um novo elemento na posicao inicial da lista.
	 * 
	 * @param element O elemento a ser inserido
	 */
	public void insertFirst(E element) {
		// cria um novo no e o torna o novo "head"
		Node<E> newNode = new Node<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head = newNode;
		}

		// ajusta o total de elementos
		numElements++;
	}

	/**
	 * Insere um novo elemento no final da lista.
	 * 
	 * @param element O elemento a ser inserido
	 */
	public void insertLast(E element) {
		// cria um novo no e o torna o novo "tail"
		Node<E> newNode = new Node<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			tail = newNode;
		}

		// ajusta o total de elementos
		numElements++;
	}

	/**
	 * Remove o primeiro elemento da lista.
	 * 
	 * @return O elemento removido
	 */
	public E removeFirst() {
		// verifica se ha pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma referencia tempor�ria ao elemento sendo removido
		E element = head.getElement();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else
			// ...senao, o segundo elemento passa a ser o "head"
			head = head.getNext();

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}

	/**
	 * Remove o ultimo elemento da lista.
	 * 
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
			// ...senao, e necessario percorrer o encadeamento
			// ate chegar ao no imediatamente anterior ao ultimo...
			Node<E> prev = head;
			while (prev.getNext() != tail)
				prev = prev.getNext();

			// ...para poder torn�-lo o novo "tail"
			tail = prev;
			prev.setNext(null);
		}

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}

	public E remove(int pos) {
		// verifica se a posicao e valida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		// casos especiais: remocao do inicio...
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements - 1) // ... ou remocao do final
			return removeLast();
		else { // caso geral: remocao do meio da lista
				// localiza o no imediatamente anterior � posicao
				// de onde o elemento ser� removido
			Node<E> prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();

			// guarda uma ref. temporaria ao elemento sendo removido
			E element = prev.getNext().getElement();

			// ajusta o encadeamento "pulando" o no sendo removido
			prev.setNext(prev.getNext().getNext());

			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	}

	public E get(int pos) {
		// verifica se a posicao e valida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		// percorre o encadeamento ate chegar ao elemento
		Node<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();

		return current.getElement();
	}

	public int search(E element) {
		// percorre o encadeamento ate encontrar o elemento
		Node<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}

		// se chegar ate aqui, e porque n�o encontrou
		return -1;
	}

	public String toString() {
		String s = "";

		Node<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " ";
			current = current.getNext();
		}
		return s;
	}
	
	public void insert(E element, int pos) {
		// verifica se a posicao e valida
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();

		// casos especiais: insercao no inicio...
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements) // ... ou insercao no final
			insertLast(element);
		else { // caso geral: insercao no meio da lista
				// localiza o no imediatamente anterior a posicao
				// onde o novo sera inserido
			Node<E> prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();

			// cria um novo n� e o posiciona logo apos "prev",
			// ajustando os apontamentos e o total de elementos
			Node<E> newNode = new Node<E>(element);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
	}
	
//Letra c)  Crie um método chamado addAfter(Element e, int pos), que insere o nodo n
//			depois do nodo de número pos (considerando que o primeiro nodo é o nodo na
//			posição 0).
	
	public void addAfter(E element, int pos) {
		if (pos < 0 || pos > numElements) {
			throw new IndexOutOfBoundsException(); 
		}
		if (pos == numElements) {
			insertLast(element);
		} else {
			Node<E> prev = head;
			Node<E> newNode = new Node<E>(element);
			for (int i = 0; i < pos; i++) {
				prev = prev.getNext();
			}
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
	
	}
	
//Letra d)	Crie um método chamado addBefore(Element e, int pos), que insere o nodo
//			n antes do nodo de número pos (considerando que o primeiro nodo é o nodo na
//			posição 0).
	
	public void addBefore(E element, int pos) {
		if (pos == 0 || pos > numElements) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == 1) {
			insertFirst(element);
		} else {
			Node<E> prev = head;
			Node<E> newNode = new Node<E>(element);
			for (int i = 0; i < pos - 1; i++) {
				prev = prev.getNext();
			}
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
	}
}