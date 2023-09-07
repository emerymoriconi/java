package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date moment = new Date();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(moment, status, client);
		
		System.out.print("How many items to this order? ");
		Integer N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String product_name = sc.nextLine();
			System.out.print("Product price: ");
			Double product_price = sc.nextDouble();
			
			Product product = new Product(product_name, product_price);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, product_price, product);
			
			order.addItem(orderItem);
		}
		
		String bd = sdf.format(order.getClient().getBirthDate());
		String mom = sdf2.format(order.getMoment());
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + mom);
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " (" + bd + ") - " + order.getClient().getEmail());
		System.out.println("Order items: ");
		
		for (OrderItem i : order.getItems()) {
			System.out.println(i.getProduct().getName() + ", $" + 
					i.getPrice() + ", Quantity: " + i.getQuantity() + 
					", Subtotal: $" + i.subTotal());
		}
		
		System.out.println("Total price: $" + order.total());
		
		sc.close();

	}

}
