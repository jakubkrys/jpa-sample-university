package repositories;

import entities.Student;

import javax.persistence.*;

public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
    EntityManager entityManager = emf.createEntityManager();

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
}
