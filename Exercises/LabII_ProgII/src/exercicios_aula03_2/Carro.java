package exercicios_aula03_2;

public class Carro extends Veiculo {
	
	int anoDeFabricacao;

	public Carro(double velocidadeMaxima, double preco, int anoDeFabricacao) {
		super(velocidadeMaxima, preco);
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}
	
	@Override
	public String toString() {
		return "Velocidade M�xima: " + getVelocidadeMaxima() + " Km/h" + '\n' +
				"Pre�o: R$ " + getPreco() + '\n' +
				"Ano de Fabrica��o: " + anoDeFabricacao + '\n';
	}
}
