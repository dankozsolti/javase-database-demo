package hu.ulyssys.java.course.database.hibernate2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Teacher")
public class Teacher extends AbstractPerson implements Serializable {

    @Column(name = "courses_number")
    private int coursesNumber;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, int coursesNumber) {
        super(firstName, lastName);
        this.coursesNumber = coursesNumber;
    }

    public int getCoursesNumber() {
        return coursesNumber;
    }

    public void setCoursesNumber(int coursesNumber) {
        this.coursesNumber = coursesNumber;
    }
}
