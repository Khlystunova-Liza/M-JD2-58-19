package by.pvt.service;

import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SystemUsersServiceTest extends DBTestCase {

    SystemUsersService objectUnderTest;

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
    public void insert() {
    }

    @Test
    public void insertList() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}