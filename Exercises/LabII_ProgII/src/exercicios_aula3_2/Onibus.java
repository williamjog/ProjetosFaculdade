package exercicios_aula3_2;

public class Onibus extends Veiculo {
	
	int capacidadeDePassageiros;

	public Onibus(double velocidadeMaxima, double preco, int capacidadeDePassageiros) {
		super(velocidadeMaxima, preco);
		this.capacidadeDePassageiros = capacidadeDePassageiros;
	}

	public int getCapacidadeDePassageiros() {
		return capacidadeDePassageiros;
	}

	public void setCapacidadeDePassageiros(int capacidadeDePassageiros) {
		this.capacidadeDePassageiros = capacidadeDePassageiros;
	}
	
	@Override
	public String toString() {
		return "Velocidade M�xima: " + getVelocidadeMaxima() + " Km/h" + '\n' +
				"Pre�o: R$ " + getPreco() + '\n' +
				"Capacidade: " + capacidadeDePassageiros + " passageiros" + '\n';
	}
	

}
