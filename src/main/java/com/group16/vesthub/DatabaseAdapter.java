package com.group16.vesthub;

import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DatabaseAdapter {

    private JdbcTemplate jdbcTemplate;

    public DatabaseAdapter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getAllUsernames() {
        return jdbcTemplate.queryForList("SELECT name FROM user", String.class);
    }

    //get everything from the database
    public List<Map<String, Object>> getAllFromDB() {
        return jdbcTemplate.queryForList("SELECT name, surname FROM user");
    }

    @GetMapping("/getFromDB")
    public String getFromDB() {
        //List<String> usernames = getAllUsernames();
        List<Map<String, Object>> resultSet = getAllFromDB();
        Gson gson = new Gson();
        return gson.toJson(resultSet);
    }

    public void insertUser(String name, String surname, String email, String phone, String password, String fullAddress, String city, String country, int status) 
    {
        jdbcTemplate.update("INSERT INTO users (name, surname, email, phone, password, fullAddress, city, country, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", name, surname, email, phone, password, fullAddress, city, country, status);
    }

    public boolean checkUserExists(String email) 
    {
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE email = ?", Integer.class, email);
        return count > 0;
    }

    public User signIn(String email, String password) 
    {
        List<Map<String, Object>> userToBeConverted =  jdbcTemplate.queryForList("SELECT * FROM users WHERE email = ? AND password = ?", email, password);
        User user = new User();
        for (Map<String, Object> map : userToBeConverted) 
        {
            user.setName((String) map.get("name"));
            user.setSurname((String) map.get("surname"));
            user.setEmail((String) map.get("email"));
            user.setPhone((String) map.get("phone"));
            user.setFullAddress((String) map.get("fullAddress"));
            user.setCity((String) map.get("city"));
            user.setCountry((String) map.get("country"));
            user.setStatus((int) map.get("status"));
            user.setProfilePicture((String) map.get("profilePicture"));
        }

        //if there is no such user
        if (user.getName() == null) 
        {
            return null;
        }
        
        return user;
    }

    public int getOwnerID(String email){
        return jdbcTemplate.queryForObject("SELECT userID FROM users WHERE email = ?", Integer.class, email);

        //return id;
    }

    public int getLatestHouseID() 
    {
        return jdbcTemplate.queryForObject("SELECT MAX(id) FROM houses", Integer.class);
    }

    public List<House> getAllHouses()
    {
        return jdbcTemplate.query("SELECT * FROM houses", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"),rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null));
    }

    public String[] parseMatch(String[] searchValues)
    {

        String[] response = new String[searchValues.length < 3 ? 3 : searchValues.length];
        for (int i = 0; i < response.length; i++)
        {
            response[i] = null;
        }

        for (int i = 0; i < searchValues.length; i++)
        {

            if (response[0]==null)
            {
                if(getCountryMatch(searchValues[i]) != null && response[1]!=searchValues[i] && response[2]!=searchValues[i]) 
                {
                    response[0] = getCountryMatch(searchValues[i]);
                }
            }

            if (response[1]==null)
            {
                if(getCityMatch(searchValues[i]) != null && response[0]!=searchValues[i] && response[2]!=searchValues[i])
                {
                    response[1] = getCityMatch(searchValues[i]);
                }
            }   
                
            if (response[2]==null)
            {
                if(getDistrictMatch(searchValues[i]) != null && response[0]!=searchValues[i] && response[1]!=searchValues[i])
                {
                    response[2] = getDistrictMatch(searchValues[i]);
                }
            }


        }

        return response;
    }

    public String getCountryMatch(String searchValue)
    {
        List<String> countries = jdbcTemplate.queryForList("SELECT country FROM houses WHERE country = ?", String.class, searchValue);
        if (countries.size() > 0)
        {
            return searchValue;
        }
        return null;
    }

    public String getCityMatch(String searchValue)
    {
        List<String> cities = jdbcTemplate.queryForList("SELECT city FROM houses WHERE city = ?", String.class, searchValue);
        if (cities.size() > 0)
        {
            return searchValue;
        }
        return null;
    }

    public String getDistrictMatch(String searchValue)
    {
        List<String> districts = jdbcTemplate.queryForList("SELECT `distinct` FROM houses WHERE `distinct` = ?", String.class, searchValue);
        if (districts.size() > 0)
        {
            return searchValue;
        }
        return null;
    }



    public List<House> getSearchResultsDB(String searchValue)
    {
        //parse the search value with spaces
        String[] searchValues = searchValue.split(" ");
        System.out.println("Array:"+ searchValues[0]);
        int search_size =searchValues.length;
        String country = null;
        String city = null;
        String district = null;

        String[] response = parseMatch(searchValues);
        country = response[0];
        city = response[1];
        district = response[2];

        String query = "";
        if(country==null && city ==null && district==null){
            query = "SELECT * FROM houses WHERE houseID=-1";
        }
        else{
            query = "SELECT * FROM houses ";
            if (country != null) //country varsa
            {
                query += "WHERE country = '" + country + "'";
                if(city != null)
                    query += " AND city = '" + city + "'";
                if(district != null)
                    query += " AND `distinct` = '" + district + "'";
            }
            else if(city != null)
            {
                query += "WHERE city = '" + city + "'";
                if(district != null)
                    query += " AND `distinct` = '" + district + "'";
            }
            else if(district != null)
            {
                query += "WHERE `distinct` = '" + district + "'";
            }
            /* 
            else
            {
                query += " title LIKE '%" + searchValue + "%' OR description LIKE '%" + searchValue + "%' OR city LIKE '%" + searchValue + "%' OR `distinct` LIKE '%" + searchValue + "%' OR street LIKE '%" + searchValue + "%' OR country LIKE '%" + searchValue + "%' OR fullAddress LIKE '%" + searchValue + "%' OR price LIKE '%" + searchValue + "%' OR numOfBathroom LIKE '%" + searchValue + "%' OR numOfBedroom LIKE '%" + searchValue + "%' OR numOfRooms LIKE '%" + searchValue + "%' OR area LIKE '%" + searchValue + "%' OR saleRent LIKE '%" + searchValue + "%' OR approved LIKE '%" + searchValue + "%' OR floor LIKE '%" + searchValue + "%' OR totalFloor LIKE '%" + searchValue + "%' OR fiberInternet LIKE '%" + searchValue + "%' OR airConditioner LIKE '%" + searchValue + "%' OR floorHeating LIKE '%" + searchValue + "%' OR fireplace LIKE '%" + searchValue + "%' OR terrace LIKE '%" + searchValue + "%' OR satellite LIKE '%" + searchValue + "%' OR parquet LIKE '%" + searchValue + "%' OR steelDoor LIKE '%" + searchValue + "%' OR furnished LIKE '%" + searchValue + "%' OR insulation LIKE '%" + searchValue + "%' OR status LIKE '%" + searchValue + "%' OR houseType LIKE '%" + searchValue + "%'";
            }*/
        }
        System.out.println(query);

        

        return jdbcTemplate.query(query, (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null));

    }



    public void insertHouse(int ownerID, String title, String description, String city, String distinct, String street, String country ,String fullAddress, int price, int numOfBathroom, int numOfBedroom, String numOfRooms, int area, double lat, double lng, String saleRent, int approved, int floor, int totalFloor, int fiberInternet, int airConditioner, int floorHeating, int fireplace, int terrace, int satellite, int parquet, int steelDoor, int furnished, int insulation, String status, String houseType, String ownerMail) 
    {
        jdbcTemplate.update("INSERT INTO houses (ownerID, title, description, city, `distinct`, street, country, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType, ownerMail, uploadDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())", ownerID, title, description, city, distinct, street, country, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType, ownerMail);
    }

    public void insertImage (String image, int houseID) 
    {
        jdbcTemplate.update("INSERT INTO images (houseID, pixels) VALUES (?, ?)", houseID, image);
    }

    public String[] getPhotos (int houseID) 
    {
        List<String> images = jdbcTemplate.queryForList("SELECT pixels FROM images WHERE houseID = ?", String.class, houseID);

        List<String> real_images = new ArrayList<String>();

        System.out.println(images.size());

        // Initialize BufferedReader
        BufferedReader reader = null;

        for (String imagepath : images) {
            try {
                // Create FileReader and BufferedReader
                FileReader fileReader = new FileReader("src/home-images/" + imagepath);
                reader = new BufferedReader(fileReader);

                // Read the file line by line
                String line;
                while ((line = reader.readLine()) != null) {
                    real_images.add(line);
                }
            } catch (IOException e) {
                // Handle potential IOException
                System.err.println("An IOException was caught: " + e.getMessage());
            } finally {
                // Close the BufferedReader
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        System.err.println("An IOException was caught when closing the reader: " + e.getMessage());
                    }
                }
            }
        }
        

        return real_images.toArray(new String[real_images.size()]);
    }

    public List<House> getFeaturedHomes ()
    {
        return jdbcTemplate.query("SELECT * FROM houses WHERE approved = 0", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null));
        
    }

    public House getHouseByID(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM houses WHERE id = ?", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null), id);
        //return new House();
    }

    public List<House> getMyHouses(int id)
    {
        return jdbcTemplate.query("SELECT * FROM houses WHERE ownerID = ?", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null), id);
    }

    public List<House> getMyFavorites (int id)
    {
        return jdbcTemplate.query("SELECT * FROM houses WHERE id IN (SELECT houseID FROM favorites WHERE userID = ? AND status = 1)", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null), id);
    }

    public void addFavorite (int userID, int houseID)
    {
        if(checkFavorite(userID, houseID, 0) == true){ //if that house liked, and unliked before
            updateFavorite(userID, houseID, 1);
        }
        else{
            jdbcTemplate.update("INSERT INTO favorites (userID, houseID, status) VALUES (?, ?, ?)", userID, houseID, 1);
        }
    }

    public void updateFavorite (int userID, int houseID, int status)
    {
        jdbcTemplate.update("UPDATE favorites SET status = ? WHERE userID = ? AND houseID = ?", status, userID, houseID);
    }

    public boolean checkFavorite (int userID, int houseID, int status)
    {
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM favorites WHERE userID = ? AND houseID = ? AND status = ?", Integer.class, userID, houseID, status);
        return count > 0;
    }
}