package unisinos;

public class Diversos extends Produto {
	
	private String infoExtra;
		
	public Diversos(int id, double preco, String descricao, int quantidadeEmEstoque, int quantidadeVendida, String tipo,
			String infoExtra) {
		super(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida, tipo);
		this.infoExtra = infoExtra;
	}

	public String getInfoExtra() {
		return infoExtra;
	}

	public void setInfoExtra(String infoExtra) {
		this.infoExtra = infoExtra;
	}
	
	@Override
	public String getExtraInfo() {
		return infoExtra;
	}
	
	@Override
	public void setExtraInfo(String infoExtra) {
		this.infoExtra = infoExtra;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipo() + "\n" + "Descricao: " + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "ID: " + this.getId() + "\n" + "Quantidade: " + this.getQuantidadeEmEstoque() + "\n" + "Vendas: " +
				this.getQuantidadeVendida() + "\n" + "Informacao Extra: " + infoExtra; 
	}
}
