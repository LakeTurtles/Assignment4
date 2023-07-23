public class UserService {

    public Student createStudent (Integer studentID, String studentName, String course, Integer grade) {
        Student student = new Student(studentID, studentName, course, grade);

            return student;
        }


    public String[] parseText(String input){
        String[] userInfo = input.split(",");
        return  userInfo;
    }
}
