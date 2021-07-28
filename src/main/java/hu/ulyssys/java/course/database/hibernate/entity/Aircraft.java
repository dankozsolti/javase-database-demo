package hu.ulyssys.java.course.database.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "aircraft")
public class Aircraft extends AbstractEntity implements Serializable {
}
