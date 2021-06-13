import java.io.FileNotFoundException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	
	// Desenvolvido por William Gomes e Iohanna

	public static void main(String[] args) {
		
		String file = "C:\\Users\\willi\\Desktop\\pessoas.txt"; // No meu PC deixei na área de trabalho.
		
		ArvoreAVL arvore = new ArvoreAVL();
		
		try {
			
			arvore.carregarPessoas(file);
			
			Scanner sc = new Scanner(System.in);
			
			boolean opcaoMenu = true;
			
			while(opcaoMenu) {
				System.out.println("DIGITE A OPÇÃO ESCOLHIDA:");
				System.out.println("1 - [Consultar CPF] \n2 - [Consultar pessoas pelo nome]\n3 - [Consultar pessoas por Data de Nascimento]\n4 - [Sair]");
				
				try {
					int opcao = Integer.parseInt(sc.nextLine());
					
					switch (opcao) {
					
					case 1: 
						System.out.println("\nDigite o CPF da pessoa: \n");
						long CPF = Long.parseLong(sc.nextLine());
						Node pessoaProcurada = arvore.procurarPessoaPeloCPF(CPF);
						
						if (pessoaProcurada != null) {
							System.out.println("\n" + pessoaProcurada.getChave());
						} else {
							System.out.println("CPF não encontrado!\n");
						}
						break;
					
					case 2:
						System.out.println("\nDigite o nome desejado: ");
						String nomeProcurado = sc.nextLine();
						
						System.out.println("\n[");
						arvore.procurarPessoaPeloNome(nomeProcurado);
						System.out.println("]\n");
						break;
					
					case 3:
						System.out.println("\nDigite a data inicial: ");
						String primeiraData = sc.nextLine();
						
						System.out.println("\nDigite a data final: ");
						String segundaData = sc.nextLine();
						
						SimpleDateFormat data1 = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat data2 = new SimpleDateFormat("dd/MM/yyyy");
						
						Date dataInicial = data1.parse(primeiraData);
						Date dataFinal = data2.parse(segundaData);
						
						System.out.println("\n[\n");
						arvore.procurarPessoasPelaDataDeNascimento(dataInicial,dataFinal);
						System.out.println("]\n");
						break;
					
					case 4: 
						opcaoMenu = false;
						System.out.println("Programa encerrado.");
						break;	
						
					default:
						System.out.println("Digite os dados corretamente! \n");
						break;
					}		
					
				} catch (Exception NumberFormatException) {
					System.out.println("Digite os dados corretamente! \n");
				}
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    } 
}
