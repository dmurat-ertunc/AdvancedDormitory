package com.dme.DormitoryAdvanced.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personnel")
public class Personnel{

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

    @Column(name = "surname")
    private String surname;

    @Column(name = "identity_no")
    private String identityNo;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private ZonedDateTime birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "personnel_type_id") // student tablosunda bu kolon oluşur
    private PersonnelType personnelType;
}
