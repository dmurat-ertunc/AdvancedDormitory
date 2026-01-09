package com.dme.DormitoryAdvanced.business.QueryService;

import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.entity.University;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UniversityQueryService {

    public Specification<University> createSpecification(UniversityCriteria criteria) {
        Specification<University> spec = Specification.where(null);

        if (criteria != null) {

            // City filters
            if (criteria.getCity() != null) {
                if (criteria.getCity().getEquals() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.equal(cb.lower(root.get("city")), criteria.getCity().getEquals().toLowerCase()));
                }
                if (criteria.getCity().getContains() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.like(cb.lower(root.get("city")), "%" + criteria.getCity().getContains().toLowerCase() + "%"));
                }
            }

            // Name filters
            if (criteria.getName() != null) {
                if (criteria.getName().getEquals() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.equal(cb.lower(root.get("name")), criteria.getName().getEquals().toLowerCase()));
                }
                if (criteria.getName().getContains() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.like(cb.lower(root.get("name")), "%" + criteria.getName().getContains().toLowerCase() + "%"));
                }
            }

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
