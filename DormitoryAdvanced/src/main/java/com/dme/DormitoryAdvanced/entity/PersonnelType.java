package com.dme.DormitoryAdvanced.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personnel_type")
public class PersonnelType{

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

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "personnelType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personnel> personnels;
}
