package exercicios_aula_11;

public class Vestuario extends Produto {

	private int quantidadeEmEstoque;
	private String produto;

	public Vestuario(double preco, String descricao, String tipo, int quantidadeEmEstoque, String produto) {
		super(preco, descricao, tipo);
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.produto = produto;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	@Override
	public String toString() {
		return "Produto: " + produto + "\n" + "Quantidade: " + quantidadeEmEstoque + "\n";
	}
}
