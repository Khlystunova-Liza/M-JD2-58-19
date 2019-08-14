package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertEquals;



public class RequestTest {

    @Test
    public void testSaveRequest(){
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;
        try{
            //save
            tx = session.beginTransaction();
            Request request = createRequest();

            session.saveOrUpdate(request);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Request> orderList = session.createQuery("from Request").list();
            assertEquals(1,orderList.size());
            Request request1 = orderList.get(0);
            assertEquals(request,request1);
            tx.commit();
            session.close();

            //get
            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            Request loadOrder = session.get(Request.class, 1);
            assertEquals(request,loadOrder);
            tx.commit();
            session.close();

            //update
            session = HibernateUtil.getInstance().getSession();
            tx  = session.beginTransaction();
            request.setNameOfCoffeeMachine("nameUpdate");
            session.update(request);
            Request request2 = session.get(Request.class, 1);
            assertEquals("nameUpdate",request2.getNameOfCoffeeMachine());
            tx.commit();
            session.close();

            //delete
            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            session.delete(request);

            List<Request> from_request = session.createQuery("from Request").list();
            assertEquals(0,from_request.size());
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    private static Request createRequest() {

        Request request = new Request();
        request.setId(1);
        request.setPersonId(2);
        request.setContact("contactPerson");
        request.setDeliveryAddress("deliveryAddressP");
        request.setNameOfCoffeeMachine("NameOfCoffeeMachine");

        return request;
    }
}
