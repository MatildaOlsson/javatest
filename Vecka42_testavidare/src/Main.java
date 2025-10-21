//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentMethod payPal = new PayPal();
        PaymentMethod creditcard = new CreditCard();
        PaymentProcessor.processor(payPal, 202);
        PaymentProcessor.processor(creditcard, 2025);
        PaymentProcessor.processor(payPal, -7);

    }
}