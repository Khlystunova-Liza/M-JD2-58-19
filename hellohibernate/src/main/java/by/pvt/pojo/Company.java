package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "company")
public class Company implements Serializable {

    public static final long serialVersionUID = -2530759826378761624L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String location;

    @OneToMany(mappedBy = "company")
    private List<Car> cars;


    @ManyToMany
    List<StakeHolder> stakeHolders;

    public Company() {
    }

    public List<StakeHolder> getStakeHolders() {
        return stakeHolders;
    }

    public void setStakeHolders(List<StakeHolder> stakeHolders) {
        this.stakeHolders = stakeHolders;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!id.equals(company.id)) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (location != null ? !location.equals(company.location) : company.location != null) return false;
        return cars != null ? cars.equals(company.cars) : company.cars == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }
}
