package commerce;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
        Product[] arr = {
            new Product("1", "Desktop", "Electronics"),
            new Product("2", "Garden Axe", "Gardening"),
            new Product("3", "Tablet", "Accessories"),
            new Product("4", "EyePalette", "Beauty"),
            new Product("5", "SunGlasses", "Accessories")
        };


        System.out.println("Linear Search:");
        Product foundProduct = Search.linearSearch(arr, "Desktop");
        System.out.println(foundProduct != null ? foundProduct : "Product not found");

 
        Arrays.sort(arr, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        System.out.println("\nBinary Search:");
        foundProduct = Search.binarySearch(arr, "Tablet");
        System.out.println(foundProduct != null ? foundProduct : "Product not found");
    }
}
