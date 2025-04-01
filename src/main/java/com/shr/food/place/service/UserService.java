package com.shr.food.place.service;

import com.shr.food.place.base.dto.request.AddUserRequestDTO;
import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.persistence.entity.User;
import com.shr.food.place.service.base.GenericSearchService;

/**
 * @author MSA
 * @version 1.0
 */

public interface UserService extends GenericSearchService<User, Long> {
    void addUser(AddUserRequestDTO requestDto) throws SWException;

    SearchResultResponseDTO find(SearchCriteriaRequestDTO requestDto) throws SWException;
}