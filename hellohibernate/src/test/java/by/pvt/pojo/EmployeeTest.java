package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeTest {

    static Employee createEmployee(int index){
        Employee employee = new Employee();
        employee.setName("Name" +index);
        employee.setDateOfBirth(new Date());
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
            session.saveOrUpdate(createEmployee(3));
            session.saveOrUpdate(createEmployee(4));
            session.saveOrUpdate(createEmployee(5));
            tx.commit();

        }catch (Exception e){
            if(tx != null)tx.rollback();
            assertEquals(true,false);
        }finally {
            session.close();
        }

    }


}