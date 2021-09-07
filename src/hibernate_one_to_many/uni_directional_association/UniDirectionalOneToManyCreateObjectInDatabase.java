package hibernate_one_to_many.uni_directional_association;

import hibernate_one_to_many.entity_uni_directional.Department;
import hibernate_one_to_many.entity_uni_directional.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UniDirectionalOneToManyCreateObjectInDatabase {
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
//                    new Department("HR", 1500, 500);
//            Employee emp1 =
//                    new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 =
//                    new Employee("Andrey", "Sidorov", 1000);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
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
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department =
//                    session.get(Department.class, 2);
//            System.out.println(department);
//
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
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
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            session.close();
//            factory.close();
//        }
//  ==================================================================================
//       delete employee from table employees
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department =
                    session.get(Department.class, 3);
            session.delete(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
