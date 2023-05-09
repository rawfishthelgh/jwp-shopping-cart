package cart.product.dto;

import cart.product.entity.Product;

public class ProductResponse {

    private Long id;
    private String name;
    private String image;
    private Long price;

    public ProductResponse() {
    }


    public ProductResponse(Long id, String name, String image, Long price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }


    public ProductResponse(Product product) {
        this(product.getId(), product.getName(), product.getImage(), product.getPrice());
    }

    public ProductResponse(Long id, Product product) {
        this(id, product.getName(), product.getImage(), product.getPrice());
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
