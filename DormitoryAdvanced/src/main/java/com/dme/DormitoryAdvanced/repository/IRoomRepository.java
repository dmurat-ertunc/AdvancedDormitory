package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.Room;
import com.dme.DormitoryAdvanced.entity.University;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,Long>, JpaSpecificationExecutor<Room> {

    @Query("SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.students")
    Page<Room> findAll(Specification<Room> spec, Pageable pageable);
    List<Room> findByEmptyTrue();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select r from Room r where r.id = :id")
    Room findByIdForUpdate(@Param("id") Long id);
}
