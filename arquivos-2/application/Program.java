package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\teste\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//estabelece uma stream(sequência de leitura)...
			//...a partir do arquivo que está no caminho path.
			fr = new FileReader(path);
			//implementa uma leitura mais rápida a partir do Buffer de memória
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			//possível erro na leitura do arquivo
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
