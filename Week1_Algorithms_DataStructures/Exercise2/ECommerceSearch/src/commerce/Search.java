package commerce;

public class Search {
	public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
	public static Product binarySearch(Product[] products, String pname) {
        int l = 0;
        int r = products.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int comp = products[mid].getProductName().compareToIgnoreCase(pname);

            if (comp == 0) {
                return products[mid];
            } else if (comp < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return null;
    }
}
