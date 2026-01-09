package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.Student;
import com.dme.DormitoryAdvanced.entity.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> , JpaSpecificationExecutor<Student> {

    Page<Student> findAll(Specification<Student> spec, Pageable pageable);

}
