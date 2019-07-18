package by.pvt.service;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import java.sql.*;

public class HelloMysqlTest extends DBTestCase {

    public HelloMysqlTest(String name) {
        super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hello_mysql_junit" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root" );
    }
    //удаляет данные из базы после теста
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder()
                .build(HelloMysqlTest.class.getResourceAsStream("system_users.xml"));
    }

    //проверяет есть ли данные в таблице
    @Test
    public void testConnection(){

        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from system_users");
            ResultSet resultSet = preparedStatement.executeQuery();

            int rowCount = 0;
            while (resultSet.next()){
                rowCount++;
            }
            assertEquals(4,rowCount);

            assertNotNull(resultSet);

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
