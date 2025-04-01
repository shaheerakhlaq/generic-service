package com.shr.food.place.base.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
public class UserResponseDTO implements Serializable {
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String status;
}