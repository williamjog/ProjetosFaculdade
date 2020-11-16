
public class StaticDeque<E> extends StaticQueue<E> {

	public StaticDeque(int maxSize) {
		super(maxSize);
	}

	public void insert(E element, boolean inFront) throws OverflowException { // inFront = primeiro
		if (isFull()) {
			throw new OverflowException();
		} else {
			if (isEmpty()) {
				this.elements[0] = element;
				first = last = 0;
			} else if (inFront) {
				last = (last + 1) % this.elements.length;
				for (int i = last; i > last - this.numElements(); i--) { // 1 > 1 - 2 + 1 = 0; 
					int position1 = i;
					int position2 = (i - 1);
					if (position1 < 0) {
						position1 = position1 + this.elements.length;
						position2 = position2 + this.elements.length;
					} else if (position2 < 0) {
						position2 = position2 + this.elements.length;
					}
					this.elements[position1] = this.elements[position2];
					// this.elements[1] = this.elements[0]
				}
				this.elements[first] = element;
				//first continua 0; = elemento
			} else {
				this.enqueue(element);
			}
		}
	}
	
	public void remove(boolean inBack) throws UnderflowException { // inBack = ultimo
		if (isEmpty()) throw new UnderflowException();
		if (first == last) {
			first = last = -1;
			return;
		}
		if (inBack) {
			last = (last - 1) % this.elements.length;
		} else {
			this.dequeue();
		}
	}
	
	public int search(E element) {
		int i = first - 1;
		int position = 0;
		do {
			i = (i + 1) % this.elements.length;
			if (this.elements[i].toString().equals(element.toString())) {
				return position;
			}
			position++;
		} while (i != last); 
		return -1;
	}
	
	public void printFirst() {
		if (first != -1) {
			System.out.println(this.elements[first]);
		} else {
			System.out.println("[Empty]");
		}
	}
	
	public void printLast() {
		if (last != -1) {
			System.out.println(this.elements[last]);
		} else {
			System.out.println("[Empty]");
		}
	}
}