package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    static Employee createTestData(int index){
        Employee employee = new Employee();
        employee.setName("Name" +index);
        employee.setTitle("Employee");
        employee.setEmpNumber(index);
        return employee;
    }

    @Test
    public void testSaveOrUpdate(){

        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.saveOrUpdate(createTestData(1));
            session.saveOrUpdate(createTestData(2));
            session.saveOrUpdate(createTestData(3));
            tx.commit();

        }catch (Exception e){
            if(tx != null)tx.rollback();
            assertEquals(true,false);
        }finally {
            session.close();
        }

    }


}