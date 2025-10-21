public class CreditCard implements PaymentMethod {
    @Override
    public double processPayment(double amount) {
        if (amount > 0) {
            System.out.println("Payment with creditcard succeeded. " + amount + " will be taken");
            return amount;
        }
        else {
            return 0;
        }
    }
}
