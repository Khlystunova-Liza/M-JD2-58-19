package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EngineTest {

    Engine engine;

    static Engine createEngine(int index){

        Engine engine = new Engine();
        engine.setModel("model" + index);
        engine.setNumber("124547659ehfbceeg34t" + index);
        return engine;

    }

    @Before
    public void createAndSaveEngine(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{

            tx = session.beginTransaction();
            Car car = CarTest.createCar(3);
            session.save(car);
            engine = createEngine(1);
            engine.setCar(car);
            session.save(engine);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }
    }

    @Test
    public void testSaveEngine(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            List<Engine> from_engine = session.createQuery("from engine").list();
            assertEquals(1,from_engine.size());
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

    @Test
    public void testUpdateEngine(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            engine.setModel("update");
            session.update(engine);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Engine> from_engine = session.createQuery("from engine").list();
            Engine engine = from_engine.get(0);
            assertEquals("update",engine.getModel());
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

    @Test
    public void testGetEngine(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            Engine engineLoud = session.get(Engine.class, engine.getId());
            assertEquals(engine,engineLoud);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

    @Test
    public void testDeleteEngine(){

        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            session.delete(engine);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Engine> from_engine = session.createQuery("from engine").list();
            assertEquals(0,from_engine.size());
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

    @After
    public  void deleteEngineAndCar(){
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try{
            tx = session.beginTransaction();
            List<Engine> from_engine = session.createQuery("from engine").list();
            tx.commit();
            session.close();

            session =HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            if(from_engine.size()!=0)
            session.delete(engine);
            tx.commit();

            session =HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Car> from_car = session.createQuery("from car").list();
            Car car = from_car.get(0);
            session.delete(car);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }finally {
            session.close();
        }

    }

}