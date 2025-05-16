package com.Aurum.DTH_App.Entity;



import com.Aurum.DTH_App.Enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer_profile")
public class CustomerProfile
{
    @Id
    private int customerProfileId;
    private long alternatePhoneNumber;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    @Indexed(unique = true)
    private long phoneNumber;
    @DBRef
    private Address address;

    public CustomerProfile(int customerProfileId, long alternatePhoneNumber, String firstName, String lastName, String email, Gender gender, long phoneNumber, Address address) {
        this.customerProfileId = customerProfileId;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getCustomerProfileId() {
        return customerProfileId;
    }

    public void setCustomerProfileId(int customerProfileId) {
        this.customerProfileId = customerProfileId;
    }

    public long getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(long alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
