package com.dme.DormitoryAdvanced.controller;

import com.dme.DormitoryAdvanced.business.Dtos.MenusDTO;
import com.dme.DormitoryAdvanced.business.service.IMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenusResource {

    private IMenusService menusService;

    @Autowired
    public MenusResource(IMenusService menusService) {
        this.menusService = menusService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MenusDTO>> getAll(){
        return this.menusService.getAll();
    }
}
