package com.shr.food.place.service.base;

import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.persistence.entity.BaseEntity;

/**
 * @author MSA
 * @version 1.0
 */

public interface GenericSearchService<E extends BaseEntity, ID> extends GenericService<E, ID> {
    SearchResultResponseDTO search(SearchCriteriaRequestDTO requestDto) throws SWException;
}