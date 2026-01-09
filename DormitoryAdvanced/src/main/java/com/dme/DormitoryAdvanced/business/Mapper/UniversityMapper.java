package com.dme.DormitoryAdvanced.business.Mapper;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.entity.Menus;
import com.dme.DormitoryAdvanced.entity.Student;
import com.dme.DormitoryAdvanced.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

public class UniversityMapper {
    public static UniversityDTO toDto(University entity) {
        if (entity == null) return null;

        UniversityDTO dto = new UniversityDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCity(entity.getCity());
        dto.setActive(entity.getActive());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDt(entity.getCreatedDt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedDt(entity.getUpdatedDt());

        // Öğrencileri sadece ID'leriyle DTO'da tutuyorsan:
        if (entity.getStudents() != null) {
            List<Long> studentIds = entity.getStudents().stream()
                    .map(Student::getId)
                    .collect(Collectors.toList());
            dto.setStudentIds(studentIds);
        }

        return dto;
    }

    public static University toEntity(UniversityDTO dto) {
        if (dto == null) return null;

        University entity = new University();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setActive(dto.getActive());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDt(dto.getCreatedDt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedDt(dto.getUpdatedDt());

        // NOT: `dto.getStudentIds()` içindeki öğrencilerle birebir Student setleme işlemi
        // için bu aşamada StudentRepository ile yükleme yapılabilir. Örnek:
        // entity.setStudents(studentRepository.findAllById(dto.getStudentIds()));

        return entity;
    }
}
