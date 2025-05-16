package com.Aurum.DTH_App.Controller;


import com.Aurum.DTH_App.Entity.Registration;
import com.Aurum.DTH_App.Service.IRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private IRegistration iRegistration;
    public RegistrationController(IRegistration iRegistration){
        this.iRegistration=iRegistration;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveRegistration(@RequestBody Registration registration){
        Registration registration1 = iRegistration.saveRegistration(registration);
        if(registration == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Data is Saved Successfully",HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllRegistrations(){
        List<Registration> list = iRegistration.getAllRegistrations();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

