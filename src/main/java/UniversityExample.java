import entities.Student;
import repositories.StudentRepository;
import java.util.*;

public class UniversityExample {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        Scanner scanner = new Scanner(System.in);
        Student student;
        Integer indexNumber;
        Integer studentCardNumber;
        int option;
        int id;

        do {
            System.out.println("1 - get student by ID");
            System.out.println("2 - get student by index number");
            System.out.println("3 - get all students");
            System.out.println("4 - add new student to database");
            System.out.println("5 - change student's data");
            System.out.println("6 - remove student from database by ID");
            System.out.println("7 - remove student from database by student card number");
            System.out.println("0 - close app");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // get student by ID
                    System.out.print("Student's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    student = studentRepository.getStudentByID(id);
                    System.out.println(student);
                    break;
                case 2:
                    // get student by index number
                    System.out.print("Index number (6 digits): ");
                    indexNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(studentRepository.getStudentByIndexNumber(indexNumber));
                    break;
                case 3:
                    // get all students
                    System.out.println(studentRepository.getAll());
                    break;
                case 4:
                    // add new student to database
                    Student newStudent = studentRepository.gatherAllStudentData();
                    studentRepository.saveStudentToDatabase(newStudent);
                    System.out.println("Student "+newStudent.getName()+" "+newStudent.getSurname()+" successfully added to database.");
                    break;
                case 5:
                    // change student's data
                    System.out.print("Student's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    student = studentRepository.getStudentByID(id);
                    studentRepository.editStudentData(student);
                    System.out.println("Data of student "+id+": "+student.getName()+" "+student.getSurname()+" changed.");
                    break;
                case 6:
                    // remove student from database by ID
                    System.out.print("Student's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    studentRepository.removeStudentById(id);
                    System.out.println("Student "+id+" successfully removed from database.");
                    break;
                case 7:
                    // remove student from database by student card number
                    System.out.print("Student card number: ");
                    studentCardNumber = scanner.nextInt();
                    scanner.nextLine();
                    studentRepository.removeStudentByStudentCardNumber(studentCardNumber);
                    System.out.println("Student "+studentCardNumber+" successfully removed from database.");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}