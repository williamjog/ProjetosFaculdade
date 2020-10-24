package unisinos;

import java.util.Scanner;

public class Main {
	
	// William Jansen Ostrowski Gomes - Individual

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean validOption = true;

		String file = "C:\\Users\\willi\\Desktop\\Estoque.txt";

		Estoque estoque = new Estoque();

		estoque.preencheEstoque(file);

		while (validOption) {

			try {
				System.out.println("MENU:");
				System.out.println("1 - Cadastrar um novo produto");
				System.out.println("2 - Listar produtos cadastrados");
				System.out.println("3 - Remover um produto");
				System.out.println("4 - Atualizar informação");
				System.out.println("5 - Vender um produto");
				System.out.println("6 - Imprimir relatório de Vendas");
				System.out.println("7 - Ordenar estoque pelo ID");
				System.out.println("8 - Sair \n");

				System.out.println("Escolha uma opção do Menu:");
				int option = Integer.parseInt(sc.nextLine());

				if (option < 1 || option > 8) {
					validOption = false;
					System.out.println("Fim.");

				} else {

					if (option == 1) {
						System.out.println("Digite o ID do produto: ");
						int id = Integer.parseInt(sc.nextLine());
						estoque.verificaIdIgual(id);

						System.out.println("Digite o Preço do produto: ");
						double price = Double.parseDouble(sc.nextLine());

						System.out.println("Digite a Descrição do produto: ");
						String description = sc.nextLine();

						System.out.println("Digite a quantidade em estoque do produto: ");
						int quantidadeEmEstoque = Integer.parseInt(sc.nextLine());

						int quantidadeVendida = 0;

						System.out.println("Digite o número correspondente ao tipo do produto: ");
						System.out.println("[1 - Alimento] - [2 - Textil] - [3 - Eletronico] - [4 - Diversos]");
						int type = Integer.parseInt(sc.nextLine());

						if (type == 1) {
							System.out.println("Digite o peso do alimento em gramas:");
							String peso = sc.nextLine();
							Produto product = new Alimento(id, price, description, quantidadeEmEstoque,
									quantidadeVendida, "Alimento", peso);
							estoque.AdicionaProduto(product, file);

						} else if (type == 2) {
							System.out.println("Digite a marca do Produto:");
							String marca = sc.nextLine();
							Produto product = new Textil(id, price, description, quantidadeEmEstoque, quantidadeVendida,
									"Textil", marca);
							estoque.AdicionaProduto(product, file);

						} else if (type == 3) {
							System.out.println("Digite a voltagem do Produto:");
							String voltagem = sc.nextLine();
							Produto product = new Eletronico(id, price, description, quantidadeEmEstoque,
									quantidadeVendida, "Eletronico", voltagem);
							estoque.AdicionaProduto(product, file);

						} else if (type == 4) {
							System.out.println("Digite a informação extra do Produto:");
							String infoExtra = sc.nextLine();
							Produto product = new Diversos(id, price, description, quantidadeEmEstoque,
									quantidadeVendida, "Diversos", infoExtra);
							estoque.AdicionaProduto(product, file);
							
						} else {
							System.out.println("\nOpção inválida!\n");
						}

					} else if (option == 2) {
						estoque.printStock();

					} else if (option == 3) {
						System.out.println("Digite o id do produto:");
						int id = Integer.parseInt(sc.nextLine());
						estoque.removeProduto(id, file);

					} else if (option == 4) {
						System.out.println("Digite o ID do produto:");
						int id = Integer.parseInt(sc.nextLine());
						estoque.verificaSeOIdExiste(id);

						System.out.println("Campos Editáveis:");
						System.out.println("[1 - Preço] - [2 - Descrição] - [3 - Quantidade] - [4 - Informação Extra]");
						int campo = Integer.parseInt(sc.nextLine());
						
						if (campo < 1 || campo > 4) {
							System.out.println("\nOpção inválida!\n");
							System.out.println("Campos Editáveis:");
							System.out.println("[1 - Preço] - [2 - Descrição] - [3 - Quantidade] - [4 - Informação Extra]");
							campo = Integer.parseInt(sc.nextLine());
						}
				
						System.out.println("Digite a nova informação:");
						String novaInfo = sc.nextLine();
						estoque.alteraInfoProduto(id, campo, novaInfo, file);

					} else if (option == 5) {
						System.out.println("Digite o id do produto:");
						int id = Integer.parseInt(sc.nextLine());
						estoque.verificaSeOIdExiste(id);

						System.out.println("Digite a quantidade de itens vendidos:");
						int quantidadeVendida = Integer.parseInt(sc.nextLine());

						estoque.verificaQuantidadeEmEstoque(id, quantidadeVendida);
						estoque.venderProduto(id, quantidadeVendida, file);

					} else if (option == 6) {
						estoque.printSalesReport();

					} else if (option == 7) {
						estoque.ordenarEstoque(file);
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("Opção inválida!\n");
			} catch (stockIsFullException e) {
				System.out.println(e);
			} catch (idAlreadyExistsException e) {
				System.out.println(e);
			} catch (idDoesntExistException e) {
				System.out.println(e);
			} catch (outOfStockException e) {
				System.out.println(e);
			}
		}
		sc.close();
	}
}