package entities;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Embeddable
public class StudentSubjectId implements Serializable {

    private int student_id;
    private int subject_id;

    public StudentSubjectId() {}

    public StudentSubjectId(int student_id, int subject_id) {
        this.student_id = student_id;
        this.subject_id = subject_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSubjectId that = (StudentSubjectId) o;
        return student_id == that.student_id && subject_id == that.subject_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, subject_id);
    }
}
