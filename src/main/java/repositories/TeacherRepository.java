package repositories;

import entities.*;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TeacherRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
    EntityManager entityManager = emf.createEntityManager();
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public Teacher getTeacherByID(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        return teacher;
    }

    public void saveTeacherToDatabase(Teacher teacher) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void removeTeacherById(int id) {
        try {
            entityManager.getTransaction().begin();
            Teacher teacher = getTeacherByID(id);
            entityManager.remove(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Teacher> getTeacherBySubjectID(Integer subjectID){
//        // łączenie stringów
////        TypedQuery <Teacher> Teacher = entityManager.createQuery("SELECT s FROM Teacher s WHERE s.indexNumber = '"+indexNumber+"'",Teacher.class);
//
//        // parametry indeksowe
////        TypedQuery <Teacher> Teacher = entityManager.createQuery("SELECT s FROM Teacher s WHERE s.indexNumber = ?1",Teacher.class);
////        Teacher.setParameter(1,indexNumber);
//
//        // parametry nazwane
        TypedQuery <Teacher> teacher = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.subjectId = :subjectID",Teacher.class);
        teacher.setParameter("subjectID",subjectID);

        return teacher.getResultList();
    }

    public List<Teacher> getTeacherByAcademicDegree(String academicDegree){
//        // łączenie stringów
////        TypedQuery <Teacher> Teacher = entityManager.createQuery("SELECT s FROM Teacher s WHERE s.indexNumber = '"+indexNumber+"'",Teacher.class);
//
//        // parametry indeksowe
////        TypedQuery <Teacher> Teacher = entityManager.createQuery("SELECT s FROM Teacher s WHERE s.indexNumber = ?1",Teacher.class);
////        Teacher.setParameter(1,indexNumber);
//
//        // parametry nazwane
        TypedQuery <Teacher> teacher = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.academicDegree = :academicDegree",Teacher.class);
        teacher.setParameter("academicDegree",academicDegree);

        return teacher.getResultList();
    }

    public List<Teacher> getAll() {
        TypedQuery <Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t",Teacher.class);
        List <Teacher> allTeachers = query.getResultList();
        return allTeachers;
    }

    public void editTeacherData(Teacher teacher) {
        System.out.println("Field to change: ");
        System.out.println("1 - name");
        System.out.println("2 - second name");
        System.out.println("3 - surname");
        System.out.println("4 - e-mail address");
        System.out.println("5 - phone number");
        System.out.println("6 - academic degree");
        System.out.println("7 - subject ID");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                System.out.println("Current name: "+teacher.getName());
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setName(newName);
                entityManager.getTransaction().commit();
                break;
            case 2:
                System.out.println("Current second name: "+teacher.getSecondName());
                System.out.print("New second name: ");
                String newSecondName = scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setSecondName(newSecondName);
                entityManager.getTransaction().commit();
                break;
            case 3:
                System.out.println("Current surname: "+teacher.getSurname());
                System.out.print("New surname: ");
                String newSurname = scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setSurname(newSurname);
                entityManager.getTransaction().commit();
                break;
            case 4:
                System.out.println("Current e-mail address: "+teacher.getEmailAddress());
                System.out.print("New e-mail address: ");
                String newEmailAddress = scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setEmailAddress(newEmailAddress);
                entityManager.getTransaction().commit();
                break;
            case 5:
                System.out.println("Current phone number: "+teacher.getPhoneNumber());
                System.out.print("New phone number (9 digits): ");
                Integer newPhoneNumber = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setPhoneNumber(newPhoneNumber);
                entityManager.getTransaction().commit();
                break;
            case 6:
                String newTeacherAcademicDegree = "";
                System.out.println("Current teacher academic degree: "+teacher.getAcademicDegree());
                System.out.println("New teacher academic degree: ");
                System.out.println("1 - Magister");
                System.out.println("2 - Doktor");
                System.out.println("3 - Profesor");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 1:
                        newTeacherAcademicDegree = "Magister";
                        break;
                    case 2:
                        newTeacherAcademicDegree = "Doktor";
                        break;
                    case 3:
                        newTeacherAcademicDegree = "Profesor";
                        break;
                }
                entityManager.getTransaction().begin();
                teacher.setAcademicDegree(newTeacherAcademicDegree);
                entityManager.getTransaction().commit();
                break;
            case 7:
                System.out.println("Current subject ID: "+teacher.getSubjectId());
                System.out.print("New subject ID: ");
                Integer newSubjectId = scanner.nextInt();
                scanner.nextLine();
                entityManager.getTransaction().begin();
                teacher.setSubjectId(newSubjectId);
                entityManager.getTransaction().commit();
                break;
        }
    }

    public Teacher gatherAllTeacherData() {
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
        System.out.print("Academic degree: ");
        String academicDegree = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Subject ID: ");
        Integer subjectId = scanner.nextInt();
        scanner.nextLine();
        return new Teacher(name,secondName,surname,emailAddress,phoneNumber,academicDegree,subjectId);
    }
}