package com.group16.vesthub;

public class House 
{
    private int id;
    private int ownerID;
    private String ownerMail;
    private String title;
    private String description;
    private String city;
    private String distinct;
    private String street;
    private String fullAddress;
    private int price;
    private int numOfBathroom;
    private int numOfBedroom;
    private String numOfRooms;
    private int area;
    private double lat;
    private double lng;
    private String saleRent;
    private int approved;
    private int floor;
    private int totalFloor;
    private int fiberInternet;
    private int airConditioner;
    private int floorHeating;
    private int fireplace;
    private int terrace;
    private int satellite;
    private int parquet;
    private int steelDoor;
    private int furnished;
    private int insulation;
    private String status;
    private String houseType;
    private String keyFeatures[];
    private String images[];

    public House() 
    {
    }

    public House(int id, int ownerID, String ownerMail, String title, String description, String city, String distinct, String street, String fullAddress, int price, int numOfBathroom, int numOfBedroom, String numOfRooms, int area, double lat, double lng, String saleRent, int approved, int floor, int totalFloor, int fiberInternet, int airConditioner, int floorHeating, int fireplace, int terrace, int satellite, int parquet, int steelDoor, int furnished, int insulation, String status, String houseType, String keyFeatures[], String images[]) 
    {
        this.id = id;
        this.ownerID = ownerID;
        this.ownerMail = ownerMail;
        this.title = title;
        this.description = description;
        this.city = city;
        this.distinct = distinct;
        this.street = street;
        this.fullAddress = fullAddress;
        this.price = price;
        this.numOfBathroom = numOfBathroom;
        this.numOfBedroom = numOfBedroom;
        this.numOfRooms = numOfRooms;
        this.area = area;
        this.lat = lat;
        this.lng = lng;
        this.saleRent = saleRent;
        this.approved = approved;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.fiberInternet = fiberInternet;
        this.airConditioner = airConditioner;
        this.floorHeating = floorHeating;
        this.fireplace = fireplace;
        this.terrace = terrace;
        this.satellite = satellite;
        this.parquet = parquet;
        this.steelDoor = steelDoor;
        this.furnished = furnished;
        this.insulation = insulation;
        this.status = status;
        this.houseType = houseType;
        this.keyFeatures = keyFeatures; //Yeni
        this.images = images;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getOwnerID() 
    {
        return ownerID;
    }

    public void setOwnerID(int ownerID) 
    {
        this.ownerID = ownerID;
    }

    public String getOwnerMail() 
    {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) 
    {
        this.ownerMail = ownerMail;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getDistinct() 
    {
        return distinct;
    }

    public void setDistinct(String distinct) 
    {
        this.distinct = distinct;
    }

    public String getStreet() 
    {
        return street;
    }

    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getFullAddress() 
    {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) 
    {
        this.fullAddress = fullAddress;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setPrice(int price) 
    {
        this.price = price;
    }

    public int getNumOfBathroom() 
    {
        return numOfBathroom;
    }

    public void setNumOfBathroom(int numOfBathroom) 
    {
        this.numOfBathroom = numOfBathroom;
    }

    public int getNumOfBedroom() 
    {
        return numOfBedroom;
    }

    public void setNumOfBedroom(int numOfBedroom) 
    {
        this.numOfBedroom = numOfBedroom;
    }

    public String getNumOfRooms() 
    {
        return numOfRooms;
    }

    public void setNumOfRooms(String numOfRooms) 
    {
        this.numOfRooms = numOfRooms;
    }

    public int getArea() 
    {
        return area;
    }

    public void setArea(int area) 
    {
        this.area = area;
    }

    public double getLat() 
    {
        return lat;
    }

    public void setLat(double lat) 
    {
        this.lat = lat;
    }

    public double getLng() 
    {
        return lng;
    }

    public void setLng(double lng) 
    {
        this.lng = lng;
    }

    public String getSaleRent() 
    {
        return saleRent;
    }

    public void setSaleRent(String saleRent) 
    {
        this.saleRent = saleRent;
    }

    public int getApproved() 
    {
        return approved;
    }

    public void setApproved(int approved) 
    {
        this.approved = approved;
    }

    public int getFloor() 
    {
        return floor;
    }

    public void setFloor(int floor) 
    {
        this.floor = floor;
    }

    public int getTotalFloor() 
    {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) 
    {
        this.totalFloor = totalFloor;
    }

    public int getFiberInternet() 
    {
        return fiberInternet;
    }

    public void setFiberInternet(int fiberInternet) 
    {
        this.fiberInternet = fiberInternet;
    }

    public int getAirConditioner() 
    {
        return airConditioner;
    }

    public void setAirConditioner(int airConditioner) 
    {
        this.airConditioner = airConditioner;
    }

    public int getFloorHeating() 
    {
        return floorHeating;
    }

    public void setFloorHeating(int floorHeating) 
    {
        this.floorHeating = floorHeating;
    }

    public int getFireplace() 
    {
        return fireplace;
    }

    public void setFireplace(int fireplace) 
    {
        this.fireplace = fireplace;
    }

    public int getTerrace() 
    {
        return terrace;
    }

    public void setTerrace(int terrace) 
    {
        this.terrace = terrace;
    }

    public int getSatellite() 
    {
        return satellite;
    }

    public void setSatellite(int satellite) 
    {
        this.satellite = satellite;
    }

    public int getParquet() 
    {
        return parquet;
    }

    public void setParquet(int parquet) 
    {
        this.parquet = parquet;
    }

    public int getSteelDoor() 
    {
        return steelDoor;
    }

    public void setSteelDoor(int steelDoor) 
    {
        this.steelDoor = steelDoor;
    }

    public int getFurnished() 
    {
        return furnished;
    }

    public void setFurnished(int furnished) 
    {
        this.furnished = furnished;
    }

    public int getInsulation() 
    {
        return insulation;
    }

    public void setInsulation(int insulation) 
    {
        this.insulation = insulation;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getHouseType() 
    {
        return houseType;
    }

    public void setHouseType(String houseType) 
    {
        this.houseType = houseType;
    }

    public String[] getKeyFeatures() {
        return keyFeatures;
    }

    public void setKeyFeatures(String[] keyFeatures) {
        this.keyFeatures = keyFeatures;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}

