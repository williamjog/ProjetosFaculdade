public class Candidato {

	private String nome;
	private String partido;
	private int qtdIntencoesDeVoto;
		
	public Candidato(String nome, String partido, int qtdIntencoesDeVoto) {
		this.nome = nome;
		this.partido = partido;
		this.qtdIntencoesDeVoto = qtdIntencoesDeVoto;
	}
	
	public Candidato() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getQtdIntencoesDeVoto() {
		return qtdIntencoesDeVoto;
	}

	public void setQtdIntencoesDeVoto(int qtdIntencoesDeVoto) {
		this.qtdIntencoesDeVoto = qtdIntencoesDeVoto;
	}

	@Override
	public String toString() {
		return  "Candidato: " + nome + "\n" +
				"Partido: " + partido + "\n" +
				"Intenções de Voto: " + qtdIntencoesDeVoto;
	}
}
