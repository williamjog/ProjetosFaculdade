
public class Teste {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> S = new SinglyLinkedList<Integer>();
					
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
		
		System.out.println(S + "\n");
		
		System.out.println("---Exercicio Letra C---");
		//Exercicio Letra C 
		S.addAfter(2, 1); // Testando caso normal inserindo numa posição em que fica no entre o último e o primeiro
		System.out.println(S + "\n");
		S.addAfter(5, 3); // Testando caso em que o usuário decide inserir numa posição depois da última, o que caracteriza como insertLast();
		System.out.println(S + "\n");
		
		
		
		System.out.println("---Exercicio Letra D---");
		//Exercicio Letra D
		S.addBefore(4, 4); // Testando caso normal, inserindo antes da tail atual
		S.addBefore(100, 1); // Testando caso em que o usuário quer inserir antes da posição 1, o que o tornaria o novo head da lista;
		
		System.out.println(S);
		
		S.remove(0); // Removendo o 100 pra ficar mais bonitinho hehehe
		
		System.out.println("\n" +S);
	}
}
