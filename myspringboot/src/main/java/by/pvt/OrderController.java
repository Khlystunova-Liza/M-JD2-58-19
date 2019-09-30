package by.pvt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OrderController {

    Logger log = Logger.getLogger("OrderController");

    @Autowired
    OrderPaymentService orderPaymentService;

    @GetMapping("/order")
    public List<OrderCmd> getOrders(@RequestParam int maxCount){

        if(maxCount < 1)throw new IllegalArgumentException();

        return orderPaymentService.getAllOrders(maxCount);
    }

    @GetMapping("/order/{oderId}")
    public OrderCmd getOrder(@PathVariable("oderId")int orderId) {

        return orderPaymentService.getOrderById(orderId);


    }

    @PostMapping("/")
    public void createNewOrder(@RequestBody OrderCmd newOrder) {
        orderPaymentService.createNewOrder(newOrder);
        log.info("New order: " + newOrder);
    }

    @PutMapping("/order/{id}")
    public void updateOrder(@PathVariable int id,
                            @RequestBody OrderCmd order){
        log.info("Update order ID= "+id+" "+order);

    }

    @DeleteMapping
    public void deleteOrder(@PathVariable int id){
        log.info("Delete order ID= "+id);

    }
}
