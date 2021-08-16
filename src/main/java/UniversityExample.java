import Entities.Student;

import javax.persistence.*;

public class UniversityExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
        EntityManager entityManager = emf.createEntityManager();

        Student student = entityManager.find(Student.class, 1);
        System.out.println(student);
    }
}