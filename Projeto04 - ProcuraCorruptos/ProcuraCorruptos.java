package grauBFinal;

public class ProcuraCorruptos {

	private Deputado[] deputados;

	public ProcuraCorruptos(int numeroDeDeputados) {
		this.deputados = new Deputado[numeroDeDeputados];
	}

	public Deputado getDeputados(int i) {
		return deputados[i];
	}

	public Deputado[] getDeputados() {
		return deputados;
	}

	public void setDeputados(Deputado[] deputados) {
		this.deputados = deputados;
	}

	public Deputado[] deputadosComMaisFuncionarios() {
		Deputado[] deputadosComFuncionarioFantasmas = new Deputado[10];
		for (int i = 0; i < deputados.length; i++) {
			if (deputados[i].getFuncionarios().length > 10) {
				deputadosComFuncionarioFantasmas[i] = deputados[i];
			}
		}
		return deputadosComFuncionarioFantasmas;
	}

	public Deputado[] deputadosQueRecebemValores() {
		Deputado[] deputadosQueFazemRachadinha = new Deputado[10];
		for (int i = 0; i < deputados.length; i++) {
			for (int j = 0; j < deputados[i].getFuncionarios().length; j++) {
				if (deputados[i].getFuncionarios(j)
						.getSalarioLiquido() < (deputados[i].getFuncionarios(j).getSalarioBruto() * 0.70)) {
					deputadosQueFazemRachadinha[i] = deputados[i];
					break;
				}
			}
		}
		return deputadosQueFazemRachadinha;
	}

	public Deputado[] deputadosQueDesviamVerbas() {
		Deputado[] deputadosCaixaDois = new Deputado[10];
		for (int i = 0; i < deputados.length; i++) {
			if (deputados[i].getSalarioLiquido() > deputados[i].getSalarioBruto80()) {
				deputadosCaixaDois[i] = deputados[i];
			}
		}
		return deputadosCaixaDois;
	}
}
