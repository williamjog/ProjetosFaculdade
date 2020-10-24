package exercicios_aula_11;

import java.io.*;

public class Estoque {

	private Produto[] arrayDeProdutos;

	public Estoque() {
	}

	public Produto[] getArrayDeProdutos() {
		return arrayDeProdutos;
	}

	public void setArrayDeProdutos(Produto[] arrayDeProdutos) {
		this.arrayDeProdutos = arrayDeProdutos;
	}
	
	
	public void preencheEstoque(String file) {
						
		try {
			File readFile = new File(file);
			LineNumberReader howManyLines = new LineNumberReader(new FileReader(readFile));
			howManyLines.skip(readFile.length());
			int numberOfLines = howManyLines.getLineNumber();
			howManyLines.close();
			Produto[] arrayDeProdutos = new Produto[numberOfLines - 1]; //Preciso desconsiderar a primeira linha que � o cabe�alho
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String[] line = new String[4];
			line = in.readLine().split("\\*");
			int i = 0;
			while (line != null) {

				String buffer = in.readLine();

				if (buffer == null)	break;

				line = buffer.split("\\*");
				String produto = line[0].replaceAll("\\s+", "");
				String descricao = line[1];
				String preco = line[2].replaceAll("\\s+", "");
				String tipo = line[3].replaceAll("\\s+", "");
				String informacaoExtra = line[4].replaceAll("\\s+", "");

				switch (tipo) {
				case "Alimento":
					arrayDeProdutos[i] = new Alimento(Double.parseDouble(preco), descricao, tipo, informacaoExtra,
							produto);
					break;
				case "Vestu�rio":
					arrayDeProdutos[i] = new Vestuario(Double.parseDouble(preco), descricao, tipo,
							Integer.parseInt(informacaoExtra), produto);
					break;
				case "Eletrodom�stico":
					arrayDeProdutos[i] = new Eletrodomestico(Double.parseDouble(preco), descricao, tipo,
							Double.parseDouble(informacaoExtra), produto);
				default:
					break;
				}

				i++;
			}

			fr.close();
			in.close();

			printTheMostExpensiveFood(arrayDeProdutos);
			
			printCheapestHomeAppliance(arrayDeProdutos);
			
			printAllClothesonStock(arrayDeProdutos);
			
			System.out.println("Software terminated.");

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + file + "\" n�o existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + file + ".");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Posi��o do Array ultrapassou o tamanho m�ximo!");
		}
	}

	private void printTheMostExpensiveFood(Produto[] arrayDeProdutos) {
		int position = 0;
		double highestPrice = 0;
		for (int i = 0; i < arrayDeProdutos.length; i++) {
			if (arrayDeProdutos[i].getTipo().equals("Alimento")) {
				if (arrayDeProdutos[i].getPreco() > highestPrice) {
					highestPrice = arrayDeProdutos[i].getPreco();
					position = i;
				}
			}
		}
		System.out.println("\nO Alimento mais caro �: \n" + arrayDeProdutos[position]);
	}

	private void printCheapestHomeAppliance(Produto[] arrayDeProdutos) {
		int position = 0;
		double lowestPrice = 100000;
		for (int i = 0; i < arrayDeProdutos.length; i++) {
			if (arrayDeProdutos[i].getTipo().equals("Eletrodom�stico")) {
				if (lowestPrice > arrayDeProdutos[i].getPreco()) {
					lowestPrice = arrayDeProdutos[i].getPreco();
					position = i;
				}
			}
		}
		System.out.println("O Eletrodom�stico mais barato �: \n" + arrayDeProdutos[position]);
	}

	private void printAllClothesonStock(Produto[] arrayDeProdutos) {
		System.out.println("Estoque de Vestu�rio:");
		for (int i = 0; i < arrayDeProdutos.length; i++) {
			if (arrayDeProdutos[i].getTipo().equals("Vestu�rio")) {
				System.out.println(arrayDeProdutos[i]);
			}
		}
	}
}
