package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;


public class EmployeeDetailsTest {

    private static EmployeeDetails createEmployeeDetails(int index){

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setStreet("Pr.Mira " + index);
        employeeDetails.setCity("Mogilev " + index);
        employeeDetails.setAddressLine("27b flat 12 " + index);
        return employeeDetails;
    }

    @Test
    public  void testSaveOrUpdate(){

        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Employee employee = EmployeeTest.createEmployee(1);
            Employee employee1 = EmployeeTest.createEmployee(222);
            session.save(employee);
            session.save(employee1);
            EmployeeDetails employeeDetails = createEmployeeDetails(1);
            EmployeeDetails employeeDetails1 = createEmployeeDetails(222);
            employeeDetails.setEmployee(employee);
            employeeDetails1.setEmployee(employee1);
            session.saveOrUpdate(employeeDetails);
            session.saveOrUpdate(employeeDetails1);
            tx.commit();


        }catch (Exception e){
            if(tx != null)tx.rollback();
            assertEquals(true,false);
        }finally {
            session.close();
        }
    }

}