package exercicios_aula_11;

public class Eletrodomestico extends Produto {

	private double valorDeIPI;
	private String produto;

	public Eletrodomestico(double preco, String descricao, String tipo, double valorDeIPI, String produto) {
		super(preco, descricao, tipo);
		this.valorDeIPI = valorDeIPI;
		this.produto = produto;
	}

	public double getValorDeIPI() {
		return valorDeIPI;
	}

	public void setValorDeIPI(int valorDeIPI) {
		this.valorDeIPI = valorDeIPI;
	}

	@Override
	public String toString() {
		return "Produto: " + produto + "\n" + "Descricao:" + this.getDescricao() + "\n" + "Preço: R$ " + getPreco()
				+ "\n" + "Valor do IPI: R$ " + valorDeIPI + "\n";
	}
}
