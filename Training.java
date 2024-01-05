import java.util.ArrayList;

public class Training extends PaidCourse {

    private ArrayList<Pengguna> enrolledParticipants;

    public Training(String name, long price) {
        super(null, name, price);
        this.enrolledParticipants = new ArrayList<>();
    }

    public ArrayList<Pengguna> getEnrolledParticipants() {
        return enrolledParticipants;
    }

    public void enrollParticipant(Pengguna pengguna) {
        if (!enrolledParticipants.contains(pengguna)) {
            enrolledParticipants.add(pengguna);
            System.out.println(pengguna.getNama() + " berhasil di-enroll ke dalam Training " + getName());
        } else {
            System.out.println("Gagal Enroll: " + pengguna.getNama() + " sudah di-enroll ke dalam Training " + getName());
        }
    }

    public boolean isEnrolled(Pengguna pengguna) {
        return enrolledParticipants.contains(pengguna);
    }

    public String details() {
        return namaCourse;
    }
}
