import java.util.List;

public abstract class Payment {
    protected List<Course> enrolledCourses;
    public Payment(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    protected abstract double calculateDiscount(double originalAmount, double userPoints);
    public abstract void processPayment(double amount) throws InsufficientBalanceException;
}
