package unisinos;

public class Textil extends Produto {
	
	private String marca;

	public Textil(int id, double preco, String descricao, int quantidadeEmEstoque, int quantidadeVendida, String tipo,
			String marca) {
		super(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida, tipo);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String getExtraInfo() {
		return marca;
	}
	
	@Override
	public void setExtraInfo(String infoExtra) {
		this.marca = infoExtra;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipo() + "\n" + "Descricao: " + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "ID: " + this.getId() + "\n" + "Quantidade: " + this.getQuantidadeEmEstoque() + "\n" + "Vendas: " 
				+ this.getQuantidadeVendida() +	"\n" + "Marca: " + marca; 
	}	
}
