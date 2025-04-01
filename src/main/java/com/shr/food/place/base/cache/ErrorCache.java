package com.shr.food.place.base.cache;

import com.shr.food.place.base.util.SWStatusConstants;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class ErrorCache extends BaseCache {
    private static final ConcurrentMap<Integer, String> errorMap = new ConcurrentHashMap<>();

    /**
     * Retrieve error message dynamically at runtime.
     *
     * @param code Error code
     * @return Corresponding error message or "Unknown error code"
     */
    public static String getErrorMessage(int code) {
        try {
            return errorMap.get(code);
        } catch (Exception e) {
            return "Unknown error code: " + code;
        }
    }

    /**
     * Dynamically update an error message at runtime.
     *
     * @param code  Error code
     * @param value New error message
     */
    public static void updateError(int code, String value) {
        errorMap.put(code, value); // Update in main errorMap
    }

    /**
     * Remove an error message from the cache.
     *
     * @param code Error code to remove
     */
    public static void removeError(int code) {
        errorMap.remove(code);
    }

    /**
     * Clear the entire cache dynamically.
     */
    public static void clearCache() {
        errorMap.clear();  // Clear cache
    }

    @PostConstruct
    public void init() {
        loadErrorMessages(); // You can fetch from db
    }

    /**
     * Load default error messages into errorMap.
     */
    private void loadErrorMessages() {
        // Initialize static error map
        errorMap.put(SWStatusConstants.Status.CODE_SUCCESS, SWStatusConstants.Status.MSG_SUCCESS);
        errorMap.put(SWStatusConstants.Status.CODE_FAIL, SWStatusConstants.Status.MSG_FAIL);
        errorMap.put(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND, SWStatusConstants.Status.MSG_RESULT_NOT_FOUND);
        errorMap.put(SWStatusConstants.Status.CODE_USER_NOT_FOUND, SWStatusConstants.Status.MSG_USER_NOT_FOUND);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_CREDENTIALS, SWStatusConstants.Status.MSG_INVALID_CREDENTIALS);
        errorMap.put(SWStatusConstants.Status.CODE_INACTIVE_USER, SWStatusConstants.Status.MSG_INACTIVE_USER);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_MFA_CODE, SWStatusConstants.Status.MSG_INVALID_MFA_CODE);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_MFA_CODE_EXPIRED, SWStatusConstants.Status.MSG_INVALID_MFA_CODE_EXPIRED);
        errorMap.put(SWStatusConstants.Status.CODE_USER_DELETED, SWStatusConstants.Status.MSG_USER_DELETED);
        errorMap.put(SWStatusConstants.Status.CODE_FULL_AUTHENTICATION_REQUIRED, SWStatusConstants.Status.MSG_FULL_AUTHENTICATION_REQUIRED);
        errorMap.put(SWStatusConstants.Status.CODE_EMAIL_ADDRESS_ALREADY_EXISTS, SWStatusConstants.Status.MSG_EMAIL_ADDRESS_ALREADY_EXISTS);
        errorMap.put(SWStatusConstants.Status.CODE_CREDENTIALS_NOT_FOUND, SWStatusConstants.Status.MSG_CREDENTIALS_NOT_FOUND);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_CURRENT_PASSWORD, SWStatusConstants.Status.MSG_INVALID_CURRENT_PASSWORD);
        errorMap.put(SWStatusConstants.Status.CODE_FILE_NAME_ALREADY_EXISTS, SWStatusConstants.Status.MSG_FILE_NAME_ALREADY_EXISTS);
        errorMap.put(SWStatusConstants.Status.CODE_FILE_NAME_ALREADY_DELETE, SWStatusConstants.Status.MSG_FILE_NAME_ALREADY_DELETE);
        errorMap.put(SWStatusConstants.Status.CODE_ROLE_NOT_ASSIGNED, SWStatusConstants.Status.MSG_ROLE_NOT_ASSIGNED);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_TOKEN, SWStatusConstants.Status.MSG_INVALID_TOKEN);
        errorMap.put(SWStatusConstants.Status.CODE_ACCESS_DENIED, SWStatusConstants.Status.MSG_ACCESS_DENIED);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_INVALID_SIGNATURE, SWStatusConstants.Status.MSG_JWT_INVALID_SIGNATURE);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_MALFORMED, SWStatusConstants.Status.MSG_JWT_MALFORMED);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_EXPIRED, SWStatusConstants.Status.MSG_JWT_EXPIRED);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_UNSUPPORTED, SWStatusConstants.Status.MSG_JWT_UNSUPPORTED);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_ILLEGAL_ARGUMENT, SWStatusConstants.Status.MSG_JWT_ILLEGAL_ARGUMENT);
        errorMap.put(SWStatusConstants.Status.CODE_JWT_EMPTY_TOKEN, SWStatusConstants.Status.MSG_JWT_EMPTY_TOKEN);
        errorMap.put(SWStatusConstants.Status.CODE_INVALID_QUERY_KEY, SWStatusConstants.Status.MSG_INVALID_QUERY_KEY);
    }
}