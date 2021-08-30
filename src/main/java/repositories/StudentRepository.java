package repositories;

import entities.Student;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
    EntityManager entityManager = emf.createEntityManager();
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public Student getStudentByID(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    public void saveStudentToDatabase(Student student1) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student1);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void removeStudentById(int id) {
        try {
            entityManager.getTransaction().begin();
            Student student = getStudentByID(id);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Student> getStudentByIndexNumber(Integer indexNumber){
        // łączenie stringów
//        TypedQuery <Student> student = entityManager.createQuery("SELECT s FROM Student s WHERE s.indexNumber = '"+indexNumber+"'",Student.class);

        // parametry indeksowe
//        TypedQuery <Student> student = entityManager.createQuery("SELECT s FROM Student s WHERE s.indexNumber = ?1",Student.class);
//        student.setParameter(1,indexNumber);

        // parametry nazwane
        TypedQuery <Student> student = entityManager.createQuery("SELECT s FROM Student s WHERE s.indexNumber = :indexNumber",Student.class);
        student.setParameter("indexNumber",indexNumber);

        return student.getResultList();
    }

    public List<Student> getAll() {
        TypedQuery <Student> query = entityManager.createQuery("SELECT s FROM Student s",Student.class);
        List <Student> allStudents = query.getResultList();
        return allStudents;
    }

    public void removeStudentByStudentCardNumber(Integer studentCardNumber) {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.studentCardNumber = :studentCardNumber");
            query.setParameter("studentCardNumber",studentCardNumber);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
        }
    }

    public void editStudentData(Student student) {
        System.out.println("Field to change: ");
        System.out.println("1 - name");
        System.out.println("2 - second name");
        System.out.println("3 - surname");
        System.out.println("4 - e-mail address");
        System.out.println("5 - phone number");
        System.out.println("6 - student group ID");
        System.out.println("7 - index number");
        System.out.println("8 - student card number");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                System.out.println("Current name: "+student.getName());
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setName(newName);
                entityManager.getTransaction().commit();
                break;
            case 2:
                System.out.println("Current second name: "+student.getSecondName());
                System.out.print("New second name: ");
                String newSecondName = scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setSecondName(newSecondName);
                entityManager.getTransaction().commit();
                break;
            case 3:
                System.out.println("Current surname: "+student.getSurname());
                System.out.print("New surname: ");
                String newSurname = scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setSurname(newSurname);
                entityManager.getTransaction().commit();
                break;
            case 4:
                System.out.println("Current e-mail address: "+student.getEmailAddress());
                System.out.print("New e-mail address: ");
                String newEmailAddress = scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setEmailAddress(newEmailAddress);
                entityManager.getTransaction().commit();
                break;
            case 5:
                System.out.println("Current phone number: "+student.getPhoneNumber());
                System.out.print("New phone number (9 digits): ");
                Integer newPhoneNumber = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setPhoneNumber(newPhoneNumber);
                entityManager.getTransaction().commit();
                break;
            case 6:
                System.out.println("Current student group ID: "+student.getStudentGroupId());
                System.out.print("New student group ID: ");
                Integer newStudentGroupId = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setStudentGroupId(newStudentGroupId);
                entityManager.getTransaction().commit();
                break;
            case 7:
                System.out.println("Current index number: "+student.getIndexNumber());
                System.out.print("New index number (6 digits): ");
                Integer newIndexNumber = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setIndexNumber(newIndexNumber);
                entityManager.getTransaction().commit();
                break;
            case 8:
                System.out.println("Current student card number: "+student.getStudentCardNumber());
                System.out.print("New student card number (8 digits): ");
                Integer newStudentCardNumber = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                student.setStudentCardNumber(newStudentCardNumber);
                entityManager.getTransaction().commit();
                break;
        }
    }

    public Student gatherAllStudentData() {
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
        return new Student(name,secondName,surname,emailAddress,phoneNumber,studentGroupId,indexNumber,studentCardNumber);
    }
}