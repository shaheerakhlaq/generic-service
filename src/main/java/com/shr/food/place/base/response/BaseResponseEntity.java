package com.shr.food.place.base.response;

import com.shr.food.place.base.dto.response.base.BaseResponseDTO;
import com.shr.food.place.base.util.SWStatusConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public abstract class BaseResponseEntity {
    /**
     * response
     *
     * @param <R>
     * @return BaseResponseDTO
     */
    public <R> BaseResponseDTO<R> response() {
        return response(SWStatusConstants.Status.CODE_SUCCESS, SWStatusConstants.Status.MSG_SUCCESS, null);
    }

    /**
     * response
     *
     * @param code
     * @param value
     * @param <R>
     * @return BaseResponseDTO
     */
    public <R> BaseResponseDTO<R> response(int code, String value) {
        return response(code, value, null);
    }

    /**
     * response
     *
     * @param data
     * @param <R>
     * @return BaseResponseDTO
     */
    public <R> BaseResponseDTO<R> response(R data) {
        return response(SWStatusConstants.Status.CODE_SUCCESS, SWStatusConstants.Status.MSG_SUCCESS, data);
    }

    /**
     * response
     *
     * @param code
     * @param value
     * @param data
     * @param <R>
     * @return BaseResponseDTO
     */
    public <R> BaseResponseDTO<R> response(int code, String value, R data) {
        BaseResponseDTO<R> baseResponseDTO = new BaseResponseDTO<R>();
        baseResponseDTO.setCode(code);
        baseResponseDTO.setValue(value);
        baseResponseDTO.setData(data);

        return baseResponseDTO;
    }
}