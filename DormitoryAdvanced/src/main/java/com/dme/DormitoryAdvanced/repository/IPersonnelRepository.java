package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonnelRepository extends JpaRepository<Personnel,Long> {
}
