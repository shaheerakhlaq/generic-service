package com.shr.food.place.base.util;

/**
 * @author MSA
 * @version 1.0
 */

public class SWStatusConstants {
    public final class Status {
        public static final int CODE_SUCCESS = 0;
        public static final String MSG_SUCCESS = "success";
        public static final String RC_SUCCESS = "0";

        public static final int CODE_FAIL = 1;
        public static final String MSG_FAIL = "failed";

        public static final int CODE_RESULT_NOT_FOUND = 101;
        public static final String MSG_RESULT_NOT_FOUND = "Result not found";
        public static final int CODE_INVALID_QUERY_KEY = 102;
        public static final String MSG_INVALID_QUERY_KEY = "Invalid query key";
        public static final int CODE_INVALID_MFA_CODE = 103;
        public static final String MSG_INVALID_MFA_CODE = "Invalid MFA code";
        public static final int CODE_INVALID_MFA_CODE_EXPIRED = 104;
        public static final String MSG_INVALID_MFA_CODE_EXPIRED = "Invalid MFA code is expired";

        public static final int CODE_INVALID_REQUEST = 105;

        public static final int CODE_USER_NOT_FOUND = 201;
        public static final String MSG_USER_NOT_FOUND = "User not found";
        public static final int CODE_INVALID_CREDENTIALS = 202;
        public static final String MSG_INVALID_CREDENTIALS = "Bad credentials";
        public static final int CODE_INACTIVE_USER = 203;
        public static final String MSG_INACTIVE_USER = "User account is inactive";
        public static final int CODE_USER_DELETED = 204;
        public static final String MSG_USER_DELETED = "User account is deleted";
        public static final int CODE_FULL_AUTHENTICATION_REQUIRED = 205;
        public static final String MSG_FULL_AUTHENTICATION_REQUIRED = "Full authentication is required to access this resource";
        public static final int CODE_EMAIL_ADDRESS_ALREADY_EXISTS = 206;
        public static final String MSG_EMAIL_ADDRESS_ALREADY_EXISTS = "Email address is already exists";
        public static final int CODE_CREDENTIALS_NOT_FOUND = 207;
        public static final String MSG_CREDENTIALS_NOT_FOUND = "Credentials not found";
        public static final int CODE_INVALID_CURRENT_PASSWORD = 208;
        public static final String MSG_INVALID_CURRENT_PASSWORD = "Invalid current password";
        public static final int CODE_BAD_CREDENTIALS = 212;
        public static final String MSG_BAD_CREDENTIALS = "Bad credentials";
        public static final int CODE_USER_ACCOUNT_LOCKED = 213;
        public static final String MSG_USER_ACCOUNT_LOCKED = "Account is locked";

        public static final int CODE_NO_ROLE_FOUND = 301;
        public static final String MSG_NO_ROLE_FOUND = "No role found";
        public static final int CODE_NO_PRIVILEGE_FOUND = 302;
        public static final String MSG_NO_PRIVILEGE_FOUND = "No privilege found";
        public static final int CODE_ROLE_NOT_ASSIGNED = 303;
        public static final String MSG_ROLE_NOT_ASSIGNED = "No role assigned";
        public static final int CODE_NO_PRIVILEGE_ASSIGNED = 304;
        public static final String MSG_NO_PRIVILEGE_ASSIGNED = "No privilege assigned";
        public static final int CODE_PRIVILEGE_ALREADY_ASSIGNED = 305;
        public static final String MSG_PRIVILEGE_ALREADY_ASSIGNED = "Privilege is already assigned";

        public static final int CODE_FILE_NAME_ALREADY_EXISTS = 401;
        public static final String MSG_FILE_NAME_ALREADY_EXISTS = "File name is already exists";
        public static final int CODE_FILE_NAME_ALREADY_DELETE = 402;
        public static final String MSG_FILE_NAME_ALREADY_DELETE = "File already deleted";
        public static final int CODE_FILE_ERROR = 403;
        public static final String MSG_FILE_ERROR = "Error in upload file";

        public static final int CODE_INVALID_TOKEN = 901;
        public static final String MSG_INVALID_TOKEN = "Invalid token";
        public static final int CODE_ACCESS_DENIED = 902;
        public static final String MSG_ACCESS_DENIED = "You don't have access, Please contact to administrator";
        public static final int CODE_TOKEN_EXPIRED = 903;
        public static final String MSG_TOKEN_EXPIRED = "Token has expired";
        public static final int CODE_NO_TOKEN_FOUND = 904;
        public static final String MSG_NO_TOKEN_FOUND = "No token found";

        public static final int CODE_JWT_INVALID_SIGNATURE = 911;
        public static final String MSG_JWT_INVALID_SIGNATURE = "JWT invalid signature";
        public static final int CODE_JWT_MALFORMED = 912;
        public static final String MSG_JWT_MALFORMED = "JWT malformed";
        public static final int CODE_JWT_EXPIRED = 913;
        public static final String MSG_JWT_EXPIRED = "JWT expired";
        public static final int CODE_JWT_UNSUPPORTED = 914;
        public static final String MSG_JWT_UNSUPPORTED = "JWT unsupported";
        public static final int CODE_JWT_ILLEGAL_ARGUMENT = 915;
        public static final String MSG_JWT_ILLEGAL_ARGUMENT = "JWT illegal argument";
        public static final int CODE_JWT_EMPTY_TOKEN = 916;
        public static final String MSG_JWT_EMPTY_TOKEN = "Empty token";

        public static final int CODE_INVALID_DATA = 9999;
        public static final String MSG_INVALID_DATA = "Invalid data";
    }
}
