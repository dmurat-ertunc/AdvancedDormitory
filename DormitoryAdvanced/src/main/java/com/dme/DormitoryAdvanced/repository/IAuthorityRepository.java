package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority,Long> {
}
