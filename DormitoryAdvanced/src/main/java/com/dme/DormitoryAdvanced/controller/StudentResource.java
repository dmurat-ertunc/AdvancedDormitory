package com.dme.DormitoryAdvanced.controller;


import com.dme.DormitoryAdvanced.business.Criteria.StudentCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.business.service.IStudentService;
import com.dme.DormitoryAdvanced.business.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentResource {
    private IStudentService studentService;

    @Autowired
    public StudentResource(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAll(StudentCriteria criteria, Pageable pageable) {
        Page<StudentDTO> page = studentService.getModels(criteria, pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(page.getTotalElements()));

        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }



    @GetMapping("get-all")
    public ResponseEntity<List<StudentDTO>> getAll(){
        return this.studentService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO){
        return this.studentService.save(studentDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id,@RequestBody StudentDTO studentDTO){
        return this.studentService.update(id,studentDTO);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable Long id){
        return this.studentService.delete(id);
    }
}
