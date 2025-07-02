package Entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct(String name, Double price, Integer quantity, Double customsFee) {
		super(name, price, quantity);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\n$ " + price);
		sb.append("\nQuantity: " + getQuantity());
		sb.append("\nCustoms Fee: $ " + customsFee);
		sb.append("\nSub total: $ " + subTotal());
		sb.append("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		return sb.toString();

	}

	@Override
	public Double subTotal() {
		return (super.getPrice() + customsFee) * getQuantity();
	}
}
