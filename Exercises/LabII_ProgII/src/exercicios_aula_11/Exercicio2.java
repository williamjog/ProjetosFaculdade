package exercicios_aula_11;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o caminho do arquivo a ser lido: ");

		String file = sc.nextLine();

		Estoque e = new Estoque();

		e.preencheEstoque(file);

		sc.close();
	}
}
