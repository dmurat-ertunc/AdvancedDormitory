package com.dme.DormitoryAdvanced.business.QueryService;

import com.dme.DormitoryAdvanced.business.Criteria.StudentCriteria;
import com.dme.DormitoryAdvanced.business.Criteria.UniversityCriteria;
import com.dme.DormitoryAdvanced.entity.Student;
import com.dme.DormitoryAdvanced.entity.University;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StudentQueryService {

    public Specification<Student> createSpecification(StudentCriteria criteria) {
        Specification<Student> spec = Specification.where(null);

        if (criteria != null) {

            // identity filters
            if (criteria.getIdentityNo() != null) {
                if (criteria.getIdentityNo().getEquals() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.equal(cb.lower(root.get("identityNo")), criteria.getIdentityNo().getEquals().toLowerCase()));
                }
                if (criteria.getName().getContains() != null) {
                    spec = spec.and((root, query, cb) ->
                            cb.like(cb.lower(root.get("identityNo")), "%" + criteria.getName().getContains().toLowerCase() + "%"));
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
