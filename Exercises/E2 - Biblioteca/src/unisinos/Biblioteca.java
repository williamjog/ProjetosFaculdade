package unisinos;

public class Biblioteca {
	
	private Livro[] arrayLivros;
	private int totLivros;
	private int tamLivros;
	private Editora[] arrayEditoras;
	private int totEdits;
	private int tamEdits;
	
	public Biblioteca(int tamLivros, int tamEdits) {
		this.tamLivros = tamLivros;
		this.tamEdits = tamEdits;
		this.arrayEditoras = new Editora[tamEdits];
		this.arrayLivros = new Livro[tamLivros];
		totLivros = 0;
		totEdits = 0;
	}
	
	public boolean insereLivro(Livro livro) {	
		boolean naoExiste = true;
		if (totLivros < tamLivros) {
			for (int i = 0 ; i < totEdits ; i++) {
				if (arrayEditoras[i].getCodigoEditora() == livro.getCodEditora()) {
					for (int j = 0 ; j < totLivros ; j++) {
						if (arrayLivros[j].getNome().equalsIgnoreCase(livro.getNome())) {
							System.out.println("Livro ja cadastrado!");
							naoExiste = false;
							return false; 
						} 				
				} if (naoExiste) {
					arrayLivros[totLivros] = livro;
					totLivros ++;
					System.out.println("Livro " + livro.getNome() + " cadastrado!");
					return true;
				}
			  }							
			} System.out.println("Codigo de editora ainda nao cadastrado.");
			  return false;			  
		} System.out.println("Cadastro lotado.");
		  return false;
	}
	
	
	public boolean removeLivroPeloNome(String nomeLivro) {
		int i = 0;
		if (totLivros > 0) {
			for (Livro l : arrayLivros) {
				if (l.getNome().equalsIgnoreCase(nomeLivro)) {
					if (totLivros == 1) {
						totLivros--;
						System.out.println(nomeLivro + " " + "Removido!");
						return true;
					} else {
						arrayLivros[i] = arrayLivros[totLivros - 1];
						System.out.println(nomeLivro + " " + "Removido!");
						totLivros --;
						return true;
					}
				  } i++; 
			   } 	System.out.println("Erro - Livro nao encontrado."); 
			        return false;
		     } System.out.println("Cadastro de livros vazio!");
			   return false;
           } 
	 
		
	public boolean removeLivroPelaEditora(int codEditora) {
		while(removeLivro(codEditora)) {
	  }
		return true;
  }		
			
	
	private int procuraLivro(int codigodaEditora) {
		for (int i = 0 ; i < totLivros ; i++) {
			if (arrayLivros[i].getCodEditora() == codigodaEditora) {
				return i;
			}
		} return -1;	
	}
	
	private boolean removeLivro(int codEditora) {
			if (procuraLivro(codEditora) >= 0) {
				if (totLivros == 1) {
					System.out.println("Livro: " + arrayLivros[procuraLivro(codEditora)].getNome() + " Removido!");
					totLivros--;
					return true;
				} else {
					System.out.println("Livro: " + arrayLivros[procuraLivro(codEditora)].getNome() + " Removido!");
					arrayLivros[procuraLivro(codEditora)] = arrayLivros[totLivros - 1];
					totLivros --;
					return true;		
			}
		} return false;	
	}
				
	
	public void listaLivros() {
		if (totLivros < 1) {
			System.out.println("\nCadastro vazio.");
		} else {
			for (int i = 0; i < totLivros ; i++) {
				System.out.println("\n" + arrayLivros[i]);
				System.out.println("Editora: " + (nomedaEditora(arrayLivros[i].getCodEditora())));
		} 
	} 	
}
	
	private String nomedaEditora(int codigoEditora) {
		for (int i = 0 ; i < totEdits ; i++) {
			if (arrayEditoras[i].getCodigoEditora() == codigoEditora) {
				String editora = arrayEditoras[i].getNome();
				return editora;
			}
		} return "Nao encontrado";
	 }
	

	public boolean insereEditora(Editora editora) {		
		boolean naoExiste = true;
		if (totEdits < tamEdits) {
			for (int i = 0 ; i < totEdits ; i++) {						
				if (arrayEditoras[i].getNome().equalsIgnoreCase(editora.getNome()) || 
						arrayEditoras[i].getCodigoEditora() == editora.getCodigoEditora()) {
							System.out.println("ERRO - Editora ou codigo ja cadastrado!");
							naoExiste = false;
							return false; 
						} 				
				} if (naoExiste) {
					arrayEditoras[totEdits] = editora;
					totEdits ++;
					System.out.println("Editora " + editora.getNome() + " cadastrada!");
					return true;
				}
			  }	System.out.println("ERRO - Cadastro lotado.");
			    return false;
			} 
	
	public boolean removeEditora(int codigoEditora) {
		if (totEdits > 0) {
		for (int i = 0 ; i < totEdits ; i++) {
			if (arrayEditoras[i].getCodigoEditora() == codigoEditora) {
				if (totEdits == 1) {
					totEdits --;
					System.out.println("Editora: " + arrayEditoras[i].getNome() + " Removida!");
				 } else {
					 System.out.println("Editora " + arrayEditoras[i].getNome() + " Removida!");
					 arrayEditoras[i] = arrayEditoras[totEdits -1];
					 totEdits --;
			 }
		  } 
		} removeLivroPelaEditora(codigoEditora);
		  return true;
	  }	System.out.println("Cadastro vazio!");
		return false;
   }		
		
	
	public void listaEditoras() {
		if (totEdits < 1) {
			System.out.println("Cadastro vazio.");
		} else {
			for (int i = 0 ; i < totEdits ; i++)
				System.out.println("\n" + arrayEditoras[i]);
		}	
	} 						
}
