package com.shr.food.place.base.exception.advice;

import com.shr.food.place.base.dto.response.base.BaseResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWLoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author MSA
 * @version 1.0
 */

@ControllerAdvice
public class SWExceptionHandler {
    /**
     * Handle SWException (Internal Server Error)
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SWException.class)
    public BaseResponseDTO handleSWException(SWException e) {
        return handleException(e.getCode(), e.getMessage(), e);
    }

    /**
     * Generic Exception Handler Method
     *
     * @param code    HTTP status code
     * @param message Custom message
     * @param e       Exception instance
     * @param <R>     Generic Response Type
     * @return BaseResponseDTO<R>
     */
    private <R> BaseResponseDTO<R> handleException(int code, String message, Throwable e) {
        SWLoggerUtil.info("Exception Caught: {} - {}", e.getClass().getSimpleName(), e.getMessage(), e);

        return buildResponse(code, message);
    }

    /**
     * Build BaseResponseDTO
     *
     * @param code    HTTP status code
     * @param message Response message
     * @param <R>     Generic Response Type
     * @return BaseResponseDTO<R>
     */
    private <R> BaseResponseDTO<R> buildResponse(int code, String message) {
        BaseResponseDTO<R> response = new BaseResponseDTO<>();
        response.setCode(code);
        response.setValue(message);
        return response;
    }
}