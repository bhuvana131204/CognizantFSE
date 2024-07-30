package orders;

public class Main {
	public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Bhuvana", 250.0),
            new Order("2", "Sravya", 150.0),
            new Order("3", "Radha", 300.0),
            new Order("4", "Vijay", 100.0),
            new Order("5", "Shraddha", 200.0)
        };

        System.out.println("Bubble Sort:");
        OrderSort.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

 
        orders = new Order[]{
        		new Order("1", "Bhuvana", 250.0),
                new Order("2", "Sravya", 150.0),
                new Order("3", "Radha", 300.0),
                new Order("4", "Vijay", 100.0),
                new Order("5", "Shraddha", 200.0)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        OrderSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
