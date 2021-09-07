package hibernate_one_to_one.one_to_one.uni_directional_association;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UniDirectionalCreateObjectInDatabase {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Detail.class)
                        .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Employee employee =
//                    new Employee("Zaur", "Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "123456789", "zaurtregulov@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //"==========================================================="

//            session = factory.getCurrentSession();
//            Employee employee =
//                    new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow", "987654321", "olejka@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //"==========================================================="
//          get information about details from database an employee with id = 1
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            System.out.println(emp.getEmpDetail());
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //"==========================================================="
//          delete object from database
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
