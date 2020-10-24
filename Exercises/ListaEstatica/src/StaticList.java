
public class StaticList<E> implements List<E> {

	private E[] elements;
	private int numElements;
	
	@SuppressWarnings("unchecked")
	public StaticList(){
		this.numElements = 0;
		this.elements = (E[]) new Object[20];
	}
	
	public int numElements() {
		return numElements;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	public boolean isFull(){
		return numElements == elements.length;
	}
	
	public void insert(E element, int pos) throws IndexOutOfBoundsException {
		if(pos < 0 || pos > numElements) throw new IndexOutOfBoundsException();
		if (isFull()) {
			//aumenta o array elements
			@SuppressWarnings("unchecked")
			E[] aux = (E[]) new Object[elements.length*2];
			for(int i=0; i<elements.length; i++)
				aux[i] = elements[i];
			elements = aux;
		}
		for(int i = numElements - 1; i >= pos; i--)
			elements[i+1] = elements[i];
		
		elements[pos] = element;
		
		numElements++;
	}
	
	public E remove(int pos){
		return null;
	}
	
	public E get(int pos) throws IndexOutOfBoundsException{
		if (pos < 0 || pos >= numElements) throw new IndexOutOfBoundsException();
		return elements[pos];
	}
	
	public int search(E element){
		for(int i=0; i<numElements; i++)
			if(elements[i].equals(element))
				return i;
		return -1;
	}
	
	public void merge(List<E> l) {
		for (int i = 0; i < l.numElements(); i++) {
			this.insert(l.get(i), this.numElements);
		}
	}
	
	public List<E> subList(int i, int j) {
		List<E> aux = new StaticList<>();
		for (int position = i; position <= j; position ++) {
			aux.insert(this.elements[position], position - i);
		}
		return aux;
	}
	
	
	public static void main(String[] args) {
		StaticList<Integer> lista = new StaticList<Integer>();
		lista.insert(1, 0);
		lista.insert(2, 1);
		lista.insert(3, 2);
		lista.insert(4, 3);
		lista.insert(5, 4);
		for(int i = 0; i < lista.numElements(); i++)
			System.out.println(lista.get(i));
		
		StaticList<Integer> newList = new StaticList<Integer>();
		newList.insert(6, 0);
		newList.insert(7, 1);
		newList.insert(8, 2);
		newList.insert(9, 3);
		newList.insert(10, 4);
		lista.merge(newList);
		System.out.println("-------------");
		for(int i = 0; i < lista.numElements(); i++)
			System.out.println(lista.get(i));
		
		StaticList<Integer> newList2 = new StaticList<Integer>();
		newList2 = (StaticList<Integer>) lista.subList(3, 6);
		System.out.println("-------------");
		for(int i = 0; i< newList2.numElements(); i++)
			System.out.println(newList2.get(i));
	}
}
