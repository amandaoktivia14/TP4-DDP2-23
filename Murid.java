import java.util.ArrayList;

public class Murid extends Pengguna implements CanPay {
    private int point = 0;
    private ArrayList<ReportCard> reportCards = new ArrayList<>();
    private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
    private CourseCart courseCart = new CourseCart();
    // private String nomorID;


    
    public Murid(String name, String dob, String address, long saldo){
        super(name, dob, address);
        this.balance = saldo;
        // this.point = 0;
        // this.nomorID = super.generateId("M");
    }
    // public String getNomorID() {
    //     return nomorID;
    // }

    public void hitungPoint(ReportCard reportCard){
        if (reportCard.getScore()>85){
            this.point += 25;
        } else if (reportCard.getScore()>70){
            this.point += 20;
        } else if (reportCard.getScore()>55){
            this.point += 10;
        } else {
            this.point += 5;
        }

        if(reportCard.getCourse() instanceof PaidCourse){
            this.point += 10;
        }
    }

    public String getTotalPoint() {
        return "Total Point Anda : " + point;
    }

    public String getNilai(Course course) {
        for (ReportCard reportCard : reportCards) {
            if (reportCard.getCourse().equals(course)) {
                return String.valueOf(reportCard.getNilai());
            }
        }
        return null;
    }
    public String getFeedback(Course course) {
        for (ReportCard reportCard : reportCards) {
            if (reportCard.getCourse().equals(course)) {
                return String.valueOf(reportCard.getFeedback());
            }
        }
        return null;
    }
    public int getPoint() {
        return point;
    }
    public void addReportCard(ReportCard reportCard){
        this.reportCards.add(reportCard);
        this.enrolledCourses.remove(reportCard.getCourse());
        this.hitungPoint(reportCard);
        System.out.println("Report Card berhasil ditambahkan, point saat ini :" + this.point);
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public ArrayList<ReportCard> getReportCards() {
        return this.reportCards;
    }

    public void setReportCards(ArrayList<ReportCard> reportCards) {
        this.reportCards = reportCards;
    }
    public long getBalance() {
        return balance;
    }

    public void addCourseToCart(PaidCourse course) {
        courseCart.addCourseToCart(course);
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public CourseCart getCourseCart() {
        return this.courseCart;
    }

    public void setCourseCart(CourseCart courseCart) {
        this.courseCart = courseCart;
    }

    public void printRaport(){
        if(this.getReportCards().size() >0){
            System.out.println("---------- RAPOR ----------");
            System.out.println("Total Point Anda :" + this.point);
            System.out.println("Detail: ");
            for(int i = 0; i < reportCards.size(); i++){
                System.out.println("----------  " + (i+1) + "  ----------");
                System.out.println(reportCards.get(i).details());
            }
        } else {
            System.out.println("Anda belum menyelesaikan course apapun");
        }
        
    }


    @Override
    public void pay() {
        Payment payment = Payment.get(Payment.size() - 1);
        balance -= payment.totalPembayaran;

        System.out.println("--- Payment Berhasil ---");
        System.out.println("Nama : " + nama);
        System.out.println("Metode : " + payment.toString());
        System.out.println("List Course :");
        for (Course course : courseCart.getCourseList()) {
            course.setActive(true);
            enrolledCourses.add(course);
            course.getMuridList().add(this);
            System.out.println(course.getName());
        }
        System.out.println("Jumlah Harga Course : Rp" + payment.getCourseCart().getTotalHarga() + ",-");
        System.out.println("Jumlah Harga Bayar : Rp" + payment.getTotalPembayaran() + ",-");
        courseCart.getCourseList().clear();
        
    }
}
