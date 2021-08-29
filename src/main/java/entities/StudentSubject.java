package entities;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name="student_subject")
public class StudentSubject implements Serializable {

    @EmbeddedId
    private StudentSubjectId studentSubjectId;

    @Column(name="grade")
    private Integer grade;

    public StudentSubject() {}

    public StudentSubject(StudentSubjectId studentSubjectId, Integer grade) {
        this.studentSubjectId = studentSubjectId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\n Student_Subject ID: " + studentSubjectId + "\n" +
                " Grade: " + grade + "\n";
    }
}