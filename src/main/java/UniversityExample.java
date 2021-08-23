import Entities.Student;

import javax.persistence.*;

public class UniversityExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
        EntityManager entityManager = emf.createEntityManager();

        // pobieranie po ID
//        Student student = entityManager.find(Student.class, 300);
//        System.out.println(student);

        // zapis do bazy danych
//        Student student1 = new Student("Adrian", "Spejson", "Puchacki", "adrian.puchacki@student.edu.pl", 222333444, 7, 404009, 87564231);
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(student1);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//        }
    }
}