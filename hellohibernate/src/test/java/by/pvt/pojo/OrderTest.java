package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertEquals;


public class OrderTest {

    @Test
    public void testSaveOrder(){
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = null;
        try{

            tx = session.beginTransaction();
            Order order = createOrder();

            session.save(order);
            tx.commit();
            session.close();

           /* session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            //достает из бд лист заказов при помощи языка hql
            List<Order> orderList = session.createQuery("from Order").list();
            assertEquals(1,orderList.size());

            Order order1 = orderList.get(0);
            assertEquals(order,order1);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            Order loadOrder = session.get(Order.class, 1);
            assertEquals(order,loadOrder);
            tx.commit();*/


        }catch (Exception e){
            if (tx != null) tx.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    private static Order createOrder() {

        Order order = new Order();
        order.setId(1);
        order.setPersonId(2);
        order.setContact("contactPerson");
        order.setDeliveryAddress("deliveryAddressP");
        order.setNameOfCoffeeMachine("NameOfCoffeeMachine");

        return order;
    }
}
