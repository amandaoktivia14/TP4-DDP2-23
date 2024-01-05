public class CashPayment extends Payment {

    public CashPayment(CourseCart courseCart, Pengguna pengguna){
        super(courseCart, pengguna);
    }

    @Override
    public int discount() {
        if (pengguna instanceof Murid) {
            Murid murid = (Murid) pengguna;
            if (murid.getPoint() > 50) {
                return (int)(courseCart.getTotalHarga() * 0.05);
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Cash";
    }
}