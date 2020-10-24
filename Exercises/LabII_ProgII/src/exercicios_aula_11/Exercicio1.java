package exercicios_aula_11;

import java.io.*;

public class Exercicio1 {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\willi\\Desktop\\teste.java";
		String filenameExport = "C:\\Users\\willi\\Desktop\\teste1.java";
		
		try {
			FileWriter fw = new FileWriter(filenameExport, false);
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			String aux = line;
			while (line != null) {
				String buffer = in.readLine();
				if (buffer == null) {
					break;
				}
				line = in.readLine();
				aux += line;
			}
			String[] array = new String[100];
			System.out.println(aux);
			array = aux.split("}");
			for (int i = array.length - 2; i >= 0; i--) {
				if (i == 0) {
					fw.write((array[i]) + " }");
				} else {
					fw.write((array[i]  + " }" + "\n"));
				}
			}
			fw.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+fileName+"\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + fileName+".");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Limite do array estourado!");
		}
	}
}
