package com.dme.DormitoryAdvanced.business.Criteria;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

import java.time.ZonedDateTime;

public class StudentCriteria {

    private LongFilter id;
    private StringFilter createdBy;
    private ZonedDateTimeFilter createdDt;
    private StringFilter updatedBy;
    private ZonedDateTimeFilter updatedDt;
    private BooleanFilter active;
    private StringFilter name;
    private StringFilter surname;
    private StringFilter identityNo;
    private StringFilter email;
    private ZonedDateTimeFilter birthDate;
    private StringFilter phoneNumber;


    public StudentCriteria() {
    }

    public StudentCriteria(LongFilter id, StringFilter createdBy, ZonedDateTimeFilter createdDt, StringFilter updatedBy, ZonedDateTimeFilter updatedDt, BooleanFilter active, StringFilter name, StringFilter surname, StringFilter identityNo, StringFilter email, ZonedDateTimeFilter birthDate, StringFilter phoneNumber) {
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
    }

    public LongFilter getId() {
        return id;
    }
    public void setId(LongFilter id) {
        this.id = id;
    }
    public StringFilter getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
    }
    public ZonedDateTimeFilter getCreatedDt() {
        return createdDt;
    }
    public void setCreatedDt(ZonedDateTimeFilter createdDt) {
        this.createdDt = createdDt;
    }
    public StringFilter getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(StringFilter updatedBy) {
        this.updatedBy = updatedBy;
    }
    public ZonedDateTimeFilter getUpdatedDt() {
        return updatedDt;
    }
    public void setUpdatedDt(ZonedDateTimeFilter updatedDt) {
        this.updatedDt = updatedDt;
    }
    public BooleanFilter getActive() {
        return active;
    }
    public void setActive(BooleanFilter active) {
        this.active = active;
    }
    public StringFilter getName() {
        return name;
    }
    public void setName(StringFilter name) {
        this.name = name;
    }
    public StringFilter getSurname() {
        return surname;
    }
    public void setSurname(StringFilter surname) {
        this.surname = surname;
    }
    public StringFilter getIdentityNo() {
        return identityNo;
    }
    public void setIdentityNo(StringFilter identityNo) {
        this.identityNo = identityNo;
    }
    public StringFilter getEmail() {
        return email;
    }
    public void setEmail(StringFilter email) {
        this.email = email;
    }
    public ZonedDateTimeFilter getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(ZonedDateTimeFilter birthDate) {
        this.birthDate = birthDate;
    }
    public StringFilter getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(StringFilter phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
