package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			
			if(c == 'i') {
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				products.add(product);
			} else if (c == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String date = sc.nextLine();
				Product product = new UsedProduct(name, price, sdf.parse(date));
				products.add(product);
			} else {
				Product product = new Product(name, price);
				products.add(product);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}
