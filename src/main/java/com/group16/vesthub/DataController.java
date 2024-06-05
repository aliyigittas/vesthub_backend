package com.group16.vesthub;

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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



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
            //print only profilePicture from frontend using mapper
            //System.out.println("User Photo: " + mapper.readTree(data).get("profilePicture").asText());
            //System.out.println("User Photo: " + user.getProfilePicture());
            // Print received data

            


            System.out.println("Received data from frontend: " + data);
            if (dbAdapter.checkUserExists(user.getEmail())) 
            {
                return false;
            }
            //insert database
            dbAdapter.insertUser(user.getName(), user.getSurname(), user.getEmail(), user.getPhone(), user.getPassword(), user.getFullAddress(), user.getCity(), user.getCountry(), 1);
            int lastUserID = dbAdapter.getLatestUserID();
            String fileName = lastUserID +".txt";
                
            //save to a file 
            // Using try-with-resources to ensure the file is closed properly
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/profile-images/"+fileName))) {
                writer.write(user.getProfilePicture());
            } catch (IOException e) {
                System.err.println("An IOException was caught: HATA image olmadı" + e.getMessage());
            }
            dbAdapter.insertProfileImage(fileName, lastUserID);

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
        for (int i = 0; i < myHouses.size(); i++) {
            String[] photos = dbAdapter.getPhotos(myHouses.get(i).getId());
            myHouses.get(i).setImages(photos);
        }
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
        for (int i = 0; i < myFavoriteHouses.size(); i++) {
            String[] photos = dbAdapter.getPhotos(myFavoriteHouses.get(i).getId());
            myFavoriteHouses.get(i).setImages(photos);
        }
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

    @PostMapping("api/featuredHomes")
    public String getFeaturedHomes(@RequestBody String data) {     


        // Initialize ObjectMapper
        ObjectMapper mapper2 = new ObjectMapper();
        String email = "";
        String city = "";
        String country = "";
        try {
            JsonNode rootNode = mapper2.readTree(data);
            email = rootNode.get("email").asText();
            city = rootNode.get("city").asText();
            country = rootNode.get("country").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<House> featuredHomes = dbAdapter.getFeaturedHomes(email, city, country);
        if(email.equals("")){ //there is no one logged in
            featuredHomes = dbAdapter.getFeaturedHomes(email, city, "Türkiye");
        }
        
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
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    @GetMapping("/api/sideFilter/{param}")
    public String getSideFilter(@PathVariable String param) {
        String[] params = param.split(" ");
        String[] parsedResult = dbAdapter.parseMatch(params);
        
        //create a json object
        HashMap<String, String> sideFilter = new HashMap<String, String>();
        sideFilter.put("country", parsedResult[0] == null ? "": parsedResult[0]);
        sideFilter.put("city", parsedResult[1] == null ? "": parsedResult[1]);
        sideFilter.put("district", parsedResult[2] == null ? "": parsedResult[2]);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String sideFilterJson = mapper.writeValueAsString(sideFilter);
            return sideFilterJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/search/{param}/{email}")
    public String getSearchResults(@PathVariable String param, @PathVariable String email) {

        //parse the string with & delimeter
        String[] params = param.split("&");
        String searchValue = params[0];
        String saleRent = params[1];
        String saleRentParsed = (saleRent.split("="))[1];
        String houseType = params[2];
        String houseTypeParsed = (houseType.split("="))[1];
        String roomCount = params[3];
        String roomCountParsed = (roomCount.split("="))[1];
        String minPrice = params[4];
        int minPriceParsed = Integer.parseInt((minPrice.split("="))[1]);
        String maxPrice = params[5];
        int maxPriceParsed = Integer.parseInt((maxPrice.split("="))[1]);
        String minArea = params[6];
        int minAreaParsed = Integer.parseInt((minArea.split("="))[1]);
        String maxArea = params[7];
        int maxAreaParsed = Integer.parseInt((maxArea.split("="))[1]);
        String listingDate = params[8];
        String listingDateParsed = (listingDate.split("="))[1];
        String flag = params[9];
        int flagParsed = Integer.parseInt((flag.split("="))[1]);

        String ownerMail = email;
       
        if(!listingDateParsed.equals("All")){
            listingDateParsed = String.valueOf(listingDateParsed.charAt(4));
        }

        List<House> searchResults = dbAdapter.getSearchResultsDB(searchValue, saleRentParsed, houseTypeParsed, roomCountParsed, minPriceParsed, maxPriceParsed, minAreaParsed, maxAreaParsed, listingDateParsed, flagParsed, ownerMail);

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

    @PostMapping("/api/UpdateListing")
    public boolean receiveDataFromUpdateHouse(@RequestBody String data) 
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
            
            // Parse JSON string to House object
            House house = mapper.readValue(data, House.class);
            house.setOwnerID(VesthubApplication.currentlyLoggedIn); //owner
            System.out.println("ID: " + house.getId());
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
            dbAdapter.updateHouse(house.getId(), dbAdapter.getOwnerID(house.getOwnerMail()), house.getTitle(), house.getDescription(), house.getCity(), house.getDistinct(), house.getStreet(), house.getCountry(), house.getFullAddress(), house.getPrice(), house.getNumOfBathroom(), house.getNumOfBedroom(), house.getNumOfRooms(), house.getArea(), house.getLat(), house.getLng(), house.getSaleRent(), house.getApproved(), house.getFloor(), house.getTotalFloor(), house.getFiberInternet(), house.getAirConditioner(), house.getFloorHeating(), house.getFireplace(), house.getTerrace(), house.getSatellite(), house.getParquet(), house.getSteelDoor(), house.getFurnished(), house.getInsulation(), "Pending", house.getHouseType(), house.getOwnerMail());
            System.out.println("HOUSE ID: " + house.getId());
            //update images
            dbAdapter.deleteImages(house.getId());

            //delete all images from the local folder
            for (int i = 0; i < images.size(); i++) {
                String fileName = house.getId() + "&" + i + ".txt";
                try {
                    //delete the file
                    String filePath = "src/home-images/" + fileName;
                    System.out.println("Deleting file: " + filePath);
                    if (new java.io.File(filePath).delete()) {
                        System.out.println("File deleted successfully");
                    } else {
                        System.out.println("Failed to delete the file");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }


            for (int i = 0; i < images.size(); i++) {
                String fileName = house.getId() + "&" + i + ".txt";
                
                //save to a file 
                // Using try-with-resources to ensure the file is closed properly
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/home-images/"+fileName))) {
                    writer.write(images.get(i));
                } catch (IOException e) {
                    System.err.println("An IOException was caught: HATA image olmadı" + e.getMessage());
                }
                dbAdapter.insertImage(fileName, house.getId());
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @PostMapping("/api/addReservation")
    public boolean addReservation(@RequestBody String entity) {
        //add reservation to the class
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to User object
            Reservation reservation = mapper.readValue(entity, Reservation.class);
            if(dbAdapter.alreadySentReservation(reservation.getHouseID(), reservation.getOwnerMail(), reservation.getClientMail())){
                return false;
            }
            else{
                dbAdapter.insertReservation(reservation.getHouseID(), reservation.getOwnerMail(), reservation.getClientMail(), reservation.getDaytime(), reservation.getDate(), reservation.getStatus(), reservation.getMessage());
                System.out.println("Reservation daytime: " + reservation.getDaytime());
                System.out.println("Reservation date: " + reservation.getDate());
                System.out.println("Reservation houseID: " + reservation.getHouseID());
                System.out.println("Reservation houseOwnerID: " + reservation.getOwnerMail());
                System.out.println("Reservation clientID: " + reservation.getClientMail());
                System.out.println("Reservation status: " + reservation.getStatus());
                System.out.println("Reservation message: " + reservation.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    @GetMapping("/api/getReservations/{ownerMail}")
    public String getReservations(@PathVariable String ownerMail) {
        List<Reservation> reservations = dbAdapter.getReservations(ownerMail);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String reservationsJson = mapper.writeValueAsString(reservations);
            return reservationsJson;
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
            dbAdapter.insertHouse(dbAdapter.getOwnerID(house.getOwnerMail()), house.getTitle(), house.getDescription(), house.getCity(), house.getDistinct(), house.getStreet(), house.getCountry(), house.getFullAddress(), house.getPrice(), house.getNumOfBathroom(), house.getNumOfBedroom(), house.getNumOfRooms(), house.getArea(), house.getLat(), house.getLng(), house.getSaleRent(), house.getApproved(), house.getFloor(), house.getTotalFloor(), house.getFiberInternet(), house.getAirConditioner(), house.getFloorHeating(), house.getFireplace(), house.getTerrace(), house.getSatellite(), house.getParquet(), house.getSteelDoor(), house.getFurnished(), house.getInsulation(), "Pending", house.getHouseType(), house.getOwnerMail());
            
            int lastHouseID = dbAdapter.getLatestHouseID();
            System.out.println("Last house ID: " + lastHouseID);
            for (int i = 0; i < images.size(); i++) {
                String fileName = lastHouseID+ "&" + i + ".txt";
                
                //save to a file 
                // Using try-with-resources to ensure the file is closed properly
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/home-images/"+fileName))) {
                    writer.write(images.get(i));
                } catch (IOException e) {
                    System.err.println("An IOException was caught: HATA image olmadı" + e.getMessage());
                }
                dbAdapter.insertImage(fileName, lastHouseID);
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
        String[] photos = dbAdapter.getPhotos(id);
        house.setImages(photos);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String houseJson = mapper.writeValueAsString(house);
            return houseJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/updateReservationStatus")
    public boolean updateMeetingStatus(@RequestBody String entity) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to 
            int reservationID = mapper.readTree(entity).get("reservationID").asInt();
            String status = mapper.readTree(entity).get("meetingStatus").asText();
            dbAdapter.updateReservationStatusDB(reservationID, status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
    

    @GetMapping("/api/checkFavorite")
    public String checkFavorite(@RequestParam int houseID, @RequestParam String ownerMail) {
        int ownerID = dbAdapter.getOwnerID(ownerMail);
        System.out.println("Check ownerId:"+ownerID);
        boolean isFavorite = dbAdapter.checkFavorite(ownerID, houseID, 1); 
        return isFavorite ? "true" : "false";
    }

    @PostMapping("/api/updateProfileInfo")
    public boolean updateProfileInfo(@RequestBody String entity) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to 
            String newEmail = mapper.readTree(entity).get("newEmail").asText();
            String oldEmail = mapper.readTree(entity).get("oldEmail").asText();
            String name = mapper.readTree(entity).get("name").asText();
            String surname = mapper.readTree(entity).get("surname").asText();
            String phone = mapper.readTree(entity).get("phone").asText();
            int ownerID = dbAdapter.getOwnerID(oldEmail);
            return dbAdapter.updateProfileInfoDB(ownerID, name, surname, newEmail, phone);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/api/changePassword")
    public boolean changePassword(@RequestBody String entity) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to 
            String email = mapper.readTree(entity).get("email").asText();
            String oldPassword = mapper.readTree(entity).get("currentPassword").asText();
            String newPassword = mapper.readTree(entity).get("newPassword").asText();
            System.out.println("Email: " + email);
            System.out.println("Old Password: " + oldPassword);
            System.out.println("New Password: " + newPassword);
            int ownerID = dbAdapter.getOwnerID(email);
            return dbAdapter.changePasswordDB(ownerID, oldPassword, newPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("api/updateAddressSettings")
    public boolean updateAddressSettings(@RequestBody String entity) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string
        JsonNode jsonNode = mapper.readTree(entity);
        String email = jsonNode.get("email").asText();
        String address = jsonNode.get("address").asText();
        String city = jsonNode.get("city").asText();
        String country = jsonNode.get("country").asText();
            System.out.println("Email:" + email);
            System.out.println("Address:"+ address);
            System.out.println("City:"+ city);
            System.out.println("Country:"+ country);
            int ownerID = dbAdapter.getOwnerID(email);
            return dbAdapter.changeAddressDB(ownerID, address, city, country);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    
    @GetMapping("/api/getUser/{email}")
    public String getUser(@PathVariable String email) {
        User user = dbAdapter.getUserFromMail(email);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String userJson = mapper.writeValueAsString(user);
            return userJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/adminListings")
    public String getAdminHouses() {
        List<House> adminHouses = dbAdapter.getAdminHouses();
        for (int i = 0; i < adminHouses.size(); i++) {
            String[] photos = dbAdapter.getPhotos(adminHouses.get(i).getId());
            adminHouses.get(i).setImages(photos);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String adminHousesJson = mapper.writeValueAsString(adminHouses);
            return adminHousesJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/updateStatus")
    public boolean updateStatus(@RequestBody String data) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(data);
            int houseID = rootNode.get("houseID").asInt();
            String status = rootNode.get("status").asText();
            dbAdapter.updateHouseStatus(houseID, status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/api/changeAvailability")
    public boolean changeAvailability(@RequestBody String entity) {
        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse JSON string to 
            int houseID = mapper.readTree(entity).get("houseID").asInt();
            String availability = mapper.readTree(entity).get("status").asText();
            dbAdapter.updateHouseStatus(houseID, availability);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    
    
}

