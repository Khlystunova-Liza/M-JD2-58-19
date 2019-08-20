package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "department")
@SequenceGenerator(name ="department_seq" ,sequenceName  = "department_seq")
public class Department implements Serializable {

    private static final long serialVersionUID = -3317690100087338053L;

    @Id
    @GeneratedValue(generator = "department_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return employees != null ? employees.equals(that.employees) : that.employees == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }
}


