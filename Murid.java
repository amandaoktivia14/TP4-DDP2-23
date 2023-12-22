import java.util.ArrayList;

public class Murid extends Pengguna {
    //TODO: Lengkapi kelas
    private int point = 0;
    private ArrayList<ReportCard> reportCards = new ArrayList<>();
    private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
    private int balance; 
    // private String nomorID;
    private int i;


    
    public Murid(String name, String dob, String address){
        super(name, dob, address);
        this.balance = 0;
        this.i = i;
        // this.point = 0;
        // this.nomorID = super.generateId("M");
    }
    // public String getNomorID() {
    //     return nomorID;
    // }
    
 

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
    public void  addReportCard(ReportCard reportCard) {
        reportCards.add(reportCard);
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
    public int getBalance() {
        return balance;
    }
}
