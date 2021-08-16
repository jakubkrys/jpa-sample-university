import javax.persistence.*;

public class UniversityExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university");
        EntityManager entityManager = emf.createEntityManager();
    }
}