public class PayPal implements PaymentMethod{


    @Override
    public double processPayment(double amount) {

        if (amount > 0) {
            System.out.println("PayPal payment succeded. " + amount + " SEK has been withdrawn from the account");
            return amount;
        }
        else {
            return 0;
        }
    }

}
