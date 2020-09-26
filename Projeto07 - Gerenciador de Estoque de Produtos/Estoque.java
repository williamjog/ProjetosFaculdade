package unisinos;

import java.io.*;

public class Estoque {

	private Produto[] arrayDeProdutos;
	private double valorEmEstoque;
	private double valorVendido;
	private int totProdutos;

	public Estoque() {
		arrayDeProdutos = new Produto[10];
		totProdutos = 0;
		valorEmEstoque = 0;
		valorVendido = 0;
	}

	private String printProdutReport(Produto produto) {
		double valorTotaldeVenda = produto.getQuantidadeVendida() * produto.getPreco();
		String stringValorVenda = String.format("%.2f", valorTotaldeVenda);
		return "\nProduto: " + produto.getDescricao() + "\n" + "Tipo: " + produto.getTipo() + "\n" + "Vendas: "
				+ produto.getQuantidadeVendida() + "\n" + "Total de vendas deste produto em R$: " + stringValorVenda;
	}

	public void printSalesReport() {
		System.out.printf("\nO somatório do valor em vendas atual é de R$ %.2f", valorVendido);
		System.out.printf("\nO valor em estoque atualmente é de R$ %.2f\n", valorEmEstoque);
		for (int i = 0; i < totProdutos; i++) {
			if (arrayDeProdutos[i].getQuantidadeVendida() > 0) {
				System.out.println("\nSegue relatório dos itens vendidos:");
				System.out.println(printProdutReport(arrayDeProdutos[i]));
			}
		}
	}

	public void verificaQuantidadeEmEstoque(int id, int quantidadeVendida) throws outOfStockException {
		for (int i = 0; i < totProdutos; i++) {
			if (arrayDeProdutos[i].getId() == id) {
				if (arrayDeProdutos[i].getQuantidadeEmEstoque() < quantidadeVendida) {
					throw new outOfStockException();
				}
			}
		}
	}

	public void venderProduto(int id, int quantidadeVendida, String filepath) {
		for (int i = 0; i < totProdutos; i++) {
			if (arrayDeProdutos[i].getId() == id) {
				arrayDeProdutos[i]
						.setQuantidadeEmEstoque(arrayDeProdutos[i].getQuantidadeEmEstoque() - quantidadeVendida);
				arrayDeProdutos[i].setQuantidadeVendida(arrayDeProdutos[i].getQuantidadeVendida() + quantidadeVendida);
				valorEmEstoque -= arrayDeProdutos[i].getPreco() * quantidadeVendida;
				valorVendido += arrayDeProdutos[i].getPreco() * quantidadeVendida;
				break;
			}
		}
		
		try {
			FileWriter fw = new FileWriter(filepath, false);
			for (int i = 0; i < totProdutos; i++) {

				fw.write(arrayDeProdutos[i].writeProduct());
			}

			fw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + filepath + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + filepath + ".");
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println("Venda Cadastrada!");
		return;
	}

	public void ordenarEstoque(String fileName) {
		sortSelection(arrayDeProdutos);

		try {
			FileWriter fw = new FileWriter(fileName, false);
			for (int i = 0; i < totProdutos; i++) {
				fw.write(arrayDeProdutos[i].writeProduct());
			}

			fw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + fileName + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + fileName + ".");
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println("Estoque ordenado!");
	}

