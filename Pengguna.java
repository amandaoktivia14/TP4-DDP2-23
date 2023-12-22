import java.util.ArrayList;
import java.util.Scanner;

public class Pengguna {
    //TODO: Lengkapi kelas
    private String name;
    private String dob;
    private String address;

    public Pengguna(String nama, String tanggalLahir, String alamat){
        this.name = nama;
        this.dob = tanggalLahir;
        this.address = alamat;
    }

    public String getName(){
        return name;
    }

    public String getDob(){
        return dob;
    }

    public String getAddress(){
        return address;
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