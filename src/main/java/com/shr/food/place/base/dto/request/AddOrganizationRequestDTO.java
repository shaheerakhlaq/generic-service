package com.shr.food.place.base.dto.request;

import com.shr.food.place.base.dto.request.base.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class AddOrganizationRequestDTO extends BaseRequestDTO {
    private String name;
    private String code;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private Integer status;
}