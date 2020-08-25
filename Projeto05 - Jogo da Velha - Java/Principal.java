package exercicios_aula02;

public class Principal {

	static Teclado t = new Teclado();

	public static void main(String[] args) {

		Jogador jogador1 = new Jogador('X');
		System.out.println("");
		Jogador jogador2 = new Jogador('O');
		System.out.println("");

		System.out.println(jogador1);
		System.out.println("");
		System.out.println(jogador2);

		JogoDaVelha jogoDaVelha = new JogoDaVelha(t.leInt("\nQual Tamanho do Tabuleiro?"));
		System.out.println("");

		boolean vencedor = false;

		while (!vencedor) {
			String winner = jogoDaVelha.realizaJogada();
			if (winner.equals("Jogador 1")) {
				jogador1.isWinner();
				System.out.println(jogador1);
			} else {
				jogador2.isWinner();
				System.out.println(jogador2);
			}
			System.out.println("\nContinuar para mais um jogo?");
			String opcao = t.leString("[Sim] [Não]");
			if (opcao.equalsIgnoreCase("sim")) {
				jogoDaVelha.reset();
				vencedor = false;
			} else {
				vencedor = true;
				System.out.println("\nPlacar:\n");
				System.out.println(jogador1);
				System.out.println("");
				System.out.println(jogador2);
				Jogador bestPlayer = jogador1.getPontos() > jogador2.getPontos() ? jogador1 : jogador2;
				System.out.println("\nO campeão é o " + bestPlayer);
			}
		}
	}
}
