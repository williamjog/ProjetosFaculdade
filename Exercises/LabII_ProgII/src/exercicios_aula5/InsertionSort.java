package exercicios_aula5;

public class InsertionSort {

	public void sortInsertion(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			 // Move os elementos de arr [0..i-1], que são maiores que o valor de Key
			 // para uma posição à frente de sua posição atual
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	
	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
