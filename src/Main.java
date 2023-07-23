import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Student[] userArray = new Student[100];    //////////////////////////

        try (BufferedReader dirFile = new BufferedReader(new FileReader("src/student-master-list.csv"))) {
            String input;
            int count = 0;
            dirFile.readLine();
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");

                Integer studentID = Integer.parseInt(data[0]);
                String studentName = data[1];
                String classroom = data[2];
                Integer gradeInClass = Integer.parseInt(data[3]) ;


                userArray[count] = new UserService().createStudent(studentID, studentName, classroom, gradeInClass);
                count++;
            }
        }

        for(Student student : userArray){
            if(student != null){
                System.out.println(student.getCourse());
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////


        Student[] compSciStudents = new Student[34];
        int compSciStudentCount = 0;

        Student[] apMathStudents = new Student[33];
        int apMathStudentCount = 0;

        Student[] statStudents = new Student[33];
        int statStudentCount = 0;

        for(Student student : userArray){
            Student newStudent = student;
            if(newStudent != null){

                if (newStudent.getCourse().contains("COMPSCI")){
                    compSciStudents[compSciStudentCount] = newStudent;
                    compSciStudentCount++;
//                    System.out.println(newStudent);
                }
                if(newStudent.getCourse().contains("APMTH")){
                    apMathStudents[apMathStudentCount] = newStudent;
                    apMathStudentCount++;
//                    System.out.println(newStudent);
                }
                if(newStudent.getCourse().contains("STAT")){
                    statStudents[statStudentCount] = newStudent;
                    statStudentCount++;
//                    System.out.println(newStudent);
                }
            }

        }

//////////////////////////////////////////////////////////////////////////////////////


        try {
            Arrays.sort(compSciStudents);
            Arrays.sort(apMathStudents);
            Arrays.sort(statStudents);
        }catch (Exception e){
            e.printStackTrace();

        }
        


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("course1.csv"))){
            writer.write("Student ID,Student Name,Course,Grade\n");
            for(Student student: compSciStudents){
                if (student != null){
                    writer.write(student.toString());
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("course2.csv"))){
            writer.write("Student ID,Student Name,Course,Grade\n");
            for(Student student: apMathStudents){
                if (student != null){
                    writer.write(student.toString());
                }

            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("course3.csv"))){
            writer.write("Student ID,Student Name,Course,Grade\n");
            for(Student student: statStudents){
                if (student != null){
                    writer.write(student.toString());
                }
            }
        }







    }
}