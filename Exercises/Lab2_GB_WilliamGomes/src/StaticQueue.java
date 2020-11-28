import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class StaticQueue implements Queue {

	protected int first;
	protected int last;
	protected Ingresso elements[];

	public StaticQueue(int maxSize) {
		elements = new Ingresso[maxSize];
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
			int n = elements.length;
			return ((n + last - first) % n) + 1;
		}
	}

	public void enqueue(Ingresso element) throws OverflowException {
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

	public Ingresso dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		Ingresso element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	public Ingresso front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	public Ingresso back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}
	
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = elements[first].toString();
			int n = numElements();
			for (int i = 1; i < n; i++) {
				s += "\n" + i + "º da fila";
				int k = (first + i) % elements.length;
				s += "\n\n" + elements[k];
			}
			s += "\n" + numElements() + "º da fila";
			return s;
		}
	}
	
	public void salvaFila() {
		try {
			FileWriter fw = new FileWriter("fila.txt", false);
			for (int i = 0; i < this.numElements(); i++) {
				fw.write(elements[i].getNomeDaPessoa() + " " + elements[i].getLocalizacaoNoEstadio() + " " + elements[i].getTipo() + "\n");
			}
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + "fila.txt" + "\" does not exist.");
		} catch (IOException e) {
			System.out.println("Reading error in file " + "fila.txt" + ".");
		}
	}
}