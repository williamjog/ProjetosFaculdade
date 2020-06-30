package trabalhoGB;

public class CaixaPostal {

	private String nomeDono;
	private Email[] caixaDeSaida;
	private Email[] caixaDeEntrada;
	private int totEmailsCxSaida;
	private int totEmailsCxEntrada;

	public CaixaPostal(String nome, int tamanhoCxSaida, int tamanhoCxEntrada) {
		this.nomeDono = nome;
		this.caixaDeSaida = new Email[tamanhoCxSaida];
		this.caixaDeEntrada = new Email[tamanhoCxEntrada];
		totEmailsCxSaida = 0;
		totEmailsCxEntrada = 0;
	}

	public boolean isFull() {
		if (totEmailsCxEntrada >= caixaDeEntrada.length) {
			return true;
		}
		return false;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public int getTotEmailsCxSaida() {
		return totEmailsCxSaida;
	}

	public void setTotEmailsCxSaida(int totEmailsCxSaida) {
		this.totEmailsCxSaida = totEmailsCxSaida;
	}

	public void setTotEmailsCxEntrada(int totEmailsCxEntrada) {
		this.totEmailsCxEntrada = totEmailsCxEntrada;
	}

	public int getTotEmailsCxEntrada() {
		return totEmailsCxEntrada;
	}

	public Email[] getCaixaDeSaida() {
		return caixaDeSaida;
	}

	public Email[] getCaixaDeEntrada() {
		return caixaDeEntrada;
	}

	public boolean send(Email email) {
		if (totEmailsCxSaida < caixaDeSaida.length) {
			caixaDeSaida[totEmailsCxSaida] = email;
			totEmailsCxSaida++;
			return true;
		}
		return false;
	}

	public boolean receive(Email email) {
		if (totEmailsCxEntrada < caixaDeEntrada.length) {
			caixaDeEntrada[totEmailsCxEntrada] = email;
			totEmailsCxEntrada++;
			return true;
		}
		return false;
	}

	public String showInbox() {
		String stringAcumuladora = "";
		if (totEmailsCxEntrada > 0) {
			for (int i = 0; i < totEmailsCxEntrada; i++) {
				stringAcumuladora += caixaDeEntrada[i] + "\n";
			}
			return stringAcumuladora;
		}
		return "";
	}

	public String showOutbox() {
		String stringAcumuladora = "";
		if (totEmailsCxSaida > 0) {
			for (int i = 0; i < totEmailsCxSaida; i++) {
				stringAcumuladora += caixaDeSaida[i] + "\n";
			}
			return stringAcumuladora;
		}
		return "";
	}

	public void clearInbox() {
		totEmailsCxEntrada = 0;
	}

	@Override
	public String toString() {
		return "CAIXA POSTAL DO " + nomeDono.toUpperCase() + "\n\n" + "Caixa de Entrada: " + "\n" + showInbox()
				+ "Caixa de Saida: " + "\n" + showOutbox() + "----------------------------------------" + "\n";
	}
}
