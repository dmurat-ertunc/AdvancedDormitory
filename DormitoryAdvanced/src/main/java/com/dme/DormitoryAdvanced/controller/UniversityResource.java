package com.dme.DormitoryAdvanced.controller;


import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.business.service.IUniversityService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RequestMapping("/api/universities")
@RestController
public class UniversityResource {

    private IUniversityService universityService;

    @Autowired
    public UniversityResource(IUniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("")
    public ResponseEntity<List<UniversityDTO>> getAll(UniversityCriteria criteria, Pageable pageable) {
        Page<UniversityDTO> page = universityService.getModels(criteria, pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(page.getTotalElements()));

        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }



    @GetMapping("get-all")
    public ResponseEntity<List<UniversityDTO>> getAll(){
        return this.universityService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<UniversityDTO> save(@RequestBody UniversityDTO universityDTO){
        return this.universityService.save(universityDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UniversityDTO> update(@PathVariable Long id,@RequestBody UniversityDTO universityDTO){
        return this.universityService.update(id,universityDTO);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable Long id){
        return this.universityService.delete(id);
    }
}
