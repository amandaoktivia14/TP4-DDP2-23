import java.util.List;

public abstract class Payment {
    protected Pengguna pengguna;
    protected CourseCart courseCart;
    protected long totalPembayaran;
    
    public Payment(CourseCart courseCart, Pengguna pengguna) {
        this.courseCart = courseCart;
        this.pengguna = pengguna;
        this.totalPembayaran = courseCart.getTotalHarga() - discount();
    }

    public abstract int discount();
    public abstract String toString();


    public Pengguna getPengguna() {
        return this.pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public CourseCart getCourseCart() {
        return this.courseCart;
    }

    public void setCourseCart(CourseCart courseCart) {
        this.courseCart = courseCart;
    }

    public long getTotalPembayaran() {
        return this.totalPembayaran;
    }

    public void setTotalPembayaran(long totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

}
