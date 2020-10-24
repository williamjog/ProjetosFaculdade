package trabalhoGB;

public class EmailComAnexo extends Email {

	private String anexo;

	public EmailComAnexo(String[] destinatarios, String assunto, String corpoDoEmail, String anexo) {
		super(destinatarios, assunto, corpoDoEmail);
		this.anexo = anexo;
	}

	public EmailComAnexo(String remetente, String[] destinatarios, String assunto, String corpoDoEmail, String anexo) {
		super(remetente, destinatarios, assunto, corpoDoEmail);
		this.anexo = anexo;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
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
					+ "Anexo: " + anexo + "\n" + "Destinatario(s): " + mostraDestinarios() + "\n";

		} else {
			return "\nAssunto: " + assunto + "\n" + "Corpo: " + corpoDoEmail + "\n" + "Anexo: " + anexo + "\n" + "\n"
					+ "Destinatario(s): " + mostraDestinarios() + "\n";
		}
	}
}
