package com.dme.DormitoryAdvanced.business.Criteria;

import com.dme.DormitoryAdvanced.entity.Student;
import io.github.jhipster.service.filter.*;

import java.time.ZonedDateTime;
import java.util.List;

public class RoomCriteria {

    private LongFilter id;
    private StringFilter createdBy;
    private ZonedDateTimeFilter createdDt;
    private StringFilter updatedBy;
    private ZonedDateTimeFilter updatedDt;
    private BooleanFilter active;
    private LongFilter roomNo;
    private IntegerFilter roomSize;
    private IntegerFilter manySize;
    private FloatFilter perPersonPrice;
    private BooleanFilter empty;


    public RoomCriteria() {
    }

    public RoomCriteria(LongFilter id, StringFilter createdBy, ZonedDateTimeFilter createdDt, StringFilter updatedBy, ZonedDateTimeFilter updatedDt, BooleanFilter active, LongFilter roomNo, IntegerFilter roomSize, IntegerFilter manySize, FloatFilter perPersonPrice, BooleanFilter empty) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
        this.updatedBy = updatedBy;
        this.updatedDt = updatedDt;
        this.active = active;
        this.roomNo = roomNo;
        this.roomSize = roomSize;
        this.manySize = manySize;
        this.perPersonPrice = perPersonPrice;
        this.empty = empty;
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

    public LongFilter getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(LongFilter roomNo) {
        this.roomNo = roomNo;
    }

    public IntegerFilter getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(IntegerFilter roomSize) {
        this.roomSize = roomSize;
    }

    public IntegerFilter getManySize() {
        return manySize;
    }

    public void setManySize(IntegerFilter manySize) {
        this.manySize = manySize;
    }

    public FloatFilter getPerPersonPrice() {
        return perPersonPrice;
    }

    public void setPerPersonPrice(FloatFilter perPersonPrice) {
        this.perPersonPrice = perPersonPrice;
    }

    public BooleanFilter getEmpty() {
        return empty;
    }

    public void setEmpty(BooleanFilter empty) {
        this.empty = empty;
    }
}
