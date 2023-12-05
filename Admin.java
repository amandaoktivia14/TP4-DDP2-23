public class Admin extends Pengguna {

    public Admin(String name, String dob, String address) {
        super(name, dob, address);
    }

    public String verifikasiInstruktur(Instruktur instruktur) {
        instruktur.approve();
        return "Instruktur "+ instruktur.getName() + " berhasil diverifikasi";
    }
}
