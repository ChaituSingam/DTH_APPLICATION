package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.Address;
import com.Aurum.DTH_App.Repository.AddressRepository;
import com.Aurum.DTH_App.Service.IAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImp implements IAddress {

    public AddressRepository addressRepo;
    public AddressImp(AddressRepository addressRepo){
        this.addressRepo=addressRepo;
    }
    @Override
    public  Address saveAddress(Address address) {
        try {
            return addressRepo.save(address);
        }

        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }
}
