public class TeacherNotFoundException extends Exception {
    public TeacherNotFoundException(String teacherName) {
        super("TeacherNotFoundException: " + teacherName + " tidak ada didalam sistem");
    }
}
