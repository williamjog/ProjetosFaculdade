
public class Teste {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> S = new DoublyLinkedList<Integer>();

		S.insertFirst(0);
		
		S.insertLast(3);
		
		S.insert(3, 2);
		
		S.removeFirst();
		
		S.removeLast();
		
		S.insertFirst(0);
		
		S.insertLast(3);
		
		S.insertLast(4);
		
		S.remove(3);
		
		System.out.println(S.get(2));
		
		System.out.println(S.search(2));
		
		S.insert(1, 1);
		
		S.remove(3);
		
		System.out.println(S);
		
		// Exercicio 3 Implementar um m�todo que busca um elemento na lista e retorna
		// sua posi��o e valor
		System.out.println("---Exercicio 3---");
		try {
			Object[] positionAndValue = new Integer[2];
			positionAndValue = S.searchElement(3);
			for (Object positionThenValue : positionAndValue) {
				System.out.println((Integer) positionThenValue);
			}
		} catch (ElementNotFoundException e) {
			e.getMessage();
		} 

		// Exercicio 4 Implementar um m�todo que insere um novo elemento em uma
		// posi��o passada por par�metro
		System.out.println("\n---Exercicio 4---");
		S.insertOptimized(4, 3);
		System.out.println(S);
		S.insertOptimized(2, 2);
		System.out.println(S);
		S.insertOptimized(2, 2);
		System.out.println(S);
		
		// Exercicio 5 Implementar um m�todos que remove o elemento contido na
		// posi��o passada por par�metro
		System.out.println("\n---Exercicio 5---");
		S.removeOptimized(2);
		System.out.println(S);
	}
}
