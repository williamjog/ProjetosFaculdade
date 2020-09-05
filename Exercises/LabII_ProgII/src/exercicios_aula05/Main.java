package exercicios_aula05;

import java.time.Duration;
import java.time.Instant;


public class Main {

	public static void main(String[] args) {
		
		BubbleSort bs = new BubbleSort(); 
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = i;
        }
		Instant startTime = Instant.now();
        bs.bubbleSort(arr); 
        System.out.println("\nBubbleSort aplicado em array já ordenado crescente:");  
		Instant endTime = Instant.now();
		Duration totalTime = Duration.between(startTime, endTime);
		System.out.println(totalTime);
		
		    
        InsertionSort is = new InsertionSort(); 
        System.out.println("\nInsertionSort aplicado em array já ordenado crescente:");  
        int arr1[] = new int[100000];
        for (int i = 0; i < arr1.length; i++) {
        	arr1[i] = i;
        } 
    	Instant startTime1 = Instant.now();
        is.sortInsertion(arr1);   
		Instant endTime1 = Instant.now();
		Duration totalTime1 = Duration.between(startTime1, endTime1);
		System.out.println(totalTime1);
		
		
		SelectionSort ss = new SelectionSort(); 
		int arr2[] = new int[100000];
	    for (int i = 0; i < arr2.length; i++) {
	        	arr2[i] = i;
	    }
		Instant startTime2 = Instant.now();
        ss.sortSelection(arr2); 
        System.out.println("\nSelectionSort aplicado em array já ordenado crescente:"); 
		Instant endTime2 = Instant.now();
		Duration totalTime2 = Duration.between(startTime2, endTime2);
		System.out.println(totalTime2);
		
		
		BubbleSort bs1 = new BubbleSort(); 
		int arr3[] = new int[100000];
		int j = 0;
	    for (int i = 100000; i > 0; i--) {
        	arr3[j] = i;
        	j++;
	    }
		Instant startTime3 = Instant.now();
        bs1.bubbleSort(arr3);
		Instant endTime3 = Instant.now();
        System.out.println("\nBubbleSort aplicado em array ordenado de forma decrescente:"); 
		Duration totalTime3 = Duration.between(startTime3, endTime3);
		System.out.println(totalTime3);
		
		
		InsertionSort is1 = new InsertionSort();
		int arr4[] = new int[100000];
		j = 0;
	    for (int i = 100000; i > 0; i--) {
        	arr4[j] = i;
        	j++;
	    } 
        System.out.println("\nInsertionSort aplicado em array ordenado de forma decrescente:");    
		Instant startTime4 = Instant.now();
        is1.sortInsertion(arr4);    
		Instant endTime4 = Instant.now();
		Duration totalTime4 = Duration.between(startTime4, endTime4);
		System.out.println(totalTime4);
		
		
		SelectionSort ss1 = new SelectionSort(); 
		int arr5[] = new int[100000];
		j = 0;
	    for (int i = 100000; i > 0; i--) {
        	arr5[j] = i;
        	j++;
	    }
		Instant startTime5 = Instant.now();
        ss1.sortSelection(arr5); 
        System.out.println("\nSelectionSort aplicado em array ordenado de forma decrescente:"); 
		Instant endTime5 = Instant.now();
		Duration totalTime5 = Duration.between(startTime5, endTime5);
		System.out.println(totalTime5);
		

		
		int arr6[] = new int[100000];
	    for (int i = 0; i < arr6.length; i++) {
        	arr6[i] = (int) (Math.random() * 100000) + 1;
	    }

	    int arr7[] = arr6.clone();

	    		    
		BubbleSort bs2 = new BubbleSort();
		Instant startTime6 = Instant.now();
        System.out.println("\nBubbleSort aplicado em um array com valores aleatórios:");
        bs2.bubbleSort(arr7);
		Instant endTime6 = Instant.now();
		Duration totalTime6 = Duration.between(startTime6, endTime6);
		System.out.println(totalTime6);
		
		  
        InsertionSort is2 = new InsertionSort();
        arr7 = arr6.clone();
		Instant startTime7 = Instant.now();
        System.out.println("\nInsertionSort aplicado em um array com valores aleatórios:");    
        is2.sortInsertion(arr7);
		Instant endTime7 = Instant.now();
		Duration totalTime7 = Duration.between(startTime7, endTime7);
		System.out.println(totalTime7);


		SelectionSort ss2 = new SelectionSort();
	    arr7 = arr6.clone();
		Instant startTime8 = Instant.now();
        ss2.sortSelection(arr7); 
        System.out.println("\nSelectionSort aplicado em um array com valores aleatórios:");      
		Instant endTime8 = Instant.now();
		Duration totalTime8 = Duration.between(startTime8, endTime8);
		System.out.println(totalTime8);
	}

}
