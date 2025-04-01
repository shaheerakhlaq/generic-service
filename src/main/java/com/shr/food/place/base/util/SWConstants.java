package com.shr.food.place.base.util;

/**
 * @author MSA
 * @version 1.0
 */

public class SWConstants {
    public static final class ApplicationYaml {
        public static final String JDBC_DRIVER_CLASS_NAME = "spring.datasource.hikari.driver-class-name";
        public static final String JDBC_URL = "spring.datasource.hikari.jdbc-url";
        public static final String JDBC_USERNAME = "spring.datasource.hikari.username";
        public static final String JDBC_PASSWORD = "spring.datasource.hikari.password";
        public static final String JDBC_MIN_IDLE = "spring.datasource.hikari.minimum-idle";
        public static final String JDBC_MAX_POOL_SIZE = "spring.datasource.hikari.maximum-pool-size";
        public static final String JDBC_IDLE_TIMEOUT = "spring.datasource.hikari.idle-timeout";
        public static final String JDBC_CONNECTION_TIMEOUT = "spring.datasource.hikari.connection-timeout";
        public static final String JDBC_LEAK_DETECTION_THRESHOLD = "spring.datasource.hikari.leak-detection-threshold";
        public static final String JDBC_CONNECTION_TEST_QUERY = "spring.datasource.hikari.connection-test-query";
        public static final String JDBC_VALIDATION_TIMEOUT = "spring.datasource.hikari.validation-timeout";
        public static final String JDBC_MAX_LIFETIME = "spring.datasource.hikari.max-lifetime";
        public static final String POOL_NAME = "spring.datasource.hikari.pool-name";
        public static final String DATABASE_PLATFORM = "spring.jpa.properties.hibernate.database-platform";
    }

    public static final class Common {
        public static final int INT_ZERO = 0;
        public static final int INT_ONE = 1;
        public static final int INT_TWO = 2;
        public static final int INT_THREE = 3;
        public static final int INT_FOUR = 4;
        public static final int INT_FIVE = 5;
        public static final int INT_SIX = 6;
        public static final int INT_SEVEN = 7;
        public static final int INT_EIGHT = 8;
        public static final int INT_NINE = 9;
        public static final int INT_TEN = 10;
        public static final int INT_ELEVEN = 11;
        public static final int INT_TWELVE = 12;
        public static final int INT_THIRTEEN = 13;
        public static final int INT_FOURTEEN = 14;
        public static final int INT_FIFTEEN = 15;
        public static final int INT_SIXTEEN = 16;
        public static final int INT_SEVENTEEN = 17;
        public static final int INT_EIGHTEEN = 18;
        public static final int INT_NINETEEN = 19;
        public static final int INT_TWENTY = 20;
        public static final int INT_TWENTY_ONE = 21;
        public static final int INT_TWENTY_TWO = 22;
        public static final int INT_TWENTY_THREE = 23;
        public static final int INT_TWENTY_FOUR = 24;
        public static final int INT_TWENTY_FIVE = 25;
        public static final int INT_TWENTY_SIX = 26;
        public static final int INT_TWENTY_SEVEN = 27;
        public static final int INT_TWENTY_EIGHT = 28;

        public static final int INT_NINTY_NINE = 99;
        public static final int INT_HUNDRED = 100;
        public static final int INT_TWO_HUNDRED = 200;
        public static final int INT_SIXTY = 60;
        public static final int INT_FOURTEEN_FORTY = 1440;

        public static final long LONG_ZERO = 0L;
        public static final long LONG_ONE = 1L;
        public static final long LONG_TWO = 2L;
        public static final long LONG_THREE = 3L;
        public static final long LONG_FOUR = 4L;
        public static final long LONG_FIVE = 5L;
        public static final long LONG_SIX = 6L;
        public static final long LONG_SEVEN = 7L;
        public static final long LONG_EIGHT = 8L;
        public static final long LONG_NINE = 9L;

        public static final String JAN_SHORT_CODE = "Jan";
        public static final String FEB_SHORT_CODE = "Feb";
        public static final String MAR_SHORT_CODE = "Mar";
        public static final String APR_SHORT_CODE = "Apr";
        public static final String MAY_SHORT_CODE = "May";
        public static final String JUN_SHORT_CODE = "Jun";
        public static final String JUL_SHORT_CODE = "Jul";
        public static final String AUG_SHORT_CODE = "Aug";
        public static final String SEP_SHORT_CODE = "Sep";
        public static final String OCT_SHORT_CODE = "Oct";
        public static final String NOV_SHORT_CODE = "Nov";
        public static final String DEC_SHORT_CODE = "Dec";

        public static final String STRING_ZERO = "0";
        public static final String STRING_ZERO_ONE = "01";
        public static final String STRING_ZERO_TWO = "02";
        public static final String STRING_ZERO_THREE = "03";
        public static final String STRING_ZERO_FOUR = "04";
        public static final String STRING_ZERO_FIVE = "05";
        public static final String STRING_ZERO_SIX = "06";
        public static final String STRING_ZERO_SEVEN = "07";
        public static final String STRING_ZERO_EIGHT = "08";
        public static final String STRING_ZERO_NINE = "09";
        public static final String START_DAY_TIME = " 12.00.00 AM";
        public static final String END_DAY_TIME = " 11.59.59 PM";

        public static final String FORMAT_24_START_DAY_TIME = "00:00:00";
        public static final String FORMAT_24_END_DAY_TIME = "23:59:59";

