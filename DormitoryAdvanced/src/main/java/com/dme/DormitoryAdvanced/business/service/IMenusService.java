package com.dme.DormitoryAdvanced.business.service;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.entity.Menus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenusService {

    ResponseEntity<List<MenusDTO>> getAll();

    ResponseEntity<List<MenusDTO>> getByType(Long typeId);
}
