package exercicios_aula02;

public class Jogador {

	Teclado t = new Teclado();

	private String nome;
	private int pontos;
	private char symbol;

	public Jogador(char symbol) {
		this.nome = t.leString("Qual o seu nome?");
		this.pontos = 0;
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public void isWinner() {
		pontos++;
	}

	@Override
	public String toString() {
		return "Jogador: " + nome + "\n" + "Pontos: " + pontos;
	}
}
