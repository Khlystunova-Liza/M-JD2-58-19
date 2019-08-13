package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name ="Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 4934025357325982076L;

    @Id
    private int id;
    @Column
    private int personId;
    @Column
    private String contact;
    @Column
    private String deliveryAddress;
    @Column
    private String nameOfCoffeeMachine;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public int getPersonId() {
        return personId;
    }

    public String getContact() {
        return contact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getNameOfCoffeeMachine() {
        return nameOfCoffeeMachine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setNameOfCoffeeMachine(String nameOfCoffeeMachine) {
        this.nameOfCoffeeMachine = nameOfCoffeeMachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (personId != order.personId) return false;
        if (contact != null ? !contact.equals(order.contact) : order.contact != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(order.deliveryAddress) : order.deliveryAddress != null)
            return false;
        return nameOfCoffeeMachine != null ? nameOfCoffeeMachine.equals(order.nameOfCoffeeMachine) : order.nameOfCoffeeMachine == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personId;
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        result = 31 * result + (nameOfCoffeeMachine != null ? nameOfCoffeeMachine.hashCode() : 0);
        return result;
    }
}