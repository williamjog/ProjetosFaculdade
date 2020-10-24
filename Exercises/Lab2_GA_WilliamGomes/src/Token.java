import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Token {
	
	public Token() {
	}
		
	public static String generateToken() {
		String buffer = "";
		int number1 = (int) (Math.random() * 1000);
		
		if (number1 < 10) {
			buffer = ("00" + Integer.toString(number1));
			
		} else if (number1 < 100) {
			buffer = ("0" + Integer.toString(number1));
		} else {
			if (number1 >= 1000) {
				number1 = 999;
			}
			buffer = Integer.toString(number1);
		}
		return buffer;
	}
	
	public static String readToken(String file, int index) throws numberOutofBondsException {
		
		String buffer = "";
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int i;
			
			for (i = 1; i < index; i++) {
				br.readLine();
			}
			
			buffer = br.readLine();
			
			br.close();
			fr.close();
			
			if (buffer == null) {
				throw new numberOutofBondsException();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + file + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + file + ".");
		} 
		
		return buffer;
	}
	
	public static String completeTokens(String token) {
			return token + generateToken();
	}
	
	public static void writeLog(String token, String file) {
		
		String buffer = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		buffer = buffer + " | " + token + "\n";

		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(buffer);
			fw.close();
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + file + ".");
		}
	
	}
	
	public static void printLog(String logFile) {
		String buffer = "";
		try {
			FileReader fr = new FileReader(logFile);
			BufferedReader br = new BufferedReader(fr);
			
			System.out.println("\n\tHorário       Token");
			buffer = br.readLine();
			
			while (buffer != null) {
				System.out.println("\n" + buffer);
				buffer = br.readLine();
			}
			
			fr.close();
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + logFile + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + logFile + ".");
		}
	
	}
		
	public static void write50Tokens(String file) {		
		try {			
			FileWriter fw = new FileWriter(file, false);
			
			for (int i = 0; i < 50; i++) {
					fw.write(generateToken() + "\n");
			}
			
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + file + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + file + ".");
		}
		
	}

	public static void handleTokens(int tokens, String file, String logFile) {
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		String token = "";
		while (i < tokens) {
			System.out.println("\nInforme o código:");
			int tokenQuantity = Integer.parseInt(sc.nextLine());
			if (tokenQuantity >= 1 && tokenQuantity <= 50) {
				try {
					token = readToken(file, tokenQuantity);
					token = completeTokens(token);
					writeLog(token, logFile);
				} catch (numberOutofBondsException e) {
					e.getMessage();
				}
				i++;
			}
		}
		sc.close();
	}
}
	
