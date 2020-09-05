package exercicios_aula01;

public class Main {
	
	static Teclado t = new Teclado();

	public static void main(String[] args) {
		
		// Impress�o dos n�meros na tela a t�tulo de verifica��o.
		
		// Exerc�cio 1a
		Method.exercicio1a();
		
		// Exerc�cio 1.b
		Method.exercicio1b();
		
		// Exerc�cio 1.c
		Method.exercicio1c();
		
		//Exerc�cio 1.d
		Method.exercicio1d();
		
		//Exerc�cio 2
		Method.exercicio2();
		
		//Exerc�cio 3
		Method.exercicio3();
		
		//Exerc�cio 4 (O exerc�cio 5 � igual ao 4)
		double[][] array = new double[7][4];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.random() * 50;
			}
		}	
		Method.exercicio4(array);
		
		//Exerc�cio 6
		double[][] array1 = new double[4][5];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				array1[i][j] = Math.random() * 25;
			}
		}		
		Method.exercicio6(array1);
		
		//Exerc�cio 7
		double[][] array2 = new double[4][7];
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = Math.random() * 35;
			}
		}	
		Method.exercicio7(array2);
		
		//Exerc�cio 8
		double[][] array3 = new double[3][4];
		for (int i = 0; i < array3.length; i++) {
			for (int j = 0; j < array3[i].length; j++) {
				array3[i][j] = Math.random() * 40;
			}
		}
		Method.exercicio8(array3);
		
		//Exerc�cio 9
		double[][] array4 = new double[3][5];
		for (int i = 0; i < array4.length; i++) {
			for (int j = 0; j < array4[i].length; j++) {
				array4[i][j] = Math.random() * 45;
			}
		}
		Method.exercicio9(array4);
		
		//Exercicio 10
		Method.exercicio10();
		
		//Exerc�cio 11
		int[][] array5 = new int[5][6];
		for (int i = 0; i < array5.length; i++) {
			for (int j = 0; j < array5[i].length; j++) {
				array5[i][j] = (int) Math.round(Math.random() * 55);
			}
		}
		Method.exercicio11(array5);	
	}
}
