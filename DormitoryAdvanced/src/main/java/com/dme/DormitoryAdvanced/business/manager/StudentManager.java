package com.dme.DormitoryAdvanced.business.manager;

import com.dme.DormitoryAdvanced.base.BaseClass;
import com.dme.DormitoryAdvanced.business.Criteria.StudentCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import com.dme.DormitoryAdvanced.business.Mapper.StudentMapper;
import com.dme.DormitoryAdvanced.business.QueryService.StudentQueryService;
import com.dme.DormitoryAdvanced.business.service.IStudentService;
import com.dme.DormitoryAdvanced.entity.*;
import com.dme.DormitoryAdvanced.exception.BusinessException;
import com.dme.DormitoryAdvanced.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentManager extends BaseClass implements IStudentService {

    private IStudentRepository studentRepository;
    private StudentQueryService studentQueryService;
    private IUniversityRepository universityRepository;
    private IRoomRepository roomRepository;
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public StudentManager(IStudentRepository studentRepository,  StudentQueryService studentQueryService,
                          IRoomRepository roomRepository, IUniversityRepository universityRepository, IUserRepository userRepository,
                          IRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.studentQueryService = studentQueryService;
        this.universityRepository = universityRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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

    @Transactional
    @Override
    public ResponseEntity<StudentDTO> save(StudentDTO dto) {

        Student entity = StudentMapper.toEntity(dto);

        if (dto.getUniversityId() != null) {
            University university = universityRepository
                    .findById(dto.getUniversityId())
                    .orElseThrow(() -> new RuntimeException("University not found"));
            entity.setUniversity(university);
        }

        if (dto.getRoomId() != null) {

            Room room = roomRepository.findByIdForUpdate(dto.getRoomId());

            if (room.getManySize() >= room.getRoomSize()) {
                throw new BusinessException("Room is full",HttpStatus.FORBIDDEN);
            }

            room.setManySize(room.getManySize() + 1);

            room.setEmpty(room.getManySize() < room.getRoomSize());

            entity.setRoom(room);
        }

        if (dto.getEmail() == null || !dto.getEmail().contains("@")) {
            throw new RuntimeException("Invalid email");
        }

        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        String baseUsername = dto.getEmail().substring(0, dto.getEmail().indexOf("@"));
        String username = baseUsername;

        int counter = 1;
        while (userRepository.existsByUsername(username)) {
            username = baseUsername + counter;
            counter++;
        }

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }

        Role studentRole = roleRepository.findByName("STUDENT")
                .orElseThrow(() -> new RuntimeException("Student role not found"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("123"));
        user.getRoles().add(studentRole);

        User savedUser = userRepository.save(user);

        entity.setUser(savedUser);


        Student saved = studentRepository.save(entity);

        return ResponseEntity.ok(StudentMapper.toDto(saved));
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
