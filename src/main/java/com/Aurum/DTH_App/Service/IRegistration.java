package com.Aurum.DTH_App.Service;

import com.Aurum.DTH_App.Entity.Registration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IRegistration {

    Registration saveRegistration(Registration registration);

    List<Registration> getAllRegistrations();
}
