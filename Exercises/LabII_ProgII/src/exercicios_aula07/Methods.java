package exercicios_aula07;

public class Methods {
	
	// Crie uma fun��o recursiva para calcular a soma dos inteiros de 1 a n, sendo n >= 1.
	public static int SomaInteirosexercicio01(int n) {		
		if (n < 0) {
			return 0;
		} else {
			return n + SomaInteirosexercicio01(n - 1);
		}
	}
	
	// Escreva uma fun��o recursiva que retorne a soma dos elementos de um vetor v contendo t elementos.	
	public static int SomaElementosVetorexercicio02 (int[] v, int len) {
		if (len <= 1) {
			return v[0];
		} else {
			return v[len -1] + SomaElementosVetorexercicio02(v, len -1);
		}
	}
	
	// Implemente um m�todo recursivo que calcule m�ximo divisor comum (MDC) entre dois n�meros inteiros utilizando a seguinte f�rmula
	//	MDC (x,y) == y, se x >= y e x % y == 0;
	//	MDC (x,y) == MDC (x,y), se x < y
	//	MDC (x,y) == MDC (y, x % y) caso contr�rio
	public static int MDCexercicio03(int x, int y) {
		if (x >= y && x % y == 0) {
			return y;
		} else if (x < y) {
			return MDCexercicio03(y, x);
		} else {
			return MDCexercicio03(y, x % y);
		}
	}
	
	// Escreva uma fun��o recursiva para verificar se um certo caractere est� ou n�o numa string. 
	// Receba uma String e um caractere por par�metro, retornando verdadeiro ou falso. 
	// Utilize (para facilitar) as fun��es charAt, length e substring da classe String.
	public static boolean searchChar(String string, char x) {
		if (string.charAt(string.length() -1) == x) {
			return true;
		} else if (string.length() < 2) {
			return false;
		} else {
			string = string.substring(0, string.length() -1);
			return searchChar(string, x);
		}
	}
	
	 // Crie um m�todo recursivo que imprime um array recebido por par�metro de tr�s para frente.
	public static void reversePrintArray(int[] array) {
		printArray(array, array.length - 1);			
	}
	
	// M�todo privado auxiliar, n�o consegui pensar em outra forma de fazer...
	private static void printArray (int[] array, int position) {
		if (position < 0) {
			return;
		} else {
			System.out.print(array[position] + " ");
			printArray(array, position - 1);
		}
	}
	
	// Crie um m�todo recursivo que recebe um array bidimensional de double e retorna a soma dos elementos deste array.
	public static double arraySum(double[] array) {
		return sumArray(array, 0, 0);	
	}
	
	private static double sumArray(double[] array, int position, double sum) {
		if (position > array.length - 1) {
			return sum;
		} else {
			sum += array[position];
			return sumArray(array, position + 1, sum);
		}
	}
	
	// Crie um m�todo chamado encontraPosicaoMenorValor. 
	// Este m�todo deve encontrar a posi��o do menor valor de um array de inteiros V	
	public static int encontraPosicaoMenorValor(int[] v) {
		return findLowestNumber(v, 0, 0);
	}
	
	private static int findLowestNumber(int[] v, int position, int lowestNumberPosition) {
		if (position > v.length - 1) {
			return lowestNumberPosition;
		} else {
			lowestNumberPosition = (v[position] < v[lowestNumberPosition]) ? lowestNumberPosition = position : lowestNumberPosition;
			return findLowestNumber(v, position + 1, lowestNumberPosition);
		}
	}
	
	
	//Crie um m�todo recursivo chamado printPrimaryDiagonal, que imprime a diagonal prim�ria de uma matriz qualquer.	
	public static void printPrimaryDiagonal(int[][] matrix) throws MatrixNotPossibleException {
		if (matrix.length != matrix[0].length) {
			throw new MatrixNotPossibleException();
		} else {
			printMatrix(matrix, 0, 0);
		}
	}
	
	private static void printMatrix(int[][] matrix, int line, int column) {
		if (line > matrix.length - 1) {
			return;
		} else {
			System.out.print(matrix[line][column] + " ");
			printMatrix(matrix, line + 1, column + 1);
		}
	}
	
	// Crie um m�todo recursivo chamado binaryToDecimal, que recebe uma String que cont�m um n�mero em base 2
	// e retorna um n�mero em base 10.
	public static int binaryToDecimal(String binaryNumber) {
		return convertNumber(binaryNumber, binaryNumber.length());
	}
	
	private static int convertNumber(String binary, int len) {
		if (len == 1) {
			return binary.charAt(0) - 48;
		} else {
			return binary.charAt(len - 1) - 48 + 2 * convertNumber(binary, len - 1);
		}
	}
}