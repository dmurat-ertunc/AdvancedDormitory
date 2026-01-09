package com.dme.DormitoryAdvanced.business.manager;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.business.Mapper.IMenusMapper;
import com.dme.DormitoryAdvanced.business.service.IMenusService;
import com.dme.DormitoryAdvanced.entity.Menus;
import com.dme.DormitoryAdvanced.repository.IMenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusManager implements IMenusService {

    private IMenusRepository menusRepository;
    private IMenusMapper menusMapper;

    @Autowired
    public MenusManager(IMenusRepository menusRepository, IMenusMapper menusMapper) {
        this.menusRepository = menusRepository;
        this.menusMapper = menusMapper;
    }

    @Override
    public ResponseEntity<List<MenusDTO>> getAll() {
        List<Menus> menusList2 = menusRepository.findAll();
        List<MenusDTO> menusList = menusMapper.toDtoList(menusRepository.findAll());
        return ResponseEntity.ok().body(menusList);
    }

    @Override
    public ResponseEntity<List<MenusDTO>> getByType(Long typeId) {
        return null;
    }
}
