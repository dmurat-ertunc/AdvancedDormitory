package com.dme.DormitoryAdvanced.business.Mapper;


import com.dme.DormitoryAdvanced.business.Dtos.RoomDTO;
import com.dme.DormitoryAdvanced.business.Dtos.StudentDTO;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.entity.Room;
import com.dme.DormitoryAdvanced.entity.Student;
import com.dme.DormitoryAdvanced.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {


    public static RoomDTO toDto(Room entity) {
        if (entity == null) return null;

        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDt(entity.getCreatedDt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedDt(entity.getUpdatedDt());
        dto.setActive(entity.getActive());
        dto.setRoomNo(entity.getRoomNo());
        dto.setRoomSize(entity.getRoomSize());
        dto.setManySize(entity.getManySize());
        dto.setPerPersonPrice(entity.getPerPersonPrice());
        dto.setEmpty(entity.isEmpty());

        // Students'ı mapleyelim
        if (entity.getStudents() != null) {
            List<StudentDTO> studentDTOs = entity.getStudents().stream()
                    .map(StudentMapper::toDto)
                    .collect(Collectors.toList());
            dto.setStudents(studentDTOs);
        }

        return dto;
    }

    public static Room toEntity(RoomDTO dto) {
        if (dto == null) return null;

        Room entity = new Room();
        entity.setId(dto.getId());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDt(dto.getCreatedDt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedDt(dto.getUpdatedDt());
        entity.setActive(dto.getActive());
        entity.setRoomNo(dto.getRoomNo());
        entity.setRoomSize(dto.getRoomSize());
        entity.setManySize(dto.getManySize());
        entity.setPerPersonPrice(dto.getPerPersonPrice());
        entity.setEmpty(dto.isEmpty());

        if (dto.getStudents() != null) {
            List<Student> students = dto.getStudents().stream()
                    .map(StudentMapper::toEntity)
                    .collect(Collectors.toList());
            entity.setStudents(students);
        }

        return entity;
    }

}
