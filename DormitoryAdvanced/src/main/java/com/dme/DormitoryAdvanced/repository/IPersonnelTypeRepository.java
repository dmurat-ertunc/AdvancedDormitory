package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.PersonnelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonnelTypeRepository extends JpaRepository<PersonnelType,Long> {
}
