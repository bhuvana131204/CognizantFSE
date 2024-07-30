package strategy;

public class TestStrategyPattern {
	public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100.0);
        System.out.println();

        PaymentStrategy payPalPayment = new PayPalPayment("johndoe@example.com");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.0);
    }
}
