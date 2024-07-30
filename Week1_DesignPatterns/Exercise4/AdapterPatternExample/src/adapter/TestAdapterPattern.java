package adapter;

public class TestAdapterPattern {
 public static void main(String[] args) {
     // Create instances of payment gateways
     PayPal payPal = new PayPal();
     Stripe stripe = new Stripe();

     // Create adapters
     PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
     PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

     // Process payments through adapters
     payPalAdapter.processPayment(100.0);
     stripeAdapter.processPayment(200.0);
 }
}
