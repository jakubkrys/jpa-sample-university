package entities;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="hours_per_semester")
    private Integer hoursPerSemester;

    public Subject() {}

    public Subject(String name, Integer hoursPerSemester) {
        this.name = name;
        this.hoursPerSemester = hoursPerSemester;
    }

    @Override
    public String toString() {
        return "\nSUBJECT " + id + ":\n" +
                " Name: " + name + "\n" +
                " Hours per semester: " + hoursPerSemester + "\n";
    }
}
