import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String file = "Token.txt";
		String logFile = "logFile.txt";
		boolean validOption = true;

		while (validOption) {

			Token.write50Tokens(file);

			try {
				System.out.println("Quantos tokens serão gerados?");
				int howManyTokens = Integer.parseInt(sc.nextLine());
				Token.handleTokens(howManyTokens, file, logFile);
				validOption = false;
				Token.printLog(logFile);

			} catch (NumberFormatException e) {
				System.out.println("Token inválido!\n");
			}

		}
		sc.close();
	}

}
