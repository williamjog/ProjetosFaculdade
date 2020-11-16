
public class Main {

	public static void main(String[] args) {
		
		StaticDeque<Integer> D = new StaticDeque<Integer>(5);
		D.insert(5, true);
		D.insert(10, true);
		D.insert(15, true);
		D.insert(20, true);
		D.insert(18, true);
		
		System.out.println(D + "\n");
		
		System.out.printf("Position of Element 20: %d", D.search(20) + 1); // + 1 para ficar condizente com o println
		
		D.dequeue();
		
		System.out.println("\n\n"+ D + "\n");
		
		D.insert(13, false);  // Isso é igual a um enque(element) da classe super;
		
		System.out.println(D + "\n");
		 
		System.out.printf("Position of Element 10: %d\n\n", D.search(10) + 1); // + 1 para ficar condizente com o println
		
		D.dequeue();
		
		D.insert(150, false);  // Isso é igual a um enque(element) da classe super;
		
		System.out.println(D + "\n");
		
		D.remove(true);
				
		System.out.println(D + "\n");
		
		D.remove(false); // Isso é igual ao dequeue() da classe super;
		
		System.out.println(D + "\n");
		
		D.insert(255, false); // Isso é igual a um enque(element) da classe super;
		
		System.out.println(D + "\n");
		
		System.out.printf("Position of Element 255: %d\n\n", D.search(255) + 1); // + 1 para ficar condizente com o println
		
		D.printFirst();
		System.out.println("");
		D.printLast();
		
		D.enqueue(1000);
		
		System.out.println("\n" + D + "\n");
		
		D.printLast();
	}

}