	private void sortSelection(Produto arr[]) { // Adaptado do site GeeksForGeeks: https://www.geeksforgeeks.org/selection-sort/
		int n = totProdutos;
		// Limite de movimento um a um em relação ao array não ordenado
		for (int i = 0; i < n - 1; i++) {
			// Encontra o elemento com valor mínimo no array não ordenado
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j].getId() < arr[min_idx].getId())
					min_idx = j;
			// Troca o elemento encontrado com o primeiro elemento
			Produto temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public boolean AdicionaProduto(Produto produto, String fileName) throws stockIsFullException {
		if (totProdutos < arrayDeProdutos.length) {
			arrayDeProdutos[totProdutos] = produto;
			
			try {
				FileWriter fw = new FileWriter(fileName, true);
				fw.write(produto.writeProduct());
				fw.close();

				totProdutos++;
				valorEmEstoque += produto.getPreco() * produto.getQuantidadeEmEstoque();
				return true;

			} catch (FileNotFoundException e) {
				System.out.println("Arquivo \"" + fileName + "\" não existe.");
			} catch (IOException e) {
				System.out.println("Erro na leitura de " + fileName + ".");
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		throw new stockIsFullException();
	}

	public boolean removeProduto(int id, String fileName) {
		boolean idOk = false;
		for (int i = 0; i < totProdutos; i++) {
			if (arrayDeProdutos[i].getId() == id) {
				idOk = true;
				break;
			}
		}

		if (idOk) {
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader in = new BufferedReader(fr);
				FileWriter fw = new FileWriter(fileName, false);
				for (int i = 0; i < totProdutos; i++) {
					if (arrayDeProdutos[i].getId() != id) {
						fw.write(arrayDeProdutos[i].writeProduct());
					}
				}
				fr.close();
				in.close();
				fw.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			resetarArrayDeProdutos();
			preencheEstoque(fileName);

			System.out.println("Produto com o ID " + id + " removido com sucesso! Verifique o estoque atual!");
			return true;

		} else {
			System.out.println("ID não encontrado.");
			return false;
		}
	}

	private void resetarArrayDeProdutos() {
		for (int i = 0; i < totProdutos; i++) {
			arrayDeProdutos[i] = null;
		}
		totProdutos = 0;
		valorEmEstoque = 0;
		valorVendido = 0;
		return;
	}

	public void alteraInfoProduto(int id, int campo, String novaInfo, String fileName) {

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			FileWriter fw = new FileWriter(fileName, false);

			String newField = whichField(campo);
			for (int i = 0; i < totProdutos; i++) {
				if (arrayDeProdutos[i].getId() == id) {
					switch (newField) {
					case "preco":
						arrayDeProdutos[i].setPreco(Double.parseDouble(novaInfo));
						fw.write(arrayDeProdutos[i].writeProduct());
						break;
					case "descricao":
						arrayDeProdutos[i].setDescricao(novaInfo);
						fw.write(arrayDeProdutos[i].writeProduct());
						break;
					case "quantidadeEmEstoque":
						arrayDeProdutos[i].setQuantidadeEmEstoque(Integer.parseInt(novaInfo));
						fw.write(arrayDeProdutos[i].writeProduct());
						break;
					case "infoExtra":
						arrayDeProdutos[i].setExtraInfo(novaInfo);
						fw.write(arrayDeProdutos[i].writeProduct());
						break;
					default:
						break;
					}
				} else {
					fw.write(arrayDeProdutos[i].writeProduct());
				}
			}

			fr.close();
			in.close();
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		resetarArrayDeProdutos();
		preencheEstoque(fileName);
	}

	private String whichField(int campo) {
		String field = "";
		switch (campo) {
		case 1:
			field = "preco";
			break;
		case 2:
			field = "descricao";
			break;
		case 3:
			field = "quantidadeEmEstoque";
			break;
		case 4:
			field = "infoExtra";
			break;
		}
		return field;
	}

	public void printStock() {
		System.out.println("\nESTOQUE ATUAL:");
		for (int i = 0; i < totProdutos; i++) {
			System.out.println(arrayDeProdutos[i]);
		}
		System.out.println("--------------------\n");
	}
	
	public void verificaSeOIdExiste(int id) throws idDoesntExistException {
		boolean idOk = false;
		for (int i = 0; i < totProdutos; i++) {
			if (arrayDeProdutos[i].getId() == id) {
				idOk = true;
				break;
			}
		}
		if (!idOk) {
			throw new idDoesntExistException();
		}
	}

	public void verificaIdIgual(int id) throws idAlreadyExistsException {
		for (int i = 0; i < getTotProdutos(); i++) {
			if (getArrayDeProdutos()[i].getId() == id) {
				throw new idAlreadyExistsException();
			}
		}
	}

	public void preencheEstoque(String file) {

		try {
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String[] line = new String[6];
			int i = 0;

			String buffer = in.readLine();
			while (buffer != null) {

				line = buffer.split("\\*");
				int id = Integer.parseInt((line[0].replaceAll("\\s+", "")));
				double preco = Double.parseDouble(line[1].replaceAll("\\s+", ""));
				String descricao = line[2].trim();
				int quantidadeEmEstoque = Integer.parseInt((line[3].replaceAll("\\s+", "")));
				int quantidadeVendida = Integer.parseInt((line[4].replaceAll("\\s+", "")));
				String tipo = line[5].replaceAll("\\s+", "");
				String infoExtra = line[6].trim();

				switch (tipo) {

				case "Alimento":
					arrayDeProdutos[i] = new Alimento(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida,
							tipo, infoExtra);
					totProdutos++;
					valorEmEstoque += preco * quantidadeEmEstoque;
					valorVendido += preco * quantidadeVendida;
					break;
				case "Textil":
					arrayDeProdutos[i] = new Textil(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida, tipo,
							infoExtra);
					totProdutos++;
					valorEmEstoque += preco * quantidadeEmEstoque;
					valorVendido += preco * quantidadeVendida;
					break;
				case "Eletronico":
					arrayDeProdutos[i] = new Eletronico(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida,
							tipo, infoExtra);
					totProdutos++;
					valorEmEstoque += preco * quantidadeEmEstoque;
					valorVendido += preco * quantidadeVendida;
					break;
				case "Diversos":
					arrayDeProdutos[i] = new Diversos(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida,
							tipo, infoExtra);
					totProdutos++;
					valorEmEstoque += preco * quantidadeEmEstoque;
					valorVendido += preco * quantidadeVendida;
					break;
				default:
					break;
				}

				i++;
				buffer = in.readLine();
			}

			fr.close();
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + file + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + file + ".");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Posição do Array ultrapassou o tamanho máximo!");
		}
	}

	public Produto[] getArrayDeProdutos() {
		return arrayDeProdutos;
	}

	public void setArrayDeProdutos(Produto[] arrayDeProdutos) {
		this.arrayDeProdutos = arrayDeProdutos;
	}

	public double getValorEmEstoque() {
		return valorEmEstoque;
	}

	public void setValorEmEstoque(double valorEmEstoque) {
		this.valorEmEstoque = valorEmEstoque;
	}

	public double getValorVendido() {
		return valorVendido;
	}

	public void setValorVendido(double valorVendido) {
		this.valorVendido = valorVendido;
	}

	public int getTotProdutos() {
		return totProdutos;
	}

	public void setTotProdutos(int totProdutos) {
		this.totProdutos = totProdutos;
	}
}
