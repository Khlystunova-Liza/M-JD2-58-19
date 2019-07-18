package by.pvt.service;

import by.pvt.dto.SystemUsers;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.sql.*;
import java.util.List;


public class SystemUsersServiceTest extends DBTestCase  {

    public SystemUsersServiceTest() {
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS
                , "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL
                , "jdbc:mysql://localhost:3306/hello_mysql_junit" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME
                , "root" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD
                , "root" );
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder()
                .build(SystemUsersServiceTest.class
                        .getResourceAsStream("system_users.xml"));
    }

    private SystemUsers systemUser = new SystemUsers();

    @Test
    public void getSystemUsersTest() {
      try(Connection connection = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit"
                              ,"root","root");

          PreparedStatement preparedStatement = connection.prepareStatement("select * from system_users");
          ResultSet resultSet = preparedStatement.executeQuery())
        {
            List<SystemUsers> systemUsers =  new SystemUsersService().getSystemUsers();
            int users = 0 ;
            while(resultSet.next()){
              users++;
             }
            assertEquals(users,systemUsers.size());

        } catch (SQLException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void insertTest() {
        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit"
                        ,"root"
                        ,"root"))
        {
            systemUser.setId(5);
            systemUser.setActive(true);
            systemUser.setUsername("Guest5");
            systemUser.setDateofbirth(new Date(12));

            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from system_users where id=5");
            ResultSet resultSet = preparedStatement.executeQuery();

            assertEquals(5,resultSet.getInt("id"));
            assertTrue(resultSet.getBoolean("active"));
            assertEquals("Guest5",resultSet.getString("username"));
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteTest() {
        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit"
                        ,"root"
                        ,"root"))
        {
            new SystemUsersService().delete(4);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from system_users where id = 4");
            ResultSet resultSet = preparedStatement.executeQuery();

            int users = 0;
            while(resultSet.next()){
                users++;
            }
            assertEquals(0,users);
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTest() {
        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit"
                        ,"root"
                        ,"root"))
        {
            systemUser.setUsername("GuestUpdate");
            systemUser.setActive(false);
            new SystemUsersService().update(systemUser);

            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from system_users where id =5");
            ResultSet resultSet = preparedStatement.executeQuery();

            assertEquals("GuestUpdate",resultSet.getString("username"));
            assertFalse(resultSet.getBoolean("active"));

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}