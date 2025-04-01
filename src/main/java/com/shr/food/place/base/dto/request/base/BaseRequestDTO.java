package com.shr.food.place.base.dto.request.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
public class BaseRequestDTO implements Serializable {
    private String origin;
    private Long organizationId;
}