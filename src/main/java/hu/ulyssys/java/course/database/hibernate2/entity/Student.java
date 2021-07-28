package hu.ulyssys.java.course.database.hibernate2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student extends AbstractPerson implements Serializable {

    @Column(name = "friends_number")
    private int friendsNumber;

    public Student() {
    }

    public Student(String firstName, String lastName, int friendsNumber) {
        super(firstName, lastName);
        this.friendsNumber = friendsNumber;
    }

    public int getFriendsNumber() {
        return friendsNumber;
    }

    public void setFriendsNumber(int friendsNumber) {
        this.friendsNumber = friendsNumber;
    }
}
