package com.dme.DormitoryAdvanced.business.manager;

import com.dme.DormitoryAdvanced.base.BaseClass;
import com.dme.DormitoryAdvanced.business.Criteria.RoomCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.business.Dtos.RoomDTO;
import com.dme.DormitoryAdvanced.business.Dtos.RoomDTO;
import com.dme.DormitoryAdvanced.business.Mapper.RoomMapper;
import com.dme.DormitoryAdvanced.business.QueryService.RoomQueryService;
import com.dme.DormitoryAdvanced.business.service.IRoomService;
import com.dme.DormitoryAdvanced.entity.Room;
import com.dme.DormitoryAdvanced.entity.University;
import com.dme.DormitoryAdvanced.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoomManager extends BaseClass implements IRoomService{
    private IRoomRepository roomRepository;
    private RoomQueryService roomQueryService;


    @Autowired
    public RoomManager(IRoomRepository roomRepository,   RoomQueryService roomQueryService) {
        this.roomRepository = roomRepository;
        this.roomQueryService = roomQueryService;
    }


    @Override
    public Page<RoomDTO> getModels(RoomCriteria criteria, Pageable pageable) {
        Specification<Room> spec = roomQueryService.createSpecification(criteria);
        return roomRepository.findAll(spec, pageable)
                .map(RoomMapper::toDto);
    }

    @Override
    public ResponseEntity<RoomDTO> getById(Long id){
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()){
            Room room = roomOptional.get();
            return ResponseEntity.ok(entityToDto(room, RoomMapper::toDto));
        }
        return null;
    }


    @Override
    public ResponseEntity<List<RoomDTO>> getAll(){
        List<RoomDTO> RoomDTOList = entityToDtoList(roomRepository.findAll(), RoomMapper::toDto);
        return ResponseEntity.ok(RoomDTOList);
    }

    @Override
    public ResponseEntity<RoomDTO> save(RoomDTO roomDTO){
        Room room = dtoToEntity(roomDTO, RoomMapper::toEntity);
        roomRepository.save(room);
        return ResponseEntity.ok(roomDTO);
    }

    @Override
    public ResponseEntity<RoomDTO> update(Long id,RoomDTO roomDTO) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()){
            Room room = dtoToEntity(roomDTO, RoomMapper::toEntity);
            roomRepository.save(room);
            return ResponseEntity.ok(roomDTO);
        }
        return  null;
    }

    @Override
    public Void delete(Long id){
        roomRepository.deleteById(id);
        return null;
    }

    @Override
    public ResponseEntity<List<RoomDTO>> getEmptyRooms(){
        List<RoomDTO> roomDTOList = entityToDtoList(roomRepository.findByEmptyTrue(), RoomMapper::toDto );
        return ResponseEntity.ok(roomDTOList);
    }
}
