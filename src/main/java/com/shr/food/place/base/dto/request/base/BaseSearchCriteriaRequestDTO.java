package com.shr.food.place.base.dto.request.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseSearchCriteriaRequestDTO extends BaseRequestDTO {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    private Integer pageNumber;
    private Integer pageSize;
    private String sortColumn;
    private String sortOrder;
}