package com.dme.DormitoryAdvanced.business.service;


import com.dme.DormitoryAdvanced.business.Criteria.RoomCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.RoomDTO;
import com.dme.DormitoryAdvanced.business.Dtos.UniversityDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoomService {
    ResponseEntity<List<RoomDTO>> getAll();
    ResponseEntity<RoomDTO> save(RoomDTO roomDTO);
    ResponseEntity<RoomDTO> update(Long id,RoomDTO roomDTO);
    Void delete(Long id);
    Page<RoomDTO> getModels(RoomCriteria criteria, Pageable pageable);
    ResponseEntity<RoomDTO> getById(Long id);
    ResponseEntity<List<RoomDTO>> getEmptyRooms();
}
