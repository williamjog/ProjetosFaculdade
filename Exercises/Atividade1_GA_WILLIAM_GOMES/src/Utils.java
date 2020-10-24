public class Utils {
	
	public static String generateRandomParty() {
		int x = (int) (Math.random() * 10);
		switch (x) {
		case 0:
			return "PSDB";
		case 1:
			return "PT";
		case 2:
			return "PCO";
		case 3:
			return "NOVO";
		case 4:
			return "MDB";
		case 5:
			return "PSOL";
		case 6:
			return "PCC";
		case 7:
			return "Partido Comunista de Iphone";
		default:
			return "Centrão";
		}
	}
		
	public static String generateRandomName() {
		int nameLength = 1 + (int) (Math.random() * 15);
		String nome = "";
		for (int i = 0; i < nameLength; i++) {
			nome += (char) (65 + Math.random() * 26); // Gera uma letra Maíscula com base no seu código da tabela ASCII
		}
		return nome;
	}
	
	public static IBOPE survey(int idDaPesquisa) {
		IBOPE survey = new IBOPE(idDaPesquisa);
		int surveySize = (int) (1500 + Math.random() * 500);
		survey.setEleitores(surveySize);
		
		int votes = (int) (Math.random() * 100);
		int sumOfVotes = votes;
		
		survey.adicionaCandidato(new Candidato("Branco", "Branco", votes));
		
		votes = (int) (Math.random() * 100);
		sumOfVotes += votes;
		
		survey.adicionaCandidato(new Candidato("Indecisos", "Indecisos", votes));
		
		int numberOfCandidates = (int) (Math.random() * 1000 + 1);
		for (int i = 1; i <= numberOfCandidates; i++) {
			if (sumOfVotes < surveySize) {
				votes = ((int) (Math.random() * 10000)) % (surveySize - sumOfVotes + 1);
				sumOfVotes += votes;
				survey.adicionaCandidato(new Candidato(generateRandomName(), generateRandomParty(), votes));
			} else {
				survey.adicionaCandidato(new Candidato(generateRandomName(), generateRandomParty(), 0));
			}
			if (i == numberOfCandidates && sumOfVotes < surveySize) {
				survey.adicionaCandidato(new Candidato(generateRandomName(), generateRandomParty(), (surveySize - sumOfVotes)));
			}
		}
		return survey;	
	}
}
