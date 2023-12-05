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

    public String toString(){
        return String.format("%s - %s - %s\n", name, dob, address);
    }


}