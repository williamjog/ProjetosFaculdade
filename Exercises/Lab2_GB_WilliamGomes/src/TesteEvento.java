import java.util.Scanner;

public class TesteEvento {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Ocupacao ocupacao = new Ocupacao();

		String file = "clientes.txt";
				
		ocupacao.lerArquivoDeClientes(file);  // le o arquivo clientes.txt e os insere na lista 	
		
		int numeroDeClientesAnterior = ocupacao.numElements();
		
		boolean validOption = true;

		while (validOption) {
			System.out.println("\nMENU:");
			System.out.println("1 - Vender Ingresso");
			System.out.println("2 - Ver fila de entrada");
			System.out.println("3 - Sair \n");
			System.out.println("Escolha uma opção do menu acima");
			
			int option = Integer.parseInt(sc.nextLine());

			if (option < 1 || option >= 3) {
				validOption = false;
				System.out.println("Programa encerrado.");
			} else {
				if (option == 1) {
					System.out.println("Digite o nome do comprador: ");
					String nomeDaPessoa = sc.nextLine();
					
					System.out.println("Digite qual a localizacao no estadio:");
					String localizacaoNoEstadio = sc.nextLine();
					
					System.out.println("Digite o tipo de ingresso: ");
					String tipo = sc.nextLine();
					
					Ingresso ingresso = new Ingresso(nomeDaPessoa, localizacaoNoEstadio, tipo);
					ocupacao.vendeIngresso(ingresso);
				}
				else if (option == 2) {
					StaticQueue filaDeEntrada = ocupacao.filaEntrada();
					filaDeEntrada.salvaFila();
					System.out.println("\n" + filaDeEntrada);
				}
			}
		}
		
		sc.close();
		
		StaticQueue filaDeEntrada = ocupacao.filaEntrada();
		filaDeEntrada.salvaFila(); 
		// garante que ao sair do programa a fila é salva com os novos compradores de ingresso.

		ocupacao.salvarClientes(file, numeroDeClientesAnterior); 
		// ao finalizar o programa, é dado append do ingresso vendido, se tiver algum ingresso vendido no menu
	}
}
