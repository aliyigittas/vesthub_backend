package com.group16.vesthub;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;


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
                    VesthubApplication.currentlyLoggedIn = dbAdapter.getOwnerID(user.getEmail()); //ownerID için
                    
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

    @GetMapping("/api/getPhotos/{id}")
    public String[] getPhoto(@PathVariable int id) {
        return dbAdapter.getPhotos(id);
        
    }

    @GetMapping("/api/myListings/{ownerMail}")
    public String getMyHouses(@PathVariable String ownerMail) {
        int id = dbAdapter.getOwnerID(ownerMail);
        List<House> myHouses = dbAdapter.getMyHouses(id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String myHousesJson = mapper.writeValueAsString(myHouses);
            return myHousesJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/favorites/{ownerMail}")
    public String getMyFavorites(@PathVariable String ownerMail) {
        int id = dbAdapter.getOwnerID(ownerMail);
        List<House> myFavoriteHouses = dbAdapter.getMyFavorites(id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String myHousesJson = mapper.writeValueAsString(myFavoriteHouses);
            return myHousesJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/addFavorite")
    public boolean addFavorite(@RequestBody String data) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to User object
            JsonNode rootNode = mapper.readTree(data);
            int houseID = rootNode.get("houseID").asInt();
            String ownerMail = rootNode.get("ownerMail").asText();
            int ownerID = dbAdapter.getOwnerID(ownerMail);
            dbAdapter.addFavorite(ownerID, houseID);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/api/removeFavorite")
    public boolean removeFavorite(@RequestBody String data) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to User object
            JsonNode rootNode = mapper.readTree(data);
            int houseID = rootNode.get("houseID").asInt();
            String ownerMail = rootNode.get("ownerMail").asText();
            int ownerID = dbAdapter.getOwnerID(ownerMail);
            dbAdapter.updateFavorite(ownerID, houseID, 0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //check favorite

    @GetMapping("api/featuredHomes")
    public String getFeaturedHomes() {
        List<House> featuredHomes = dbAdapter.getFeaturedHomes();
        //get house photos from databse
        for (int i = 0; i < featuredHomes.size(); i++) {
            String[] photos = dbAdapter.getPhotos(featuredHomes.get(i).getId());
            featuredHomes.get(i).setImages(photos);
        }
        System.out.println("Featured Homes: " + featuredHomes.size());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String featuredHomesJson = mapper.writeValueAsString(featuredHomes);
            return featuredHomesJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/result/{param}")
    public String getSearchResults(@PathVariable String param) {
        List<House> searchResults = dbAdapter.getAllHouses();
        //get house photos from databse
        for (int i = 0; i < searchResults.size(); i++) {
            String[] photos = dbAdapter.getPhotos(searchResults.get(i).getId());
            searchResults.get(i).setImages(photos);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String searchResultsJson = mapper.writeValueAsString(searchResults);
            return searchResultsJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

            JsonNode imagesNode = rootNode.get("images");
            List<String> images = mapper.convertValue(imagesNode, new TypeReference<List<String>>() {});
            /* 
            for (int i = 0; i < images.size(); i++) {
                //delete the first part of the string
                String[] parts = images.get(i).split(",");
                images.set(i, parts[1]);
            }
            */

            // Parse JSON string to House object
            House house = mapper.readValue(data, House.class);
            house.setOwnerID(VesthubApplication.currentlyLoggedIn); //owner
            house.setApproved(0);
            //parse the keyfeatures array
            for (int i = 0; i < keyFeatures.size(); i++) {
                String feature = keyFeatures.get(i);
                if (feature.equals("Fiber Internet")) {
                    house.setFiberInternet(1);
                } else if (feature.equals("Air Conditioner")) {
                    house.setAirConditioner(1);
                } else if (feature.equals("Floor Heating")) {
                    house.setFloorHeating(1);
                } else if (feature.equals("Fireplace")) {
                    house.setFireplace(1);
                } else if (feature.equals("Terrace")) {
                    house.setTerrace(1);
                } else if (feature.equals("Satellite")) {
                    house.setSatellite(1);
                } else if (feature.equals("Parquet")) {
                    house.setParquet(1);
                } else if (feature.equals("Steel Door")) {
                    house.setSteelDoor(1);
                } else if (feature.equals("Furnished")) {
                    house.setFurnished(1);
                } else if (feature.equals("Insulation")) {
                    house.setInsulation(1);
                }
            }

            
            //insert database
            //dbAdapter.insertHouse(house.getOwnerID(), house.getTitle(), house.getDescription(), house.getCity(), house.getDistinct(), house.getStreet(), house.getFullAddress(), house.getPrice(), house.getNumOfBathroom(), house.getNumOfBedroom(), house.getNumOfRooms(), house.getArea(), house.getLat(), house.getLng(), house.getSaleRent(), house.getApproved(), house.getFloor(), house.getTotalFloor(), house.getFiberInternet(), house.getAirConditioner(), house.getFloorHeating(), house.getFireplace(), house.getTerrace(), house.getSatellite(), house.getParquet(), house.getSteelDoor(), house.getFurnished(), house.getInsulation(), house.getStatus(), house.getHouseType());

            //Şu an tüm özellikler formdan gelmediği için dummy insert
            
            dbAdapter.insertHouse(dbAdapter.getOwnerID(house.getOwnerMail()), house.getTitle(), house.getDescription(), house.getCity(), house.getDistinct(), house.getStreet(), house.getFullAddress(), house.getPrice(), 1, 1, "2+1", 75, house.getLat(), house.getLng(), "Sale", house.getApproved(), 2, 5, house.getFiberInternet(), house.getAirConditioner(), house.getFloorHeating(), house.getFireplace(), house.getTerrace(), house.getSatellite(), house.getParquet(), house.getSteelDoor(), house.getFurnished(), house.getInsulation(), "Available", "Apartment", house.getOwnerMail());
            
            
            int lastHouseID = dbAdapter.getLatestHouseID();
            System.out.println("Last house ID: " + lastHouseID);
            for (int i = 0; i < images.size(); i++) {
                dbAdapter.insertImage(images.get(i), lastHouseID);
            }

            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/api/house/{id}")
    public String getHouse(@PathVariable int id) {
        // Get house ID from URL
        House house = dbAdapter.getHouseByID(id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String houseJson = mapper.writeValueAsString(house);
            return houseJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/checkFavorite")
    public String checkFavorite(@RequestParam int houseID, @RequestParam String ownerMail) {
        int ownerID = dbAdapter.getOwnerID(ownerMail);
        System.out.println("Check ownerId:"+ownerID);
        boolean isFavorite = dbAdapter.checkFavorite(ownerID, houseID, 1); 
        return isFavorite ? "true" : "false";
    }
    
}

