import java.util.ArrayList;

public class Training extends PaidCourse {

    private ArrayList<Pengguna> enrolledParticipants;

    public Training(Instruktur instruktur, String name, long price) {
        super(instruktur, name, price);
        this.enrolledParticipants = new ArrayList<>();
    }

    public Training(String namaTraining, int hargaTraining) {
    }

    public ArrayList<Pengguna> getEnrolledParticipants() {
        return enrolledParticipants;
    }

    // mengenroll peserta ke dalam Training
    public void enrollParticipant(Pengguna pengguna) {
        if (!enrolledParticipants.contains(pengguna)) {
            enrolledParticipants.add(pengguna);
            System.out.println(pengguna.getName() + " berhasil di-enroll ke dalam Training " + getName());
        } else {
            System.out.println("Gagal Enroll: " + pengguna.getName() + " sudah di-enroll ke dalam Training " + getName());
        }
    }

    public boolean isEnrolled(Pengguna pengguna) {
        return enrolledParticipants.contains(pengguna);
    }
}
