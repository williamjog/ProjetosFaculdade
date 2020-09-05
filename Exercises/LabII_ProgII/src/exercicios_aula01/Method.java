package exercicios_aula01;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Method {
	
	static Teclado t = new Teclado();
	
	public static int[][] exercicio1a() {
		System.out.println("\nExercício 1a");
		int[][] array = new int[3][10];
		for (int i = 0; i < 3; i++) {
			String umaLinhaDoArray = "";
			for (int j = 0; j < 10; j++) {
				array[i][j] = j;
				umaLinhaDoArray += Integer.toString(array[i][j]) + " ";
			}
			if (i < 2) {
				System.out.println(umaLinhaDoArray);
			} else {
				System.out.println(umaLinhaDoArray + "\n");
			}
		}		
		return array;
	}
	
	public static int[][] exercicio1b() {
		System.out.println("\nExercício 1b");
		int[][] array = new int[3][10];
		for (int i = 0; i < 3; i++) {
			String umaLinhaDoArray = "";
			for (int j = 0; j < 10; j++) {
				array[i][j] = (int) Math.pow(j, 2);
				umaLinhaDoArray += Integer.toString(array[i][j]) + " ";
			}
			if (i < 2) {
				System.out.println(umaLinhaDoArray);
			} else {
				System.out.println(umaLinhaDoArray + "\n");
			}
		}
		return array;
	}
	
	public static int[][] exercicio1c() {
		System.out.println("\nExercício 1c");
		int[][] array = new int[6][6];
		for (int i = 0; i < 6; i++) {
			String umaLinhaDoArray = "";
			for (int j = 0; j < 6; j++) {
				array[i][j] = i;
				umaLinhaDoArray += Integer.toString(array[i][j]) + " ";
			}
			if (i < 5) {
				System.out.println(umaLinhaDoArray);
			} else {
				System.out.println(umaLinhaDoArray + "\n");
			}
		}
		return array;
	}
	
	public static int[][] exercicio1d() {
		System.out.println("\nExercício 1d");
		int[][] array = new int[9][6];
		for (int i = 0; i < 9; i++) {
			String umaLinhaDoArray = "";
			for (int j = 0; j < 6; j++) {
				if (i % 2 == 0 || i == 0) {
					array[i][j] = 0;
					umaLinhaDoArray += Integer.toString(array[i][j]) + " ";
				} else {
					array[i][j] = -1;
					umaLinhaDoArray += Integer.toString(array[i][j]);
				}
			}
			if (i < 8) {
				System.out.println(umaLinhaDoArray);
			} else {
				System.out.println(umaLinhaDoArray + "\n");
			}
		}
		return array;
	}
	
	public static int[][] exercicio2() {
		System.out.println("\nExercício 2");
		int linhas = t.leInt("How many lines?");
		int colunas = t.leInt("How many columns?");
		int[][] array = new int[linhas][colunas];
		String umaLinhaDoArray = "\n"; 
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				array[i][j] = (int) (Math.random() * 100);
				umaLinhaDoArray += array[i][j] + " ";
			}
			umaLinhaDoArray += '\n';
		}
		System.out.println("\nHere is your matrix:"+ umaLinhaDoArray);
		return array;	
	}
	
	public static int[][] exercicio3() {
		System.out.println("\nExercício 3");
		int[][] array = new int[2][5];
		String anArrayLine = "";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				array[i][j] = t.leInt("Please write a number:");
				anArrayLine += array[i][j] + " ";
			}
			anArrayLine += '\n';
		}
		System.out.println("\n" + "Here is your matrix:" + '\n' + anArrayLine);
		return array;
	}
	
	public static int exercicio4(double[][] array) {
		System.out.println("\nExercício 4");
		String matrix = "";
		DecimalFormat df = new DecimalFormat("0.0");
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				counter++;
				matrix += df.format(array[i][j]) + "  ";
			}
			matrix += '\n';
//		for (double[] i : array) {
//			for (double j : i) {
//				counter++;
//			}
//		}	
		}
		System.out.println("Here is your matrix: " + '\n' + matrix);
		System.out.printf("Number of items in the received array: %d.\n\n", counter);
		return counter;
	}
	
	public static String exercicio6(double[][] array) {
		System.out.println("\nExercício 6");
		String matrix = "";
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (j != array[i].length - 1) {
					matrix += df.format(array[i][j]) + " - ";
				} else {
					matrix += df.format(array[i][j]);
				}
			}
			matrix += '\n';
		}
		System.out.println(matrix);
		return matrix;
	}
	
	public static void exercicio7(double[][] array) {
		System.out.println("\nExercício 7");
		String matrix = "";
		double highestValue = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > highestValue) {
					highestValue = array[i][j];
					matrix += df.format(array[i][j]) + "  ";
				} else {
					matrix += df.format(array[i][j]) + "  ";
				}
			}
			matrix += '\n';
		}
		System.out.println(matrix);
		System.out.printf("The highest number in this matrix is \'%.1f\'.", highestValue);
	}
	
	public static double exercicio8(double[][] array) {
		System.out.println("\n\nExercício 8");
		String matrix = "";
		double sum = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				matrix += df.format(array[i][j]) + " ";
			}
			matrix += '\n';
		}
		System.out.println(matrix);
		System.out.printf("The sum of the values is %.1f.", sum);
		return sum;
	}
	
	public static double exercicio9(double[][] array) {
		System.out.println("\n\nExercício 9");
		String matrix = "";
		int counter = 0;
		double sum = 0;
		double average = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				counter ++;
				sum += array[i][j];
				matrix += df.format(array[i][j]) + " ";
			}
			matrix += '\n';
		}
		average = sum / counter;
		System.out.println(matrix);
		System.out.printf("The average of the values is %.1f.", average);
		return average;
	}
	
	public static String exercicio10() {
		System.out.println("\n\nExercício 10");
		int lines =  (int) Math.ceil(Math.random() * 5);
		int columns = (int) Math.ceil(Math.random() * 3);
		System.out.println("Number of lines: " + lines);
		System.out.println("Number of columns: " + columns);
		String matrix = "";
		String[][] array = new String[lines][columns];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = t.leString("Write any character:");
				matrix += array[i][j] + " ";
			}
			matrix += '\n';
		}
		System.out.println("\nHere's your matrix: " + "\n" + matrix);
		return matrix;
	}
	
	public static int[] exercicio11(int[][] array) {
		System.out.println("\nExercício 11");
		int[] tempArray = new int[array.length * array[0].length];
		String accumulator = "";
		String oldMatrix = "";
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] % 2 == 0) {
					accumulator += array[i][j] + " ";
					oldMatrix += array[i][j] + " ";
					tempArray[counter] = array[i][j];
					counter++;
				} else {
					oldMatrix += array[i][j] + " ";
				}
			}
			oldMatrix += "\n";
		}
		int[] array1d = new int[counter];
		for (int i = 0; i < array1d.length; i++) {
			array1d[i] = tempArray[i];
		}
		System.out.println("\nMatrix received: " + '\n' + oldMatrix);
		System.out.println("New Array containing only even numbers:" + '\n' + "[ " + accumulator + "]");
		return array1d;
	}
}