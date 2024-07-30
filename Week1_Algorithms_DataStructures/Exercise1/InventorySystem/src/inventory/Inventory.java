package inventory;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<String,Product>prod;
	public Inventory() {
		prod = new HashMap<>();
		
	}
	public void addProduct(Product product) {
        prod.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(String productId, int quantity, double price) {
        Product product = prod.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Method to delete a product
    public void deleteProduct(String productId) {
        prod.remove(productId);
    }

    // Method to display all products
    public void displayProducts() {
        for (Product product : prod.values()) {
            System.out.println(product);
        }
    }
}
