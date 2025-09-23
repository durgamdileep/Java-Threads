package com.dileep.withhibernate;

import com.dileep.withhibernate.Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Build Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // load hibernate.cfg.xml

        // Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setSalary(50000);

            session.persist(emp);

            tx.commit();
            System.out.println("Employee saved successfully");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
