package com.peaksoft;
import com.peaksoft.entity.Employee;
import static com.peaksoft.entity.Service.*;
public class App {
    public static void main( String[] args ) {

        Employee employee1 = new Employee("AZA", "BAYMATOV", 20);
        creat(employee1);
        Employee employee2 = new Employee("AZA", "KALMARZAEV", 21);
        creat(employee2);
        Employee employee3 = new Employee("KUTTUBEK", "JALALOV", 22);
        creat(employee3);
        Employee employee4 = new Employee("AZA", "ISMAYLIEV", 23);
        creat(employee4);
        Employee employee5 = new Employee("MEDER", "TYNYCHBEKOV", 24);
        creat(employee5);

        read();

        update(2, "AZA", 18);
        update(4, "AZA", 18);
        update(1, "AZA", 18);

        deleteAll("AZA");
    }
}
