package Entities;

public class Product {
	protected String name;
	protected Double price;
	private Integer quantity;

	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\n$ " + price);
		sb.append("\nQuantity: " + quantity);
		sb.append("\nSub total: $ " + subTotal());
		sb.append("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		return sb.toString();

	}

	public Double subTotal() {
		return price * quantity;
	}

	public Product() {
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

}
