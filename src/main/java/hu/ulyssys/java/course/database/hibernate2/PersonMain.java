package hu.ulyssys.java.course.database.hibernate2;
import hu.ulyssys.java.course.database.hibernate2.DatabaseSessionProvider;
import hu.ulyssys.java.course.database.hibernate2.entity.Student;
import hu.ulyssys.java.course.database.hibernate2.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonMain {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Teacher","Name",12);
        insertTeacher(teacher);

        //Save
        Student student = new Student("Student","Student2",15);
        Long id = insertStudent(student);
        // find By id
        Student persistStudent = findById(id);
        // lekérdezzük
        persistStudent.setFriendsNumber(2);
        persistStudent.setFirstName("test");
        update(persistStudent);
        findAll().forEach(student1 -> {
            System.out.println(student1.getId()+" "+student1.getFirstName()+" "+student1.getLastName()
            + " " + student1.getFriendsNumber());
        });
        DatabaseSessionProvider.getInstance().getSessionObj().close();
    }

    private static List<Student> findAll() {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Student> query = session.createQuery("select n from Student n", Student.class);
        return query.getResultList();
    }

    private static void update(Student student) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    private static Student findById(Long id) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(Student.class, id);
    }

    private static Long insertTeacher(Teacher teacher) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        return teacher.getId();
    }

    private static Long insertStudent(Student student) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        return student.getId();
    }
}


