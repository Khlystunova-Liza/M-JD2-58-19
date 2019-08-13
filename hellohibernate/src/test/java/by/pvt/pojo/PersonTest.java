package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import static junit.framework.TestCase.assertEquals;


public class PersonTest {

    @Test
    public void testPerson() {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;
        try {
            //save person
            tx = session.beginTransaction();
            Person person = createPerson();
            session.saveOrUpdate(person);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Person> personList = session.createQuery("from Person").list();
            assertEquals(1, personList.size());
            Person p2 = personList.get(0);
            assertEquals(person, p2);
            tx.commit();
            session.close();

            //get
            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            Person getPerson = session.get(Person.class, 1);

            assertEquals(getPerson.getId(),1);
            tx.commit();
            session.close();

            //update
            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            person.setFirstName("UpdateName");
            session.update(person);

            Person personUpdate = session.get(Person.class, 1);
            assertEquals("UpdateName",personUpdate.getFirstName());
            tx.commit();
            session.close();

            //delete
            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            session.delete(person);
            List<Person> list = session.createQuery("from Person").list();
            assertEquals(0,list.size());

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    private static Person createPerson() {

        Person person = new Person();
        person.setId(1);
        person.setFirstName("FirstName");
        person.setLastName("LastName");
        person.setGender('f');
        person.setDateOfBirth(new Date());

        return person;
    }

}