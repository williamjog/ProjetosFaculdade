package trabalhoGB;

public class Teste {

	public static void main(String[] args) {

		ISP isp = new ISP(10);

		isp.insereServidor(new Servidor("kmail.com", 10));
		isp.insereServidor(new Servidor("oi.com", 10));

		isp.getServidor("kmail.com").addCx(new CaixaPostal("jonas", 20, 20));
		isp.getServidor("kmail.com").addCx(new CaixaPostal("william", 10, 10));
		isp.getServidor("oi.com").addCx(new CaixaPostal("carlos", 20, 1));
		isp.getServidor("oi.com").addCx(new CaixaPostal("eduardo", 20, 20));

		isp.getServidor("kmail.com").getCx("jonas")
				.send(new Email("jonas", new String[] { "carloss@oi.com", "eduardo@oi.com", "willian@kmail.com" },
						"Balanco Comercial", "Parabens a todos, nosso balanco foi positivo!"));

		isp.getServidor("kmail.com").getCx("william")
				.send(new Email("william", new String[] { "eduardo@oi.com", "jonas@kmail.com", "carlos@oi.com" },
						"Trabalho do GrauB", "Ufa, terminei! Bora beber gurizada!"));

		isp.getServidor("oi.com").getCx("carlos")
				.send(new Email("carlos", new String[] { "william@kmail.com", "jonas@kmail.com" }, "Orcamento",
						"O nosso orcamento esta estourado!!!!"));

		isp.getServidor("oi.com").getCx("eduardo")
				.send(new EmailComAnexo("eduardo",
						new String[] { "carlos@oi.com", "jonas@kmail.com", "william@kmail.com" }, "Cronograma",
						"Pessoal, segue em anexo o cronograma do mes.", "Cronograma.pdf"));

		isp.sendReceive();

		System.out.println(isp.showAll());
	}
}