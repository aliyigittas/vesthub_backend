package com.group16.vesthub;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class DataController {
    public HashMap<String, Integer> housefeauter = new HashMap<String, Integer>();
    private DatabaseAdapter dbAdapter;
    public DataController(DataSource dataSource) {
        dbAdapter = new DatabaseAdapter(dataSource);
        housefeauter.put("fiberInternet", 0);
        housefeauter.put("airConditioner", 0);
        housefeauter.put("floorHeating", 0);
        housefeauter.put("fireplace", 0);
        housefeauter.put("terrace", 0);
        housefeauter.put("satellite", 0);
        housefeauter.put("parquet", 0);
        housefeauter.put("steelDoor", 0);
        housefeauter.put("furnished", 0);
        housefeauter.put("insulation", 0);
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

    @PostMapping("/api/CreateListing")
    public boolean receiveDataFromAddHouse(@RequestBody String data) 
    {
        try 
        {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            JsonNode rootNode = mapper.readTree(data);

        // Extract keyFeatures array from the JsonNode
            JsonNode keyFeaturesNode = rootNode.get("keyFeatures");
            List<String> keyFeatures = mapper.convertValue(keyFeaturesNode, new TypeReference<List<String>>() {});
            
            // Parse JSON string to House object
            //House house = mapper.readValue(data, House.class);

            // Print received data
            System.out.println("Received data from frontend: " + data);

            System.out.println("Key Features: " + keyFeatures);
            
            //insert database
            //dbAdapter.insertHouse(house.getOwnerID(), house.getTitle(), house.getDescription(), house.getCity(), house.getDistinct(), house.getStreet(), house.getFullAddress(), house.getPrice(), house.getNumOfBathroom(), house.getNumOfBedroom(), house.getNumOfRooms(), house.getArea(), house.getLat(), house.getLng(), house.getSaleRent(), house.getApproved(), house.getFloor(), house.getTotalFloor(), house.getFiberInternet(), house.getAirConditioner(), house.getFloorHeating(), house.getFireplace(), house.getTerrace(), house.getSatellite(), house.getParquet(), house.getSteelDoor(), house.getFurnished(), house.getInsulation(), house.getStatus(), house.getHouseType());
            
            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }


}

