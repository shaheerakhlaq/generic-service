package com.shr.food.place.service.factory;

import com.shr.food.place.service.OrganizationService;
import com.shr.food.place.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@RequiredArgsConstructor
@Component
public class ServiceFactory {
    private final UserService userService;
    private final OrganizationService organizationService;
}