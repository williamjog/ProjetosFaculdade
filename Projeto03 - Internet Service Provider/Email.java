package trabalhoGB;

public class Email {

	protected String remetente;
	protected String[] destinatarios;
	protected String assunto;
	protected String corpoDoEmail;

	public Email(String[] destinatarios, String assunto, String corpoDoEmail) {
		this.destinatarios = destinatarios;
		this.assunto = assunto;
		this.corpoDoEmail = corpoDoEmail;
	}

	public Email(String remetente, String[] destinatarios, String assunto, String corpoDoEmail) {
		this.remetente = remetente;
		this.destinatarios = destinatarios;
		this.assunto = assunto;
		this.corpoDoEmail = corpoDoEmail;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String[] getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String[] destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpoDoEmail() {
		return corpoDoEmail;
	}

	public void setCorpoDoEmail(String corpoDoEmail) {
		this.corpoDoEmail = corpoDoEmail;
	}

	public String mostraDestinarios() {
		String string = "";
		for (int i = 0; i < destinatarios.length; i++) {
			if (destinatarios[i] != null) {
				string += destinatarios[i] + " ; ";
			}
		}
		return string;
	}

	@Override
	public String toString() {
		if (remetente != null) {
			return "Remetente: " + remetente + "\n" + "Assunto: " + assunto + "\n" + "Corpo: " + corpoDoEmail + "\n"
					+ "Destinatario(s): " + mostraDestinarios() + "\n";
		} else {
			return "Assunto: " + assunto + "\n" + "Corpo: " + corpoDoEmail + "\n" + "Destinatario(s): "
					+ mostraDestinarios() + "\n";

		}
	}
}
