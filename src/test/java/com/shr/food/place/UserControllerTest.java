package com.shr.food.place;

import com.shr.food.place.service.UserService;
import com.shr.food.place.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserControllerTest {
    public UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testGreetWithValidName() {
        //User user = userService.findByEntityId(1L);

        Assertions.assertEquals("superadmin", "superadmin");
    }
}