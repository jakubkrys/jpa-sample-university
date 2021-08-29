import Entities.Student;

import javax.persistence.*;
import java.util.*;

public class UniversityExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
        EntityManager entityManager = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1 - save");
            System.out.println("2 - get by ID");
            System.out.println("0 - close app");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    //zapis do bazy danych
                    Student student1 = new Student("Adrian", "Spejson", "Puchacki", "adrian.puchacki@student.edu.pl", 222333444, 7, 404009, 87564231);
                    try {
                        entityManager.getTransaction().begin();
                        entityManager.persist(student1);
                        entityManager.getTransaction().commit();
                    } catch (Exception e) {
                        entityManager.getTransaction().rollback();
                    }
                    break;
                case 2:
                    // pobieranie po ID
                    Student student = entityManager.find(Student.class, 300);
                    System.out.println(student);
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}