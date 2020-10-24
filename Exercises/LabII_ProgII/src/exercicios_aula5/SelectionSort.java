package exercicios_aula5;

public class SelectionSort {
	
	   public void sortSelection(int arr[]) {
			int n = arr.length;
			// Limite de movimento um a um em relação ao array não ordenado
			for (int i = 0; i < n - 1; i++) {
				// Encontra o elemento com valor mínimo no array não ordenado
				int min_idx = i;
				for (int j = i + 1; j < n; j++)
					if (arr[j] < arr[min_idx])
						min_idx = j;
				// Troca o elemento encontrado com o primeiro elemento
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}

		public void printArray(int arr[]) {
			int n = arr.length;
			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
}
