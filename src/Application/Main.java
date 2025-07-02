package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Client;
import Entities.ImportedProduct;
import Entities.Order;
import Entities.Product;
import Entities.UsedProduct;
import Entities.enums.OrderStatus;
import exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			char typeOfProduct = ' ';

			System.out.println("Enter cliente data: ");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Birth date (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());

			Client client = new Client(name, email, date);

			System.out.println("Enter order data: ");
			sc.nextLine();
			System.out.print("Status: \n( PENDING_PAYMENT / PROCESSING / SHIPPED / DELIVERED )\n");
			String status = sc.nextLine().toUpperCase().trim();

			Order order = new Order(OrderStatus.valueOf(status), client);

			System.out.print("How many items to this order?  ");
			Integer quantityItems = sc.nextInt();
			if (quantityItems <= 0)
				throw new DomainException("A quantidade de itens deve ser maior que zero.");
			sc.nextLine();

			for (int c = 1; c <= quantityItems; c++) {
				do {
					System.out.printf("Enter #%d item data: %n", c);
					System.out.print("Type of product\n" + "Commun, used or imported (C/U/I): ");
					typeOfProduct = Character.toUpperCase(sc.nextLine().charAt(0));
					switch (typeOfProduct) {
					case 'C' -> TypeCommun(sc, order);
					case 'U' -> TypeUsed(sc, sdf, order);
					case 'I' -> TypeImported(sc, order);
					default -> System.err.println("Tipo de produto inválido!");
					}
				} while (typeOfProduct != 'C' && typeOfProduct != 'U' && typeOfProduct != 'I');
			}

			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println(order.toString());

			System.out.println("Total value: " + order.total());

			sc.close();

		} catch (ParseException e) {
			System.err.println("Error: Formato de data inválido!");
		} catch (IllegalArgumentException e) {
			System.err.println("Error: Status inválido");
		} catch (InputMismatchException e) {
			System.err.println("Error: Valor digitado incorreto!");
		} catch (DomainException e) {
			System.err.println("Error: "+e.getMessage());
		}
	}

	public static void TypeCommun(Scanner sc, Order order) {
		System.out.print("Product name: ");
		String productName = sc.nextLine();
		System.out.print("Product price:  ");
		Double price = sc.nextDouble();
		System.out.print("Quantity:  ");
		Integer quantity = sc.nextInt();
		sc.nextLine();
		Product prod = new Product(productName, price, quantity);
		order.addItem(prod);

	}

	public static void TypeUsed(Scanner sc, SimpleDateFormat sdf, Order order) throws ParseException {
		System.out.print("Product name: ");
		String productName = sc.nextLine();
		System.out.print("Product price:  ");
		Double price = sc.nextDouble();
		System.out.print("Quantity:  ");
		Integer quantity = sc.nextInt();
		System.out.print("Manufacture date (dd/MM/yyyy):  ");
		sc.nextLine();
		Date manufactureDate = sdf.parse(sc.next());
		sc.nextLine();

		Product prod = new UsedProduct(productName, price, quantity, manufactureDate);
		order.addItem(prod);
	}

	public static void TypeImported(Scanner sc, Order order) {
		System.out.print("Product name: ");
		String productName = sc.nextLine();
		System.out.print("Product price:  ");
		Double price = sc.nextDouble();
		System.out.print("Customs Fee:  ");
		Double customsFee = sc.nextDouble();
		System.out.print("Quantity:  ");
		Integer quantity = sc.nextInt();
		sc.nextLine();

		Product prod = new ImportedProduct(productName, price, quantity, customsFee);
		order.addItem(prod);
	}
}
