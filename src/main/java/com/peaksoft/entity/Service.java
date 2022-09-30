package com.peaksoft.entity;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class Service {

    public static int creat(Employee employee){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно" + employee);
        return employee.getId();
    }

    public static List<Employee> read() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Employee> employees =
                session.createQuery(" FROM Employee  emp WHERE emp.name = 'AZA' AND emp.age > 20").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Основывать" + employees.size() + "employees");
        return employees;
    }

    public static void update(int id, String name, int age) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Employee em = session.get(Employee.class, id);
        em.setName(name);
        em.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешное обнавление!");

    }

    public static void deleteAll(String name) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM  Employee WHERE name = :name").setParameter("name",name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("удалаение по именам успешно");
    }
}
