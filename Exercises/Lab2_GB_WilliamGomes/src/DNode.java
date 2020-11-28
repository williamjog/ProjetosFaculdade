public class DNode {
	
	protected Ingresso element;
	protected DNode prev;
	protected DNode next;

	public DNode(Ingresso e) {
		element = e;
		prev = next = null;
	}

	public Ingresso getElement() {
		return element; 
	}

	public DNode getPrevious() { 
		return prev;
	}

	public DNode getNext() { 
		return next;
	}

	public void setElement(Ingresso e) { 
		element = e; 
	}

	public void setPrevious(DNode p) {
		prev = p; 
	}

	public void setNext(DNode n) {
		next = n; 
	}
}

