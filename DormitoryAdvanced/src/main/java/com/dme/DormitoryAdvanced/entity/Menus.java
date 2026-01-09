package com.dme.DormitoryAdvanced.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menus")
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_dt")
    private ZonedDateTime createdDt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_dt")
    private ZonedDateTime updatedDt;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "lang_code")
    private String langCode;

    @Column(name = "path")
    private String path;

    @Column(name = "main_group_id")
    private Long mainGroupId;

    @Column(name = "type")
    private Long type;

    @Column(name = "icon-name")
    private String iconName;


}
