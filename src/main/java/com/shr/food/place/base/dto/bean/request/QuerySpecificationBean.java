package com.shr.food.place.base.dto.bean.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
public class QuerySpecificationBean implements Serializable {
    private String column;
    private Object value;
    private String dataType;
    private String queryOperator;
    private Boolean joined;
}