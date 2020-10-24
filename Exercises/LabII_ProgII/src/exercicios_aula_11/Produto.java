package exercicios_aula_11;

public abstract class Produto {

	private double preco;
	private String descricao;
	private String tipo;

	public Produto(double preco, String descricao, String tipo) {
		this.preco = preco;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
