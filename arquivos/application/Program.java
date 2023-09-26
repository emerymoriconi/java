package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//encapsula o processo de acessar o arquivo em questão
		File file = new File("c:\\teste\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			//é uma boa prática colocar o fechamento do recurso sempre no bloco finally
			if(sc != null) {
				sc.close();
			}
		}
	}
}
