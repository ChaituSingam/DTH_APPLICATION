package com.Aurum.DTH_App.Controller;

import com.Aurum.DTH_App.Entity.Address;
import com.Aurum.DTH_App.Service.IAddress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController
{
    private IAddress iAddress;
    public AddressController(IAddress iAddress){
        this.iAddress=iAddress;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveAddress(@RequestBody Address address){
        Address add =iAddress.saveAddress(address);
        if(add == null){
            return new ResponseEntity<>("Data is not saved." , HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Data is Saved Successfully", HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllAddresses(){
        List<Address> list = iAddress.getAllAddresses();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No Data found in Collection.",HttpStatus.NO_CONTENT);
        }
    }

}

