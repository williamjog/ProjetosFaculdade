public class PrincipalIBOPE {

	public static void main(String[] args) {
	
		IBOPE ibope = Utils.survey(20200904);
		
		ibope.showSurveyResults(); //Mostra todos os candidatos da pesquisa e seus respectivos votos
		
		System.out.println("Total de Votos: " + ibope.sumOfVotes()); // Comparando o numero de eleitores e votos
		System.out.println("Total de Eleitores: " + ibope.getEleitores()); // Comparando o numero de eleitores e votos
		System.out.println("Total de Candidatos: " + ibope.getTotCandidatos() + "\n");
		
		try {
			System.out.println("O Candidato mais bem colocado da pesquisa IBOPE " + ibope.getIdDaPesquisa() + " foi: ");
			System.out.println(ibope.candidatoMaisBemColocado());
		}
		catch (ArrayNotPossibleException e) {
			System.out.println(e.getMessage());
		}		
	}
}
