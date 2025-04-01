package com.shr.food.place.service.base;

import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.persistence.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author MSA
 * @version 1.0
 */

public interface GenericService<E extends BaseEntity, ID> {
    void insert(E entity) throws SWException;

    void update(E entity) throws SWException;

    void delete(ID id) throws SWException;

    E findByEntityId(ID id) throws SWException;

    Page<E> findAll(SearchCriteriaRequestDTO requestDto) throws SWException;

    Page<E> findAll(SearchCriteriaRequestDTO requestDto, Specification<E> specification) throws SWException;
}