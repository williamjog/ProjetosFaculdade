package trabalhoGB;

public class Servidor {

	private String nomeServidor;
	private CaixaPostal[] caixasPostais;
	private int totCaixasPostais;

	public Servidor(String nomeServidor, int tamanhoDoArray) {
		this.nomeServidor = nomeServidor;
		this.caixasPostais = new CaixaPostal[tamanhoDoArray];
		totCaixasPostais = 0;
	}

	public CaixaPostal getCaixasPostais(int i) {
		return caixasPostais[i];
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public void setCaixasPostais(CaixaPostal[] caixasPostais) {
		this.caixasPostais = caixasPostais;
	}

	public int getTotCaixasPostais() {
		return totCaixasPostais;
	}

	public void setTotCaixasPostais(int totCaixasPostais) {
		this.totCaixasPostais = totCaixasPostais;
	}

	public boolean addCx(CaixaPostal caixaPostal) {
		if (totCaixasPostais < caixasPostais.length) {
			caixasPostais[totCaixasPostais] = caixaPostal;
			totCaixasPostais++;
			return true;
		}
		return false;
	}

	public CaixaPostal getCx(String nomeDoDono) {
		for (int i = 0; i < totCaixasPostais; i++) {
			if (caixasPostais[i].getNomeDono().equalsIgnoreCase(nomeDoDono)) {
				return caixasPostais[i];
			}
		}
		return null;
	}

	public String showCxsPostais() {
		String acumuladora = "";
		for (int i = 0; i < totCaixasPostais; i++) {
			acumuladora += caixasPostais[i];
		}
		return acumuladora;
	}

	@Override
	public String toString() {
		return "****************************************" + "\n" + "SERVIDOR: " + nomeServidor + "\n\n"
				+ showCxsPostais();
	}
}
