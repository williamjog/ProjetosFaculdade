import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ocupacao implements List {

	protected DNode head;
	protected DNode tail;
	protected int numElements;
	
	public Ocupacao() {
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
		return false;
	}
	
	public void insertFirst(Ingresso element) {
		DNode newNode = new DNode(element);
		if (isEmpty()) {			
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		numElements++;
	}
	
	public void insertLast(Ingresso element) {
		DNode newNode = new DNode(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		numElements++;
	}

	public Ingresso removeFirst() {
		if (isEmpty())
			throw new UnderflowException();

		Ingresso element = head.getElement();

		if (head == tail)
			head = tail = null;
		else {
			head = head.getNext();
			head.setPrevious(null);
		}
		numElements--;
		return element;
	}
	
	public Ingresso removeLast() {
		if (isEmpty())
			throw new UnderflowException();

		Ingresso element = tail.getElement();
		
		if (head == tail)
			head = tail = null;
		else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		numElements--;
		return element;
	}
	
	public void insert(Ingresso element, int pos) {
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		
		if (pos == 0) {			
			insertFirst(element);
		} else if (pos == numElements) {			
			insertLast(element);
		} else { 
			DNode prev = head;
			for (int i = 0; i < pos - 1; i++) {				
				prev = prev.getNext();
			}

			DNode newNode = new DNode(element);
			newNode.setPrevious(prev);
			newNode.setNext(prev.getNext());
			prev.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			numElements++;
		}
	}
	
	public Ingresso remove(int pos) {
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) 
			return removeLast();
		else { 
			DNode prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			
			Ingresso element = prev.getNext().getElement();
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);
			numElements--;
			return element;
		}
	}

	public Ingresso get(int pos) {
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		DNode current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		
		return current.getElement();
	}
	
	public int search(Ingresso element) {
		DNode current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
					return i;
			i++;
			current = current.getNext();
		}
		return -1;
	}
		
	public String toString() {
		String s = "";
		DNode current = head;
		while (current != null) {
			s += current.getElement().toString() + "\n\n";
			current = current.getNext();
		}
		return s;
	}
	
	public void lerArquivoDeClientes(String file) {
		try { // Verifica se existe um arquivo chamado clientes.txt, senão lança uma exceção.
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String buffer = in.readLine();
			String[] line = new String[3];
			while (buffer != null && !buffer.equals("")) {
				line = buffer.split(";");
				String nomeDaPessoa = line[0].trim();
				String localizacaoNoEstadio = line[1].trim();
				String tipo = line[2].trim();
				Ingresso ingressoDaFila = new Ingresso(nomeDaPessoa, localizacaoNoEstadio, tipo);
				this.vendeIngresso(ingressoDaFila);
				buffer = in.readLine();
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \\" + file + "\\ nao existe!");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + file);
		}
	}
	
	public void vendeIngresso(Ingresso ingresso) {
		this.insertLast(ingresso);
	}
	
	public StaticQueue filaEntrada() {
		StaticQueue fila = new StaticQueue(this.numElements);
		DNode ingresso = this.head;
		for (int i = 0; i < this.numElements; i++) {
			if (ingresso.getElement().getTipo().equalsIgnoreCase("idoso")) {
				fila.enqueue(ingresso.getElement());
			}
			ingresso = ingresso.getNext();
		}
		ingresso = this.head;
		for (int i = 0; i < this.numElements; i++) {
			if (ingresso.getElement().getTipo().equalsIgnoreCase("normal") || 
				ingresso.getElement().getTipo().equalsIgnoreCase("estudante")) {
				fila.enqueue(ingresso.getElement());
			}
			ingresso = ingresso.getNext();
		}
		return fila;
	}
	
	public void salvarClientes(String filename, int position) {
		DNode ingresso = this.head;
		for (int i = 0; i < position; i++) {
			ingresso = ingresso.getNext();
		}
		if (ingresso == null) {
			return;
		}
		try {
			FileWriter fw = new FileWriter(filename, true);
			while (!ingresso.equals(tail)) {
				fw.write(ingresso.getElement().getNomeDaPessoa() + "; " +
					     ingresso.getElement().getLocalizacaoNoEstadio() + "; " +
						 ingresso.getElement().getTipo() + "\n");
				ingresso = ingresso.getNext();
			}
			fw.write(ingresso.getElement().getNomeDaPessoa() + "; " +
				     ingresso.getElement().getLocalizacaoNoEstadio() + "; " +
					 ingresso.getElement().getTipo() + ";" + "\n");
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}