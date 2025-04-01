package com.shr.food.place.controller.base;

import com.shr.food.place.base.response.BaseResponseEntity;
import com.shr.food.place.mapper.OrganizationMapper;
import com.shr.food.place.mapper.UserMapper;
import com.shr.food.place.service.OrganizationService;
import com.shr.food.place.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
public abstract class BaseController extends BaseResponseEntity {
    // Mapper
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;

    // Service
    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;
}