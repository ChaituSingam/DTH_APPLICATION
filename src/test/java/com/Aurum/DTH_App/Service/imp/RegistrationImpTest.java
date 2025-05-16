package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.Registration;
import com.Aurum.DTH_App.Entity.SetupBox;
import com.Aurum.DTH_App.Enums.IDProof;
import com.Aurum.DTH_App.Repository.RegistrationRepository;
import com.Aurum.DTH_App.Repository.SetupBoxRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegistrationImpTest {

    @Mock
    private RegistrationRepository registrationRepo;

    @Mock
    private SetupBoxRepository setupBoxRepo;

    @InjectMocks
    private RegistrationImp registrationImp;

    private SetupBox sampleSetupBox;

    @BeforeEach
    public void setup() {
        sampleSetupBox = new SetupBox();
        sampleSetupBox.setId(1);
        // initialize other SetupBox fields if needed
    }

    private Registration createRegistration(int id, String idProofNumber, IDProof idProofType, LocalDate regDate,
                                            String registrationId, String sellerId, SetupBox setupBox) {
        return new Registration(id, idProofNumber, idProofType, regDate, registrationId, sellerId, setupBox);
    }

    @Test
    public void testSaveRegistration_WithValidSetupBox() {
        Registration registration = createRegistration(101,"ID123456",IDProof.AADHAR_NUMBER,LocalDate.now(),"REG20230516","Seller001",sampleSetupBox);

        when(setupBoxRepo.findById(sampleSetupBox.getId())).thenReturn(Optional.of(sampleSetupBox));
        when(registrationRepo.save(registration)).thenReturn(registration);

        Registration result = registrationImp.saveRegistration(registration);

        verify(setupBoxRepo, times(1)).findById(sampleSetupBox.getId());
        verify(registrationRepo, times(1)).save(registration);

        assertEquals(registration, result);
    }

    @Test
    public void testSaveRegistration_WithMissingSetupBox_ShouldThrowException() {
        Registration registration = createRegistration(102,"ID654321",IDProof.PASSPORT_NUMBER, LocalDate.now(),"REG20230517","Seller002",sampleSetupBox);

        when(setupBoxRepo.findById(sampleSetupBox.getId()))
                .thenThrow(new RuntimeException("SetupBox not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            registrationImp.saveRegistration(registration);
        });

        verify(setupBoxRepo, times(1)).findById(sampleSetupBox.getId());
        verify(registrationRepo, never()).save(any());

        assertEquals("SetupBox not found", exception.getMessage());
    }

    @Test
    public void testGetAllRegistrations_ReturnsList() {
        Registration reg1 = createRegistration(201, "ID100", IDProof.AADHAR_NUMBER, LocalDate.now(), "REG001", "Seller1", sampleSetupBox);
        Registration reg2 = createRegistration(202, "ID101", IDProof.PASSPORT_NUMBER, LocalDate.now(), "REG002", "Seller2", sampleSetupBox);

        List<Registration> mockList = Arrays.asList(reg1, reg2);

        when(registrationRepo.findAll()).thenReturn(mockList);

        List<Registration> result = registrationImp.getAllRegistrations();

        verify(registrationRepo, times(1)).findAll();

        assertEquals(2, result.size());
        assertEquals("ID100", result.get(0).getIdProofNumber());
        assertEquals("Seller2", result.get(1).getSellerId());
    }

    @Test
    public void testSaveRegistration_WithPANNumberIdProof() {
        Registration registration = createRegistration(103,"LAK23453M",IDProof.PAN_NUMBER,LocalDate.now(),"REG20230518","Seller003",sampleSetupBox);

        when(setupBoxRepo.findById(sampleSetupBox.getId())).thenReturn(Optional.of(sampleSetupBox));
        when(registrationRepo.save(registration)).thenReturn(registration);

        Registration result = registrationImp.saveRegistration(registration);

        verify(setupBoxRepo, times(1)).findById(sampleSetupBox.getId());
        verify(registrationRepo, times(1)).save(registration);

        assertEquals(IDProof.PAN_NUMBER, result.getIdProofType());
        assertEquals("LAK23453M", result.getIdProofNumber());
    }

    @Test
    public void testSaveRegistration_WithVoterIdAndEmptySellerId() {
        Registration registration = createRegistration(104,"VID100212B",IDProof.VOTER_ID,LocalDate.now(),"REG20230519","",sampleSetupBox);

        when(setupBoxRepo.findById(sampleSetupBox.getId())).thenReturn(Optional.of(sampleSetupBox));
        when(registrationRepo.save(registration)).thenReturn(registration);

        Registration result = registrationImp.saveRegistration(registration);

        verify(setupBoxRepo, times(1)).findById(sampleSetupBox.getId());
        verify(registrationRepo, times(1)).save(registration);

        assertEquals(IDProof.VOTER_ID, result.getIdProofType());
        assertEquals("", result.getSellerId());
    }

}
