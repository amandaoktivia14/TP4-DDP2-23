public class ReportCard {
    private Murid murid;
    private Course course;
    private int nilai;
    private String feedback;

    public ReportCard(Murid murid, Course course, int nilai, String feedback) {
        this.murid = murid;
        this.course = course;
        this.nilai = nilai;
        this.feedback = feedback;
    }

    public Murid getMurid() {
        return murid;
    }

    public Course getCourse() {
        return course;
    }

    public int getNilai() {
        return nilai;
    }

    public String getFeedback() {
        return feedback;
    }
}


