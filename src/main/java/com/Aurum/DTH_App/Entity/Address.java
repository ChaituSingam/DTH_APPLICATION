package com.Aurum.DTH_App.Entity;



import com.Aurum.DTH_App.Enums.Country;
import com.Aurum.DTH_App.Enums.State;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {

    @Id
    private int addressId;
    @Indexed(unique = true)
    private String houseNumber;
    private  String street;
    private State state;
    private int pincode;
    private String city;
    private Country country;

    public Address(int addressId, String houseNumber, String street, State state, int pincode, String city, Country country) {
        this.addressId = addressId;
        this.houseNumber = houseNumber;
        this.street = street;
        this.state = state;
        this.pincode = pincode;
        this.city = city;
        this.country = country;
    }

    public Address() {

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
