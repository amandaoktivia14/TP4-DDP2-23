import java.util.ArrayList;

public class CourseCart {
    private ArrayList<Course> courseList = new ArrayList<>();
    private long totalHarga;

    public CourseCart() {
        this.totalHarga = 0;
    }

    public ArrayList<Course> getCourseList() {
        return this.courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public long getTotalHarga() {
        return this.totalHarga;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void addCourseToCart(PaidCourse course) {
        courseList.add(course);
        this.totalHarga += course.getPrice();
    }

}
