package by.pvt.pojo;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "car")
@SequenceGenerator(name = "car_seq",sequenceName = "car_seq")
public class Car {

    @Id
    @GeneratedValue(generator = "car_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String brand;

    private String model;

    private String year;

    private String run;

    @OneToOne(mappedBy = "car")
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!id.equals(car.id)) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (year != null ? !year.equals(car.year) : car.year != null) return false;
        return run != null ? run.equals(car.run) : car.run == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (run != null ? run.hashCode() : 0);
        return result;
    }
}
