package cart.product.dto;

import cart.product.entity.Product;

public class ProductResponse {

	private final Long id;
	private final String name;
	private final String image;
	private final Long price;

	public ProductResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.image = product.getImage();
		this.price = product.getPrice();
	}

	public ProductResponse(Long id, Product product) {
		this.id = id;
		this.name = product.getName();
		this.image = product.getImage();
		this.price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public Long getPrice() {
		return price;
	}
}
