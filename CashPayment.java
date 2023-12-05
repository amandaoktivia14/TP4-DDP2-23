import java.util.List;

public class CashPayment extends Payment {
    private double saldoInstruktur;
    private Pengguna loginPengguna;
    private List<Course> enrolledCourses;

    public CashPayment(double saldoInstruktur, List<Course> enrolledCourses){
        super(enrolledCourses);
        this.saldoInstruktur = saldoInstruktur;
        // this.loginPengguna = loginPengguna; 
        // this.enrolledCourses = enrolledCourses;
    }

    @Override
    protected double calculateDiscount(double originalAmount, double userPoints){
        return (userPoints > 50) ? 0.05 * originalAmount : 0.0;
    }

    @Override
    public void processPayment(double amount) throws InsufficientBalanceException {
        double discount = calculateDiscount(amount, 0);
        double totalAmount = amount - discount;

        if (saldoInstruktur >= totalAmount){
            saldoInstruktur -= totalAmount;

            System.out.println("--- Payment Berhasil ---");
            System.out.println("Nama: " + loginPengguna.getName());
            System.out.println("Metode: Cash");
            System.out.println("List Course:");
            for (Course course : enrolledCourses){
                System.out.println(course.toString());
            }
            System.out.println("Jumlah harga course: Rp" + amount + ",-");
            System.out.println("Jumlah harga bayar: Rp" + totalAmount + ",-");
        
        } else {
            throw new InsufficientBalanceException("Saldo tidak mencukupi");
        }
    }
}