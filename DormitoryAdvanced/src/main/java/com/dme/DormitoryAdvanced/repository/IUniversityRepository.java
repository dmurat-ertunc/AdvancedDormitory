package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.University;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable; // ✅ doğru

@Repository
public interface IUniversityRepository extends JpaRepository<University,Long>, JpaSpecificationExecutor<University> {

    Page<University> findAll(Specification<University> spec, Pageable pageable);

}
