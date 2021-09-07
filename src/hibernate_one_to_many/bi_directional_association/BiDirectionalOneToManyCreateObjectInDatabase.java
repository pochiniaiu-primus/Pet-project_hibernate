package hibernate_one_to_many.bi_directional_association;

import hibernate_one_to_many.entity_bi_directional.Department;
import hibernate_one_to_many.entity_bi_directional.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalOneToManyCreateObjectInDatabase {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Department.class)
                        .buildSessionFactory();
        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//            Department department =
//                    new Department("Sales", 1500, 800);
//            Employee emp1 =
//                    new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 =
//                    new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 =
//                    new Employee("Anton", "Sidorov", 1200);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
//============================================================================================
// get from table departments department and all employees with this department
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Get department");
            Department department =
                    session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Download information about all employees");
            department.getEmps().get(0);

            session.getTransaction().commit();
            System.out.println("Done!");
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
        } finally {
            session.close();
            factory.close();
        }
        //============================================================================================
// get from table employees employee and department where work this employee
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee =
//                    session.get(Employee.class, 1);
//            System.out.println(employee);
//
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
//  ==================================================================================
//       delete employee from table employees
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee =
//                    session.get(Employee.class, 4);
//            session.delete(employee);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
    }
}
