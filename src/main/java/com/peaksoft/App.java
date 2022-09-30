package com.peaksoft;
import com.peaksoft.entity.Employee;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main( String[] args ) {

        Employee employee1 = new Employee("AZA","BAYMATOV",20);
        creat(employee1);
        Employee employee2 = new Employee("AZA","KALMARZAEV",21);
        creat(employee2);
        Employee employee3 = new Employee("KUTTUBEK","JALALOV",22);
        creat(employee3);
        Employee employee4 = new Employee("AZA","ISMAYLIEV",23);
        creat(employee4);
        Employee employee5 = new Employee("MEDER","TYNYCHBEKOV",24);
        creat(employee5);

        read();

        update(2,"AZA",18);
        update(4,"AZA",18);
        update(1,"AZA",18);

        deleteAll("AZA");


    }
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
