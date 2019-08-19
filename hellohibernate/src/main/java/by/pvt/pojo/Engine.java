package by.pvt.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "engine")
public class Engine {

    @Id
    @GeneratedValue
    @GenericGenerator(name ="id",strategy = "increment")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String model;

    private String number;

    @OneToOne
    private Car car;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (!id.equals(engine.id)) return false;
        if (model != null ? !model.equals(engine.model) : engine.model != null) return false;
        if (number != null ? !number.equals(engine.number) : engine.number != null) return false;
        return car != null ? car.equals(engine.car) : engine.car == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }
}
