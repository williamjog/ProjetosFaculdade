package trabalhoGB;

public class ISP {

	private Servidor[] servidores;
	private int totServidores;

	public ISP(int tamanhoDoArray) {
		servidores = new Servidor[tamanhoDoArray];
		totServidores = 0;
		insereServidor(new Servidor("admin", 1));
		getServidor("admin").addCx(new CaixaPostal("postman", 100, 100));
	}

	public int getTotServidores() {
		return totServidores;
	}

	public boolean insereServidor(Servidor servidor) {
		if (totServidores < servidores.length) {
			servidores[totServidores] = servidor;
			totServidores++;
			return true;
		} else {
			return false;
		}
	}

	private int procuraServidor(String nomeServidor) {
		for (int i = 0; i < totServidores; i++) {
			if (servidores[i].getNomeServidor().equalsIgnoreCase(nomeServidor)) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeServidor(String nomeServidor) {
		if (procuraServidor(nomeServidor) > 0) {
			servidores[procuraServidor(nomeServidor)] = servidores[totServidores - 1];
			totServidores--;
			return true;
		}
		return false;
	}

	public Servidor getServidor(String nomeServidor) {
		for (int i = 0; i < totServidores; i++) {
			if (servidores[i].getNomeServidor().equalsIgnoreCase(nomeServidor)) {
				return servidores[i];
			}
		}
		return null;
	}

	public Servidor getServidor(int indice) {
		return servidores[indice];
	}

	public String showAll() {
		String string = "";
		for (int i = 0; i < totServidores; i++) {
			string += servidores[i];
		}
		return string;
	}

	private CaixaPostal procuraCx(String destinatario) {
		CaixaPostal cxAux = null;
		String nomeDono = destinatario.split("@")[0];
		String nomeServidor = destinatario.split("@")[1];
		Servidor servAux = getServidor(nomeServidor);
		if (servAux != null) {
			cxAux = servAux.getCx(nomeDono);
		}
		return cxAux;
	}

	private void enviarEmailsDoPostman() {
		for (int n = 0; n < servidores[0].getCaixasPostais(0).getTotEmailsCxSaida(); n++) {
			Email emailDoPostMan = servidores[0].getCaixasPostais(0).getCaixaDeSaida()[n];
			for (int e = 0; e < emailDoPostMan.destinatarios.length; e++) {
				CaixaPostal cpProcurada = procuraCx(emailDoPostMan.getDestinatarios()[e]);
				cpProcurada.receive(emailDoPostMan);
			}
		}
		servidores[0].getCaixasPostais(0).setTotEmailsCxSaida(0);
	}
	
	public void sendReceive() {
		for (int i = 1; i < totServidores; i++) {
			for (int j = 0; j < servidores[i].getTotCaixasPostais(); j++) {
				for (int k = 0; k < servidores[i].getCaixasPostais(j).getTotEmailsCxSaida(); k++) {
					Email em = servidores[i].getCaixasPostais(j).getCaixaDeSaida()[k];
					String remetente = em.getRemetente();
					em.setRemetente(remetente + "@" + servidores[i].getNomeServidor());
					for (int m = 0; m < em.getDestinatarios().length; m++) {
						CaixaPostal cpProcurada = procuraCx(em.getDestinatarios()[m]);
						if (cpProcurada != null) {
							if (cpProcurada.isFull()) {
								servidores[0].getCaixasPostais(0)
										.send(new Email("postman" + "@" + servidores[0].getNomeServidor(),
												new String[] { remetente + "@" + servidores[i].getNomeServidor() },
												"Erro de Envio - Caixa de entrada do destinatario" + " " + "'"
														+ cpProcurada.getNomeDono() + "@"
														+ servidores[i].getNomeServidor() + "'" + " " + "está cheia!",
												em.corpoDoEmail));
							} else {
								cpProcurada.receive(em);
							}
						} else {
							servidores[0].getCaixasPostais(0)
									.send(new Email("postman" + "@" + servidores[0].getNomeServidor(),
											new String[] { remetente + "@" + servidores[i].getNomeServidor() },
											"Erro de Envio - Endereço " + "'" + em.getDestinatarios()[m] + "'"
													+ " incorreto ou inexistente!",
											em.corpoDoEmail));
						}
					}
				}
				servidores[i].getCaixasPostais(j).setTotEmailsCxSaida(0);
			}
		}
		enviarEmailsDoPostman();
	}
}
