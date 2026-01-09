package com.dme.DormitoryAdvanced.business.Mapper;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import com.dme.DormitoryAdvanced.entity.Menus;
import com.dme.DormitoryAdvanced.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


public class StudentMapper {
    public static StudentDTO toDto(Student entity) {
        if (entity == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDt(entity.getCreatedDt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedDt(entity.getUpdatedDt());
        dto.setActive(entity.getActive());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setIdentityNo(entity.getIdentityNo());
        dto.setEmail(entity.getEmail());
        dto.setBirthDate(entity.getBirthDate());
        dto.setPhoneNumber(entity.getPhoneNumber());

//        dto.setUser(entity.getUser()); // varsa UserDTO ile değiştirilebilir
        dto.setUniversity(entity.getUniversity());
        dto.setRoom(entity.getRoom());

        dto.setUniversityId(entity.getUniversity() != null ? entity.getUniversity().getId() : null);
        dto.setRoomId(entity.getRoom() != null ? entity.getRoom().getId() : null);

        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        if (dto == null) return null;

        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDt(dto.getCreatedDt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedDt(dto.getUpdatedDt());
        entity.setActive(dto.getActive());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setIdentityNo(dto.getIdentityNo());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPhoneNumber(dto.getPhoneNumber());

//        entity.setUser(dto.getUser());
        entity.setUniversity(dto.getUniversity()); // isteğe bağlı Entity load edilebilir
        entity.setRoom(dto.getRoom());

        return entity;
    }
}
