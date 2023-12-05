import java.util.List;

public class CreditCardPayment extends Payment {
    private String creditCardNumber;
    private double saldoInstruktur;
    private Pengguna loginPengguna; // Assuming Pengguna is a class or type
    private List<Course> enrolledCourses;

    public CreditCardPayment(String creditCardNumber, double saldoInstruktur, Pengguna loginPengguna, List<Course> enrolledCourses) {
        super(enrolledCourses);
        this.creditCardNumber = creditCardNumber;
        this.saldoInstruktur = saldoInstruktur;
        this.loginPengguna = loginPengguna;
    }

    @Override
    protected double calculateDiscount(double originalAmount, double userPoints) {
        double discount = 0.05;

        if (userPoints > 50){
            discount += 0.05;
        } 
        else if (userPoints > 20){
            discount += 0.02;
        }
        return discount * originalAmount;
    }

    @Override
    public void processPayment(double amount) throws InsufficientBalanceException {
        double discount = calculateDiscount(amount, 0);
        double totalAmount = amount - discount;

        if (saldoInstruktur >= totalAmount) {
            saldoInstruktur -= totalAmount;

            System.out.println("--- Payment Berhasil ---");
            System.out.println("Nama : " + loginPengguna.getName());
            System.out.println("Metode : Credit Card - " + creditCardNumber);
            System.out.println("List Course :");
            for (Course course : enrolledCourses) {
                System.out.println(course.toString());
            }
            System.out.println("Jumlah Harga Course : Rp" + amount + ",-");
            System.out.println("Jumlah Harga Bayar : Rp" + totalAmount + ",-");
        } else {
            throw new InsufficientBalanceException("Saldo tidak mencukupi");
        }
    }


}