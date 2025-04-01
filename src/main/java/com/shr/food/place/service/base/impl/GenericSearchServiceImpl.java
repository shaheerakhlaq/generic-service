package com.shr.food.place.service.base.impl;

import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWHelper;
import com.shr.food.place.base.util.SWStatusConstants;
import com.shr.food.place.base.util.SWUtil;
import com.shr.food.place.service.base.GenericSearchService;
import com.shr.food.place.mapper.factory.MapperFactory;
import com.shr.food.place.mapper.generic.GenericMapper;
import com.shr.food.place.persistence.entity.BaseEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Transactional
public abstract class GenericSearchServiceImpl<E extends BaseEntity, ID> extends GenericServiceImpl<E, ID> implements GenericSearchService<E, ID> {
    private final Class<E> entityClass;
    @Autowired
    private MapperFactory mapperFactory;

    protected GenericSearchServiceImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Searches
     *
     * @param requestDto
     * @return SearchResultResponseDTO<R> - A search result response DTO of type R.
     * @throws SWException
     */
    public SearchResultResponseDTO search(SearchCriteriaRequestDTO requestDto) throws SWException {
        Page<E> pages = this.findAll(requestDto);

        return getSearchResult(pages, this.entityClass);
    }

    /**
     * Set search result
     *
     * @param pages
     * @param entityType
     * @param <E>        Entity type parameter.
     * @param <R>        Response DTO type parameter.
     * @return SearchResultResponseDTO<R> - A search result response DTO.
     */
    public <E, R> SearchResultResponseDTO<R> getSearchResult(Page<E> pages, Class<E> entityType) throws SWException {
        if (!SWUtil.isCollectionNotBlank(pages.getContent())) {
            SWHelper.handleSHFException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND);
        }

        GenericMapper<E, R> mapper = getMapperFactory().getMapper(entityType);

        List<R> mappedContent = pages.getContent().stream()
                .map(mapper::find)
                .collect(Collectors.toList());

        return (SearchResultResponseDTO<R>) SearchResultResponseDTO.builder()
                .totalPages(pages.getTotalPages())
                .totalElements(pages.getTotalElements())
                .content(mappedContent)
                .build();
    }
}