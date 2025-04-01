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
public class UpdateUserRequestDTO extends BaseRequestDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Integer status;
}