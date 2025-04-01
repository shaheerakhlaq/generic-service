package com.shr.food.place.base.exception;

import lombok.Getter;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
public class UserNotFoundException extends RuntimeException {
    private int code;

    /**
     * ResultNotFoundException
     *
     * @param message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * ResultNotFoundException
     *
     * @param code
     * @param message
     */
    public UserNotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * ResultNotFoundException
     *
     * @param code
     * @param message
     * @param cause
     */
    public UserNotFoundException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}