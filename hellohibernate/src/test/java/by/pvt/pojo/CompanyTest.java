package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CompanyTest {

    Company company;

     static Company createCompany(int index){
        Company company = new Company();
        company.setCompanyName("companyName"+index);
        company.setLocation("location"+index);
        return company;
        }

    @Before
    public void saveCompany(){
        Transaction tx = null;

        try(Session session = HibernateUtil.getInstance().getSession()){
            tx = session.beginTransaction();
            company = createCompany(1);
            Car car1 = CarTest.createCar(3);
            Car car2 = CarTest.createCar(4);
            car1.setCompany(company);
            car2.setCompany(company);

            session.save(car1);
            session.save(car2);

            session.save(company);

            tx.commit();
        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }
    }

    @Test
    public void testSaveCompany(){
        Transaction tx = null;

        try(Session session = HibernateUtil.getInstance().getSession()){
            tx = session.beginTransaction();
            List<Company> from_company = session.createQuery("from company").list();
            assertEquals(1,from_company.size());
            tx.commit();
        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }

    }

    @Test
    public void testGetCompany(){
        Transaction tx = null;

        try(Session session = HibernateUtil.getInstance().getSession()){
            tx = session.beginTransaction();

            Company companyLoud = session.get(Company.class, company.getId());

            assertEquals(company.getCompanyName(),companyLoud.getCompanyName());
            assertEquals(company.getId(),companyLoud.getId());
            assertEquals(company.getLocation(),companyLoud.getLocation());

            tx.commit();
        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }

    }

    @Test
    public void testUpdateCompany(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();

        try{
            tx = session.beginTransaction();
           company.setLocation("UpdateLocation");
           session.update(company);
           tx.commit();
           session.close();

           session = HibernateUtil.getInstance().getSession();
           tx = session.beginTransaction();
            List<Company> from_company = session.createQuery("from company").list();
            Company company = from_company.get(0);
            assertEquals("UpdateLocation",company.getLocation());
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

    @After
    public void deleteCompany(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{

            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            if(from_car.size()!=0) {
                for (Car car : from_car) {
                    session.delete(car);
                }
            }
            List<Company> from_company = session.createQuery("from company").list();
            Company company = from_company.get(0);
            session.delete(company);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {

            session.close();

        }
    }


}