import java.io.*;

public class Schedule<E> implements List<E> {

	protected DNode<E> head;
	protected DNode<E> tail;
	protected int numElements;
	
	public Schedule() {
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
	
	public void insertFirst(E element) {
		DNode<E> newNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		numElements++;
	}
	
	public void insertLast(E element) {
		DNode<E> newNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		numElements++;
	}

	public E removeFirst() {
		if (isEmpty())
			throw new UnderflowException();

		E element = head.getElement();

		if (head == tail)
			head = tail = null;
		else {
			head = head.getNext();
			head.setPrevious(null);
		}
		numElements--;
		return element;
	}
	
	public E removeLast() {
		if (isEmpty())
			throw new UnderflowException();

		E element = tail.getElement();
		
		if (head == tail)
			head = tail = null;
		else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		numElements--;
		return element;
	}
	
	public void insert(E element, int pos) {
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements)
			insertLast(element);
		else { 
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();

			DNode<E> newNode = new DNode<E>(element);
			newNode.setPrevious(prev);
			newNode.setNext(prev.getNext());
			prev.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			numElements++;
		}
	}
	
	public E remove(int pos) {
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) 
			return removeLast();
		else { 
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			
			E element = prev.getNext().getElement();
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);
			numElements--;
			return element;
		}
	}

	public E get(int pos) {
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		
		return current.getElement();
	}
	
	public int search(E element) {
		DNode<E> current = head;
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
		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString();
			current = current.getNext();
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public void getCommitments(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			
			String[] line = new String[3];
			String buffer = in.readLine();
			int i = 0;
			while (buffer != null && !buffer.equals("")) {
		
				line = buffer.split("\\*");
				String name = line[0].trim();
				String hour = line[1].trim();
				String location = line[2].trim();
				Commitment commitment = new Commitment(name, hour, location);
				this.insert((E) commitment, i);
				i++;
				buffer = in.readLine();
			}
			
			fr.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + file + "\" does not exist.");
		} catch (IOException e) {
			System.out.println("Reading error in " + file + ".");
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void addCommitment(Commitment commitment, String fileName) {
			
			this.insert((E) commitment, numElements);
						
			try {
				FileWriter fw = new FileWriter(fileName, true);
				fw.write(commitment.writeCommitment());
				fw.close();
				System.out.println("\nCommitment created!\n");
			} catch (FileNotFoundException e) {
				System.out.println("File \"" + fileName + "\" does not exist.");
			} catch (IOException e) {
				System.out.println("Reading error in file " + fileName + ".");
			}
	}
	
	public void removeCommitment(String name, String file) {
		int pos = -1;
		for (int i = 0; i < numElements; i++) {
			if (((Commitment) this.get(i)).getName().equals(name)) {
				pos = i;
				break;
			}
		}
		if (pos >= 0) {
			if (numElements > 1) {
				Commitment removedCommitment = (Commitment) this.remove(pos);
				for (int j = 0; j < numElements; j++) {
					if (!((Commitment) this.get(j)).getName().equals(removedCommitment.getName())) {
						try {
							FileWriter fw = new FileWriter(file, false);
							fw.write(((Commitment) this.get(j)).writeCommitment());
							fw.close();
						} catch (FileNotFoundException e) {
							System.out.println("File \"" + file + "\" does not exist.");
						} catch (IOException e) {
							System.out.println("Reading error in file " + file + ".");
						}
					}
				}
				System.out.println("\nCommitment deleted!\n");
			} else {
				try {
					this.remove(pos);
					FileWriter fw = new FileWriter(file, false);
					fw.write("");
					fw.close();
					System.out.println("\nCommitment deleted!\n");
				} catch (FileNotFoundException e) {
					System.out.println("File \"" + file + "\" does not exist.");
				} catch (IOException e) {
					System.out.println("Reading error in file " + file + ".");
				}
			}
		} else {
			System.out.println("Commitment not found!\n");
		}
	}
	
	public void updateCommitmentInfo(String name, int field, String newInfo, String file) {
		if (!this.isEmpty()) {
			if (searchCommitment(name)) {
				try {			
					FileWriter fw = new FileWriter(file, false);
					for (int i = 0; i < numElements; i++) {
						if (((Commitment) this.get(i)).getName().equals(name)) {
							switch (field) {
							case 1:
								((Commitment) this.get(i)).setName(newInfo);
								fw.write(((Commitment) this.get(i)).writeCommitment());
								break;
							case 2:
								((Commitment) this.get(i)).setHour(newInfo);
								fw.write(((Commitment) this.get(i)).writeCommitment());
								break;
							case 3:
								((Commitment) this.get(i)).setLocation(newInfo);
								fw.write(((Commitment) this.get(i)).writeCommitment());
								break;
							default:
								break;
							}
						} else {
							fw.write(((Commitment) this.get(i)).writeCommitment());
						}
					}
					System.out.println("\nInfo Updated!\n");
					fw.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			} else {
				System.out.println("Commitment not found!");
			}
		} else {
			System.out.println("\nEmpty agenda!\n");
		}
	}
	
	public boolean searchCommitment(String name) {
		boolean hasCommitment = false;
		for (int i = 0; i < numElements; i++) {
			if (((Commitment) this.get(i)).getName().equals(name)) {
				hasCommitment = true;
			}
		}
		return hasCommitment;
	}
}
