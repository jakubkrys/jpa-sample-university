import entities.*;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.*;

public class UniversityExample {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        Scanner scanner = new Scanner(System.in);
        Student student;
        Teacher teacher;
        Integer indexNumber;
        Integer studentCardNumber;
        String academicDegree;
        int option;
        int id;

        do {
            System.out.println("---------------- STUDENTS ------------");
            System.out.println("1 - get student by ID");
            System.out.println("2 - get student by index number");
            System.out.println("3 - get all students");
            System.out.println("4 - add new student to database");
            System.out.println("5 - change student's data");
            System.out.println("6 - remove student from database by ID");
            System.out.println("7 - remove student from database by student card number");
            System.out.println("--------------- TEACHERS ----------------");
            System.out.println("11 - get teacher by ID");
            System.out.println("12 - get teacher by subject ID");
            System.out.println("13 - get teacher by academic degree");
            System.out.println("14 - get all teachers");
            System.out.println("15 - add new teacher to database");
            System.out.println("16 - change teacher's data");
            System.out.println("17 - remove teacher from database by ID");
            System.out.println("-------------------------------------------------");

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
                case 11:
                    // get teacher by ID
                    System.out.print("Teacher's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    teacher = teacherRepository.getTeacherByID(id);
                    System.out.println(teacher);
                    break;
                case 12:
                    // get teacher by subject ID
                    System.out.print("Subject ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    List <Teacher> teachersById = teacherRepository.getTeacherBySubjectID(id);
                    System.out.println(teachersById);
                    break;
                case 13:
                    // get teacher by academic degree
                    System.out.print("Academic degree: ");
                    academicDegree = scanner.nextLine();
                    List <Teacher> teachersByAcademicDegree = teacherRepository.getTeacherByAcademicDegree(academicDegree);
                    System.out.println(teachersByAcademicDegree);
                    break;
                case 14:
                    // get all teachers
                    System.out.println(teacherRepository.getAll());
                    break;
                case 15:
                    // add new teacher to database
                    Teacher newTeacher = teacherRepository.gatherAllTeacherData();
                    teacherRepository.saveTeacherToDatabase(newTeacher);
                    System.out.println("Student "+newTeacher.getName()+" "+newTeacher.getSurname()+" successfully added to database.");
                    break;
                case 16:
                    // change teacher's data
                    System.out.print("Teacher's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    teacher = teacherRepository.getTeacherByID(id);
                    teacherRepository.editTeacherData(teacher);
                    System.out.println("Data of teacher "+id+": "+teacher.getName()+" "+teacher.getSurname()+" changed.");
                    break;
                case 17:
                    // remove teacher from database by ID
                    System.out.print("Teacher's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    teacherRepository.removeTeacherById(id);
                    System.out.println("Teacher "+id+" successfully removed from database.");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}