package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ProjectTest {

    private Project project;

    private static Project createProject(int index){
        Project project = new Project();
        project.setProjectName("projectName"+index);
        project.setStartDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,365);
        project.setEndDate(calendar.getTime());
        return project;
    }

    @Before
    public void createProjectAndEmployees(){
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            project = createProject(1);
            Employee employee = EmployeeTest.createEmployee(5);
            Employee employee2 = EmployeeTest.createEmployee(6);

            session.save(employee);
            session.save(employee2);

            project.addEmployee(employee);
            project.addEmployee(employee2);
            session.save(project);
            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
    }

    @Test
    public void testSaveProject(){
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {

            tx = session.beginTransaction();
            List from_project = session.createQuery("from project").list();
            assertEquals(1,from_project.size());
            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }

    }

    @After
    public void deleteProjectAndEmployees(){
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            if(project!=null) {
                List<Employee> employees = project.getEmployees();
                if(employees.size()!=0) {
                    for (Employee employee : employees) {
                        session.delete(employee);
                    }
                }
                session.delete(project);
            }
            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
    }

}