package com.shr.food.place.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SWException extends RuntimeException {
    private int code;

    /**
     * SHFException
     *
     * @param message
     */
    public SWException(String message) {
        super(message);
    }

    /**
     * SHFException
     *
     * @param code
     * @param message
     */
    public SWException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * SHFException
     *
     * @param code
     * @param message
     * @param cause
     */
    public SWException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}