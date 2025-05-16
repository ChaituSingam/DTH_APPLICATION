package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.SetupBox;
import com.Aurum.DTH_App.Repository.SetupBoxRepository;
import com.Aurum.DTH_App.Service.ISetupBox;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SetupBoxImp implements ISetupBox {

    private SetupBoxRepository setupBoxRepo;
    public SetupBoxImp(SetupBoxRepository setupBoxRepo){
        this.setupBoxRepo=setupBoxRepo;
    }
    @Override
    public SetupBox saveSetUpBox(SetupBox setupBox) {
        try{
            return setupBoxRepo.save(setupBox);
        }

        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<SetupBox> getAllSetUpBoxes() {
        return setupBoxRepo.findAll();
    }
}
