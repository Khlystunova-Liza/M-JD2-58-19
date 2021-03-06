package by.pvt.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//обьект который генерирует id
@SequenceGenerator(name="empl_seq", sequenceName = "empl_seq")
public class Employee {

    @Id
    @GeneratedValue(generator = "empl_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private Date dateOfBirth;

    @Column
    private int empNumber;

    @ManyToOne
    private Department department;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails employeeDetails;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }


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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public void addProject(Project project){
        //project.addEmployee(this);
        if(projects ==null)projects = new ArrayList<>();
        projects.add(project);
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
        if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null)
            return false;
        return employeeDetails != null ? employeeDetails.equals(employee.employeeDetails) : employee.employeeDetails == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + empNumber;
        result = 31 * result + (employeeDetails != null ? employeeDetails.hashCode() : 0);
        return result;
    }
}