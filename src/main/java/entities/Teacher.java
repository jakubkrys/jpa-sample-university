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

    @ManyToOne
    private Subject subject;

    public Teacher() {}

    public Teacher(String name, String secondName, String surname, String emailAddress, Integer phoneNumber, String academicDegree, Subject subject) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.academicDegree = academicDegree;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
                " Subject: " + subject + "\n";
    }
}