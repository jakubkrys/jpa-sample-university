package entities;

import javax.persistence.*;

@Entity
@Table(name="student_group")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="specialization")
    private String specialization;

    public StudentGroup() {}

    public StudentGroup(int id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "\nSTUDENT GROUP " + id + ":\n" +
                " Specialization: " + specialization + "\n";
    }
}