import entities.Student;
import repositories.StudentRepository;
import java.util.*;

public class UniversityExample {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1 - get student by ID");
            System.out.println("2 - get all students");
            System.out.println("3 - add new student to database");
            System.out.println("4 - change student's data");
            System.out.println("5 - remove student from database");
            System.out.println("0 - close app");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // get student by ID
                    System.out.print("Student's ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Student student = studentRepository.getStudentByID(id);
                    System.out.println(student);
                    break;
                case 3:
                    // add new student to database
                    Student student1 = new Student("Adrian", "Spejson", "Puchacki", "adrian.puchacki@student.edu.pl", 222333444, 7, 404009, 87564231);
                    studentRepository.saveStudentToDatabase(student1);
                    break;

            }
        } while (option != 0);
        scanner.close();
    }
}