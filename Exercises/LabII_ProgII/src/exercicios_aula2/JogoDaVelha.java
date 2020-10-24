package exercicios_aula2;

public class JogoDaVelha {

	Teclado t = new Teclado();

	private int tamanhoDoTabuleiro;
	private char tabuleiro[][];

	public JogoDaVelha(int tamanhoDoTabuleiro) {
		this.tamanhoDoTabuleiro = tamanhoDoTabuleiro;
		this.tabuleiro = new char[tamanhoDoTabuleiro][tamanhoDoTabuleiro];
	}

	public JogoDaVelha() {
		this.tamanhoDoTabuleiro = 3;
		this.tabuleiro = new char[tamanhoDoTabuleiro][tamanhoDoTabuleiro];
	}

	public int getTamanhoDoTabuleiro() {
		return tamanhoDoTabuleiro;
	}

	public void setTamanhoDoTabuleiro(int tamanhoDoTabuleiro) {
		this.tamanhoDoTabuleiro = tamanhoDoTabuleiro;
	}

	private String verificalinhas() {
		for (int i = 0; i < tabuleiro.length; i++) {
			int X = 0;
			int O = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == 'X') {
					X++;
				} else if (tabuleiro[i][j] == 'O') {
					O++;
				}
			}
			if (X >= tabuleiro.length) {
				return "Jogador 1";
			} else if (O >= tabuleiro.length) {
				return "Jogador 2";
			}
		}
		return "";
	}

	private String verificaColunas() {
		int X = 0;
		int O = 0;
		int j = 0;
		while (j < tabuleiro.length) {
			X = 0;
			O = 0;
			for (int i = 0; i < tabuleiro.length; i++) {
				if (tabuleiro[i][j] == 'X') {
					X++;
				} else if (tabuleiro[i][j] == 'O') {
					O++;
				}
			}
			if (j < tabuleiro.length) {
				j++;
			}

			if (X >= tabuleiro.length) {
				return "Jogador 1";
			} else if (O >= tabuleiro.length) {
				return "Jogador 2";
			}
		}
		return "";
	}

	private String verificaDiagonalPrincipal() {
		int X = 0;
		int O = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][i] == 'X') {
				X++;
			} else if (tabuleiro[i][i] == 'O') {
				O++;
			}
		}
		if (X >= tabuleiro.length) {
			return "Jogador 1";
		} else if (O >= tabuleiro.length) {
			return "Jogador 2";
		}
		return "";
	}

	private String verificaDiagonalSecundaria() {
		int X = 0;
		int O = 0;
		int i = 0;
		for (int j = tamanhoDoTabuleiro - 1; j >= 0; j--) {
			if (tabuleiro[i][j] == 'X') {
				X++;
			} else if (tabuleiro[i][j] == 'O') {
				O++;
			}
			i++;
		}
		if (X >= tabuleiro.length) {
			return "Jogador 1";
		} else if (O >= tabuleiro.length) {
			return "Jogador 2";
		}
		return "";
	}

	public String realizaJogada() {
		String winner = "";
		int counter = 0;
		boolean vencedor = false;
		while (!vencedor) {
			char symbol = counter % 2 == 0 ? 'X' : 'O';
			String jogador = counter % 2 == 0 ? "Jogador 1" : "Jogador 2";
			System.out.println("\nÉ a vez do " + jogador);
			int linha = t.leInt("\nLinha:");
			int coluna = t.leInt("Coluna:");
			if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O') {
				tabuleiro[linha][coluna] = symbol;
				counter++;
				System.out.println('\n' + toString());
				winner = verificaGanhador();
				if (winner == "") {
					vencedor = false;
				} else {
					vencedor = true;
				}
			} else {
				System.out.println("Essa posição está preenchida!\n");
			}
		}
		return winner;
	}

	public String verificaGanhador() {
		String holder;
		if ((holder = verificalinhas()) != "" || (holder = verificaColunas()) != ""
				|| (holder = verificaDiagonalPrincipal()) != "" || (holder = verificaDiagonalSecundaria()) != "") {
			System.out.printf("O vencendor foi o %s.\n\n", holder);
			return holder;
		}
		return "";
	}

	public void reset() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}

	@Override
	public String toString() {
		String fotoDoTabuleiro = "";
		for (int i = 0; i < tamanhoDoTabuleiro; i++) {
			for (int j = 0; j < tamanhoDoTabuleiro; j++) {
				fotoDoTabuleiro += tabuleiro[i][j] + " | ";
			}
			fotoDoTabuleiro += '\n';
		}
		return fotoDoTabuleiro;
	}
}
