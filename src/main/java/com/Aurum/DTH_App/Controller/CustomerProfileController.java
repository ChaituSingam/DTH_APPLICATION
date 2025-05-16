package com.Aurum.DTH_App.Controller;

import com.Aurum.DTH_App.Entity.CustomerProfile;
import com.Aurum.DTH_App.Service.ICustomerProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerProfileController {

    private ICustomerProfile iCustomerProfile;

    public CustomerProfileController(ICustomerProfile iCustomerProfile){
        this.iCustomerProfile=iCustomerProfile;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerProfile customerProfile){

        CustomerProfile customerProfile1 = iCustomerProfile.saveCustomer(customerProfile);
        if(customerProfile1 == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Data is saved Successfully.",HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCustomers(){
        List<CustomerProfile> list = iCustomerProfile.getAllCustomers();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Collection is Empty.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}

