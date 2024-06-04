package com.group16.vesthub;

public class User 
{
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String fullAddress;
    private String city;
    private String country;
    private int status;
    private String profilePicture;

    public User() 
    {

    }

    public User(String name, String surname, String email, String password, String phone, String fullAddress, String city, String country, boolean status, String profilePicture) 
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = "phone";
        this.fullAddress = "fullAddress";
        this.city = "city";
        this.country = "country";
        this.status = 1;
        this.profilePicture = profilePicture;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getFullAddress() 
    {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) 
    {
        this.fullAddress = fullAddress;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public int getStatus() 
    {
        return status;
    }

    public void setStatus(int status) 
    {
        this.status = status;
    }

    public String getProfilePicture() 
    {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) 
    {
        this.profilePicture = profilePicture;
    }
}
