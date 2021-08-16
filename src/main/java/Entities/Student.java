package Entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    private int id;

    private String name;

    @Column(name="second_name")
    private String secondName;

    private String surname;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="student_group_id")
    private Integer studentGroupId;

    @Column(name="index_number")
    private Integer indexNumber;

    @Column(name="student_card_number")
    private Integer studentCardNumber;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", studentGroupId=" + studentGroupId +
                ", indexNumber=" + indexNumber +
                ", studentCardNumber=" + studentCardNumber +
                '}';
    }
}
