package hibernate_crud.crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateObjectInDatabase {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
//            Employee emp =
//                    new Employee("Zaur", "Tregulov", "IT", 500);
            Employee emp =
                    new Employee("Alexander", "Ivanov", "IT",
                            600);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Done!");
            System.out.println(emp);
        } finally {
            factory.close();
        }
    }
}
