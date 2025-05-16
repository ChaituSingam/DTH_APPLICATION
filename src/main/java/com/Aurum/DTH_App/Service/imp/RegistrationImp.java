package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.Registration;
import com.Aurum.DTH_App.Entity.SetupBox;
import com.Aurum.DTH_App.Repository.RegistrationRepository;
import com.Aurum.DTH_App.Repository.SetupBoxRepository;
import com.Aurum.DTH_App.Service.IRegistration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationImp implements IRegistration {

    private RegistrationRepository registrationRepo;
    private SetupBoxRepository setupBoxRepo;
    public RegistrationImp(RegistrationRepository registrationRepo,SetupBoxRepository setupBoxRepo){
        this.registrationRepo=registrationRepo;
        this.setupBoxRepo=setupBoxRepo;
    }
    @Override
    public Registration saveRegistration(Registration registration) {
        try {
            Optional<SetupBox> setupBox = setupBoxRepo.findById(registration.getSetupBox().getId());
            return registrationRepo.save(registration);
        }

        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepo.findAll();
    }
}
