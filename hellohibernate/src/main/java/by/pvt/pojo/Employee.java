package by.pvt.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
//обьект который генерирует id
@SequenceGenerator(name="empl_seq", sequenceName = "empl_seq")
public class Employee {

    @Id
    @GeneratedValue(generator = "empl_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String title;

    private Date dateOfBirth;

    private int empNumber;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails employeeDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empNumber != employee.empNumber) return false;
        if (!id.equals(employee.id)) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (title != null ? !title.equals(employee.title) : employee.title != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + empNumber;
        return result;
    }
}
