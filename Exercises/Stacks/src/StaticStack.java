public class StaticStack<E> implements Stack<E> {
	
	protected int top;
	protected E elements[];

	@SuppressWarnings("unchecked")
	public StaticStack(int maxSize) {
		elements = (E[]) new Object[maxSize];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == elements.length - 1;
	}

	public int numElements() {
		return top + 1;
	}
	
	public void push(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		elements[++top] = element;
	}

	public E pop() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[top];
		elements[top--] = null; // p/ coleta de lixo
		return element;
	}

	public E top() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[top];
	}

	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[";
			for (int i = numElements() - 1; i >= 0; i--) {
				s += "\n" + elements[i];
			}
			s += "\n]";
			return s;
		}
	}
	
	// Exercicio03. Implemente em uma classe qualquer o seguinte método: 
	// Esse método deve percorrer a pilha p e retornar um vetor com os elementos de p sem
	// a ocorrência do elemento number. O conteúdo original da pilha deve ser preservado. 
	public Integer[] itemsExcept(int number, StaticStack<E> p) {
		Integer[] arrayInteger = new Integer[p.numElements() - 1];
		for (int i = 0; i < p.numElements(); i++) {
			if ((Integer) p.elements[i] != number) {
				arrayInteger[i] = (Integer) p.elements[i];
			}
		}
		return arrayInteger;
	}
	
	// Exercício 04 Implemente um método que recebe duas pilhas s1 e s2 e transfere os elementos da
	// primeira para a segunda de modo que os elementos em s2 fiquem na mesma ordem
	// que em s1. Dica: use uma pilha auxiliar.
	public void transferElements(StaticStack<E> s1, StaticStack<E> s2) {
		StaticStack<E> auxStack = new StaticStack<>(s1.numElements());
		for (int i = 0; i < s1.elements.length; i++) {
			auxStack.push(s1.pop());
		}
		for (int i = 0; i < auxStack.elements.length; i++) {
			s2.push(auxStack.pop());
		}		
	}
	
	// Exercicio 05 Esse método deve armazenar todos os elementos de p2 em p1 de maneira que eles
	// fiquem abaixo dos elementos originais de p1, mantendo os dois conjuntos de elementos
	// em sua ordem original. Podem ser utilizados vetores ou pilhas auxiliares. 
	public void prependStack(StaticStack<E> p1, StaticStack<E> p2) {
		StaticStack<E> auxStackp1 = new StaticStack<>(p1.numElements());
		StaticStack<E> auxStackp2 = new StaticStack<>(p2.numElements());
		for (int i = 0; i < p1.elements.length - p2.elements.length; i++) {
			auxStackp1.push(p1.pop());
		}
		for (int i = 0; i < p2.elements.length; i++) {
			auxStackp2.push(p2.pop());
		}
		for (int i = 0; i < p2.elements.length; i++) {
			p1.push(auxStackp2.pop());
		}
		for (int i = 0; i < auxStackp1.elements.length; i++) {
			p1.push(auxStackp1.pop());
		}
	}
	
	// Exercício09
	// Implemente um método que recebe uma pilha como parâmetro e inverte a ordem dos
	// seus elementos. Use somente outras pilhas como estruturas auxiliares. 
	public StaticStack<E> flip(StaticStack<E> p1) {
		StaticStack<E> auxStackP1 = new StaticStack<E>(this.numElements());
		StaticStack<E> auxStackP2 = new StaticStack<E>(this.numElements());
		int numberOfElements = this.numElements();
		for (int i = 0; i < numberOfElements; i++) {
			auxStackP1.push(this.pop());
		}
		for (int i = 0; i < numberOfElements; i++) {
			auxStackP2.push(auxStackP1.pop());
		}
		for (int i = 0; i < numberOfElements; i++) {
			p1.push(auxStackP2.pop());
		}
		return p1;
	}
	
	// Exercicio10
	// Escreva um algoritmo para verificar se um dado elemento está presente em uma pilha.
	// Em caso positivo, o algoritmo deve fornecer também a posição do item na pilha,
	// considerando a base como posição 0. A pilha deve permanecer a mesma após a
	// execução do procedimento. 
	
	public int verifyElement(E element) {
		int position = -1;
		for (int i = 0; i < this.numElements(); i++) {
			if (this.elements[i].toString().equals(element.toString())) {
				position = i;
			}
		}
		return position;
	}
	
	//Exercicio11
	/* Esse método verifica se uma expressão matemática tem os parênteses agrupados de
	forma correta, isto é:
	(1)se o número de parênteses à esquerda e à direita é igual; e
	(2)se todo parêntese aberto é seguido, posteriormente, por um fechamento de
	parêntese.
	Por exemplo, as expressões “((A+B)” e “A+B(” violam a regra (1) e as expressões
	“)A+B(-C” e “(A+B)) – (C+D” violam a regra (2). Um exemplo de expressão correta
	seria: “((A+B)-(C+D))”.
	O método recebe como parâmetro uma pilha que contém os caracteres da expressão
	matemática e retorna verdadeiro, se os parênteses da expressão estão agrupados de forma
	correta, ou falso, caso contrário. Uma pilha armazena apenas uma única expressão. Utilize
	o método equals para a comparação dos objetos. As expressões estão armazenadas na
	pilha da direta para a esquerda, ou seja, os caracteres da direita são empilhados primeiro
	*/
	@SuppressWarnings("unchecked")
	public boolean checkBrackets(StaticStack<Character> s1) {
		int leftParentheses = 0;
		int rightParentheses = 0;
		int length = s1.numElements();
		StaticStack<E> auxStacks1 = new StaticStack<E>(s1.numElements());
		Character[] auxArray = new Character[s1.numElements()];
		if (s1.top() != '(') {
			return false;
		}
		for (int i = 0; i < length; i++) {
			if (s1.top() == '(') {
				leftParentheses++;
			}
			if (s1.top() == ')') {
				rightParentheses++;
			}
			auxStacks1.push((E) s1.pop());			
		}
		if (leftParentheses != rightParentheses) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			auxArray[i] = (Character) auxStacks1.pop();
		}
		int midLeft = 0;
		int midRight = 0;
		double middle = auxArray.length / 2;
		for (int i = 0; i < middle; i++) {
			if (auxArray[i] == '(' || auxArray[i] == ')' ) {
				midLeft++;
			}
		}
		for (int i = auxArray.length - 1; i > middle; i--) {
			if (auxArray[i] == '(' || auxArray[i] == ')') {
				midRight++;
			}
		}
		if (midLeft != midRight) {
			return false;
		}
		return true;	
	}
	
	// Exercicio12
	// Implemente o método contains, definido abaixo, que informa se a pilha contém
	// determinado elemento. 
	public boolean contains(E element) {
		for (int i = 0; i < this.numElements(); i++) {
			if (elements[i].toString().equals(element.toString())) {
				return true;
			}
		}
		return false;
	}
	
	//Exercicio13
	// Implemente um método que inverte a ordem dos elementos da pilha.
	public void flip() {
		StaticStack<E> auxStacks1 = new StaticStack<E>(this.numElements());
		StaticStack<E> auxStacks2 = new StaticStack<E>(this.numElements());
		int length = this.numElements();
		
		for (int i = 0; i < length; i++) {
			auxStacks1.push(this.pop());
		}
		
		for (int i = 0; i < length; i++) {
			auxStacks2.push(auxStacks1.pop());
		}
				
		for (int i = 0; i < length; i++) {
			this.push(auxStacks2.pop());
		}
	}
	
	// Exercicio14
	// Implemente uma sobrecarga do método push que recebe como parâmetro uma pilha,
	// em vez de um elemento. Esse método deve adicionar à pilha corrente os elementos
	// da pilha passada como parâmetro, porém mantendo a ordem original — ou seja, o
	// elemento do topo da pilha passada como parâmetro deve ficar no topo da pilha
	// corrente.	
	public void push(StaticStack<E> s1) {
		int length = s1.numElements();
		StaticStack<E> auxStacks1 = new StaticStack<E>(s1.numElements());
		for (int i = 0; i < length; i++) {
			auxStacks1.push(s1.pop());
		}
		for (int i = 0; i < length; i++) {
			this.push(auxStacks1.pop());
		}
	}
	
	// Exercicio15
	// Implemente um método equals para a pilha. Uma pilha será igual a outra se contiver
	// os mesmos elementos, empilhados na mesma ordem. Para comparar os elementos,
	// use também o método equals. 
	public boolean equals(StaticStack<E> s1) {
		if (s1.top != this.top) {
			return false;
		}
		if (s1.numElements() != this.numElements()) {
			return false;
		}
		for (int i = 0; i < this.numElements(); i++) {
			if (s1.elements[i] != this.elements[i]) {
				return false;
			}
		}
		return true;	
	}
	
	//Exercicio16
	// Implemente um método clone para a pilha. Esse método deve retornar uma nova
	// pilha contendo os mesmos elementos da atual. Os elementos em si não devem ser
	// duplicados. 
	@SuppressWarnings("unchecked")
	public StaticStack<E> clone(StaticStack<E> s1) {
		int length = s1.numElements();
		E[] auxArray = (E[]) new Object[s1.numElements()];
		StaticStack<E> auxStacks1 = new StaticStack<E>(s1.numElements());
		StaticStack<E> auxStacks2 = new StaticStack<E>(s1.numElements());
		StaticStack<E> auxStacks3 = new StaticStack<E>(s1.numElements());
		for (int i = 0; i < length; i++) {
			auxArray[i] = s1.elements[i];
		}
		for (int i = 0; i < length; i++) {
			auxStacks1.push(auxArray[i]);
		}
		for (int i = 0; i < length; i++) {
			auxStacks2.push(auxStacks1.pop());
		}
		for (int i = 0; i < length; i++) {
			auxStacks3.push(auxStacks2.pop());
		}	
		return auxStacks3;
	}
}