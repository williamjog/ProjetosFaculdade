package unisinos;

public abstract class Produto {
	
	private int id;
	private double preco;
	private String descricao;
	private int quantidadeEmEstoque;
	private int quantidadeVendida;
	private String tipo;
		
	public Produto(int id, double preco, String descricao, int quantidadeEmEstoque, int quantidadeVendida,
			String tipo) {
		super();
		this.id = id;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.quantidadeVendida = quantidadeVendida;
		this.tipo = tipo;
	}
		
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public String getExtraInfo() {
		return "inter";
	}
	
	public void setExtraInfo(String infoExtra) {
		return;
	}
	
	public String writeProduct() { 
		return  Integer.toString(id) + " * " + Double.toString(preco) + " * " + descricao + " * "
				+ Integer.toString(quantidadeEmEstoque) + " * " + Integer.toString(quantidadeVendida) + " * "
				+ tipo + " * " + this.getExtraInfo() + "\n";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
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

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipo() + "\n" + "Descricao: " + this.getDescricao() + "\n" + "Preco: R$ " + this.getPreco()
				+ "\n" + "ID: " + this.getId() + "\n" + "Quantidade: " + this.getQuantidadeEmEstoque() + "\n";
	}
}