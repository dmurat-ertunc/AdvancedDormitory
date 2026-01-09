package com.dme.DormitoryAdvanced.business.Dtos;


import com.dme.DormitoryAdvanced.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {


    private Long id;
    private String createdBy;
    private ZonedDateTime createdDt;
    private String updatedBy;
    private ZonedDateTime updatedDt;
    private Boolean active;
    private Long roomNo;
    private int roomSize;
    private int manySize;
    private float perPersonPrice;
    private boolean empty;
    private List<StudentDTO> students;


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

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public int getManySize() {
        return manySize;
    }

    public void setManySize(int manySize) {
        this.manySize = manySize;
    }

    public float getPerPersonPrice() {
        return perPersonPrice;
    }

    public void setPerPersonPrice(float perPersonPrice) {
        this.perPersonPrice = perPersonPrice;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
