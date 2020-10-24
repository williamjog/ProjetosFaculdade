package grauBFinal;

public class Principal {

	public static void main(String[] args) {

		ProcuraCorruptos arrayDeDeputadosSemVergonha = new ProcuraCorruptos(10);

		arrayDeDeputadosSemVergonha.getDeputados()[0] = new Estadual("Dep 1", "PPT", 20000, 22000, 12, "RS");
		arrayDeDeputadosSemVergonha.getDeputados()[1] = new Federal("Dep 2", "PPS", 25000, 32000, 34, 123);
		arrayDeDeputadosSemVergonha.getDeputados()[2] = new Federal("Dep 3", "PLN", 10000, 8000, 3, 456);
		arrayDeDeputadosSemVergonha.getDeputados()[3] = new Federal("Dep 4", "JNF", 13000, 13000, 34, 789);
		arrayDeDeputadosSemVergonha.getDeputados()[4] = new Estadual("Dep 5", "PPL", 9000, 7200, 21, "RS");
		arrayDeDeputadosSemVergonha.getDeputados()[5] = new Estadual("Dep 6", "PIL", 22000, 17600, 10, "SP");
		arrayDeDeputadosSemVergonha.getDeputados()[6] = new Federal("Dep 7", "KML", 32000, 30000, 10, 321);
		arrayDeDeputadosSemVergonha.getDeputados()[7] = new Federal("Dep 8", "WHM", 25000, 29000, 4, 654);
		arrayDeDeputadosSemVergonha.getDeputados()[8] = new Estadual("Dep 9", "GRE", 10000, 8000, 9, "SC");
		arrayDeDeputadosSemVergonha.getDeputados()[9] = new Estadual("Dep 10", "MIO", 21000, 16800, 32, "RJ");

		for (int i = 0; i < 30; i++) {
			System.out.println(((int) (Math.random() * -2000) + (int) (Math.random() * 3000)));
		}

		for (int i = 0; i < arrayDeDeputadosSemVergonha.getDeputados().length; i++) {
			for (int j = 0; j < arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios().length; j++) {
				if (arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j].getSalarioBruto() >= 3000
						&& arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j]
								.getSalarioBruto() <= 5000) {
					System.out.println("Salario Bruto: "
							+ arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j].getSalarioBruto());
				} else {
					System.out.println("ERRO - valor fora dos parametros");
				}
			}
		}

		for (int i = 0; i < arrayDeDeputadosSemVergonha.getDeputados().length; i++) {
			for (int j = 0; j < arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios().length; j++) {
				if (arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j].getSalarioLiquido() >= 1000
						&& arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j]
								.getSalarioLiquido() <= 8000) {
					System.out.println("Salario Liquido: "
							+ arrayDeDeputadosSemVergonha.getDeputados()[i].getFuncionarios()[j].getSalarioLiquido());
				} else {
					System.out.println("ERRO - valor fora dos parametros");
				}
			}
		}

		System.out.println("DEPUTADOS QUE POSSUEM MAIS FUNCIONARIOS QUE O PERMITIDO: \n");
		for (int i = 0; i < arrayDeDeputadosSemVergonha.getDeputados().length; i++) {
			if (arrayDeDeputadosSemVergonha.deputadosComMaisFuncionarios()[i] != null) {
				System.out.println(arrayDeDeputadosSemVergonha.deputadosComMaisFuncionarios()[i]);
			}
		}

		System.out.println("\n\nQUE RECEBEM VALORES INDEVIDOS: \n");
		for (int i = 0; i < arrayDeDeputadosSemVergonha.getDeputados().length; i++) {
			if (arrayDeDeputadosSemVergonha.deputadosQueRecebemValores()[i] != null) {
				System.out.println(arrayDeDeputadosSemVergonha.deputadosQueRecebemValores()[i]);
			}
		}

		System.out.println("\n\nQUE DESVIAM VERBAS: \n");
		for (int i = 0; i < arrayDeDeputadosSemVergonha.getDeputados().length; i++) {
			if (arrayDeDeputadosSemVergonha.deputadosQueDesviamVerbas()[i] != null) {
				System.out.println(arrayDeDeputadosSemVergonha.deputadosQueDesviamVerbas()[i]);
			}
		}
	}
}
