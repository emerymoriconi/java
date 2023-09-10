package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (c == 'i') {
				System.out.print("Health expenditures: ");
				Double he = sc.nextDouble();
				
				TaxPayer individual = new Individual(name, anualIncome, he);
				list.add(individual);
			} else if (c == 'c') {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				
				TaxPayer company = new Company(name, anualIncome, employees);
				list.add(company);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		Double sum = 0.0;
		
		for (TaxPayer t : list) {
			System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
			sum += t.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
