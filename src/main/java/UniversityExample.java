import entities.Student;
import repositories.StudentRepository;
import java.util.*;

public class UniversityExample {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        Scanner scanner = new Scanner(System.in);
        Student student;
        int option;
        int id;

        do {
            System.out.println("1 - get student by ID");
            System.out.println("2 - get all students");
            System.out.println("3 - add new student to database");
            System.out.println("4 - change student's data");
            System.out.println("5 - remove student from database by ID");
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
                    // get all students
                    id = 1;
                    while (studentRepository.getStudentByID(id) != null){
                        student = studentRepository.getStudentByID(id);
                        System.out.println(student);
                        id++;
                    }
                    break;
                case 3:
                    // add new student to database
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Second name: ");
                    String secondName = scanner.nextLine();
                    System.out.print("Surname: ");
                    String surname = scanner.nextLine();
                    System.out.print("E-mail address: ");
                    String emailAddress = scanner.nextLine();
                    System.out.print("Phone number (9 digits): ");
                    Integer phoneNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Student group ID: ");
                    Integer studentGroupId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Index number (6 digits): ");
                    Integer indexNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Student card number (8 digits): ");
                    Integer studentCardNumber = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(name,secondName,surname,emailAddress,phoneNumber,studentGroupId,indexNumber,studentCardNumber);
                    studentRepository.saveStudentToDatabase(newStudent);
                    System.out.println("Student "+name+" "+surname+" successfully added to database.");
                    break;
                case 5:
                    System.out.print("Student's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    studentRepository.removeStudentById(id);
                    System.out.println("Student "+id+" successfully removed from database.");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}