package com.shr.food.place.base.dto.request;

import com.shr.food.place.base.dto.request.base.BaseSearchCriteriaRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchCriteriaRequestDTO extends BaseSearchCriteriaRequestDTO {
    private Map<String, Object> searchCriteria;
}