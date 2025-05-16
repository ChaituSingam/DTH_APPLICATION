package com.Aurum.DTH_App.Entity;


import com.Aurum.DTH_App.Enums.IDProof;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "registrations")
public class Registration
{
    @Id
    private int id;
    @Indexed(unique = true)
    private String idProofNumber;
    private IDProof idProofType;
    private LocalDate registrationDate;
    @Indexed(unique = true)
    private String registrationId;
    private String sellerId;
    @DBRef
    private SetupBox setupBox;

    public Registration(int id, String idProofNumber, IDProof idProofType, LocalDate registrationDate, String registrationId, String sellerId, SetupBox setupBox) {
        this.id = id;
        this.idProofNumber = idProofNumber;
        this.idProofType = idProofType;
        this.registrationDate = registrationDate;
        this.registrationId = registrationId;
        this.sellerId = sellerId;
        this.setupBox = setupBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProofNumber() {
        return idProofNumber;
    }

    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }

    public IDProof getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(IDProof idProofType) {
        this.idProofType = idProofType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public SetupBox getSetupBox() {
        return setupBox;
    }

    public void setSetupBox(SetupBox setupBox) {
        this.setupBox = setupBox;
    }
}
