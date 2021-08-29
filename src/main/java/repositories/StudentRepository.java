package repositories;

import entities.Student;

import javax.persistence.*;
import java.util.List;

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

//    public Student getStudentByIndexNumber(Integer indexNumber) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.createQuery("SELECT s FROM Student s WHERE s.index_number=:indexNumber",Student.class);
//
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//        }
//        return;
//    }

    public List<Student> getAll() {
        TypedQuery <Student> query = entityManager.createQuery("SELECT s FROM Student s",Student.class);
        List <Student> allStudents = query.getResultList();
        return allStudents;
    }
}
