package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.Address;
import com.Aurum.DTH_App.Enums.Country;
import com.Aurum.DTH_App.Enums.State;
import com.Aurum.DTH_App.Repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressImpTest {

    @Mock
    private AddressRepository addressRepo;

    @InjectMocks
    private AddressImp addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void saveAddressTest(){

        Address address=new Address(001,"6-13A","Gandhi Street", State.ASSAM,534413,"Guwahati", Country.INDIA);

        when(addressRepo.save(address)).thenReturn(address);

        Address address1 = addressService.saveAddress(address);

        assertEquals(address.getAddressId(), address1.getAddressId());
        assertEquals(State.ASSAM,address1.getState());
        assertTrue(address.getPincode() == 534413);

    }


    @Test
    public void saveAddress_WithAllFieldsTest() {
        // Create a fully populated Address object
        Address address = new Address(521,"18B","Church Street",State.KARNATAKA,533145,"BANGALORE",Country.INDIA);

        // Mock the repository to return the same address when saved
        when(addressRepo.save(address)).thenReturn(address);

        // Call the service method
        Address savedAddress = addressService.saveAddress(address);

        // Assertions to verify the data
        assertEquals(521, savedAddress.getAddressId());
        assertEquals("18B", savedAddress.getHouseNumber());
        assertEquals("Church Street", savedAddress.getStreet());
        assertEquals(State.KARNATAKA, savedAddress.getState());
        assertEquals(533145, savedAddress.getPincode());
        assertEquals("BANGALORE", savedAddress.getCity());
        assertEquals(Country.INDIA, savedAddress.getCountry());

        // Verify that the repository's save method was called once
        verify(addressRepo, times(1)).save(address);
    }


    @Test
    void testSaveAddress_Success() {
        Address address = new Address();
        address.setAddressId(101);
        address.setCity("Kolkata");

        when(addressRepo.save(address)).thenReturn(address);

        Address savedAddress = addressService.saveAddress(address);

        assertNotNull(savedAddress);
        assertEquals("Kolkata", savedAddress.getCity());
        verify(addressRepo, times(1)).save(address);
    }

    @Test
    void testSaveAddress_Exception() {
        Address address = new Address();
        address.setAddressId(2);
        address.setCity("kerala");

        when(addressRepo.save(address)).thenThrow(new RuntimeException("Database error"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            addressService.saveAddress(address);
        });

        assertEquals("Database error", exception.getMessage());
        verify(addressRepo, times(1)).save(address);
    }

    @Test
    void testGetAllAddresses() {
        Address address1 = new Address();
        address1.setCity("chennai");

        Address address2 = new Address();
        address2.setCity("madurai");

        List<Address> mockList = Arrays.asList(address1, address2);

        when(addressRepo.findAll()).thenReturn(mockList);

        List<Address> result = addressService.getAllAddresses();

        assertEquals(2, result.size());
        assertEquals("chennai", result.get(0).getCity());
        assertEquals("madurai", result.get(1).getCity());
        verify(addressRepo, times(1)).findAll();
    }
}
