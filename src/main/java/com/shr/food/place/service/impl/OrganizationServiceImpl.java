package com.shr.food.place.service.impl;

import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.mapper.OrganizationMapper;
import com.shr.food.place.persistence.entity.Organization;
import com.shr.food.place.persistence.repository.OrganizationRepository;
import com.shr.food.place.persistence.repository.base.GenericSpecification;
import com.shr.food.place.service.OrganizationService;
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
public class OrganizationServiceImpl extends GenericSearchServiceImpl<Organization, Long> implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl() {
        super(Organization.class);
    }

    /**
     * Retrieves a search result based on the provided search criteria.
     *
     * @param requestDto a {@link SearchCriteriaRequestDTO} object containing the search parameters and criteria
     * @return a {@link SearchResultResponseDTO} object containing the search results, total elements, and total pages
     * @throws SWException if an error occurs during the search operation
     */
    public SearchResultResponseDTO find(SearchCriteriaRequestDTO requestDto) throws SWException {
        Page<Organization> pages = null;

        if (requestDto.getSearchCriteria() == null || requestDto.getSearchCriteria().isEmpty()) {
            pages = this.findAll(requestDto);
        } else {
            Specification<Organization> specification = new GenericSpecification<>(requestDto.getSearchCriteria());
            Pageable pageable = this.validateSearchCriteria(requestDto);
            pages = getOrganizationRepository().findAll(specification, pageable);
        }

        return getSearchResult(pages, Organization.class);
    }
}