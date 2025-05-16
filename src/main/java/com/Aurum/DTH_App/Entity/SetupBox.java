package com.Aurum.DTH_App.Entity;

import com.Aurum.DTH_App.Enums.SetupBoxType;
import com.Aurum.DTH_App.Enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "setupBox")
public class SetupBox
{
    @Id
    private int id;
    private String ipAddress;
    private SetupBoxType setupBoxType;
    private String setupBoxId;
    private Status status;
    private String version;
    private String software;

    public SetupBox(int id, String ipAddress, SetupBoxType setupBoxType, String setupBoxId, Status status, String version, String software) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.setupBoxType = setupBoxType;
        this.setupBoxId = setupBoxId;
        this.status = status;
        this.version = version;
        this.software = software;
    }

    public SetupBox() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public SetupBoxType getSetUpBoxType() {
        return setupBoxType;
    }

    public void setSetUpBoxType(SetupBoxType setUpBoxType) {
        this.setupBoxType = setUpBoxType;
    }

    public String getSetUpBoxId() {
        return setupBoxId;
    }

    public void setSetUpBoxId(String setUpBoxId) {
        this.setupBoxId = setUpBoxId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }
}

