package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String[] produtos = new String[] { "TV LED,1290.99,1", "Video Game Chair,350.50,3", "Iphone X,900.00,2",
				"Samsung Galaxy 9,850.00,2" };

		String path = "C:\\teste\\file\\products.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String line : produtos) {
				bw.write(line); // não tem quebra de linha por padrão
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			
			String path2 = new String("C:\\teste\\file");
			
			boolean success = new File(path2 + "\\out").mkdir();
			System.out.println(success);
			
			String caminho = new String("C:\\teste\\file\\out\\summary.csv");
			
			while (line != null) {
				String[] informações = line.split(",");
				String nomeProduto = informações[0];
				Double precoProduto = Double.parseDouble(informações[1]);
				Integer quantidadeProduto = Integer.parseInt(informações[2]);
				
				String linha = new String(nomeProduto + "," + precoProduto * quantidadeProduto);
				
				try(BufferedWriter bw = new BufferedWriter(new FileWriter (caminho, true))){
					bw.write(linha); //não tem quebra de linha por padrão
					bw.newLine();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
