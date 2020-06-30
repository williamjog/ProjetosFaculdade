package unisinos;

public class Editora {
	
	private String nome;
	private int codigoEditora;
	
	public Editora(String nome, int codigoEditora) {
		this.nome = nome;
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	@Override
	public String toString() {
		return "Editora: " + nome + "\n" +
				"Codigo da Editora: " + codigoEditora;
	}
	
	@Override
	public boolean equals(Object o) {		
		if (this == o) return true;  
		Editora e = (Editora) o;	    
	    return this.nome.equals(e.getNome()) && this.codigoEditora == e.getCodigoEditora();
	}
}
