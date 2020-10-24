package unisinos;

public class Livro {
	
	private String nome;
	private String autor;
	private int codEditora;
	private int numeroPaginas;
	
	public Livro(String nome, String autor, int codEditora, int numeroPaginas) {
		this.nome = nome;
		this.autor = autor;
		this.codEditora = codEditora;
		this.numeroPaginas = numeroPaginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCodEditora() {
		return codEditora;
	}

	public void setCodEditora(int codEditora) {
		this.codEditora = codEditora;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	@Override
	public String toString() {
		return "Nome do Livro: " + nome + "\n"
				+ "Autor: " + autor + "\n"
				+ "Numero de paginas: " + numeroPaginas;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;       
        Livro l = (Livro) o;
        return this.nome.equals(l.getNome()) && this.autor.equals(l.getAutor()) 
        		&& this.codEditora == l.getCodEditora() && this.numeroPaginas == l.getNumeroPaginas();  
	}	
}
