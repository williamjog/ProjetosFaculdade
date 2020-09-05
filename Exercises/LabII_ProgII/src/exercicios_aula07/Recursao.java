package exercicios_aula07;

public class Recursao {

	public static void main(String[] args) {
		
		//Exerc�cio 01
		System.out.println(Methods.SomaInteirosexercicio01(10));
		
		//Exercicio 02
		int[] v = {1,2,3,4,5,6,7,8,9,10};
		int t = v.length;
		System.out.println("\n" + Methods.SomaElementosVetorexercicio02(v, t));
		
		//Exercicio 03
		System.out.println("\n" + Methods.MDCexercicio03(12, 10));
		
		//Exerc�cio04
		System.out.println("\n" + Methods.searchChar("Gr�mio � maior que o Binter", '�') + "\n");
		
		//Exerc�cio05
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Methods.reversePrintArray(array);
		
		//Exerc�cio06
		double[] array1 = {1.2, 2.5, 3.1, 4, 5.21, 6.59};
		System.out.println("\n\n" + Methods.arraySum(array1));
		
		//Exerc�cio07
		int[] vetor = {23, 35, 16, 8, 13, 11, 10, 20, 9, 12};
		System.out.println("\n" + Methods.encontraPosicaoMenorValor(vetor) + "\n");
		
		//Exerc�cio08
		String acc = "";
		int[][] matrix = new int[4][4]; // Se colocar uma matriz n�o quadrada d� erro!
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j< matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 50) + 1;
				if (j >= matrix[i].length - 1) {
					acc += matrix[i][j];
				} else {
					acc += matrix[i][j] + " | ";
				}
 			}
			acc += '\n';
		}
		
		System.out.println(acc);
		
		try {
			Methods.printPrimaryDiagonal(matrix);
		} 
		catch (MatrixNotPossibleException e) {
			System.out.println(e.getMessage());
		}

		//Exerc�cio09
		System.out.println("\n\n" + Methods.binaryToDecimal("11010001"));
	}
}
	