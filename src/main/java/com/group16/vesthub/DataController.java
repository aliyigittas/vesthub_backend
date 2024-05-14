package com.group16.vesthub;

import javax.sql.DataSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class DataController {
    
    private DatabaseAdapter dbAdapter;
    public DataController(DataSource dataSource) {
        dbAdapter = new DatabaseAdapter(dataSource);
    }


    @PostMapping("/api/login")
    public String receiveDataFromSignIn(@RequestBody String data) {

        System.out.println("Received data from frontend: " + data); 
        try 
        {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to User object
            User user = mapper.readValue(data, User.class);
            
            // Check if user exists in the database
            if (dbAdapter.checkUserExists(user.getEmail())) 
            {
                // Get user from database
                User userFromDB = dbAdapter.signIn(user.getEmail(), user.getPassword());
                
                // Check if user exists
                if (userFromDB != null) 
                {
                    // Convert User object to JSON string
                    String userJson = mapper.writeValueAsString(userFromDB);
                    
                    // Return JSON string
                    return userJson;
                }
                else 
                {
                    return null;
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/api/register")
    public boolean receiveDataFromSignUp(@RequestBody String data) {        
        try 
        {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to User object
            User user = mapper.readValue(data, User.class);

            // Print received data
            System.out.println("Received data from frontend: " + data);
            if (dbAdapter.checkUserExists(user.getEmail())) 
            {
                return false;
            }
            //insert database
            dbAdapter.insertUser(user.getName(), user.getSurname(), user.getEmail(), user.getPhone(), user.getPassword(), user.getFullAddress(), user.getCity(), user.getCountry(), 1);
            
            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
      
    }


}

