package com.Aurum.DTH_App.Service;

import com.Aurum.DTH_App.Entity.SetupBox;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISetupBox {

    SetupBox saveSetUpBox(SetupBox setupBox);

    List<SetupBox> getAllSetUpBoxes();
}
