package com.shr.food.place.persistence.repository.base;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

/**
 * @author MSA
 * @version 1.0
 */

public class GenericSpecification<E> implements Specification<E> {
    private final Map<String, Object> searchCriteria;

    public GenericSpecification(Map<String, Object> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * To predicate
     *
     * @param root
     * @param query
     * @param builder
     * @return Predicate
     */
    public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Predicate predicate = builder.conjunction();

        for (Map.Entry<String, Object> entry : searchCriteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value != null) {
                predicate = builder.and(predicate, builder.equal(root.get(key), value));
            }
        }

        return predicate;
    }
}