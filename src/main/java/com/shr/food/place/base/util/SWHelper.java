package com.shr.food.place.base.util;

import com.shr.food.place.base.cache.ErrorCache;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class SWHelper {
    public static void checkConfiguration(Object object, String value) {

    }

    /**
     * handleSHFException
     *
     * @param code
     */
    public static void handleSHFException(int code) {
        throw new SWException(code, ErrorCache.getErrorMessage(code));
    }

    /**
     * handleSHFException
     *
     * @param code
     * @param value
     */
    public static void handleSHFException(int code, String value) {
        throw new SWException(code, value);
    }

    /**
     * handleOptionalSWException
     *
     * @param code
     * @param value
     * @return SHFException
     * @throws SWException
     */
    public static SWException handleOptionalSWException(int code, String value) {
        return new SWException(code, value);
    }

    /**
     * handleOptionalSWException
     *
     * @param code
     * @return SHFException
     * @throws SWException
     */
    public static SWException handleOptionalSWException(int code) {
        return new SWException(code, ErrorCache.getErrorMessage(code));
    }

    /**
     * handleUserNotFoundException
     *
     * @param code
     * @param message
     */
    public static void handleUserNotFoundException(int code, String message) {
        throw new UserNotFoundException(code, message);
    }
}