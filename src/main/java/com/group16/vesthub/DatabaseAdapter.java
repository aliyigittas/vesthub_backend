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
import org.springframework.jdbc.core.JdbcTemplate;

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
        int id = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE email = ?", Integer.class, email);
        return id;
    }

    public int getLatestHouseID() 
    {
        return jdbcTemplate.queryForObject("SELECT MAX(id) FROM houses", Integer.class);
    }

    public void insertHouse(int ownerID, String title, String description, String city, String distinct, String street, String fullAddress, int price, int numOfBathroom, int numOfBedroom, String numOfRooms, int area, double lat, double lng, String saleRent, int approved, int floor, int totalFloor, int fiberInternet, int airConditioner, int floorHeating, int fireplace, int terrace, int satellite, int parquet, int steelDoor, int furnished, int insulation, String status, String houseType) 
    {
        jdbcTemplate.update("INSERT INTO houses (ownerID, title, description, city, `distinct`, street, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", ownerID, title, description, city, distinct, street, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType);
    }

    public void insertImage (String image, int houseID) 
    {
        jdbcTemplate.update("INSERT INTO images (houseID, pixels) VALUES (?, ?)", houseID, image);
    }

    public String getPhoto (int houseID) 
    {
        return jdbcTemplate.queryForObject("SELECT pixels FROM images WHERE houseID = ?", String.class, houseID);
    }

}