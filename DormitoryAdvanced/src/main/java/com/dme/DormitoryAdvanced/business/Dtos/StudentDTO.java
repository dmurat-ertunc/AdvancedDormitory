package com.dme.DormitoryAdvanced.business.Dtos;

import com.dme.DormitoryAdvanced.entity.Room;
import com.dme.DormitoryAdvanced.entity.University;
import com.dme.DormitoryAdvanced.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

public class StudentDTO {

    private Long id;
    private String createdBy;
    private ZonedDateTime createdDt;
    private String updatedBy;
    private ZonedDateTime updatedDt;
    private Boolean active;
    private String name;
    private String surname;
    private String identityNo;
    private String email;
    private ZonedDateTime birthDate;
    private String phoneNumber;
    private Long universityId;
    private Long roomId;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String createdBy, ZonedDateTime createdDt, String updatedBy,
                      ZonedDateTime updatedDt, Boolean active, String name, String surname,
                      String identityNo, String email, ZonedDateTime birthDate, String phoneNumber,
                      Long universityId, Long roomId) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
        this.updatedBy = updatedBy;
        this.updatedDt = updatedDt;
        this.active = active;
        this.name = name;
        this.surname = surname;
        this.identityNo = identityNo;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.universityId = universityId;
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public ZonedDateTime getCreatedDt() {
        return createdDt;
    }
    public void setCreatedDt(ZonedDateTime createdDt) {
        this.createdDt = createdDt;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public ZonedDateTime getUpdatedDt() {
        return updatedDt;
    }
    public void setUpdatedDt(ZonedDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getIdentityNo() {
        return identityNo;
    }
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ZonedDateTime getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Long getUniversityId() {
        return universityId;
    }
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
    public Long getRoomId() {
        return roomId;
    }
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
