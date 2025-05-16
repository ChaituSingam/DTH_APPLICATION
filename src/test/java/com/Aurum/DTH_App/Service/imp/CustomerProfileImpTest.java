package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.Address;
import com.Aurum.DTH_App.Entity.CustomerProfile;
import com.Aurum.DTH_App.Enums.Gender;
import com.Aurum.DTH_App.Repository.AddressRepository;
import com.Aurum.DTH_App.Repository.CustomerProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerProfileImpTest {

    @Mock
    private CustomerProfileRepository customerProfileRepo;

    @Mock
    private AddressRepository addressRepo;

    @InjectMocks
    private CustomerProfileImp customerProfileImp;

    private Address sampleAddress;

    @BeforeEach
    public void setup() {
        // Initialize sample Address with correct constructor and int id
        sampleAddress = new Address();
        sampleAddress.setAddressId(1);
        // You can set other fields here if needed
    }

    // Helper method to create a CustomerProfile with correct constructor and types
    private CustomerProfile createCustomerProfile(int id, String firstName, String lastName, String email, long phoneNumber, Address address) {
        return new CustomerProfile(id,0L,firstName,lastName,email,Gender.MALE,phoneNumber,address);
    }

    @Test
    public void testSaveCustomerProfile_WithValidAddress() {
        CustomerProfile profile = createCustomerProfile(1221, "Virat", "Das", "Virat@example.com", 9876543210L, sampleAddress);

        // Mock AddressRepository to return the address wrapped in Optional
        when(addressRepo.findById(sampleAddress.getAddressId())).thenReturn(Optional.of(sampleAddress));

        CustomerProfile result = customerProfileImp.saveCustomer(profile);

        verify(addressRepo, times(1)).findById(sampleAddress.getAddressId());
        assertEquals(profile, result);
    }

    @Test
    public void testSaveCustomerProfile_WithMissingAddress_ShouldThrowException() {
        CustomerProfile profile = createCustomerProfile(1202, "sai", "sukesh", "sukesh@example.com", 9009009008L, sampleAddress);

        // Mock AddressRepository to throw RuntimeException
        when(addressRepo.findById(sampleAddress.getAddressId())).thenThrow(new RuntimeException("Address lookup failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            customerProfileImp.saveCustomer(profile);
        });

        verify(addressRepo, times(1)).findById(sampleAddress.getAddressId());
        assertEquals("Address lookup failed", exception.getMessage());
    }

    @Test
    public void testGetAllCustomers_ReturnsList() {
        Address address1 = new Address();
        address1.setAddressId(2);
        Address address2 = new Address();
        address2.setAddressId(3);

        CustomerProfile customer1 = createCustomerProfile(2021, "jitesh", "kumar", "jitesh@example.com", 9876500000L, address1);
        CustomerProfile customer2 = createCustomerProfile(2022, "vishnu", "vardhan", "vishnu@example.com", 9876501111L, address2);

        List<CustomerProfile> mockList = Arrays.asList(customer1, customer2);

        when(customerProfileRepo.findAll()).thenReturn(mockList);

        List<CustomerProfile> result = customerProfileImp.getAllCustomers();

        verify(customerProfileRepo, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals("jitesh", result.get(0).getFirstName());
        assertEquals("vishnu", result.get(1).getFirstName());
    }
}
