package com.shr.food.place.base.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class SWLoggerUtil {
    public static final String INFO = "INFO";
    public static final String DEBUG = "DEBUG";
    public static final String TRACE = "TRACE";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";

    /**
     * Info logging
     *
     * @param message
     * @param params
     */
    public static void info(String message, Object... params) {
        if (log.isInfoEnabled()) {
            log.info(message, params);
        }
    }

    /**
     * Debug logging
     *
     * @param message
     * @param params
     */
    public static void debug(String message, Object... params) {
        if (log.isDebugEnabled()) {
            log.debug(message, params);
        }
    }

    /**
     * Trace logging
     *
     * @param message
     * @param params
     */
    public static void trace(String message, Object... params) {
        if (log.isTraceEnabled()) {
            log.trace(message, params);
        }
    }

    /**
     * Warn logging
     *
     * @param message
     * @param params
     */
    public static void warn(String message, Object... params) {
        if (log.isWarnEnabled()) {
            log.warn(message, params);
        }
    }

    /**
     * Error logging
     *
     * @param message
     * @param params
     */
    public static void error(String message, Object... params) {
        if (log.isErrorEnabled()) {
            log.error(message, params);
        }
    }

    /**
     * Logging with level
     *
     * @param level
     * @param message
     * @param params
     */
    public static void logging(String level, String message, Object... params) {
        if (SWLoggerUtil.INFO.equals(level)) {
            info(message, params);
        } else if (SWLoggerUtil.DEBUG.equals(level)) {
            debug(message, params);
        } else if (SWLoggerUtil.TRACE.equals(level)) {
            trace(message, params);
        } else if (SWLoggerUtil.WARN.equals(level)) {
            warn(message, params);
        } else if (SWLoggerUtil.ERROR.equals(level)) {
            error(message, params);
        }
    }
}