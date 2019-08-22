package by.pvt.repository;

import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import by.pvt.util.HibernateUtil;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class EmployeeRepositoryTest extends DBTestCase {

    private Session testSession;

    public EmployeeRepositoryTest(String name) {
        super(name);
        testSession = HibernateUtil.getInstance().getTestSession();
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hello_hibernate_junit?useSSL=false");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
    }

    @Override
    public IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(EmployeeRepositoryTest.class.getResourceAsStream("Employees.xml"));
    }

    @Test
    public void testFindAll() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        List<Employee> result = employeeRepository.findAll();
        assertNotNull(result);
        assertTrue(result.size() == 3);
    }

    @Test
    public void testFindEmployeesNames() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        List<String> employeesNames = employeeRepository.findEmployeesNames();
        for (String employeesName : employeesNames) {
            System.out.println(employeesName);
        }
        final List<String> saveNames = List.of("Ivanov", "Petrov", "Sidorov");
        assertEquals(saveNames,employeesNames);
    }

    @Test
    public void testFindEmployeeDetails() {
        EmployeeRepository repository = new EmployeeRepository(testSession);
        List<EmployeeDetails> employeeDetails = repository.findEmployeeDetails();
        for (EmployeeDetails detail : employeeDetails) {
            System.out.println(detail);
        }
        assertEquals(2,employeeDetails.size());
    }

    @Test
    public void testGetEmployeeCount() {
        EmployeeRepository repository = new EmployeeRepository(testSession);
        Long employeeCount = repository.getEmployeeCount();
        assertEquals(3,employeeCount.longValue());
    }
}