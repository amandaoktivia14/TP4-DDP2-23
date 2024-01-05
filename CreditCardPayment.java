public class CreditCardPayment extends Payment {
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber, Pengguna pengguna, CourseCart courseCart) {
        super(courseCart, pengguna);
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public int discount() {
        float discount = 0.05f;
        if (pengguna.getPoint() > 50) discount += 0.05f;
        else if (pengguna.getPoint() > 20) discount += 0.02f;
        return (int)(courseCart.getTotalHarga() * discount);
    }

    @Override
    public String toString() {
        return "Credit - " + creditCardNumber;
    }
}