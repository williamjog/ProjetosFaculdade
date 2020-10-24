package exercicios_aula_11;

public class Alimento extends Produto {

	private String dataDeValidade;
	private String produto;

	public Alimento(double preco, String descricao, String tipo, String dataDeValidade, String produto) {
		super(preco, descricao, tipo);
		this.dataDeValidade = dataDeValidade;
		this.produto = produto;
	}

	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	@Override
	public String toString() {
		return "Produto: " + produto + "\n" + "Descricao:" + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "Data de Validade: " + dataDeValidade + "\n";
	}
}
