package com.dme.DormitoryAdvanced.controller;


import com.dme.DormitoryAdvanced.business.Criteria.RoomCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.RoomDTO;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import com.dme.DormitoryAdvanced.business.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomResource {

    private IRoomService roomService;

    @Autowired
    public RoomResource(IRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public ResponseEntity<List<RoomDTO>> getAll(RoomCriteria criteria, Pageable pageable) {
        Page<RoomDTO> page = roomService.getModels(criteria, pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(page.getTotalElements()));

        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getById(@PathVariable Long id){
        return this.roomService.getById(id);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<RoomDTO>> getAll(){
        return this.roomService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<RoomDTO> save(@RequestBody RoomDTO roomDTO){
        return this.roomService.save(roomDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoomDTO> update(@PathVariable Long id,@RequestBody RoomDTO roomDTO){
        return this.roomService.update(id,roomDTO);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable Long id){
        return this.roomService.delete(id);
    }

    @GetMapping("/get-empty-rooms")
    public ResponseEntity<List<RoomDTO>> getEmptyRooms(){
        return this.roomService.getEmptyRooms();
    }
}
