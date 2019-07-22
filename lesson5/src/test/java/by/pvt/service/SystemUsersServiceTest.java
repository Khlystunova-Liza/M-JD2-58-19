package by.pvt.service;

import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import org.junit.Test;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class SystemUsersServiceTest extends DBTestCase {

    SystemUsersService objectUnderTest;
    SystemUsers systemUser;

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
                .build(HelloMysqlTest.class
                        .getResourceAsStream("system_users.xml"));
    }

    @Test
    public void testGetSystemUsers() {

        objectUnderTest = new SystemUsersService();
        try {
            objectUnderTest.setSqlSessionFactory(new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<SystemUsers> systemUsers = objectUnderTest.getSystemUsers();
        assertEquals(4,systemUsers.size());

    }

    @Test
    public void testInsert() {

        objectUnderTest = new SystemUsersService();
        try {
            objectUnderTest.setSqlSessionFactory(new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        systemUser = new SystemUsers();
        systemUser.setUsername("GuestTest");
        systemUser.setActive(true);
        systemUser.setId(6);


        objectUnderTest.insert(systemUser);
        assertEquals(5,objectUnderTest.getSystemUsers().size());

    }

    @Test
    public void testInsertList() {

        objectUnderTest = new SystemUsersService();
        try {
            objectUnderTest.setSqlSessionFactory(new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SystemUsers systemUser2 = new SystemUsers();
        systemUser2.setId(7);
        systemUser2.setActive(false);
        systemUser2.setUsername("Guest7");

        systemUser = new SystemUsers();
        systemUser.setUsername("Guest8");
        systemUser.setActive(true);
        systemUser.setId(8);

        List<SystemUsers> systemUsersList = new ArrayList<SystemUsers>();
        systemUsersList.add(systemUser);
        systemUsersList.add(systemUser2);

        objectUnderTest.insert(systemUsersList);
        assertEquals(6,objectUnderTest.getSystemUsers().size());
    }

    @Test
    public void testDelete() {
        objectUnderTest = new SystemUsersService();
        try {
            objectUnderTest.setSqlSessionFactory(new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
            ));

            objectUnderTest.delete(2);
            assertEquals(3,objectUnderTest.getSystemUsers().size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {
        objectUnderTest = new SystemUsersService();
        try {
            objectUnderTest.setSqlSessionFactory(new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
            ));

            systemUser = new SystemUsers();
            systemUser.setUsername("user6");
            systemUser.setId(7);
            systemUser.setActive(true);
            objectUnderTest.insert(systemUser);
            assertEquals("user6",systemUser.getUsername());

            systemUser.setUsername("UserUpdate");
            objectUnderTest.update(systemUser);
            assertEquals("UserUpdate",systemUser.getUsername());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}