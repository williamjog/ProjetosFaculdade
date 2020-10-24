package exercicios_aula3_2;

public class Veiculo {
	
	private double velocidadeMaxima;
	private double preco;
	
	
	public Veiculo(double velocidadeMaxima, double preco) {
		this.velocidadeMaxima = velocidadeMaxima;
		this.preco = preco;
	}
	
	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}
	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Velocidade Máxima: " + velocidadeMaxima + "Km/h" + '\n' +
				"Preço: R$ " + preco + '\n';
	}
}
