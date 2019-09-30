package by.pvt;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderPaymentService {


    public List<OrderCmd> getAllOrders(int maxCount ){

        List<OrderCmd> list = new ArrayList<>(maxCount);
        for (int i = 0; i < maxCount ; i++) {
            list.add(new OrderCmd((long)i,(long)i,Math.random(),
                    i,"Comments",new Date()));

        }

        return list;
    }


    public OrderCmd getOrderById(int orderId) {

        return new OrderCmd((long) orderId, 1L, 1D,
                -1, "Singl order", new Date());


    }

    public void createNewOrder(OrderCmd newOrder) {
        //new POjo
        //
    }
}
