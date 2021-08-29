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

    public Subject(int id, String name, Integer hoursPerSemester) {
        this.id = id;
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
