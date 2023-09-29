package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		/* FileWriter: stream de escrita de caracteres em arquivos
		 * Existe duas formas de instanciar o FileWriter
		 * --> new FileWriter(path): cria/recria o arquivo
		 * --> new FileWriter(path, true): acrescenta ao final do arquivo já existente
		 * 
		 * BufferedWriter: é mais rápido pois trata os dados com o buffer
		 * */
		
		String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good Night"};
		
		String path = "c:\\teste\\out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter (path))){
			for (String line : lines) {
				bw.write(line); //não tem quebra de linha por padrão
				bw.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//agora um exercício separado para manipular pastas e arquivos
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		//com a classe File tanto podemos manipular pastas quanto podemos manipular arquivos
		File path2 = new File(strPath);
		
		//criando um vetor com as pastas dentro daquela pasta, usando a filtragem
		File[] folders = path2.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		//criando um vetor com os arquivos dentro daquela pasta, usando a filtragem
		File[] files = path2.listFiles(File::isFile);
		System.out.println("FILES:");
		for (File file : files) {
			System.out.println(file);
		}
		
		System.out.println();
		System.out.println("INFORMAÇÕES SOBRE O CAMINHO: "); 
		//métodos aplicáveis com o tipo File 
		//pegando o caminho do arquivo
		System.out.println("getPath: " + path2.getPath());
		//pegando apenas o caminho sem o nome do arquivo
		System.out.println("getParent: " + path2.getParent());
		//pegando apenas o nome
		System.out.println("getName: " + path2.getName());
		
		sc.close();
	}
}