        public static final String SC_EMPTY = "";
        public static final String SC_STAR = "*";
        public static final String SC_SPACE = " ";
        public static final String SC_DASH = "-";
        public static final String SC_DOT = ".";
        public static final String SC_FALSE = "false";
        public static final String SC_SEMI_COLON = ";";
        public static final String SC_COLON = ":";
        public static final String SC_COLON_SPACE = ": ";
        public static final String SC_UNDER_SCORE = "_";
        public static final String SC_BACK_SLASH = "\\";
        public static final String SC_FORWARD_SLASH = "/";
        public static final String SC_DOUBLE_FORWARD_SLASH = "//";
        public static final String SC_AT_THE_RATE = "@";
        public static final String SC_GREATER_THAN = ">";
        public static final String SC_LESS_THAN = "<";
        public static final String SC_NULL = "null";
        public static final String SC_COMMA = ",";
        public static final String LEFT_BRACE = "{";
        public static final String RIGHT_BRACE = "}";
        public static final String SC_DASH_WITH_SPACE = " - ";
        public static final String SC_QUERY_SINGLE_CODE = "'";

        public static final String EMPTY = "EMPTY";

        public static final Long DEFAULT_LOGGED_IN_ID = 1L;

        public static final String UPDATE_WRONG_PASSWORD_COUNT = "UPDATE_WRONG_PASSWORD_COUNT";
        public static final String UPDATE_WRONG_PASSWORD_RESET = "UPDATE_WRONG_PASSWORD_RESET";
    }

    public static final class Header {
        public static final String J_SESSION_ID = "JSESSIONID";

        public static final String ALLOW_PATH = "/**";

        public static final String ALLOW_METHOD_HEAD = "HEAD";
        public static final String ALLOW_METHOD_GET = "GET";
        public static final String ALLOW_METHOD_POST = "POST";
        public static final String ALLOW_METHOD_PUT = "PUT";
        public static final String ALLOW_METHOD_DELETE = "DELETE";
        public static final String ALLOW_METHOD_PATCH = "PATCH";

        public static final String ALLOW_HEADER_AUTHORIZATION = "Authorization";
        public static final String ALLOW_HEADER_CACHE_CONTROL = "Cache-Control";
        public static final String ALLOW_HEADER_CONTENT_TYPE = "Content-Type";

        public static final String AUTHORIZATION = "Authorization";
        public static final String AUTHORIZATION_BEARER = "Bearer";
        public static final String AUTHORIZATION_BASIC = "Basic";
        public static final String AUTHORIZATION_BEARER_SPACE = "Bearer ";
        public static final String AUTHORIZATION_BASIC_SPACE = "Basic ";
        public static final String AUTHORIZATION_COOKIE = "Cookie";

        public static final String ACCESS_CONTROL_EXPOSE_HEADERS_KEY = "Access-Control-Expose-Headers";
        public static final String ACCESS_CONTROL_ALLOW_HEADERS_KEY = "Access-Control-Allow-Headers";
        public static final String X_AC_TOKEN_KEY = "X-AC-Token";
        public static final String CONTENT_TYPE_KEY = "Content-Type";

        public static final String ACCESS_CONTROL_EXPOSE_HEADERS_VALUE = "Authorization";
        public static final String ACCESS_CONTROL_ALLOW_HEADERS_VALUE = "Authorization, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header";
        public static final String X_AC_TOKEN_VALUE = "X-AC-Token";
        public static final String CONTENT_TYPE_VALUE = "application/json;charset=UTF-8";
    }

    public static final class Status {
        public static final int CODE_UNKNOWN = 0;
        public static final int CODE_ACTIVE = 1;
        public static final int CODE_INACTIVE = 2;
        public static final int CODE_DELETE = 3;
        public static final int CODE_TERMINATE = 4;
        public static final int CODE_UNUSED = 5;
        public static final int CODE_USED = 6;
        public static final int CODE_EXPIRED = 7;
        public static final int CODE_ACCOUNT_LOCK = 8;

        public static final String MSG_UNKNOWN = "Unknown";
        public static final String MSG_ACTIVE = "Active";
        public static final String MSG_INACTIVE = "Inactive";
        public static final String MSG_DELETE = "Deleted";
        public static final String MSG_TERMINATE = "Terminate";
        public static final String MSG_UNUSED = "Unused";
        public static final String MSG_USED = "Used";
        public static final String MSG_EXPIRED = "Expired";
        public static final String MSG_ACCOUNT_LOCK = "Account is locked";
    }

    public static final class Origin {
        public static final String WEB = "WEB";
        public static final String MOBILE = "MOBILE";
    }

    public static final class Kafka {
        public static final class Properties {
            public static final String BOOTSTRAP_SERVERS_CONFIG = "spring.kafka.bootstrap-servers";
            public static final String GROUP_ID_CONFIG = "spring.kafka.consumer.group-id";
        }

        public static final class Topic {
            public static final String Q_TOPIC_MPS = "Q-TOPIC-MPS";
        }

        public static final class Group {
            public static final String Q_GROUP_MPS = "Q-GROUP-MPS";
        }
    }

    public static final class VerificationCode {
        public static final String MFA = "MFA";
        public static final String OTP = "OTP";
    }

    public static final class ErrorCode {
        public static final int JSON_SERIALIZATION_ERROR = 1;
    }

    public static final class AuthTokenType {
        public static final String BEARER = "Bearer";
        public static final String BASIC = "Basic";
    }

    public static final class NotificationLog {
        public static final String SMS = "SMS";
        public static final String EMAIL = "EMAIL";
    }

    public static final class Role {
        public static final String ADMINISTRATOR = "ROLE_ADMINISTRATOR";
    }

    public static final class ModulePrivilegeType {
        public static final String MODULE = "Module";
        public static final String SUB_MODULE = "Sub Module";
        public static final String SERVICE = "Service";
        public static final String PAGE = "Page";
    }
}