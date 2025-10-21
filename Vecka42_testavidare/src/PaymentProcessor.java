public class PaymentProcessor {

    public static void processor(PaymentMethod method, double amount) {
        if (method instanceof PayPal) {
            PayPal payPal = (PayPal) method;
            payPal.processPayment(amount);
        }
        else if (method instanceof CreditCard) {
            CreditCard creditCard = (CreditCard) method;
            creditCard.processPayment(amount);
        }
    }
}
