import java.util.ArrayList;

public class Instruktur extends Pengguna{
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private boolean isApproved;
    private String instrukturName;
    private String instrukturDob;
    private String instrukturAddress;
    private int balance; 

    public Instruktur(String name, String dob, String address, boolean isApproved){
        super(name, dob, address);

        this.isApproved = isApproved;
        this.instrukturName = name;
        this.instrukturDob = dob;
        this.instrukturAddress = address;
        this.balance = 0;

    }

    public String getName() {
        return instrukturName; 
    }
    public String getDob() {
        return instrukturDob; 
    }
    public String getAddress() {
        return instrukturAddress; 
    }

    public ArrayList<Course> getCourses() {
        return courseList;
    }

    public void approve() {
        this.isApproved = true;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
