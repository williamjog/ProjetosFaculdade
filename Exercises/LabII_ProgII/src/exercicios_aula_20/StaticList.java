package exercicios_aula_20;

/**
 * Implementação de uma lista linear com armazenamento estático, baseado em
 * array.
 */
public class StaticList<E> implements List<E> {
	protected E[] elements;
	int numElements;

	/**
	 * Constrói uma lista com um tamanho maximo.
	 * 
	 * @param maxSize O tamanho máximo da lista
	 */
	
	@SuppressWarnings("unchecked")
	public StaticList(int maxSize) {
		elements = (E[]) new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public void insert(E element, int pos) {
		// verifica se há espaco na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posição é válida
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();

		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo
		for (int i = numElements - 1; i >= pos; i--)
			elements[i + 1] = elements[i];

		// armazena o novo elemento e ajusta o total
		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) {
		// verifica se a posição é válida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		// guarda uma referência temporária ao elemento removido
		E element = elements[pos];

		// desloca para a esquerda os elementos necessários,
		// sobrescrevendo a posiçao do que est� sendo removido
		for (int i = pos; i < numElements - 1; i++)
			elements[i] = elements[i + 1];

		// define para null a posição antes ocupada pelo ultimo,
		// para que a coleta de lixo possa atuar, e ajusta o total
		elements[numElements - 1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) {
		// verifica se a posiçao e valida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;

		// se chegar ate aqui, e porque nao encontrou
		return -1;
	}

	/**
	 * Retorna uma representacao String da lista.
	 * 
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}

	// Implemente um método que remove da lista um elemento passado como parâmetro.
	// Esse método retorna true quando o elemento é achado e removido, false caso
	// contrário. Será removida apenas a primeira ocorrência do elemento.
	public boolean remove(E element) {
		boolean removed = false;
		for (int i = 0; i < this.numElements; i++) {
			if (this.elements[i] == element) {
				removed = true;
				if (i == this.numElements - 1) {
					numElements--;
					break;
				}
				for (int j = i; j < this.numElements - 1; j++) {
					this.elements[j] = this.elements[j + 1];
				}
				numElements--;
			}
		}
		return removed;
	}

	// Implemente um método insertAfter, abaixo, que insere o elemento obj2 uma
	// posição  após o elemento obj1. Considere a primeira ocorrência de obj1.
	// Se obj1 não for encontrado, gere uma exceção apropriada.
	public void insertAfter(E obj1, E obj2) throws objectNotFoundException {
		boolean numberExists = false;
		for (int i = 0; i < this.numElements; i++) {
			if (this.elements[i].toString().equals(obj1.toString())) {
				numberExists = true;
				this.insert(obj2, i + 1);
			}
		}
		if (!numberExists) {
			throw new objectNotFoundException();
		}
	}

//	 Implemente um método que troca de lugar os objetos localizados nas posições passadas como parâmetro. 
//	 Se alguma das posições for inválida, deve ser gerada a exceção do Java IndexOutOfBoundsException.
	public void swap(int pos1, int pos2) {
		if (pos1 < 0 || pos1 > this.numElements || pos2 < 0 || pos2 > this.numElements) {
			throw new IndexOutOfBoundsException();
		} else {
			E aux = this.elements[pos1];
			this.elements[pos1] = this.elements[pos2];
			this.elements[pos2] = aux;
		}
	}

	// Implemente um método que inverte a ordem dos elementos da lista.
	public void flip() {
		int upper = this.numElements - 1;
		for (int lower = 0; lower < this.numElements; lower++) {
			if (lower > this.numElements / 2) {
				break;
			} else {
				E aux = this.elements[lower];
				this.elements[lower] = this.elements[upper];
				this.elements[upper] = aux;
				upper--;
			}
		}
	}

//	 Implemente uma sobrecarga do método insert que recebe como parâmetro uma lista, em vez de um elemento. 
//	 Esse método deve adicionar à lista corrente os elementos daquela passada como parâmetro, a partir da posição indicada.
	@SuppressWarnings("unchecked")
	public void insert(List<E> list, int position) {
		E[] aux = (E[]) new Object[elements.length + list.numElements()];
		for (int i = 0; i < aux.length; i++) {
			if (i < position) {
				aux[i] = this.elements[i];
			} else if (i < list.numElements() + position) {
				aux[i] = list.get(i - position);
			} else {
				aux[i] = this.elements[i - list.numElements()];
			}
		}
		this.elements = aux;
		this.numElements += list.numElements();
	}

//	 	Implemente um método que remove ocorrências múltiplas de elementos na lista. Para cada elemento contido na lista,
//	 	somente a primeira ocorrência deve ser mantida.
	@SuppressWarnings("unchecked")
	public void dedup() {
		int position = 0;
		boolean found = false;
		E[] aux = (E[]) new Object[this.numElements];
		for (int i = 0; i < this.numElements; i++) {
			found = false;
			for (int j = 0; j < position; j++) {
				if (this.elements[i].toString().equals(aux[j].toString())) {
					found = true;
					break;
				}
			}
			if (!found) {
				aux[position] = this.elements[i];
				found = false;
				position++;
			}
		}
		this.elements = aux;
		this.numElements = position;
	}

//	 	Implemente um método equals para a lista. Uma lista será igual a outra se contiver os mesmos elementos, dispostos na mesma ordem. 
//	 	Para comparar os elementos, use também o método equals. Pesquise como desenvolver o método equals de um objeto no Java.
	public boolean equals(List<E> list) {
		if (list.numElements() != this.numElements) {
			return false;
		} else {
			int i = 0;
			while (this.elements[i].toString().equals(list.get(i).toString())) {
				i++;
				if (i == this.numElements) {
					return true;
				}
			}
			return false;
		}
	}

//	 	Implemente um método clone para a lista. Esse método deve retornar uma nova lista contendo os mesmos elementos da atual. 
//	 	Os elementos em si não devem ser duplicados.	 	
	public List<E> clone() {
		List<E> newList = new StaticList<>(this.numElements);
		for (int i = 0; i < this.numElements; i++) {
			newList.insert(this.elements[i], i);
		}
		return newList;
	}

//	 	Implemente um método que remove da lista os elementos compreendidos entre as posições ini e fim (inclusive). 
//	 	Ele deve retornar a quantidade de elementos removidos.
	@SuppressWarnings("unchecked")
	public int remove(int ini, int fim) {
		int numElements = 0;
		E[] newList = (E[]) new Object[this.numElements - (fim - ini) - 1];
		for (int i = 0; i < newList.length; i++) {
			if (i < ini) {
				newList[i] = this.elements[i];
				numElements++;
			} else {
				newList[i] = this.elements[i + 1 + (fim - ini)];
				numElements++;
			}
		}
		this.elements = newList;
		this.numElements = numElements;
		return fim - ini + 1;
	}

//	 	Implemente um método split que divide a lista em duas partes. A lista corrente deve ficar somente com os elementos da início 
//	 	até uma posição antes da indicada, e o método deve retornar uma nova lista contendo os elementos da posição indicada até o final.
	public List<E> split(int pos) {
		List<E> newList = new StaticList<>(this.numElements - pos + 1);
		for (int i = pos; i < this.numElements; i++) {
			newList.insert(this.elements[i], i - pos);
		}
		this.numElements = pos;
		return newList;
	}
}
	 	