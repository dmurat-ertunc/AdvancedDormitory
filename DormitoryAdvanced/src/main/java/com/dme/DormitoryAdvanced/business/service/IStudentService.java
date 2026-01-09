package com.dme.DormitoryAdvanced.business.service;

import com.dme.DormitoryAdvanced.business.Criteria.StudentCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    ResponseEntity<List<StudentDTO>> getAll();
    ResponseEntity<StudentDTO> save(StudentDTO StudentDTO);
    ResponseEntity<StudentDTO> update(Long id,StudentDTO StudentDTO);
    Void delete(Long id);
    Page<StudentDTO> getModels(StudentCriteria criteria, Pageable pageable);
}
