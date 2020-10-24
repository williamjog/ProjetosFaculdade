package exercicios_aula_20;

public interface List<E> {
	/**
	 * Informa a quantidade de elementos armazenados na lista.
	 * @return A quantidade de elementos armazenados na lista.
	 */
	public int numElements();
	
	/**
	 * Informa se a lista est� vazia.
	 * @return Verdadeiro se a lista estiver vazia,
	 * 			falso caso contrário.
	 */
	public boolean isEmpty();
	
	/**
	 * Informa se a lista est� cheia.
	 * @return Verdadeiro se a lista estiver cheia,
	 * 			falso caso contrário.
	 */
	public boolean isFull();
	
	/**
	 * Insere um novo elemento na posição indicada.
	 * @param element O elemento a ser inserido
	 * @param pos A posi��o onde o elemento ser� inserido
	 * 				(iniciando em 0)
	 */
	public void insert(E element, int pos);
	
	public void insert(List<E> list, int position);
		
	/**
	 * Remove o elemento da posi��o indicada.
	 * @param pos A posição de onde o elemento ser� removido
	 * 				(iniciando em 0)
	 * @return O elemento removido
	 */
	public E remove(int pos);
	
	/**
	 * Retorna o elemento da posição indicada, sem removê-lo.
	 * @param pos A posição do elemento
	 * @return O elemento
	 */
	public E get(int pos);
	
	/**
	 * Localiza a primeira ocorr�ncia do elemento indicado na lista.
	 * @param element O elemento a ser localizado
	 * @return A posição da primeira ocorrência do elemento,
	 * 			ou -1 se ele não for encontrado.
	 */
	public int search(E element);

	public void insertAfter(E obj1, E obj2) throws objectNotFoundException;
	
	public void swap(int pos1, int pos2);
	
	public void flip();
	
	public void dedup();
	
	public boolean equals(List<E> list);
	
	public int remove(int ini, int fim);

	public List<E> clone();
	
	public List<E> split(int pos);
}