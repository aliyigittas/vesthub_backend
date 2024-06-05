package com.group16.vesthub;

import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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

    public int getLatestUserID() 
    {
        return jdbcTemplate.queryForObject("SELECT MAX(userID) FROM users", Integer.class);
    }

    public void insertProfileImage(String image, int userID) 
    {
        jdbcTemplate.update("UPDATE users SET profilePicture = ? WHERE userID = ?", image, userID);
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
            String profilePicturePath = (String) map.get("profilePicture");
            BufferedReader reader = null;
            try {
                // Create FileReader and BufferedReader
                FileReader fileReader = new FileReader("src/profile-images/" + profilePicturePath);
                reader = new BufferedReader(fileReader);
                // Read the file line by line
                user.setProfilePicture(reader.readLine());
                System.out.println("Profile picture: " + user.getProfilePicture());
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

    public boolean insertReservation(int houseID, String ownerMail, String clientMail, String daytime, String date, String status, String message) 
    {
        jdbcTemplate.update("INSERT INTO reservations (houseID, ownerMail, clientMail, daytime, date, status, message) VALUES (?, ?, ?, ?, ?, ?, ?)", houseID, ownerMail, clientMail, daytime, date, "Waiting", message);
        return true;
    }

    public List<Reservation> getReservations(String email)
    {
        updateReservationStatus("Passed", "Waiting");
        updateReservationStatus("Completed", "Accepted");
        //inner join with users table
        return jdbcTemplate.query("SELECT * FROM reservations INNER JOIN users ON reservations.ownerMail = users.email WHERE clientMail = ? OR ownerMail = ?", (rs, rowNum) -> new Reservation(rs.getInt("id"), rs.getInt("houseID"), rs.getString("name"), rs.getString("profilePicture") , rs.getString("ownerMail"), rs.getString("clientMail"), rs.getString("daytime"), rs.getString("date"), rs.getString("status"), rs.getString("message")), email, email); 
    }

    public void updateReservationStatusDB(int id, String status)
    {
        jdbcTemplate.update("UPDATE reservations SET status = ? WHERE id = ?", status, id);
    }

    public void updateReservationStatus(String status, String currentStatus)
    {
        String query = "UPDATE reservations SET status = ? WHERE status = ? AND (DATE(date) ";
        try {
            // Append time constraints to the query
            LocalTime morningMax = LocalTime.parse("11:00");
            LocalTime afternoonMax = LocalTime.parse("14:00");
            LocalTime eveningMax = LocalTime.parse("17:00");
            LocalTime currentTime = LocalTime.now();

            if (currentTime.isAfter(morningMax)) { //sabah saatini geçtiyse
                query += "<CURRENT_DATE() OR (DATE(date) = CURRENT_DATE() AND (daytime = 'Morning' ";
                if(currentTime.isAfter(afternoonMax)){ //öğleni de geçtiyse
                    query += "OR daytime = 'Afternoon' ";
                    if(currentTime.isAfter(eveningMax)){ //akşamı da geçtiyse
                        query += "OR daytime = 'Evening')))";
                    }
                    else{
                        query+=")))";
                    }
                }
                else{
                    query+=")))";
                }
            } 
            else{
                query+="<CURRENT_DATE())";
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format: " + e.getMessage());
        }

        //System.out.println(query);
        jdbcTemplate.update(query, status, currentStatus);
        
    }

    public String searchTextForQuery (String searchValue){
        //parse the search value with spaces
        String[] searchValues = searchValue.split(" ");
        System.out.println("Array:"+ searchValues[0]);
        //int search_size =searchValues.length;
        String country = null;
        String city = null;
        String district = null;

        String[] response = parseMatch(searchValues);
        country = response[0];
        city = response[1];
        district = response[2];

        String query = "";
        if(country==null && city ==null && district==null){
            query = "SELECT * FROM houses WHERE id=-1 ";
        }
        else{
            query = "SELECT * FROM houses ";
            if (country != null) //country varsa
            {
                query += "WHERE country = '" + country + "' ";
                if(city != null)
                    query += " AND city = '" + city + "' ";
                if(district != null)
                    query += " AND `distinct` = '" + district + "' ";
            }
            else if(city != null)
            {
                query += "WHERE city = '" + city + "' ";
                if(district != null)
                    query += " AND `distinct` = '" + district + "' ";
            }
            else if(district != null)
            {
                query += "WHERE `distinct` = '" + district + "' ";
            }
            /* 
            else
            {
                query += " title LIKE '%" + searchValue + "%' OR description LIKE '%" + searchValue + "%' OR city LIKE '%" + searchValue + "%' OR `distinct` LIKE '%" + searchValue + "%' OR street LIKE '%" + searchValue + "%' OR country LIKE '%" + searchValue + "%' OR fullAddress LIKE '%" + searchValue + "%' OR price LIKE '%" + searchValue + "%' OR numOfBathroom LIKE '%" + searchValue + "%' OR numOfBedroom LIKE '%" + searchValue + "%' OR numOfRooms LIKE '%" + searchValue + "%' OR area LIKE '%" + searchValue + "%' OR saleRent LIKE '%" + searchValue + "%' OR approved LIKE '%" + searchValue + "%' OR floor LIKE '%" + searchValue + "%' OR totalFloor LIKE '%" + searchValue + "%' OR fiberInternet LIKE '%" + searchValue + "%' OR airConditioner LIKE '%" + searchValue + "%' OR floorHeating LIKE '%" + searchValue + "%' OR fireplace LIKE '%" + searchValue + "%' OR terrace LIKE '%" + searchValue + "%' OR satellite LIKE '%" + searchValue + "%' OR parquet LIKE '%" + searchValue + "%' OR steelDoor LIKE '%" + searchValue + "%' OR furnished LIKE '%" + searchValue + "%' OR insulation LIKE '%" + searchValue + "%' OR status LIKE '%" + searchValue + "%' OR houseType LIKE '%" + searchValue + "%'";
            }*/
        }
        return query;
    }

    public String saleRentForQuery(String saleRent){
        String query = "";
        if(saleRent.equals("sale")){
            query += "AND saleRent = " + "'Sale' ";
        }
        else{
            query += "AND saleRent = 'Rent' ";
        }
        return query;
    }

    public String houseTypeForQuery(String houseType){
        String query = "";
        if(houseType.equals("Apartment")){
            query+="AND houseType = 'Apartment' ";
        }
        else if(houseType.equals("Villa")){
            query+="AND houseType = 'Villa' ";
        }
        else if(houseType.equals("Studio")){
            query+="AND houseType = 'Studio' ";
        }
        return query;
    }

    public String roomCountForQuery(String roomCount){
        String query = "";
        if(roomCount.equals("1+1")){
            query+="AND numOfRooms = '1+1' ";
        }
        else if(roomCount.equals("2+1")){
            query+="AND numOfRooms = '2+1' ";
        }
        else if(roomCount.equals("3+1")){
            query+="AND numOfRooms = '3+1' ";
        }
        else if(roomCount.equals("4+1")){
            query+="AND numOfRooms = '4+1' ";
        }
        else if(roomCount.equals("5+1")){
            query+="AND numOfRooms = '5+1' ";
        }
        return query;
    }

    public String priceForQuery(int minPrice, int maxPrice){
        String query = "";
        if(minPrice!=-1){
            query += "AND price>="+minPrice+" ";
        }
        if(maxPrice!=-1){
            query += "AND price<="+maxPrice+" ";
        }
        return query;
    }

    public String areaForQuery(int minArea, int maxArea){
        String query = "";
        if(minArea!=-1){
            query += "AND area>="+minArea+" ";
        }
        if(maxArea!=-1){
            query += "AND area<="+maxArea+" ";
        }
        return query;
    }

    public String listingDateForQuery(String listingDate){
        String query = "";
        int hours = 0;
        if(!listingDate.equals("All")){
            hours = (Integer.parseInt(listingDate))*24;
            query += "AND timestampdiff(hour, uploadDate, NOW()) <="+hours+" ";
        }
        return query;
    }

    public String flagSituationSearchForQuery(String searchValue, int flag){
        String query = "";
        String country = null;
        String city = null;
        String district = null;

        if(flag==0){
            query += searchTextForQuery(searchValue);
        }
        else{
            System.out.println("Genel:"+ searchValue);
            query += "SELECT * FROM houses WHERE ";
            if(!String.valueOf(searchValue.charAt(0)).equals(" ")){ //ilk gelen boş değilse yani country varsa
                String countryParsed = searchValue.split(" ")[0];
                country = getCountryMatch(countryParsed);
                int lenOfCountry = countryParsed.length();
                System.out.println("Country parsed length: " + lenOfCountry);
                if(!String.valueOf(searchValue.charAt(lenOfCountry+1)).equals(" ")){ //city de varsa
                    String cityParsed = searchValue.split(" ")[1];
                    city = getCityMatch(cityParsed);
                    if(!String.valueOf(searchValue.charAt(searchValue.length()-1)).equals(" ")){ //son char boş değilse yani district varsa
                        String districtParsed = searchValue.split(" ")[2];
                        district = getDistrictMatch(districtParsed);
                    }
                }
                else if(!String.valueOf(searchValue.charAt(searchValue.length()-1)).equals(" ")){ //son char boş değilse yani district varsa
                    String districtParsed = searchValue.split(" ")[2];
                    district = getDistrictMatch(districtParsed);
                }
            }
            else if(!String.valueOf(searchValue.charAt(2)).equals(" ")){ //city de varsa
                String cityParsed = searchValue.split(" ")[1];
                city = getCityMatch(cityParsed);
                if(!String.valueOf(searchValue.charAt(searchValue.length()-1)).equals(" ")){ //son char boş değilse yani district varsa
                    String districtParsed = searchValue.split(" ")[2];
                    district = getDistrictMatch(districtParsed);
                }
            }
            else if(!String.valueOf(searchValue.charAt(searchValue.length()-1)).equals(" ")){ //son char boş değilse yani district varsa
                String districtParsed = searchValue.split(" ")[2];
                district = getDistrictMatch(districtParsed);
            }
            
            if(country!=null){
                query += "country = '"+country+"' ";
                if(city!=null){
                    query += "AND city = '"+city+"' ";
                    if(district!=null){
                        query += "AND `distinct`= '"+district+"' ";
                    }
                }
                else if(district!=null){
                    query += "AND `distinct`= '"+district+"' ";
                }
            }
            else if(city!=null){
                query += "city = '"+city+"' ";
                if(district!=null){
                    query += "AND `distinct`= '"+district+"' ";
                }
            }
            else if(district!=null){
                query += "`distinct`= '"+district+"' ";
            }
            else {
                query += "id = -1 ";
            }
        }
        return query;
    }

    public List<House> getSearchResultsDB(String searchValue, String saleRent, String houseType, String roomCount, int minPrice, int maxPrice, int minArea, int maxArea, String listingDate, int flag, String email)
    {
        String query = "";

        if(searchValue.equals("  ")){
            query = "SELECT * FROM houses WHERE id = -1";
        }
        
        else{
            query += flagSituationSearchForQuery(searchValue, flag);
            query += saleRentForQuery(saleRent);
            query += houseTypeForQuery(houseType);
            query += roomCountForQuery(roomCount);
            query += priceForQuery(minPrice, maxPrice);
            query += areaForQuery(minArea, maxArea);
            query += listingDateForQuery(listingDate);
            query += "AND ownerMail != '"+email+"' ";
            query += "AND status = 'Available' ";
        }
        System.out.println(query);

        return jdbcTemplate.query(query, (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null));
    }

    public void insertHouse(int ownerID, String title, String description, String city, String distinct, String street, String country ,String fullAddress, int price, int numOfBathroom, int numOfBedroom, String numOfRooms, int area, double lat, double lng, String saleRent, int approved, int floor, int totalFloor, int fiberInternet, int airConditioner, int floorHeating, int fireplace, int terrace, int satellite, int parquet, int steelDoor, int furnished, int insulation, String status, String houseType, String ownerMail) 
    {
        jdbcTemplate.update("INSERT INTO houses (ownerID, title, description, city, `distinct`, street, country, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType, ownerMail, uploadDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())", ownerID, title, description, city, distinct, street, country, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType, ownerMail);
    }

    public void updateHouse(int houseID, int ownerID, String title, String description, String city, String distinct, String street, String country ,String fullAddress, int price, int numOfBathroom, int numOfBedroom, String numOfRooms, int area, double lat, double lng, String saleRent, int approved, int floor, int totalFloor, int fiberInternet, int airConditioner, int floorHeating, int fireplace, int terrace, int satellite, int parquet, int steelDoor, int furnished, int insulation, String status, String houseType, String ownerMail) 
    {
        jdbcTemplate.update("UPDATE houses SET ownerID = ?, title = ?, description = ?, city = ?, `distinct` = ?, street = ?, country = ?, fullAddress = ?, price = ?, numOfBathroom = ?, numOfBedroom = ?, numOfRooms = ?, area = ?, lat = ?, lng = ?, saleRent = ?, approved = ?, floor = ?, totalFloor = ?, fiberInternet = ?, airConditioner = ?, floorHeating = ?, fireplace = ?, terrace = ?, satellite = ?, parquet = ?, steelDoor = ?, furnished = ?, insulation = ?, status = ?, houseType = ?, ownerMail = ? WHERE id = ?", ownerID, title, description, city, distinct, street, country, fullAddress, price, numOfBathroom, numOfBedroom, numOfRooms, area, lat, lng, saleRent, approved, floor, totalFloor, fiberInternet, airConditioner, floorHeating, fireplace, terrace, satellite, parquet, steelDoor, furnished, insulation, status, houseType, ownerMail, houseID);
    }

    public void deleteImages(int houseID)
    {
        jdbcTemplate.update("DELETE FROM images WHERE houseID = ?", houseID);
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

    public List<House> getFeaturedHomes (String email, String city)
    {
        return jdbcTemplate.query("SELECT * FROM houses WHERE status = 'Available' AND city = ? AND ownerMail != ?", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null), city, email);
        
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

    public boolean updateProfileInfoDB(int id, String name, String surname, String email, String phone)
    {
        int checkforEmail = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE email = ? AND userID != ?", Integer.class, email, id);
        if(checkforEmail > 0)
        {
            return false;
        }
        else
        {
            jdbcTemplate.update("UPDATE users SET name = ?, surname = ?, email = ?, phone = ? WHERE userID = ?", name, surname, email, phone, id);
        }
        return true;
    }

    public boolean changePasswordDB(int ownerID, String oldPassword, String newPassword)
    {
        int checkforPassword = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE userID = ? AND password = ?", Integer.class, ownerID, oldPassword);
        if(checkforPassword > 0)
        {
            jdbcTemplate.update("UPDATE users SET password = ? WHERE userID = ?", newPassword, ownerID);
            return true;
        }
        else
        {
            System.out.println("Old password is wrong!!!!!!!!!!!!!!!!");
            return false;
        }
    }

    public User getUserFromMail(String email)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", (rs, rowNum) -> new User(rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("fullAddress"), rs.getString("city"), rs.getString("country"), rs.getBoolean("status"), rs.getString("profilePicture")), email);
    }

    public List<House> getAdminHouses ()
    {
        return jdbcTemplate.query("SELECT * FROM houses WHERE status = 'Pending'", (rs, rowNum) -> new House(rs.getInt("id"), rs.getInt("ownerID"), rs.getString("ownerMail") ,rs.getString("title"), rs.getString("description"), rs.getString("city"), rs.getString("distinct"), rs.getString("street"), rs.getString("country"), rs.getString("fullAddress"), rs.getInt("price"), rs.getInt("numOfBathroom"), rs.getInt("numOfBedroom"), rs.getString("numOfRooms"), rs.getInt("area"), rs.getDouble("lat"), rs.getDouble("lng"), rs.getString("saleRent"), rs.getInt("approved"), rs.getInt("floor"), rs.getInt("totalFloor"), rs.getInt("fiberInternet"), rs.getInt("airConditioner"), rs.getInt("floorHeating"), rs.getInt("fireplace"), rs.getInt("terrace"), rs.getInt("satellite"), rs.getInt("parquet"), rs.getInt("steelDoor"), rs.getInt("furnished"), rs.getInt("insulation"), rs.getString("status"), rs.getString("houseType"), null, null)); 
    }

    public void updateHouseStatus (int houseID, String status)
    {
        jdbcTemplate.update("UPDATE houses SET status = ? WHERE id = ?", status, houseID);
    }
    
}