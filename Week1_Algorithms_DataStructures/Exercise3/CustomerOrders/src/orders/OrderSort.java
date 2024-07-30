package orders;

public class OrderSort {
	public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getTotalPrice() < arr[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
	public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = divide(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
	private static int divide(Order[] arr, int low, int high) {
        Order pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getTotalPrice() > pivot.getTotalPrice()) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
