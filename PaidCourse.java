public class PaidCourse extends Course {

    private long price;

    public PaidCourse(Instruktur instruktur, String courseName, long price) {
        super(instruktur, courseName);
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
