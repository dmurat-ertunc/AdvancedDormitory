package com.dme.DormitoryAdvanced.business.manager;

import com.dme.DormitoryAdvanced.base.BaseClass;
import com.dme.DormitoryAdvanced.business.Criteria.StudentCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import com.dme.DormitoryAdvanced.business.Mapper.StudentMapper;
import com.dme.DormitoryAdvanced.business.QueryService.StudentQueryService;
import com.dme.DormitoryAdvanced.business.service.IStudentService;
import com.dme.DormitoryAdvanced.entity.Student;
import com.dme.DormitoryAdvanced.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentManager extends BaseClass implements IStudentService {

    private IStudentRepository studentRepository;
    private StudentQueryService studentQueryService;


    @Autowired
    public StudentManager(IStudentRepository studentRepository,  StudentQueryService studentQueryService) {
        this.studentRepository = studentRepository;
        this.studentQueryService = studentQueryService;
    }

    @Override
    public Page<StudentDTO> getModels(StudentCriteria criteria, Pageable pageable) {
        Specification<Student> spec = studentQueryService.createSpecification(criteria);
        return studentRepository.findAll(spec, pageable)
                .map(StudentMapper::toDto);
    }


    @Override
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<StudentDTO> StudentDTOList = entityToDtoList(studentRepository.findAll(), StudentMapper::toDto);
        return ResponseEntity.ok(StudentDTOList);
    }

    @Override
    public ResponseEntity<StudentDTO> save(StudentDTO studentDTO){
        Student student = dtoToEntity(studentDTO, StudentMapper::toEntity);
        studentRepository.save(student);
        return ResponseEntity.ok(studentDTO);
    }

    @Override
    public ResponseEntity<StudentDTO> update(Long id,StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            Student student = dtoToEntity(studentDTO, StudentMapper::toEntity);
            studentRepository.save(student);
            return ResponseEntity.ok(studentDTO);
        }
        return  null;
    }

    @Override
    public Void delete(Long id){
        studentRepository.deleteById(id);
        return null;
    }


}
