package hibernate_one_to_one.one_to_one.bi_directional_association;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalCreateObjectInDatabase {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Detail.class)
                        .buildSessionFactory();
        Session session = null;
        try {
            //"==========================================================="
//            save object in database
//            session = factory.getCurrentSession();
//            Employee employee =
//                    new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New-York", "654123789", "nikolay@gmail.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
            //"==========================================================="
//          get object from database, get information about employee using details
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class,4);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
            //"==========================================================="
//          delete details from table details
//          employee with this details from table employees also will be deleted
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 4);
//            session.delete(detail);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
            //"==========================================================="
//          delete just details from table details
//          change CascadeType in class Detail from ALL to PERSIST and REFRESH
            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);// employee with id 1 will be not deleted from table employees
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
