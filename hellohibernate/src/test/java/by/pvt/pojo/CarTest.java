package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarTest {

    Car car;

    @Before
    public void createAndSaveCar(){
        car = createCar(3);
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {
            tx = session.beginTransaction();
            session.save(car);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        }finally {
            session.close();
        }

    }

    static Car createCar(int index){
        Car car =  new Car();
        car.setBrand("BMW"+index);
        car.setModel("X6"+index);
        car.setYear("2018"+index);
        car.setRun("0");
        return  car;
    }

    @Test
    public void testSaveCar(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {

            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            assertEquals(1, from_car.size());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    @Test
    public void testGetCar(){
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;

        try{

            tx = session.beginTransaction();
            Car carLoad = session.get(Car.class,0);
            assertEquals(car,carLoad);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void testUpdateCar(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {

            tx = session.beginTransaction();
            car.setModel("update");
            session.update(car);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            Car car = from_car.get(0);
            assertEquals("update",car.getModel());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Test
    public void testDeleteCar(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {
            tx = session.beginTransaction();
            session.delete(car);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            assertEquals(0, from_car.size());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @After
    public void deleteCar(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            if(from_car.size()!=0)
                session.delete(car);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

}