package com.dme.DormitoryAdvanced.business.service;

import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable; // ✅

import java.util.List;

@Service
public interface IUniversityService {

    ResponseEntity<List<UniversityDTO>> getAll();
    ResponseEntity<UniversityDTO> save(UniversityDTO universityDTO);
    ResponseEntity<UniversityDTO> update(Long id,UniversityDTO universityDTO);
    Void delete(Long id);
    Page<UniversityDTO> getModels(UniversityCriteria criteria, Pageable pageable);
}
