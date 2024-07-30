package inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

       
        Product product1 = new Product("1", "Mobile", 40, 500.00);
        Product product2 = new Product("2", "Desktop", 10, 700.00);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

    
        inventory.displayProducts();

 
        inventory.updateProduct("1", 15, 750.00);

 
        System.out.println("\nAfter Update:");
        inventory.displayProducts();
        
        inventory.deleteProduct("2");

        System.out.println("\nAfter Deletion:");
        inventory.displayProducts();
    }
}
