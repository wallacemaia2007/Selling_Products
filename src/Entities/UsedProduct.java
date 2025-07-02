package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;

	private static final SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct(String name, Double price, Integer quantity, Date manufactureDate) {
		super(name, price, quantity);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\n$ " + price);
		sb.append("\nQuantity: " + getQuantity());
		sb.append("\nManufacture date: " + fmt1.format(manufactureDate));
		sb.append("\nSub total: $ " + subTotal());
		sb.append("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		return sb.toString();

	}
}
