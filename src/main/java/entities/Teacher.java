package entities;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="second_name")
    private String secondName;

    @Column(name="surname")
    private String surname;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private Integer phoneNumber;

    @Column(name="academic_degree")
    private String academicDegree;

    @Column(name="subject_id")
    private Integer subjectId;

    public Teacher() {}

    public Teacher(int id, String name, String secondName, String surname, String emailAddress, Integer phoneNumber, String academicDegree, Integer subjectId) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.academicDegree = academicDegree;
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "\nTEACHER "+id+":\n"+
                " Name: " + name + "\n" +
                " Second name: " + secondName + "\n" +
                " Surname: " + surname + "\n" +
                " E-mail address: " + emailAddress + "\n" +
                " Phone number: " + phoneNumber + "\n" +
                " Academic degree: " + academicDegree + "\n" +
                " Subject ID: " + subjectId + "\n";
    }
}