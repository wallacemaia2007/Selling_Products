package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entities.enums.OrderStatus;

public class Order {

	private OrderStatus status;

	private List<Product> products = new ArrayList<>();

	SimpleDateFormat sdfMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdfBirth = new SimpleDateFormat("dd/MM/yyyy");

	private Client client;
	private Date moment;

	public void addItem(Product produto) {
		products.add(produto);
	}

	public void removeItem(Product produto) {

		products.remove(produto);
	}

	public Double total() {
		Double sum = 0.0;
		for (Product c : products) {
			sum += c.subTotal();
		}
		return sum;
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
		this.moment = new Date();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Sumarry:\n");
		sb.append("Order moment: ");
		sb.append(sdfMoment.format(moment) + "\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName());
		sb.append(" (" + sdfBirth.format(client.getBirthDate()) + ")");
		sb.append(" - " + client.getEmail()).append("\n");
		sb.append("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		sb.append("Order Items: \n");

		for (Product p : products) {
			sb.append(p.priceTag());
		}

		return sb.toString();
	}

}
