import java.util.ArrayList;

public class Pengguna {
    protected String nama;
    protected String tanggalLahir;
    protected String alamat;
    protected long balance;
    protected ArrayList<Payment> Payment = new ArrayList<>();
    protected int point;

    public Pengguna(String nama, String tanggalLahir, String alamat){
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    public String getNama(){
        return nama;
    }

    public String getTanggalLahir(){
        return tanggalLahir;
    }

    public String getAlamat(){
        return alamat;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long saldo) {
        this.balance = saldo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<Payment> getPayment() {
        return this.Payment;
    }

    public void setPayment(ArrayList<Payment> Payment) {
        this.Payment = Payment;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString() {
        return String.format("Nama : %s \nTanggal Lahir : %s \nAlamat : %s", getNama(), getTanggalLahir(), getAlamat());
    }
    
    // public String generateId(String kodeJenis){
    //     StringBuilder str= new StringBuilder("");
    //     str.append(kodeJenis);
    //     str.append(this.name.substring(0, 1));
    //     str.append(formatTTL());
    //     str.append(findChecksum());
    //     return str.toString();
    // }

    // public String formatTTL(){
    //     StringBuilder str = new StringBuilder("");
    //     String[] arrStr = this.dob.split("/");
    //     str.append(arrStr[0]);
    //     str.append(arrStr[1]);
    //     str.append(arrStr[2].substring(2));
    //     return str.toString();
    // }

    // public int findChecksum(){
    //     String strTTL = formatTTL();
    //     // Integer.parseInt(String.valueOf(c)); 
    //     int sum = 0;
    //     for(int i=0; i < strTTL.length(); i++){
    //         int el = Integer.parseInt(String.valueOf(strTTL.charAt(i))); 
    //         sum += (el*9);
    //     }
    //     return sum%10;
    // }

    // public String toString(){
    //     return String.format("Nama : %s \nTanggal Lahir : %s \nAlamat : %s", getName(), getDob(), getAddress());
    // }



}