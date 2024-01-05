import java.util.ArrayList;

public class Course {
    private Instruktur instruktur;
    private ArrayList<Murid> muridList = new ArrayList<Murid>();

    protected String namaCourse;
    private boolean isActive; 
    
    

    public Course(Instruktur instruktur, String courseName) {
        this.instruktur = instruktur;
        this.namaCourse = courseName;
        this.isActive = false;
        
    }

    public String getName() {
        return namaCourse;
    }

   

    public String getInstrukturName() {
        return instruktur.getNama(); 
    }

    public boolean isEnrolled(Pengguna loginPengguna) {
        for (Murid murid: muridList){
            if (murid.equals(loginPengguna)){
                return true;
            }
        }
        return false;
    }

    public void enroll(Pengguna loginPengguna) {
        if (! isEnrolled(loginPengguna) && loginPengguna instanceof Murid){
            muridList.add((Murid) loginPengguna);
            this.isActive = true;
        }
        else{
            System.out.println("Gagal enroll: " + loginPengguna.getNama() + " sudah terdaftar di " + namaCourse);
        }

    }

    public ArrayList<Murid> getMuridList() {
        return this.muridList;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void removeEnrolledStudent(Murid murid) {
        muridList.remove(murid);
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive; 
    }

    public int getJumlahMurid() {
        return muridList.size();
    }

    public String getNamaCourse() {
        return namaCourse;
    }
    
}

