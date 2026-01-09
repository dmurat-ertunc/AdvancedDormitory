package com.dme.DormitoryAdvanced.business.Mapper;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.entity.Menus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IMenusMapper {

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "createdBy", source = "createdBy")
//    @Mapping(target = "createdDt", source = "createdDt")
//    @Mapping(target = "updatedBy", source = "updatedBy")
//    @Mapping(target = "updatedDt", source = "updatedDt")
//    @Mapping(target = "active", source = "active")
//    @Mapping(target = "langCode", source = "langCode")
//    @Mapping(target = "path", source = "path")
//    @Mapping(target = "mainGroupId", source = "mainGroupId")
//    @Mapping(target = "type", source = "type")
//    @Mapping(target = "iconName", source = "iconName")

    MenusDTO toDto(Menus entity);
    Menus toEntity(MenusDTO dto);

    List<MenusDTO> toDtoList(List<Menus> entityList);
    List<Menus> toEntityList(List<MenusDTO> dtoList);
}