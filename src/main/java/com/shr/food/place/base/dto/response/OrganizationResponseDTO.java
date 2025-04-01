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
public class OrganizationResponseDTO implements Serializable {
    private Long organizationId;
    private String name;
    private String code;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String status;
}