package by.pvt;

import by.pvt.dto.SystemUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HelloWorldServletTest {

    // how to work with object
    @Test
    public void testMapper(){
        SystemUsers systemUsers = new SystemUsers();
        systemUsers.setActive(true);
        systemUsers.setId(100);
        systemUsers.setUsername("TestUsers");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
            try{
                json = objectMapper.writeValueAsString(systemUsers);
                System.out.println(json);
            }catch (JsonProcessingException e){
                e.printStackTrace();

            }
            assertNotNull(json);
    }

}