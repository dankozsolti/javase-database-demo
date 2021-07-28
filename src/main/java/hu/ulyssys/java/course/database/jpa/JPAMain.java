package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.CustomerDAO;
import hu.ulyssys.java.course.database.jpa.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAMain {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();

        EntityManager entityManager = Persistence.createEntityManagerFactory("TestPersistence").createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = new Customer("Zsanko Dolt","dpara",123);
        customerDAO.save(customer);

        customerDAO.findAll().forEach(customer1 -> System.out.println(customer1.getId()+" "+customer1.getFullName()));
        customerDAO.findByName("Zsanko Dolt").forEach(customer1 -> {
            customer1.setFullName("Keske"+System.currentTimeMillis());
        customerDAO.update(customer1);
        });

        customerDAO.findAll().forEach(customer1 -> {
            System.out.println(customer1.getId() + " " + customer1.getFullName() + " " + customer1.getUsername());
        });
    }
}
