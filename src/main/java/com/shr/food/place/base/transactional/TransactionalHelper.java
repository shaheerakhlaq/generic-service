package com.shr.food.place.base.transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

/**
 * @author MSA
 * @version 1.0
 */

@Service
public class TransactionalHelper {
    /**
     * Executes a transactional operation without returning a result.
     *
     * @param action The action to perform within the transaction.
     */
    @Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED)
    public void executeInTransaction(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            // Log the exception and rethrow it to trigger rollback
            logError("Error during transaction execution", e);
            throw e;
        }
    }

    /**
     * Executes a transactional operation and returns a result.
     *
     * @param supplier The supplier to execute within the transaction.
     * @param <T>      The type of the result.
     * @return The result of the transactional operation.
     */
    @Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED)
    public <T> T executeInTransactionWithResult(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            // Log the exception and rethrow it to trigger rollback
            logError("Error during transaction execution with result", e);
            throw e;
        }
    }

    /**
     * Logs an error message with the given exception.
     *
     * @param message The error message.
     * @param e       The exception.
     */
    private void logError(String message, Exception e) {
        // Replace with your logging framework (e.g., SLF4J, Log4j)
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace();
    }
}