package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Shape> list = new ArrayList<>(); 
		
		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Shape #" + i + " data: ");
			System.out.print("Rectangle or Circle (r/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			sc.nextLine();
			Color color = Color.valueOf(sc.next());//a palavra que o usuario digitar vai ser convertida para o tipo Color
			
			if (c == 'r') {
				System.out.print("Width: ");
				Double width = sc.nextDouble();
				System.out.print("Height: ");
				Double height = sc.nextDouble();
				
				Shape shape = new Rectangle(color, width, height);
				list.add(shape);
			} else if (c == 'c') {
				System.out.print("Radius: ");
				Double radius = sc.nextDouble();
				
				Shape shape = new Circle(color, radius);
				list.add(shape);
			}
		}
		
		System.out.println();
		System.out.println("SHAPE AREAS: ");
		for(Shape s : list) {
			System.out.printf("%.2f%n", s.area());
		}
		
		sc.close();
	}

}
