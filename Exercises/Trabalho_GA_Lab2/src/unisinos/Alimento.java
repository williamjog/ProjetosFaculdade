package unisinos;

public class Alimento extends Produto {
	
	private String peso;

	public Alimento(int id, double preco, String descricao, int quantidadeEmEstoque, int quantidadeVendida, String tipo,
			String peso) {
		super(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida, tipo);
		this.peso = peso;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	@Override
	public String getExtraInfo() {
		return peso;
	}
	
	@Override
	public void setExtraInfo(String infoExtra) {
		this.peso = infoExtra;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipo() + "\n" + "Descricao: " + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "ID: " + this.getId() + "\n" + "Quantidade: " + this.getQuantidadeEmEstoque() + "\n" + "Vendas: " +
				this.getQuantidadeVendida() + "\n" + "Peso em Gramas: " + peso; 
	}
}
