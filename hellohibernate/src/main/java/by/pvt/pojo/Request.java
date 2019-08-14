package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name ="Request")
public class Request implements Serializable {

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

    public Request() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }


    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public String getNameOfCoffeeMachine() {
        return nameOfCoffeeMachine;
    }
    public void setNameOfCoffeeMachine(String nameOfCoffeeMachine) {
        this.nameOfCoffeeMachine = nameOfCoffeeMachine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (personId != request.personId) return false;
        if (contact != null ? !contact.equals(request.contact) : request.contact != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(request.deliveryAddress) : request.deliveryAddress != null)
            return false;
        return nameOfCoffeeMachine != null ? nameOfCoffeeMachine.equals(request.nameOfCoffeeMachine) : request.nameOfCoffeeMachine == null;
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