package com.Aurum.DTH_App.Service;

import com.Aurum.DTH_App.Entity.CustomerProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerProfile {
    CustomerProfile saveCustomer(CustomerProfile profile);
    List<CustomerProfile> getAllCustomers();
}
