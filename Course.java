import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class Course {
    private Instruktur instruktur;
    private ArrayList<Murid> enrolledStudents = new ArrayList<Murid>();

    private String courseName;
    private boolean isActive; 
    
    

    public Course(Instruktur instruktur, String courseName) {
        this.instruktur = instruktur;
        this.courseName = courseName;
        this.isActive = false;
        
    }

    public String getName() {
        return courseName;
    }

   

    public String getInstrukturName() {
        return instruktur.getName(); 
    }

    public boolean isEnrolled(Pengguna loginPengguna) {
        // Implementasi
        for (Murid murid: enrolledStudents){
            if (murid.equals(loginPengguna)){
                return true;
            }
        }
        return false;
    }

    public void enroll(Pengguna loginPengguna) {
        // Implementasi
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
    
}

