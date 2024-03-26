package com.develhope.spring.Vehicle.Specifications;

import com.develhope.spring.Vehicle.Entities.Vehicle;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
@AllArgsConstructor
public class VehicleSpecification implements Specification<Vehicle> {
    @Autowired
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (root.get(criteria.getKey()).getJavaType() == String.class) {
            return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (root.get(criteria.getKey()).getJavaType() == Boolean.class) {
            return builder.equal(root.get(criteria.getKey()), Boolean.valueOf(criteria.getValue().toString()));
        } else if (root.get(criteria.getKey()).getJavaType() == LocalDate.class) {
            return builder.equal(root.get(criteria.getKey()), LocalDate.parse(criteria.getValue().toString()));
        }else if (root.get(criteria.getKey()).getJavaType().isEnum()) {
            return builder.equal(root.get(criteria.getKey()), Enum.valueOf((Class<Enum>) root.get(criteria.getKey()).getJavaType(), criteria.getValue().toString()));
        }else {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
    }
}
