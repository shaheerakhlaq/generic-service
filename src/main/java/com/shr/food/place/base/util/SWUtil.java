package com.shr.food.place.base.util;

import java.util.*;

/**
 * @author MSA
 * @version 1.0
 */

public class SWUtil {
    private static final Map<Integer, String> STATUS_MAP = Map.of(
            SWConstants.Status.CODE_UNKNOWN, SWConstants.Status.MSG_UNKNOWN,
            SWConstants.Status.CODE_ACTIVE, SWConstants.Status.MSG_ACTIVE,
            SWConstants.Status.CODE_INACTIVE, SWConstants.Status.MSG_INACTIVE,
            SWConstants.Status.CODE_DELETE, SWConstants.Status.MSG_DELETE,
            SWConstants.Status.CODE_TERMINATE, SWConstants.Status.MSG_TERMINATE,
            SWConstants.Status.CODE_UNUSED, SWConstants.Status.MSG_UNUSED,
            SWConstants.Status.CODE_USED, SWConstants.Status.MSG_USED,
            SWConstants.Status.CODE_EXPIRED, SWConstants.Status.MSG_EXPIRED
    );

    /**
     * Convert string to int
     *
     * @param input
     * @return int
     */
    public static Optional<Integer> stringToInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(Integer.parseInt(input.trim()));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * Convert string to long
     *
     * @param input
     * @return long
     */
    public static final long stringToLong(String input) {
        long parseValue = SWConstants.Common.INT_ZERO;
        try {
            parseValue = Long.parseLong(input);
        } catch (Exception e) {
            parseValue = SWConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Convert string to double
     *
     * @param input
     * @return double
     */
    public static final double stringToDouble(String input) {
        double parseValue = SWConstants.Common.INT_ZERO;
        try {
            parseValue = Double.parseDouble(input);
        } catch (Exception e) {
            parseValue = SWConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Generate UUID
     *
     * @return String
     */
    public static String generateUUId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Validate collection object
     *
     * @param collection
     * @return boolean
     */
    public static boolean isCollectionNotBlank(Collection<?> collection) {
        return Objects.nonNull(collection) && !collection.isEmpty();
    }

    /**
     * Get status
     *
     * @param status
     * @return String
     */
    public static String getStatus(int status) {
        return STATUS_MAP.getOrDefault(status, SWConstants.Status.MSG_ACTIVE);
    }

    /**
     * This method generates a numeric OTP of the given length
     *
     * @param length The length of the OTP (e.g., 4 for a 4-digit OTP)
     * @return A string representing the OTP
     */
    public static String generateOTP(int length) {
        // Ensure the length is valid (at least 1)
        if (length <= SWConstants.Common.INT_ZERO) {
            throw new IllegalArgumentException("OTP length must be greater than 0");
        }

        // Create a Random object
        Random random = new Random();

        // Generate OTP using StringBuilder
        StringBuilder otp = new StringBuilder();

        for (int i = SWConstants.Common.INT_ZERO; i < length; i++) {
            int digit = random.nextInt(SWConstants.Common.INT_TEN); // Generate a random digit (0-9)
            otp.append(digit);
        }

        return otp.toString(); // Return the OTP as a string
    }
}