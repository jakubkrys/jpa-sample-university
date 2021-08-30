package entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="second_name")
    private String secondName;

    private String surname;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private Integer phoneNumber;

    @Column(name="student_group_id")
    private Integer studentGroupId;

    @Column(name="index_number")
    private Integer indexNumber;

    @Column(name="student_card_number")
    private Integer studentCardNumber;

    public Student () {}

    public Student(String name, String secondName, String surname, String emailAddress, Integer phoneNumber, Integer studentGroupId, Integer indexNumber, Integer studentCardNumber) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.studentGroupId = studentGroupId;
        this.indexNumber = indexNumber;
        this.studentCardNumber = studentCardNumber;
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

    public Integer getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(Integer studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Integer getStudentCardNumber() {
        return studentCardNumber;
    }

    public void setStudentCardNumber(Integer studentCardNumber) {
        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public String toString() {
        return "\nSTUDENT "+id+":\n"+
                " Name: " + name + "\n" +
                " Second name: " + secondName + "\n" +
                " Surname: " + surname + "\n" +
                " E-mail address: " + emailAddress + "\n" +
                " Phone number: " + phoneNumber + "\n" +
                " Student group ID: " + studentGroupId + "\n" +
                " Index number: " + indexNumber + "\n" +
                " Student card number: " + studentCardNumber + "\n";
    }
}
