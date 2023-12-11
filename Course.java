import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class Course {
    private Instruktur instruktur;
    private ArrayList<Murid> enrolledStudents = new ArrayList<Murid>();

    private String courseName;
    private boolean isActive; 

    private int price;
    
    

    public Course(Instruktur instruktur, String courseName) {
        this.instruktur = instruktur;
        this.courseName = courseName;
        this.isActive = false;
        this.price = 0; 
        
    }

    public String getName() {
        return courseName;
    }

   

    public String getInstrukturName() {
        return instruktur.getName(); 
    }

    public boolean isEnrolled(Pengguna loginPengguna) {
        for (Murid murid: enrolledStudents){
            if (murid.equals(loginPengguna)){
                return true;
            }
        }
        return false;
    }

    public void enroll(Pengguna loginPengguna) {
        if (! isEnrolled(loginPengguna) && loginPengguna instanceof Murid){
            enrolledStudents.add((Murid) loginPengguna);
            this.isActive = true;
        }
        else{
            System.out.println("Gagal enroll: " + loginPengguna.getName() + " sudah terdaftar di " + courseName);
        }

    }

    public boolean isActive() {
        return this.isActive;
    }
    

    public ArrayList<Murid> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void removeEnrolledStudent(Murid murid) {
        enrolledStudents.remove(murid);
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive; 
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getJumlahMurid() {
        return enrolledStudents.size();
    }

    
    
}

