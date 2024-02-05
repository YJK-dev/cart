import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final HashMap<Product, Integer> cart;

    public Cart(){
        cart = new HashMap<>();
    }

    public void showItems() {
        for (Map.Entry<Product, Integer> entry : this.cart.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println("Product: " + product + ", Quantity: " + quantity);
        }
    }

    public void addProduct(Product product, Integer quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product, Integer quantity) {
        if (cart.getOrDefault(product, 0) - quantity > 0) {
            cart.put(product, cart.get(product) - quantity);
        } else {
            cart.remove(product);
        }
    }
}
