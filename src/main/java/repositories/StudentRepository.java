package repositories;

import entities.Student;

import javax.persistence.*;
import java.util.*;

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
}
