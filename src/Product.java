import java.util.Objects;

public class Product {

    private String productId;
    private String productName;

    private Double price;

    public Product(String productId, String name, Double price) {
        this.productId = productId;
        this.productName = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price);
    }

    public String toString() {
        return String.format("Product{key=%s, name='%s', price=%2f}", productId, productName, price);
    }

}
