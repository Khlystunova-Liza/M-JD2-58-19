package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 5001717241530963232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private Date startDate;

    private Date endDate;

    @ManyToMany
    private List<Employee> employees;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void addEmployee(Employee employee){
        employee.addProject(this);
        if(employees==null)employees = new ArrayList<>();
        employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (startDate != null ? !startDate.equals(project.startDate) : project.startDate != null) return false;
        if (endDate != null ? !endDate.equals(project.endDate) : project.endDate != null) return false;
        return employees != null ? employees.equals(project.employees) : project.employees == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
