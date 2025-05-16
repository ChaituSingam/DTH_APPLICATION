package com.Aurum.DTH_App.Service.imp;


import com.Aurum.DTH_App.Entity.Address;
import com.Aurum.DTH_App.Entity.CustomerProfile;
import com.Aurum.DTH_App.Repository.AddressRepository;
import com.Aurum.DTH_App.Repository.CustomerProfileRepository;
import com.Aurum.DTH_App.Service.ICustomerProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileImp implements ICustomerProfile
{

    private CustomerProfileRepository customerProfileRepo;
    private AddressRepository addressRepo;

    public CustomerProfileImp(CustomerProfileRepository customerProfileRepo , AddressRepository addressRepo){
        this.customerProfileRepo=customerProfileRepo;
        this.addressRepo=addressRepo;
    }

    @Override
    public CustomerProfile saveCustomer(CustomerProfile profile) {
        try {
            Optional<Address> address = addressRepo.findById(profile.getAddress().getAddressId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return profile;
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepo.findAll();
    }
}
