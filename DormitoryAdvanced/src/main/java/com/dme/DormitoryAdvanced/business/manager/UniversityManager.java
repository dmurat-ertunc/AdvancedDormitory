package com.dme.DormitoryAdvanced.business.manager;


import com.dme.DormitoryAdvanced.base.BaseClass;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.business.Mapper.UniversityMapper;
import com.dme.DormitoryAdvanced.business.QueryService.UniversityQueryService;
import com.dme.DormitoryAdvanced.business.service.IUniversityService;
import com.dme.DormitoryAdvanced.entity.University;
import com.dme.DormitoryAdvanced.repository.IUniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable; // ✅ doğru
import java.util.List;
import java.util.Optional;

@Service
public class UniversityManager extends BaseClass implements IUniversityService {

    private IUniversityRepository universityRepository;
    private UniversityQueryService universityQueryService;


    @Autowired
    public UniversityManager(IUniversityRepository universityRepository, UniversityQueryService universityQueryService) {
        this.universityRepository = universityRepository;
        this.universityQueryService = universityQueryService;
    }

    @Override
    public Page<UniversityDTO> getModels(UniversityCriteria criteria, Pageable pageable) {
        Specification<University> spec = universityQueryService.createSpecification(criteria);
        return universityRepository.findAll(spec, pageable)
                .map(UniversityMapper::toDto);
    }


    @Override
    public ResponseEntity<List<UniversityDTO>> getAll(){
        List<UniversityDTO> universityDTOList = entityToDtoList(universityRepository.findAll(), UniversityMapper::toDto);
        return ResponseEntity.ok(universityDTOList);
    }

    @Override
    public ResponseEntity<UniversityDTO> save(UniversityDTO universityDTO){
        University university = dtoToEntity(universityDTO, UniversityMapper::toEntity);
        universityRepository.save(university);
        return ResponseEntity.ok(universityDTO);
    }

    @Override
    public ResponseEntity<UniversityDTO> update(Long id,UniversityDTO universityDTO) {
        Optional<University> universityOptional = universityRepository.findById(id);
        if (universityOptional.isPresent()){
            University university = entityToDto(universityDTO, UniversityMapper::toEntity);
            universityRepository.save(university);
            return ResponseEntity.ok(universityDTO);
        }
        return  null;
    }

    @Override
    public Void delete(Long id){
        universityRepository.deleteById(id);
        return null;
    }


}
