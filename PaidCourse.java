public class PaidCourse extends Course {
    public PaidCourse(Instruktur instruktur, String courseName, int price) {
        super(instruktur, courseName);
        this.setPrice(price); 
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price); 
    }
}
