import java.util.ArrayList;

public class Instruktur extends Pengguna implements CanPay {
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private boolean isApproved;
    private String instrukturName;
    private String instrukturDob;
    private String instrukturAddress;
    private long balance; 
    // private String nomorID;
    // private boolean isVerified;

    public Instruktur(String name, String dob, String address, long balance){
        super(name, dob, address);

        this.isApproved = false;
        this.instrukturName = name;
        this.instrukturDob = dob;
        this.instrukturAddress = address;
        this.balance = balance;
        this.isApproved = false;
        // this.nomorID = super.generateId("I");

    }

    public Instruktur(String nama, String tanggalLahir, String alamat, boolean isVerified) {
        super(nama, tanggalLahir, alamat);
        this.isApproved = isVerified;
    }

    // public boolean isVerified() {
    //     return this.isVerified;
    // }

    // public void setVerified(boolean isVerified) {
    //     this.isVerified = isVerified;
    // }

    // public String getNomorID() {
    //     return nomorID;
    // }

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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public void pay() {
        Payment payment = Payment.get(0);
        balance -= payment.totalPembayaran;

        System.out.println("--- Payment Berhasil ---");
    }
}
