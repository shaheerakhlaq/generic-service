package com.shr.food.place.service.base.impl;

import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWConstants;
import com.shr.food.place.base.util.SWHelper;
import com.shr.food.place.base.util.SWStatusConstants;
import com.shr.food.place.service.base.GenericService;
import com.shr.food.place.persistence.entity.BaseEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Transactional
public abstract class GenericServiceImpl<E extends BaseEntity, ID> implements GenericService<E, ID> {
    @Autowired
    public JpaRepository<E, ID> jpaRepository;

    /**
     * Insert a new entity.
     *
     * @param entity The entity to be inserted.
     * @throws SWException If an error occurs during insertion.
     */
    public void insert(E entity) throws SWException {
        jpaRepository.save(entity);
    }

    /**
     * Update an existing entity.
     *
     * @param entity The entity to be updated.
     * @throws SWException If the entity is null or an error occurs during update.
     */
    public void update(E entity) throws SWException {
        jpaRepository.save(entity);
    }

    /**
     * Delete an entity by marking it as deleted (soft delete).
     *
     * @param id The ID of the entity to be deleted.
     * @throws SWException If the entity is not found or an error occurs during deletion.
     */
    public void delete(ID id) throws SWException {
        E entity = findByEntityId(id);

        //entity.setStatus(SWConstants.Status.CODE_DELETE);

        jpaRepository.save(entity);
    }

    /**
     * Find an entity by its ID.
     *
     * @param id The ID of the entity to find.
     * @return The entity if found.
     * @throws SWException If the entity is not found or the ID is invalid.
     */
    @Cacheable(value = "find", key = "#id", condition = "#id != null")
    public E findByEntityId(ID id) throws SWException {
        return jpaRepository.findById(id).orElseThrow(() -> SWHelper.handleOptionalSWException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND, SWStatusConstants.Status.MSG_RESULT_NOT_FOUND));
    }

    /**
     * Find all entities based on search criteria.
     *
     * @param requestDto The search criteria request DTO.
     * @return A page of entities matching the criteria.
     * @throws SWException If no results are found or the request is invalid.
     */
    public Page<E> findAll(SearchCriteriaRequestDTO requestDto) throws SWException {
        Pageable pageable = this.validateSearchCriteria(requestDto);
        Page<E> pages = jpaRepository.findAll(pageable);

        if (pages.isEmpty()) {
            SWHelper.handleSHFException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND);
        }

        return pages;
    }

    /**
     * Find all entities based on search criteria and a specification.
     *
     * @param requestDto    The search criteria request DTO.
     * @param specification The specification to filter results.
     * @return A page of entities matching the criteria and specification.
     * @throws SWException If no results are found or the request is invalid.
     */
    public Page<E> findAll(SearchCriteriaRequestDTO requestDto, Specification<E> specification) throws SWException {
        validateSearchCriteria(requestDto); // Validate before proceeding
        Pageable pageable = this.buildPageable(requestDto);

        // TODO: jpaRepository.findAll(specification, pageable);

        Page<E> pages = null; //jpaRepository.findAll(specification, pageable);

        if (pages.isEmpty()) {
            throw new SWException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND, "No results found");
        }

        return pages;
    }

    /**
     * Build a Pageable object from the search criteria request DTO.
     *
     * @param requestDto The search criteria request DTO.
     * @return A Pageable object.
     * @throws SWException If the request DTO is invalid.
     */
    public Pageable buildPageable(SearchCriteriaRequestDTO requestDto) throws SWException {
        if (requestDto == null || requestDto.getPageNumber() < 0 || requestDto.getPageSize() <= 0) {
            throw new SWException(SWStatusConstants.Status.CODE_INVALID_REQUEST,
                    "Invalid pagination parameters");
        }

        return PageRequest.of(requestDto.getPageNumber(), requestDto.getPageSize(),
                Sort.by(requestDto.getSortOrder(), requestDto.getSortColumn()));
    }

    /**
     * Validates and adjusts the search criteria request data for pagination and sorting,
     * ensuring defaults are set where necessary and converting input into a Pageable object.
     *
     * @param dto the transfer object containing search criteria, pagination, and sorting details.
     *            Validations include defaulting null page numbers to 0 (adjusted to be 0-indexed),
     *            assigning default page size and sort column, and handling null sort order by
     *            setting a default descending order.
     * @return a Pageable object constructed based on the validated and adjusted search criteria.
     * @throws SWException if any error occurs during validation or adjustment of the search criteria.
     */
    protected Pageable validateSearchCriteria(SearchCriteriaRequestDTO dto) throws SWException {
        if (dto.getPageNumber() == null) {
            dto.setPageNumber(SWConstants.Common.INT_ZERO);
        } else {
            dto.setPageNumber(dto.getPageNumber() - SWConstants.Common.INT_ONE);
        }

        if (dto.getPageSize() == null) {
            if (dto.getSearchCriteria() == null) {
                dto.setPageSize(SWConstants.Common.INT_TEN);
            } else {
                dto.setPageSize(SWConstants.Common.INT_TEN);
            }
        }

        if (dto.getSortColumn() == null) {
            dto.setSortColumn("id");
        }

        Sort sortBy = Sort.by(dto.getSortColumn());

        if (dto.getSortOrder() == null) {
            dto.setSortOrder(SearchCriteriaRequestDTO.DESC);
        }

        if (SearchCriteriaRequestDTO.DESC.equals(dto.getSortOrder())) {
            sortBy = sortBy.descending();
        } else {
            sortBy = sortBy.ascending();
        }

        return PageRequest.of(dto.getPageNumber(), dto.getPageSize(), sortBy);
    }
}