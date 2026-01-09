package com.dme.DormitoryAdvanced.business.QueryService;

import com.dme.DormitoryAdvanced.business.Criteria.RoomCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.entity.Room;
import com.dme.DormitoryAdvanced.entity.University;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RoomQueryService {

    public Specification<Room> createSpecification(RoomCriteria criteria) {
        Specification<Room> spec = Specification.where(null);

        if (criteria != null) {

            // City filters
            if (criteria.getRoomNo() != null) {
                if (criteria.getRoomNo().getEquals() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.equal(cb.lower(root.get("roomNo")), criteria.getRoomNo().getEquals()));
                }
//                if (criteria.getRoomNo().getContains() != null) {
//                    spec = spec.and((root, query, cb) ->
//                            cb.like(cb.lower(root.get("city")), "%" + criteria.getRoomNo().getContains().toLowerCase() + "%"));
//                }
            }

            // Name filters
//            if (criteria.getName() != null) {
//                if (criteria.getName().getEquals() != null) {
//                    spec = spec.and((root, query, cb) ->
//                            cb.equal(cb.lower(root.get("name")), criteria.getName().getEquals().toLowerCase()));
//                }
//                if (criteria.getName().getContains() != null) {
//                    spec = spec.and((root, query, cb) ->
//                            cb.like(cb.lower(root.get("name")), "%" + criteria.getName().getContains().toLowerCase() + "%"));
//                }
//            }

            // Active filter
            if (criteria.getActive() != null && criteria.getActive().getEquals() != null) {
                spec = spec.and((root, query, cb) ->
                        cb.equal(root.get("active"), criteria.getActive().getEquals()));
            }

            // Ek filtreler: createdBy, updatedBy, createdDt, updatedDt vs. istenirse eklenebilir.
        }

        return spec;
    }
}
