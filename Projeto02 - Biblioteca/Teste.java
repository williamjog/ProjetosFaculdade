package unisinos; 

public class Teste {

	static Teclado t = new Teclado(); 
										
	public static void main(String[] args) {
		
		Biblioteca bib = new Biblioteca (20,10); // Initializing a new library
		
		Editora e1 = new Editora("Planeta", 1);
		Editora e2 = new Editora("Campus", 2);
		Editora e3 = new Editora("Pearson", 3);
		
		Livro l1 = new Livro("Introducao a Computacao", "Fernando", 2, 350);
		Livro l2 = new Livro("Engenharia da Computacao", "Somerville", 3, 650);
		Livro l3 = new Livro("Computacao em Nuvem", "Cezar", 1, 445);
		
		bib.insereEditora(e1); //livros/editoras criados e inseridos para facilitar o teste do professor
		bib.insereEditora(e2); //livros/editoras criados e inseridos para facilitar o teste do professor
		bib.insereEditora(e3); //livros/editoras criados e inseridos para facilitar o teste do professor
		
		bib.insereLivro(l1); //livros/editoras criados e inseridos para facilitar o teste do professor
		bib.insereLivro(l2); //livros/editoras criados e inseridos para facilitar o teste do professor
		bib.insereLivro(l3); //livros/editoras criados e inseridos para facilitar o teste do professor
						
		boolean opcaoValida = true;	
	
	    while(opcaoValida) {
	      System.out.println("\nMENU:");
	      System.out.println("1 - Inserir livro");
	      System.out.println("2 - Remover Livro pelo Nome");
	      System.out.println("3 - Remove Livro pela Editora");
	      System.out.println("4 - Listar livros");
	      System.out.println("5 - Inserir editora");
	      System.out.println("6 - Remover editora");
	      System.out.println("7 - Listar editoras");
	      System.out.println("8 - Encerrar programa");
	      
	      int opcao = t.leInt("\nDigite uma Opcao [1 - 8]:"); 
			
	      if (opcao < 1 || opcao >= 8) {
	    	  opcaoValida = false;
	    	  System.out.println("Programa encerrado.");
	      } else {
	    	  if (opcao == 1) {
	    		  Livro livro = new Livro(t.leString("Nome do livro? "), t.leString("Autor?"), t.leInt("Codigo da editora?"), 
	    		  t.leInt("Quantas paginas?"));	    		  
	    		  bib.insereLivro(livro);
	    	  } else if (opcao == 2) {
	    		  String nomeDoLivro = t.leString("Nome do livro?");
	    		  bib.removeLivroPeloNome(nomeDoLivro);  		  
	     	  } else if (opcao == 3) {
	     		  int codigoEditora = t.leInt("Digite o codigo da editora:");
	     		  bib.removeLivroPelaEditora(codigoEditora);		
	     	  } else if (opcao == 4) {
	     		  bib.listaLivros();
	     	  } else if (opcao == 5) {
	     		  Editora editora = new Editora(t.leString("Nome da editora?"), t.leInt("Codigo?"));
	     		  bib.insereEditora(editora);
	     	  } else if (opcao == 6) {
	     		  int codEditora = t.leInt("Qual o codigo da editora?");
	     		  bib.removeEditora(codEditora);
	     	  } else if (opcao == 7) {
	     		  bib.listaEditoras();
	     	}
	      }     
		}		
	  }
    }

