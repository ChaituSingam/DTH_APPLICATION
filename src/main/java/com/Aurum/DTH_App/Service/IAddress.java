package com.Aurum.DTH_App.Service;

import com.Aurum.DTH_App.Entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddress {

    Address saveAddress(Address address);
    List<Address> getAllAddresses();

}
