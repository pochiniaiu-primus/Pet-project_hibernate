package hibernate_crud.crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadObjectFromDatabaseOnNameAndSalary {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps =
                    session.createQuery("from Employee where firstName ='Alexander'" +
                                    "AND salary>650")
                            .getResultList();
            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
