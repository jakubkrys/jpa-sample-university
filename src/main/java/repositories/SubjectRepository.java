package repositories;

import entities.Subject;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SubjectRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
    EntityManager entityManager = emf.createEntityManager();
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public Subject getSubjectByID(int id) {
        Subject subject = entityManager.find(Subject.class, id);
        return subject;
    }

    public void saveStudentToDatabase(Subject subject) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(subject);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void removeSubjectById(int id) {
        try {
            entityManager.getTransaction().begin();
            Subject subject = getSubjectByID(id);
            entityManager.remove(subject);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Subject> getSubjectByName(String name){
        // parametry nazwane
        TypedQuery<Subject> subject = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :name",Subject.class);
        subject.setParameter("name",name);

        return subject.getResultList();
    }

    public List<Subject> getSubjectByHoursPerSemester(Integer hoursPerSemester){
        // parametry nazwane
        TypedQuery<Subject> subject = entityManager.createQuery("SELECT s FROM Subject s WHERE s.hoursPerSemester = :hoursPerSemester",Subject.class);
        subject.setParameter("hoursPerSemester",hoursPerSemester);

        return subject.getResultList();
    }

    public List<Subject> getAll() {
        TypedQuery <Subject> query = entityManager.createQuery("SELECT s FROM Subject s",Subject.class);
        List <Subject> allSubjects = query.getResultList();
        return allSubjects;
    }

    public void editSubjectData(Subject subject) {
        System.out.println("Field to change: ");
        System.out.println("1 - name");
        System.out.println("2 - hours per semester");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                System.out.println("Current name: "+subject.getName());
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                entityManager.getTransaction().begin();
                subject.setName(newName);
                entityManager.getTransaction().commit();
                break;
            case 2:
                System.out.println("Current hours per semester value: "+subject.getHoursPerSemester());
                System.out.print("New hours per semester value: ");
                Integer newHoursPerSemester = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                subject.setHoursPerSemester(newHoursPerSemester);
                entityManager.getTransaction().commit();
                break;
        }
    }

    public Subject gatherAllSubjectData() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Hours per semester: ");
        Integer hoursPerSemester = scanner.nextInt();
        scanner.nextLine();
        return new Subject(name, hoursPerSemester);
    }
}