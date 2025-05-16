package com.Aurum.DTH_App.Service.imp;

import com.Aurum.DTH_App.Entity.SetupBox;
import com.Aurum.DTH_App.Enums.SetupBoxType;
import com.Aurum.DTH_App.Enums.Status;
import com.Aurum.DTH_App.Repository.SetupBoxRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SetupBoxImpTest {

    private SetupBoxRepository setupBoxRepo;
    private SetupBoxImp setupBoxService;

    @BeforeEach
    public void setUp() {
        setupBoxRepo = mock(SetupBoxRepository.class);
        setupBoxService = new SetupBoxImp(setupBoxRepo);
    }

    private SetupBox createSampleBox() {
        return new SetupBox(1,"192.168.0.10",SetupBoxType.HD,"SB1001",Status.ACTIVE,"v1.0","Software_A");
    }

    @Test
    public void testSaveSetUpBox_Success() {
        SetupBox setupBox = createSampleBox();

        when(setupBoxRepo.save(setupBox)).thenReturn(setupBox);

        SetupBox result = setupBoxService.saveSetUpBox(setupBox);

        assertNotNull(result);
        assertEquals("SB1001", result.getSetUpBoxId());
        verify(setupBoxRepo, times(1)).save(setupBox);
    }

    @Test
    public void testSaveSetUpBox_DuplicateKeyException() {
        SetupBox setupBox = createSampleBox();

        when(setupBoxRepo.save(setupBox)).thenThrow(new RuntimeException("Duplicate key"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            setupBoxService.saveSetUpBox(setupBox);
        });

        assertEquals("Duplicate key", ex.getMessage());
        verify(setupBoxRepo, times(1)).save(setupBox);
    }

    @Test
    public void testGetAllSetUpBoxes_ReturnsList() {
        SetupBox box1 = createSampleBox();
        SetupBox box2 = new SetupBox(2,"192.168.0.11",SetupBoxType.SD,"SB1002",Status.INACTIVE,"v2.0","Software_B");

        List<SetupBox> mockList = Arrays.asList(box1, box2);

        when(setupBoxRepo.findAll()).thenReturn(mockList);

        List<SetupBox> result = setupBoxService.getAllSetUpBoxes();

        assertEquals(2, result.size());
        assertEquals("SB1001", result.get(0).getSetUpBoxId());
        assertEquals("SB1002", result.get(1).getSetUpBoxId());
        verify(setupBoxRepo, times(1)).findAll();
    }

    @Test
    public void testGetAllSetUpBoxes_EmptyList() {
        when(setupBoxRepo.findAll()).thenReturn(List.of());

        List<SetupBox> result = setupBoxService.getAllSetUpBoxes();

        assertTrue(result.isEmpty());
        verify(setupBoxRepo, times(1)).findAll();
    }
}
