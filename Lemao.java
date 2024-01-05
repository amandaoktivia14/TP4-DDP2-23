import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Lemao {
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Pengguna> penggunas = new ArrayList<Pengguna>();
    private ArrayList<ReportCard> report = new ArrayList<ReportCard>();
    private Pengguna loginPengguna;
    private ArrayList<Course> enrolledCourses = new ArrayList<>(); 
    public static void main(String[] args) {
        Lemao app = new Lemao();
        System.out.println("Welcome to Lcelemao! Enjoy your Learning");
        
        app.initData();
        app.logoutMenu(); }

    public void adminMenu(){
        Scanner scanner = new Scanner(System.in);
        int input;
        do{
        System.out.println("---------------Admin " + loginPengguna.getNama() + " Menu---------------");
        System.out.println("1. Lihat Instruktur");
        System.out.println("2. Verifikasi Instruktur");
        System.out.println("3. Buat Training");
        System.out.println("0. Logout");
        System.out.print("Pilih menu: ");
        input = scanner.nextInt();

        switch(input){
            case 1:
                lihatInstruktur(scanner);
                break;
            case 2:
                verifikasiInstruktur(scanner);
                break;
            case 3:
                buatTraining(scanner);
                break;
            case 0:
                logoutMenu();
                System.out.println("Sampai Jumpa!");
                break;
            default:
                System.out.println("Pilihan menu tidak valid.");
                break;

        }
        } while (input != 0);
        scanner.close();
    }

    public void instrukturMenu(){
        //TODO: Lengkapi menu instruktur
        Scanner scanner = new Scanner(System.in);
        int input;
        do{
        System.out.println("---------------Instruktur " + loginPengguna.getNama() + " Menu---------------");
        System.out.println("1. Buat Course");
        System.out.println("2. Lihat Course Saya");
        System.out.println("3. Buat Rapor Murid");
        System.out.println("4. Enroll Training");
        System.out.println("5. Lihat Saldo");
        System.out.println("0. Logout");
        System.out.print("Pilih menu: ");
        input = scanner.nextInt();

        switch (input){
            case 1: 
                buatCourse(scanner);
                break;
            case 2: 
                lihatCourseSaya(scanner);
                break;
            case 3: 
                buatRaporMurid(scanner);
                break;
            case 4:
                enrollTraining(scanner);
                break;
            case 5:
                lihatSaldo();
                break;
            case 0:
                logoutMenu();
                System.out.println("Sampai Jumpa!");
                break;
            default:
                System.out.println("Pilihan menu tidak valid.");
                break;

        }
        } while (input != 0);
        scanner.close();
    }

    public void muridMenu() {
        Murid murid = (Murid) loginPengguna;
        Scanner scanner = new Scanner(System.in);
        int input ;
        do {
            System.out.println("---------------Murid " + loginPengguna.getNama() + " Menu---------------");
            System.out.println("1. Enroll Course");
            System.out.println("2. Lihat Course Aktif Saya");
            System.out.println("3. Lihat Rapor");
            System.out.println("4. Bayar Course");
            System.out.println("5. Lihat Saldo");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    enrollCourse(scanner);
                    break;
                case 2:
                    lihatCourseAktif(scanner);
                    break;
                case 3:
                    lihatRapor(scanner);
                    break;
                case 4:
                    bayarCourse(scanner, null);
                    break;
                case 5:
                    lihatSaldo();
                    break;
                case 0:
                    logoutMenu();
                    System.out.println("Logout berhasil");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (input != 0);
        scanner.close();
    }

    public void enrollCourse(Scanner scanner) {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }
        System.out.print("Select a course to enroll: ");
        int choice = scanner.nextInt();
    
        if (choice < 1 || choice > courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }
    
        Course selectedCourse = courses.get(choice - 1);
        Murid murid = (Murid) loginPengguna;
    
        if (selectedCourse instanceof PaidCourse) {
            murid.addCourseToCart((PaidCourse) selectedCourse);
            System.out.println(selectedCourse.getName() + " added to your CourseCart.");
        } else {
            murid.getEnrolledCourses().add(selectedCourse);
            selectedCourse.setActive(true);
            selectedCourse.getMuridList().add(murid);
            System.out.println("Enrolled in " + selectedCourse.getName() + ".");
        }
    }

    public void lihatCourseSaya(Scanner scanner){
        int i = 1;
        for (Course course : courses){
            System.out.println("-------  " + i + "   -------");
            System.out.println("Nama Course: " + course.getName());
            System.out.println("Nama Instruktur: " + course.getInstrukturName());
            System.out.println("Jumlah Murid: " + course.getJumlahMurid());
            System.out.println("List Murid: ");

            ArrayList<Murid> enrolledStudents = course.getMuridList();
            if (! enrolledStudents.isEmpty()){
                for (Murid murid : enrolledStudents){
                    System.out.println("- " + murid.getNama());
                }
            }
            else{
                System.out.println("Belum ada murid terdaftar.");
            }

            
        }
    }
    
    public void lihatCourseAktif(Scanner scanner){
        System.out.println("-------- Course aktif saat ini --------");
        int i = 1;
        Murid murid = (Murid) loginPengguna;
        for (Course course : murid.getEnrolledCourses()){
            System.out.println(i + ". Nama course: " + course.getName() + " - Instruktur: " + course.getInstrukturName());
            i++;
        }
        if (i == 1) {
            System.out.println("Tidak ada course aktif yang di-enroll.");
        }
    }
    private void lihatPadaConsole(Murid murid) {
        murid.printRaport();
    }
    
    private void cetakDalamTxt(Murid murid) {
        try {
            if (murid.getReportCards().isEmpty()) {
                throw new NoReportException("Tidak ada laporan untuk dicetak.");
            }
    
            String filename = "Rapor-" + murid.getNama() + ".txt";
            PrintWriter out = new PrintWriter(filename);
            out.println("---------- RAPOR ----------");
            out.println("Total Point Anda: " + murid.getPoint());
            for(int i = 0; i < murid.getReportCards().size(); i++){
                out.println("----------  " + (i+1) + "  ----------");
                out.println(murid.getReportCards().get(i).details());
            }
            out.close();
            System.out.println("\nRapor dapat dilihat pada "+ filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lihatRapor(Scanner scanner) {
        Murid murid = (Murid) loginPengguna;
        System.out.println("--------- Melihat Rapor ---------");
        System.out.println("Format Rapor");
        System.out.println("1. Lihat pada console");
        System.out.println("2. Cetak dalam dokumen (.txt)");
        System.out.print("Pilih jenis: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                lihatPadaConsole(murid);
                break;
            case 2:
                cetakDalamTxt(murid);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
}
    public void buatCourse(Scanner scanner){
        System.out.println("--------- Membuat Course  ---------");
        System.out.println("Jenis Course");
        System.out.println("1. Course Gratis");
        System.out.println("2. Course Berbayar");
        System.out.println("Pilih jenis course: ");
        int jenisCourse = scanner.nextInt();

        String namaCourse;
        do {
            System.out.print("Nama Course: ");
            namaCourse = scanner.nextLine();

            if (namaCourse.isEmpty()) {
                System.out.println("Nama Course tidak boleh kosong.");
            }
        } while (namaCourse.isEmpty());

        if (jenisCourse == 2){
            int hargaCourse;
            do {
                System.out.print("Harga Course: ");
                hargaCourse = scanner.nextInt();
                if (hargaCourse <= 0) {
                    System.out.println("Harga Course harus lebih dari 0. Silakan isi kembali.");
                }
            } while (hargaCourse <= 0);

            courses.add(new Course((Instruktur) loginPengguna, namaCourse));
            System.out.println("Course berhasil ditambahkan");
        }
        else {
            // Create a new gratis course
            courses.add(new Course((Instruktur) loginPengguna, namaCourse));
            System.out.println("Course berhasil ditambahkan");
        }
    }

    public void lihatInstruktur(Scanner scanner){
        int i = 1;
        for (Pengguna pengguna : penggunas){
            if (pengguna instanceof Instruktur){
                Instruktur instruktur = (Instruktur) pengguna;
                System.out.println("-------  " + i + "   -------");
                System.out.println("Nama: " + instruktur.getNama());
                System.out.println("Tanggal lahir: " + instruktur.getTanggalLahir());
                System.out.println("Alamat: " + instruktur.getAlamat());
                String status = "Not Verified";
                if (instruktur.isApproved()) status = "Verified";
                System.out.print("Status: " + status);
                System.out.println("List Course:");
                if (instruktur.getCourses().isEmpty()) {
                    System.out.println("Belum ada course");
                }
                else {
                    for (Course course : instruktur.getCourses()) {
                        System.out.println("- " + course.getName());
                    }
                }
            }
        }
    }

    public void verifikasiInstruktur(Scanner scanner){
        for (Pengguna pengguna : penggunas){
            if (pengguna instanceof Instruktur){
                Instruktur instruktur = (Instruktur) pengguna;
                if (!instruktur.isApproved()) System.out.println("- " + instruktur.getNama());
            }
        }
        String cariInstruktur;
        System.out.print("Siapa yang akan anda verifikasi? ");
        cariInstruktur = scanner.nextLine();
        Pengguna foundUser = searchPengguna(cariInstruktur);

        if (foundUser != null){
            if (foundUser instanceof Instruktur){
                Instruktur instruktur = (Instruktur) foundUser;
                Admin admin = (Admin) loginPengguna;
                admin.verifikasiInstruktur(instruktur);
            }      
        }
        else{
            System.out.println("Pengguna tidak ditemukan");
        }
    }

    public void buatTraining(Scanner scanner){
        System.out.println("--------- Membuat Training  ---------");
        System.out.println("Nama Training: ");
        scanner.nextLine(); 
        String namaTraining = scanner.nextLine();

        int hargaTraining;
        do{
            System.out.println("Harga Training: ");
            hargaTraining = scanner.nextInt();
            if (hargaTraining <= 0){
                System.out.println("Harga tidak boloh kosong");
            }
        }while(hargaTraining <= 0);

        Training training = new Training(namaTraining, hargaTraining);
        courses.add(training);
        System.out.println("Training berhasil ditambahkan");
    }

    public void buatRaporMurid(Scanner scanner){
        System.out.println("Berikut merupakan list course anda:");
        int i = 1;
        for (Course course : courses){
            System.out.println(i + ". Nama Course:  " + course.getName() + " - Instruktur: " + course.getInstrukturName());
            i++;
        }
        System.out.println("Masukkan nomor course: ");
        int nomorCourse = scanner.nextInt();

        if (nomorCourse > 0 && nomorCourse<= courses.size()){
            Course selectedCourse = courses.get(nomorCourse - 1);

            if (selectedCourse.isActive()){
                System.out.println("-----------------------------");
                System.out.println("Berikut merupakan murid yang berada di kelas ini");
                int j = 1;
                for (Murid murid : selectedCourse.getMuridList()){
                    System.out.println(j + ". " + murid.getNama());
                    j++;
                }
            
                System.out.println("Masukkan nomor murid: ");
                int nomorMurid = scanner.nextInt();
                if (nomorMurid > 0 && nomorMurid <= selectedCourse.getMuridList().size()){
                    Murid selectedMurid = selectedCourse.getMuridList().get(nomorMurid-1);
                    System.out.println("Nilai untuk " + selectedMurid.getNama() + " pada " + selectedCourse.getName() + ": ");
                    int nilai = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Feedback untuk murid: ");
                    String feedback = scanner.nextLine();

                    hitungPoint(selectedMurid, nilai, selectedCourse);
                    report.add(new ReportCard(selectedMurid, selectedCourse, nilai, feedback));
                    selectedMurid.addReportCard(new ReportCard(selectedMurid, selectedCourse, nilai, feedback));
                    selectedCourse.removeEnrolledStudent(selectedMurid);
                    System.out.println("Report Card berhasil ditambahkan, point saat ini: " + selectedMurid.getPoint());
                    System.out.println("Murid berhasil dihapus dari course.");
                } else {
                    System.out.println("Nomor murid tidak valid.");
                }
            }else {
                System.out.println("Course tidak aktif.");
            }
        }else {
            System.out.println("Nomor course tidak valid.");
        }
    }

    public void hitungPoint(Murid murid, int nilai, Course course){
        int point = 0;
        if (nilai > 85){
            point = 25;
        }
        else if (nilai >= 70){
            point = 20;
        }
        else if (nilai >= 55){
            point = 10;
        }
        else{
            point = 5;
        }

        if (course instanceof PaidCourse) {
            point += 10;
            
        }
        murid.addPoint(point);
    }


    public void loginMenu(Scanner scanner){
        scanner.nextLine();
        System.out.println("Masukkan nama pengguna: ");
        String username = scanner.nextLine();

        Pengguna foundUser = searchPengguna(username);

        if (foundUser != null){
            loginPengguna = foundUser;
            System.out.println("Login berhasil");

            if (loginPengguna instanceof Admin){
                adminMenu();
            }
            if (loginPengguna instanceof Instruktur){
                instrukturMenu();
            }
            if (loginPengguna instanceof Murid){
                muridMenu();
            }         
        }
        else{
            System.out.println("Pengguna tidak ditemukan");
        }

    }

    public void registerMuridMenu(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println("--------- Registrasi Murid ---------");
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Lahir: ");
        String dob = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();

        if (name.isEmpty() || dob.isEmpty() || address.isEmpty()) {
            System.out.println("Pendaftaran gagal, semua field harus diisi");
        } 
        else {
            Murid murid = new Murid(name, dob, address, 0);
            penggunas.add(murid);
            System.out.println("Pendaftaran berhasil, silahkan login kembali");
        }
    }

    public void registerInstrukturMenu(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println("--------- Registrasi Instruktur ---------");
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Lahir: ");
        String dob = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();

        if (name.isEmpty() || dob.isEmpty() || address.isEmpty()) {
            System.out.println("Pendaftaran gagal, semua field harus diisi");
        } 
        else {
            Instruktur instruktur = new Instruktur(name, dob, address, false);
            penggunas.add(instruktur);
            System.out.println("Pendaftaran berhasil, silahkan login kembali.");
        }
    }

    public void keluarMenu(){
        System.out.println("Logout berhasil.");
    }

    public void logoutMenu() {
    
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("Menu" +
            "\n1. Login" +
            "\n2. Daftar sebagai Murid" +
            "\n3. Daftar sebagai Instruktur" +
            "\n0. Keluar");
            System.out.print("Pilih menu: ");
            input = scanner.nextInt();
    
            switch (input) {
                case 1:
                    //TODO: lengkapi menu login
                    loginMenu(scanner);
                    break;
                case 2:
                    //TODO: lengkapi menu daftar
                    registerMuridMenu(scanner);
                    break;
                case 3:
                    //TODO: lengkapi menu daftar
                    registerInstrukturMenu(scanner);
                    break;
                case 0:
                    keluarMenu();
                    System.out.println("Sampai Jumpa!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (input != 0);
        scanner.close();
    }

    public Course searchCourse(String courseName, String instrukturName){
        //TODO: Lengkapi method untuk mencari course by courseName
        for (Course course : courses){
            if (course.getName().equalsIgnoreCase(courseName) && course.getInstrukturName().equalsIgnoreCase(instrukturName)){
                return course;
            }
        }
        return null;
    }

    public Pengguna searchPengguna(String name){
        //TODO: Lengkapi method untuk mencari pengguna by Name
        for (Pengguna pengguna : penggunas){
            if (pengguna.getNama().equalsIgnoreCase(name)){
                return pengguna;
            }
        }
        return null;
    }


    public void initData(){
        //SILAHKAN UNCOMMENT CODE DIBAWAH UNTUK INISIALISASI DATA

        this.penggunas.add(new Admin("Fikri", "12/11/2000", "Jalan jalan"));
        this.penggunas.add(new Admin("Rahma", "2/10/2000", "Jalan Kemana"));

        Instruktur instruktur1 = new Instruktur("Aristo", "13/11/1986", "Jalan Sesama", 1000000);
        Instruktur instruktur2 = new Instruktur("Mark", "03/01/1990", "Jalan Bersama", 800000);
        Instruktur instruktur3 = new Instruktur("Ilma", "08/08/2003", "Jalan Kenangan", 200000);
        Instruktur instruktur4 = new Instruktur("Heri", "01/09/2003", "Jalan Starship", 1000000);

        this.penggunas.add(instruktur1);
        this.penggunas.add(instruktur2);
        this.penggunas.add(instruktur3);
        this.penggunas.add(instruktur4);
        this.penggunas.add(new Murid("Amanda", "14/10/2004", "Jalan A", 1500000));
        this.penggunas.add(new Murid("Yoshelin", "01/06/2004", "Jalan B", 800000));
        this.penggunas.add(new Murid("Falinno", "20/12/2004", "Jalan C", 200000));
        this.penggunas.add(new Murid("Syifa", "09/08/2004", "Jalan D", 2500000));
        this.penggunas.add(new Murid("Chelsea", "10/10/2004", "Jalan E", 200000));

        String[] arrayInstruktur = {"Aristo", "Mark", "Rayyan", "Ilma", "Heri"};
        String[] arrayCourse = {"Dasar Programming", "ALIN", "MPKT", "SOSI", "PBP"};
        for (int i = 0; i < arrayInstruktur.length; i++) {
            try {
                Pengguna search = searchPengguna(arrayInstruktur[i]);
                if (search == null || !(search instanceof Instruktur)) {
                    throw new TeacherNotFoundException(arrayInstruktur[i]);
                }
                else {
                    this.courses.add(new Course((Instruktur) search, arrayCourse[i]));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        String[] arrayPaidInstruktur = {"Aristo", "Mark", "Heri"};
        String[] arrayPaidCourse = {"PBP", "Dasar Programming", "SOSI"};
        long[] arrayHarga = {140000, 200000, 100000};
        for (int i = 0; i < arrayPaidInstruktur.length; i++) {
            try {
                Pengguna search = searchPengguna(arrayPaidInstruktur[i]);
                if (search == null || !(search instanceof Instruktur)) {
                    throw new TeacherNotFoundException(arrayPaidInstruktur[i]);
                }
                else {
                    this.courses.add(new PaidCourse((Instruktur) search, arrayPaidCourse[i], arrayHarga[i]));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    

    public void enrollTraining(Scanner scanner) {
        ArrayList<Training> arrayListTraining = new ArrayList<>();
        System.out.println("Berikut daftar Training yang ditawarkan Lemao: ");
        int i = 1;
        for (Course course : courses) {
            if (course instanceof Training) {
                Training training = (Training) course;
                arrayListTraining.add(training);
                System.out.println(i + ". " + training.details());
                i++;
            }
        }
    
        System.out.print("Masukkan nomor course: ");
        int nomorCourse = scanner.nextInt();
    
        if (nomorCourse > 0 && nomorCourse <= arrayListTraining.size()) {
            Training selectedTraining = arrayListTraining.get(nomorCourse - 1);
    
            if (loginPengguna instanceof Murid) {
                if (!selectedTraining.isEnrolled(loginPengguna)) {
                    selectedTraining.enroll(loginPengguna);
                    enrolledCourses.add(selectedTraining);
                    selectedTraining.setActive(true);
                } else {
                    System.out.println("Gagal Enroll: " + selectedTraining.getName() + " sedang di enroll");
                }
            }
            else {
                bayarCourse(scanner, selectedTraining);
            }

        } else {
            System.out.println("Nomor course tidak valid");
        }
    }
    

    public void bayarCourse(Scanner scanner, PaidCourse course) {
        System.out.println("-------------- Payment ------------------");
        System.out.println("Metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.print("Pilih metode pembayaran: ");
        int paymentMethod = scanner.nextInt();
    
        try {
            if (paymentMethod == 1) {
                if (loginPengguna instanceof Murid) {
                    Murid murid = (Murid) loginPengguna;
                    loginPengguna.getPayment().add(new CashPayment(murid.getCourseCart(), loginPengguna));
                }
                processCashPayment(course);
                
            } else if (paymentMethod == 2) {
                System.out.print("Masukkan nomor credit card anda: ");
                String creditCardNumber = scanner.next();
                processCreditCardPayment(course, creditCardNumber);
            } else {
                System.out.println("Pilihan metode pembayaran tidak valid.");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
    

    private void processCashPayment(PaidCourse course) throws InsufficientBalanceException {
        long coursePrice;
        if (course != null) {
            coursePrice = course.getPrice();
        }
        else coursePrice = ((Murid) loginPengguna).getCourseCart().getTotalHarga();
        if (loginPengguna.getBalance() < coursePrice) {
            throw new InsufficientBalanceException("Saldo tidak mencukupi");
        }
        ((CanPay) loginPengguna).pay();
        if (loginPengguna instanceof Instruktur) System.out.println(course.getName() + " berhasil di enroll");
    }

    private void processCreditCardPayment(PaidCourse course, String creditCardNumber) throws InsufficientBalanceException {
        long coursePrice;
        if (course != null) {
            coursePrice = course.getPrice();
        }
        else coursePrice = ((Murid) loginPengguna).getCourseCart().getTotalHarga();
        if (loginPengguna.getBalance() < coursePrice) {
            throw new InsufficientBalanceException("Saldo tidak mencukupi");
        }

        if (!isValidCreditCardNumber(creditCardNumber)) {
            throw new InsufficientBalanceException("Invalid credit card number");
        }
        ((CanPay) loginPengguna).pay();
        if (loginPengguna instanceof Instruktur) System.out.println(course.getName() + " berhasil di enroll");
    }
    private boolean isValidCreditCardNumber(String creditCardNumber) {
        int nDigits = creditCardNumber.length();

        int sum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int digit = creditCardNumber.charAt(i) - '0';

            if (isSecond == true)
                digit = digit * 2;
            sum += digit / 10;
            sum += digit % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }

    public void lihatSaldo() {
        Murid murid = (Murid) loginPengguna;
        System.out.println("Saldo " + murid.getNama() + " sebesar Rp" + murid.getBalance() + ",-");
    }


}
