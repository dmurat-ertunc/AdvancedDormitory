package com.dme.DormitoryAdvanced.business.Criteria;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

public class UniversityCriteria {

    private StringFilter name;
    private StringFilter city;
    private BooleanFilter active;

    private StringFilter createdBy;
    private StringFilter updatedBy;

    private ZonedDateTimeFilter createdDt;
    private ZonedDateTimeFilter updatedDt;

    private LongFilter id;

    public UniversityCriteria() {
    }

    public UniversityCriteria(StringFilter name, StringFilter city, BooleanFilter active, StringFilter createdBy, StringFilter updatedBy, ZonedDateTimeFilter createdDt, ZonedDateTimeFilter updatedDt, LongFilter id) {
        this.name = name;
        this.city = city;
        this.active = active;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDt = createdDt;
        this.updatedDt = updatedDt;
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getCity() {
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
    }

    public BooleanFilter getActive() {
        return active;
    }

    public void setActive(BooleanFilter active) {
        this.active = active;
    }

    public StringFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
    }

    public StringFilter getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(StringFilter updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTimeFilter getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(ZonedDateTimeFilter createdDt) {
        this.createdDt = createdDt;
    }

    public ZonedDateTimeFilter getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(ZonedDateTimeFilter updatedDt) {
        this.updatedDt = updatedDt;
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }
}
