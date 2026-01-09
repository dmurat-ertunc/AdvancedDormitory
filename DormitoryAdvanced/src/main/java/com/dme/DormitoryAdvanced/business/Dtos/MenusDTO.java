package com.dme.DormitoryAdvanced.business.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.ZonedDateTime;

public class MenusDTO {

    private Long id;
    private String createdBy;
    private ZonedDateTime createdDt;
    private String updatedBy;
    private ZonedDateTime updatedDt;
    private Boolean active;
    private String langCode;
    private String path;
    private Long mainGroupId;
    private Long type;
    private String iconName;

    public MenusDTO() {
    }

    public MenusDTO(Long id, String createdBy, ZonedDateTime createdDt, String updatedBy, ZonedDateTime updatedDt, Boolean active, String langCode, String path, Long mainGroupId, Long type,
                    String iconName) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
        this.updatedBy = updatedBy;
        this.updatedDt = updatedDt;
        this.active = active;
        this.langCode = langCode;
        this.path = path;
        this.mainGroupId = mainGroupId;
        this.type = type;
        this.iconName = iconName;
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

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getMainGroupId() {
        return mainGroupId;
    }

    public void setMainGroupId(Long mainGroupId) {
        this.mainGroupId = mainGroupId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
