package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentTest {

    Department department;

    static Department createDepartment(int index){

        Department department = new Department();
        department.setName("name"+index);
        department.setLocation("location"+index);
        return department;
    }

    @Before
    public void saveDepartmentAndEmployees(){
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            department = createDepartment(1);

            Employee employee1 = EmployeeTest.createEmployee(1);
            Employee employee2 = EmployeeTest.createEmployee(2);
            employee1.setDepartment(department);
            employee2.setDepartment(department);

            session.save(employee1);
            session.save(employee2);
            session.save(department);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            fail();
        }
    }

    @Test
    public void testSaveDepartment(){
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            List from_department = session.createQuery("from department").list();
            assertEquals(1,from_department.size());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            fail();
        }
    }

    @After
    public void testDeleteDepartment(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {
            tx = session.beginTransaction();

            Department department = session.get(Department.class, 1L);
            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                session.delete(employee);
            }
            session.delete(department);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw  e;
        }finally {
            session.close();
        }
    }

}