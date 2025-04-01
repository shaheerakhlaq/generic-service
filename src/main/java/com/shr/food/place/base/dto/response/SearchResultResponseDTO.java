package com.shr.food.place.base.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Builder
public class SearchResultResponseDTO<D> implements Serializable {
    private int totalPages;
    private long totalElements;
    private D content;
}