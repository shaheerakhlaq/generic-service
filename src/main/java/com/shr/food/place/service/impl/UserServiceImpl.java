package com.shr.food.place.service.impl;

import com.shr.food.place.base.dto.request.AddUserRequestDTO;
import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.transactional.TransactionalHelper;
import com.shr.food.place.mapper.UserMapper;
import com.shr.food.place.persistence.entity.User;
import com.shr.food.place.persistence.entity.UserCredential;
import com.shr.food.place.persistence.repository.UserCredentialRepository;
import com.shr.food.place.persistence.repository.UserRepository;
import com.shr.food.place.persistence.repository.base.GenericSpecification;
import com.shr.food.place.service.UserService;
import com.shr.food.place.service.base.impl.GenericSearchServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Service
public class UserServiceImpl extends GenericSearchServiceImpl<User, Long> implements UserService {
    @Autowired
    private TransactionalHelper transactionalHelper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    public UserServiceImpl() {
        super(User.class);
    }

    /**
     * Add in key cloak
     *
     * @param requestDto
     * @throws SWException
     */
    public void addUser(AddUserRequestDTO requestDto) throws SWException {
        getTransactionalHelper().executeInTransaction(() -> {
            User userEntity = getUserMapper().add(requestDto);

            getUserRepository().save(userEntity);

            UserCredential userCredentialEntity = getUserMapper().addUserCredential(requestDto, userEntity);

            getUserCredentialRepository().save(userCredentialEntity);
        });
    }

    /**
     * Retrieves a search result based on the provided search criteria.
     *
     * @param requestDto a {@link SearchCriteriaRequestDTO} object containing the search parameters and criteria
     * @return a {@link SearchResultResponseDTO} object containing the search results, total elements, and total pages
     * @throws SWException if an error occurs during the search operation
     */
    public SearchResultResponseDTO find(SearchCriteriaRequestDTO requestDto) throws SWException {
        Page<User> pages = null;

        if (requestDto.getSearchCriteria() == null || requestDto.getSearchCriteria().isEmpty()) {
            pages = this.findAll(requestDto);
        } else {
            Specification<User> specification = new GenericSpecification<>(requestDto.getSearchCriteria());
            Pageable pageable = this.validateSearchCriteria(requestDto);
            pages = getUserRepository().findAll(specification, pageable);
        }

        return getSearchResult(pages, User.class);
    }
}