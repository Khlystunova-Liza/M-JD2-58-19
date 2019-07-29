package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class PersonTest {



    @Test
    public void testSavePerson(){
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person p = createTestData();
            session.save(p);
            tx.commit();
            session.close();
            session =HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Person> personList =session.createQuery("from person").list();

            assertEquals(1,personList.size());
            tx.commit();
            Person p2 = personList.get(0);
            assertEquals(p,p2);
        }
        catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    private static Person createTestData(){
        Person person = new Person();
        person.setId(1);
        person.setFirstName("FirstName");
        person.setLastName("LastName");
        person.setGender('f');
        person.setDateOfBirth(new Date());
        return person;
    }


}