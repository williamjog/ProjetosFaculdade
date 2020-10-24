public class IBOPE {
		
	private int idDaPesquisa;
	private Candidato[] array;
	private int totCandidatos;
	private int eleitores;
	
	public IBOPE(int idDaPesquisa) {
		this.idDaPesquisa = idDaPesquisa;
		this.array = new Candidato[1000];
		this.totCandidatos = 0;
	}
	
	public void adicionaCandidato(Candidato candidato) {
		if (totCandidatos == 1000) {
			System.out.println("Limite de candidatos alcançado.");
			return;
		}
		array[totCandidatos] = candidato;
		totCandidatos++;
	}
		
	private int getPositionOfWinningCandidate(Candidato[] array, int position, int winningPosition) {
		if (position > totCandidatos - 1) {
			return winningPosition;
		} else {
			winningPosition = (array[position].getQtdIntencoesDeVoto() > array[winningPosition].getQtdIntencoesDeVoto()) ?
					 winningPosition = position : winningPosition;
			return getPositionOfWinningCandidate(array, position + 1, winningPosition);
		}
	}

	public Candidato candidatoMaisBemColocado() throws ArrayNotPossibleException {
		if (totCandidatos < 1) {
			throw new ArrayNotPossibleException();
		}
		int position = getPositionOfWinningCandidate(array, 0, 0);
		return array[position];	
	}	

	public int getIdDaPesquisa() {
		return idDaPesquisa;
	}

	public void setIdDaPesquisa(int idDaPesquisa) {
		this.idDaPesquisa = idDaPesquisa;
	}

	public Candidato[] getArray() {
		return array;
	}

	public void setArray(Candidato[] array) {
		this.array = array;
	}

	public int getTotCandidatos() {
		return totCandidatos;
	}

	public void setTotCandidatos(int totCandidatos) {
		this.totCandidatos = totCandidatos;
	}

	public int getEleitores() {
		return eleitores;
	}

	public void setEleitores(int eleitores) {
		this.eleitores = eleitores;
	}
	
	public void showSurveyResults() {
		for (int i = 0; i < totCandidatos; i++) {
			System.out.println(array[i] + "\n");
		}
	}
	
	public int sumOfVotes() {
		int x = 0;
		for (int i = 0; i < totCandidatos; i++) {
			x += array[i].getQtdIntencoesDeVoto();
		}
		return x;
	}
}
