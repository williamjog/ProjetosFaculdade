package exercicios_aula_20;

public class Main {

//	Implemente um método, em uma classe qualquer, que receba como parâmetro uma lista sequencial de números inteiros (objetos do tipo Integer) 
//	e retorne um vetor contendo apenas os números pares desta lista.	
	public static Integer[] evenNumbers(List<Integer> lista) throws noEvenNumbersException {
		if (lista.isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			int evenCounter = 0;
			for (int i = 0; i < lista.numElements(); i++) {
				if (lista.get(i) % 2 == 0) {
					evenCounter++;
				}
			}
			if (evenCounter < 1) {
				throw new noEvenNumbersException();
			} else {
				int position = 0;
				Integer[] arrayInteger = new Integer[evenCounter];
				for (int i = 0; i < lista.numElements(); i++) {
					if (lista.get(i) % 2 == 0) {
						arrayInteger[position] = lista.get(i);
						position++;
					}
				}
				return arrayInteger;
			}
		}
	}

//	Implemente um método que recebe duas listas e retorna uma terceira, contendo a intercalação dos métodos das duas iniciais. 
//	Por exemplo, dadas as listas t1 = (A, B, C) e t2 = (D, E, F), a intercalação das duas deve produzir (A, D, B, E, C, F). 
//	As listas originais não devem ser alteradas.
	public static List<Character> mergeLists(List<Character> t1, List<Character> t2) {
		if (t1.isEmpty() || t2.isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			List<Character> list = new StaticList<Character>(t1.numElements() + t2.numElements());
			int position = 0;
			for (int i = 0; i < t1.numElements() + t2.numElements(); i++) {
				if (position < t1.numElements()) {
					list.insert(t1.get(position), i);
				}
				if (position < t2.numElements()) {
					list.insert(t2.get(position), i + 1);
				}
				i++;
				position++;
			}
			return list;
		}
	}

	// Implemente um método que recebe duas listas t1 e t2 e copia os elementos da
	// segunda para o início da primeira.
	public static List<Double> prependList(List<Double> t1, List<Double> t2) {
		int sizeofLists = t1.numElements() + t2.numElements();
		List<Double> aux = new StaticList<>(sizeofLists);
		for (int i = 0; i < t1.numElements(); i++)
			aux.insert(t1.get(i), i);
		t1 = aux;
		for (int i = 0; i < t2.numElements(); i++) {
			t1.insert(t2.get(i), i);
		}
		return t1;
	}

	public static void main(String[] args) throws noEvenNumbersException, objectNotFoundException {

		//Exercicio 1
		List<Integer> listInteger = new StaticList<>(5);
		listInteger.insert(1, 0);
		listInteger.insert(2, 1);
		listInteger.insert(3, 2);
		listInteger.insert(4, 3);
		listInteger.insert(5, 4);
		Integer[] listInteger2 = evenNumbers(listInteger);
		for (int i = 0; i < listInteger2.length; i++) {
			System.out.println(listInteger2[i]);
		}
		System.out.println("----------------------------------");
		
		//Exercicio 2
		List<Character> listChar1 = new StaticList<>(7);
		List<Character> listChar2 = new StaticList<>(7);
		listChar1.insert('G', 0);
		listChar1.insert('Ê', 1);
		listChar1.insert('I', 2);
		listChar1.insert(' ', 3);
		listChar1.insert(' ', 4);
		listChar1.insert('N', 5);
		listChar1.insert('E', 6);
		
		listChar2.insert('R', 0);
		listChar2.insert('M', 1);
		listChar2.insert('O', 2);
		listChar2.insert('>', 3);
		listChar2.insert('I', 4);
		listChar2.insert('T', 5);
		listChar2.insert('R', 6);
		
		List<Character> mergedList = mergeLists(listChar1, listChar2);
		System.out.println(mergedList);
		System.out.println("----------------------------------");

		// Exercicio 3
		List<Double> listDouble1 = new StaticList<>(5);
		listDouble1.insert(1.2, 0);
		listDouble1.insert(2.2, 1);
		listDouble1.insert(3.2, 2);
		listDouble1.insert(4.2, 3);
		listDouble1.insert(5.2, 4);

		List<Double> listDouble2 = new StaticList<>(4);
		listDouble2.insert(10.1, 0);
		listDouble2.insert(11.1, 1);
		listDouble2.insert(12.2, 2);
		listDouble2.insert(13.1, 3);

		listDouble1 = prependList(listDouble1, listDouble2);
		System.out.println(listDouble1);
		System.out.println("----------------------------------");

		//Exercicio 4
		listDouble1.remove(1);
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio 5
		listDouble1.insertAfter(3.2, 3.0);
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio 6
		listDouble1.swap(2, 4);
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio 7
		listDouble1.flip();
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio 8
		listDouble1.insert(listDouble2, 3);
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio 9
		List<Integer> listInteger3 = new StaticList<>(8);
		listInteger3.insert(1, 0);
		listInteger3.insert(2, 1);
		listInteger3.insert(1, 2);
		listInteger3.insert(1, 3);
		listInteger3.insert(2, 4);
		listInteger3.insert(3, 5);
		listInteger3.insert(3, 6);
		listInteger3.insert(1, 7);
		listInteger3.dedup();
		System.out.println(listInteger3);
		System.out.println("----------------------------------");
		
		//Exercicio10
		List<Integer> listInteger4 = new StaticList<>(8);
		listInteger4.insert(1, 0);
		listInteger4.insert(2, 1);
		listInteger4.insert(1, 2);
		listInteger4.insert(1, 3);
		listInteger4.insert(2, 4);
		listInteger4.insert(3, 5);
		listInteger4.insert(3, 6);
		listInteger4.insert(1, 7);
		
		List<Integer> listInteger5 = new StaticList<>(8);
		listInteger5.insert(1, 0);
		listInteger5.insert(2, 1);
		listInteger5.insert(1, 2);
		listInteger5.insert(1, 3);
		listInteger5.insert(2, 4);
		listInteger5.insert(3, 5);
		listInteger5.insert(3, 6);
		listInteger5.insert(1, 7);
		
		System.out.println(listInteger4.equals(listInteger5));
		System.out.println(listInteger4.equals(listInteger));
		System.out.println("----------------------------------");
		
		//Exercio 11 
		List<Integer> listInteger6 = new StaticList<>(5);
		listInteger6 = listInteger.clone();
		System.out.println(listInteger6);
		System.out.println("----------------------------------");
		
		//Exercicio12
		System.out.println(listDouble1);
		System.out.println(listDouble1.remove(2, 5));
		System.out.println(listDouble1);
		System.out.println("----------------------------------");
		
		//Exercicio13
		List<Integer> listInteger7 = new StaticList<>(5);
		listInteger7.insert(10, 0);
		listInteger7.insert(11, 1);
		listInteger7.insert(12, 2);
		listInteger7.insert(13, 3);
		listInteger7.insert(14, 4);
		System.out.println(listInteger7);
		System.out.println(listInteger7.split(3));
		System.out.println(listInteger7);
		
	}
}
