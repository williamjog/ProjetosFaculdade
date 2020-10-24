package unisinos;

public class Eletronico extends Produto {
	
	private String voltagem;
			
	public Eletronico(int id, double preco, String descricao, int quantidadeEmEstoque, int quantidadeVendida,
			String tipo, String voltagem) {
		super(id, preco, descricao, quantidadeEmEstoque, quantidadeVendida, tipo);
		this.voltagem = voltagem;
	}

	public String getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(String voltagem) {
		this.voltagem = voltagem;
	}
	
	@Override
	public String getExtraInfo() {
		return voltagem;
	}
	
	@Override
	public void setExtraInfo(String infoExtra) {
		this.voltagem = infoExtra;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipo() + "\n" + "Descricao: " + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "ID: " + this.getId() + "\n" + "Quantidade: " + this.getQuantidadeEmEstoque() + "\n" + "Vendas: " +
				this.getQuantidadeVendida() + "\n" + "Voltagem: " + voltagem; 
	}	

}